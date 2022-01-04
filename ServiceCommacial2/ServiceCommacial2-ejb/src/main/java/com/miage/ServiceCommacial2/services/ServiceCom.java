/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.ServiceCommacial2.services;

import com.miage.ServiceCommacial2.entities.CommandeClient;
import static com.miage.ServiceCommacial2.entities.CommandeClient.statutCommandeValidé;
import static com.miage.ServiceCommacial2.entities.CommandeClient.statutDebutCommande;
import com.miage.ServiceCommacial2.entities.Commercial;
import com.miage.ServiceCommercial2.metier.GestionCommandeClientLocal;
import com.miage.servicesCommercial2.facacde.CommandeClientFacadeLocal;
import com.miage.servicesCommercial2.facacde.CommercialFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author AlaaCheurfa
 */
@Stateless
public class ServiceCom implements ServiceComLocal {

    @EJB
    private CommercialFacadeLocal commercialFacade;

    @EJB
    private CommandeClientFacadeLocal commandeClientFacade;

    @EJB
    private GestionCommandeClientLocal gestionCommandeClient;

    @Override
    public CommandeClient creerCommande(String ReferenceCatalogue, String CoteExact, String Tarif, Commercial commercial, Long idAffaire) {
        final CommandeClient c = commandeClientFacade.creerCommande(ReferenceCatalogue, CoteExact, Tarif, commercial);

        Context context = null;
        ConnectionFactory factory = null;
        Connection connection = null;
        String factoryName = "MenuiserieConnectionFactory";
        String destName = "SCommercial_SCA";
        Destination dest = null;
        int count = 1;
        Session session = null;
        MessageProducer sender = null;

        try {
            // create the JNDI initial context.
            context = new InitialContext();

            // look up the ConnectionFactory
            factory = (ConnectionFactory) context.lookup(factoryName);

            // look up the Destination
            dest = (Destination) context.lookup(destName);

            // create the connection
            connection = factory.createConnection();

            // create the session
            session = connection.createSession(
                    false, Session.AUTO_ACKNOWLEDGE);

            // create the sender
            sender = session.createProducer(dest);

            // start the connection, to enable message sends
            connection.start();

            for (int i = 0; i < count; ++i) {
                ObjectMessage message = session.createObjectMessage();
                message.setJMSType("CreerCmdClient");
                message.setLongProperty("idAffaire", idAffaire);
                message.setLongProperty("idCommandeClient", c.getId());
                sender.send(message);
//                System.out.println("Sent: " + client.toString());
            }
        } catch (JMSException exception) {
            exception.printStackTrace();
        } catch (NamingException exception) {
            exception.printStackTrace();
        } finally {
            // close the context
            if (context != null) {
                try {
                    context.close();
                } catch (NamingException exception) {
                    exception.printStackTrace();
                }
            }

            // close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException exception) {
                    exception.printStackTrace();
                }
            }
        }
        return c;

    }

    @Override
    public List<CommandeClient> findAllComande() {
        List<CommandeClient> commandeC = commandeClientFacade.findAll();

        return commandeC;
    }

    @Override
    public CommandeClient ValiderCommande(Long idCommande) {
        final CommandeClient commande = this.commandeClientFacade.find(idCommande);

        commande.setStatut(statutCommandeValidé);
        Context context = null;
        ConnectionFactory factory = null;
        Connection connection = null;
        String factoryName = "MenuiserieConnectionFactory";
        String destName = "SCommercial_SAchat";
        Destination dest = null;
        int count = 1;
        Session session = null;
        MessageProducer sender = null;

        try {
            // create the JNDI initial context.
            context = new InitialContext();

            // look up the ConnectionFactory
            factory = (ConnectionFactory) context.lookup(factoryName);

            // look up the Destination
            dest = (Destination) context.lookup(destName);

            // create the connection
            connection = factory.createConnection();

            // create the session
            session = connection.createSession(
                    false, Session.AUTO_ACKNOWLEDGE);

            // create the sender
            sender = session.createProducer(dest);

            // start the connection, to enable message sends
            connection.start();

            for (int i = 0; i < count; ++i) {
                ObjectMessage message = session.createObjectMessage();
                message.setJMSType("CreerCmdFournisseur");

                message.setLongProperty("idCommandeClient", idCommande);
                sender.send(message);
//                System.out.println("Sent: " + client.toString());
            }
        } catch (JMSException exception) {
            exception.printStackTrace();
        } catch (NamingException exception) {
            exception.printStackTrace();
        } finally {
            // close the context
            if (context != null) {
                try {
                    context.close();
                } catch (NamingException exception) {
                    exception.printStackTrace();
                }
            }

            // close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException exception) {
                    exception.printStackTrace();
                }
            }
        }
        return commande;

    }

    @Override
    public Commercial findIdCom(Long idCommmercial) {
        final Commercial commercial = this.commercialFacade.find(idCommmercial);
        return commercial;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
