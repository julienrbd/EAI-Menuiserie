/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.consummer;

import com.miage.Facade.PoseurFacadeLocal;
import com.miage.entities.Crenau;
import com.miage.entities.Poseur;
import com.miage.metier.GestionPoseLocal;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
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
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "AppCa_SPoseur")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class FileAppCaSposeur implements MessageListener {

    @EJB
    private GestionPoseLocal gestionPose;

    @EJB
    private PoseurFacadeLocal poseurFacade;
    
    public FileAppCaSposeur() {
    }
    
    @Override
    public void onMessage(Message message) {
        System.out.println("[SCommercial]");
        poseurFacade.create("Robardet", "Julien");
        try {
            Context context = new InitialContext();

            // look up the ConnectionFactory
            ConnectionFactory factory = null;
            Connection connection = null;
            String factoryName = "MenuiserieConnectionFactory";
            Destination dest = null;
            Session session = null;
            MessageProducer sender = null;
            factory = (ConnectionFactory) context.lookup(factoryName);

            // create the connection
            connection = factory.createConnection();

            // create the session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // start the connection, to enable message sending
            connection.start();
            Calendar dateDebut = Calendar.getInstance();
            dateDebut.setTimeInMillis(message.getLongProperty("dateDebut"));
            Calendar dateFin = Calendar.getInstance();
            dateFin.setTimeInMillis(message.getLongProperty("dateFin"));
            MessageProducer producer = session.createProducer(null);
            Map<Long, List<Crenau>> listeDispo = this.gestionPose.InterrogerDisponibilite(dateDebut, dateFin);
            for (Map.Entry<Long, List<Crenau>> entry : listeDispo.entrySet()) {
                long idCommercial = entry.getKey();
                List<Crenau> liste = entry.getValue();
                Poseur p = poseurFacade.find(idCommercial);
                for ( Crenau c:liste) {
                    TextMessage reply = session.createTextMessage();
                    reply.setLongProperty("idCommercial", idCommercial);
                    reply.setStringProperty("nom", p.getNom());
                    reply.setStringProperty("prenom", p.getPrenom());
                    reply.setLongProperty("idCrenau", c.getId());
                    reply.setLongProperty("dateDebut", c.getDateDebut().getTimeInMillis());
                    reply.setLongProperty("dateFin", c.getDateFin().getTimeInMillis());
                    producer.send(message.getJMSReplyTo(), reply);
                }

            }
        } catch (NamingException ex) {
            Logger.getLogger(FileAppCaSposeur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JMSException ex) {
            Logger.getLogger(FileAppCaSposeur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
