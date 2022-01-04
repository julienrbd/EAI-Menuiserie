/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.Consumer;

import frbouhadjacheurfarobardet.entities.Affaire;
import frbouhadjacheurfarobardet.metier.MetierAffaireLocal;
import frbouhadjacheurfarobardet.metier.MetierClientLocal;
import frbouhadjaheurfarobardet.scashared.AffaireS;
import frbouhadjaheurfarobardet.scashared.ClientS;
import frbouhadjacheurfarobardet.entities.Client;
import frbouhadjacheurfarobardet.entities.EtatAffaire;
import frbouhadjacheurfarobardet.entities.RdvCommercial;
import frbouhadjacheurfarobardet.entities.RdvPoseur;
import frbouhadjacheurfarobardet.facade.AffaireFacadeLocal;
import frbouhadjacheurfarobardet.facade.ClientFacadeLocal;
import frbouhadjacheurfarobardet.facade.RdvCommercialFacadeLocal;
import frbouhadjacheurfarobardet.facade.RdvPoseurFacadeLocal;
import frbouhadjaheurfarobardet.scashared.EtatAffaireS;
import frbouhadjaheurfarobardet.scashared.RdvCommercialS;
import frbouhadjaheurfarobardet.scashared.RdvPoseurS;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author jroba
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "AppCa_SCA")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class FileCA_SCA implements MessageListener {

    @EJB
    private RdvPoseurFacadeLocal rdvPoseurFacade;

    @EJB
    private RdvCommercialFacadeLocal rdvCommercialFacade;

    @EJB
    private ClientFacadeLocal clientFacade;

    @EJB
    private AffaireFacadeLocal affaireFacade;

    @EJB
    private MetierClientLocal metierClient;

    @EJB
    private MetierAffaireLocal metierAffaire;

    public FileCA_SCA() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                if ("CreerClient".equals(message.getJMSType())) {
                    ClientS client = (ClientS) ((ObjectMessage) message).getObject();
                    String nom = client.getNom();
                    String prenom = client.getPrenom();
                    String adresse = client.getAdresse();
                    String mail = client.getMail();
                    String tel = client.getTel();
                    String geolocalisation = client.getGeolocalisation();

                    System.out.println(nom + prenom + adresse + mail + tel + geolocalisation);
                    this.metierClient.CreerClient(nom, prenom, adresse, mail, tel, geolocalisation);

                } else if ("CreerAffaire".equals(message.getJMSType())) {
                    AffaireS affaireS = (AffaireS) ((ObjectMessage) message).getObject();
                    Client client = clientFacade.find(message.getLongProperty("id"));
                    this.metierAffaire.creerAffaire(client, affaireS.getAdresses(), affaireS.getGeolocalisation());
                    System.out.println(client.toString());
                } else if ("CreerRdvCommercial".equals(message.getJMSType())) {
                    Affaire affaire = affaireFacade.find(message.getLongProperty("idAffaire"));
                    rdvCommercialFacade.creerRdvCommercial(affaire, message.getLongProperty("idCreneau"), message.getLongProperty("idCommercial"));
                } else if (message.getJMSType().equals("CreerRdvPoseur")) {
                    Affaire affaire = affaireFacade.find(message.getLongProperty("idAffaire"));
                    rdvPoseurFacade.creerRdvPose(affaire, message.getLongProperty("idCreneau"), message.getLongProperty("idPoseur"));
                }
            } else if (message instanceof TextMessage) {
                if ("getCommandeLivre".equals(message.getJMSType())) {
                    Context context = new InitialContext();

                    // look up the ConnectionFactory
                    ConnectionFactory factory = null;
                    Connection connection = null;
                    String factoryName = "MenuiserieConnectionFactory";
                    Destination dest = null;
                    int count = 1;
                    Session session = null;
                    MessageProducer sender = null;
                    factory = (ConnectionFactory) context.lookup(factoryName);

                    // create the connection
                    connection = factory.createConnection();

                    // create the session
                    session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

                    // start the connection, to enable message sending
                    connection.start();

                    List<AffaireS> listeAffaire = new ArrayList<>();

                    for (Affaire a : this.affaireFacade.findAll()) {
                        if (a.getEtat() == EtatAffaire.LIVRE) {
                            listeAffaire.add(new AffaireS(a.getId(), a.getGeolocalisation(), a.getAdresses(), a.getIdCommande()));
                        }
                    }
                    MessageProducer producer = session.createProducer(null);
                    int cpt = 0;
                    while ((cpt < 3) && (message.getJMSReplyTo() != null)) {
                        AffaireS a = listeAffaire.get(cpt);
                        ObjectMessage reply = session.createObjectMessage();
                        reply.setObject((Serializable) a);
                        producer.send(message.getJMSReplyTo(), reply);
                        System.out.println("Sent [SCA} : " + a.toString());
                        cpt++;
                    }
                } else {
                    Context context = new InitialContext();

                    // look up the ConnectionFactory
                    ConnectionFactory factory = null;
                    Connection connection = null;
                    String factoryName = "MenuiserieConnectionFactory";
                    Destination dest = null;
                    int count = 1;
                    Session session = null;
                    MessageProducer sender = null;
                    factory = (ConnectionFactory) context.lookup(factoryName);

                    // create the connection
                    connection = factory.createConnection();

                    // create the session
                    session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

                    // start the connection, to enable message sending
                    connection.start();

                    MessageProducer producer = session.createProducer(null);

                    List<Client> listeClient = this.clientFacade.findAll();
                    int cpt = 0;
                    while ((cpt < 5) && (message.getJMSReplyTo() != null)) {
                        Client c = listeClient.get(cpt);
                        TextMessage reply = session.createTextMessage();
                        reply.setLongProperty("id", c.getId());
                        reply.setStringProperty("nom", c.getNom());
                        reply.setStringProperty("prenom", c.getPrenom());
                        producer.send(message.getJMSReplyTo(), reply);
                        cpt++;
                    }
                }
            }
        } catch (JMSException ex) {
            Logger.getLogger(FileCA_SCA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(FileCA_SCA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
