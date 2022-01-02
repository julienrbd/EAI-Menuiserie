/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.Consumer;

import frbouhadjacheurfarobardet.entities.Affaire;
import frbouhadjacheurfarobardet.entities.Client;
import frbouhadjacheurfarobardet.metier.MetierAffaireLocal;
import frbouhadjacheurfarobardet.metier.MetierClientLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

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
    private MetierClientLocal metierClient;

    @EJB
    private MetierAffaireLocal metierAffaire;

    public FileCA_SCA() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                if ("CreerClient".equals(message.getJMSType())) {
                    String nom = message.getStringProperty("nom");
                    String prenom = message.getStringProperty("prenom");
                    String adresse = message.getStringProperty("adresse");
                    String mail = message.getStringProperty("mail");
                    String tel = message.getStringProperty("tel");
                    String geolocalisation = message.getStringProperty("geolocalisation");

                    System.out.println(nom + prenom + tel);
                    this.metierClient.CreerClient(nom, prenom, adresse, mail, tel, geolocalisation);

                }
            } else if (message instanceof ObjectMessage) {
                Affaire affaire = (Affaire) ((ObjectMessage) message).getObject();

                System.out.println(affaire.toString());
                this.metierAffaire.creerAffaire(affaire.getClient(), affaire.getAdresses(), affaire.getGeolocalisation());

            }

            //TextMessage message2 = new;
            //message2.setJMSReplyTo(message.getJMSReplyTo());
            //message2.send();
            // else if (message instanceof ObjectMessage) {
            // System.out.println("Received non text message");
            // }
        } catch (JMSException ex) {
            Logger.getLogger(FileCA_SCA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
