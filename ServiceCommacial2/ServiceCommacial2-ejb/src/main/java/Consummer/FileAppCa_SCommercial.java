/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consummer;

import com.miage.ServiceCommacial2.entities.Commercial;
import com.miage.ServiceCommacial2.entities.Creneau;
import com.miage.ServiceCommercial2.metier.GestionCreneauLocal;
import com.miage.servicesCommercial2.facacde.CommercialFacadeLocal;
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
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "AppCa_SCommercial")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class FileAppCa_SCommercial implements MessageListener {

    @EJB
    private CommercialFacadeLocal commercialFacade;

    @EJB
    private GestionCreneauLocal gestionCreneau;

    public FileAppCa_SCommercial() {
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("[SCommercial]");
        commercialFacade.create("Robardet", "Julien");
        try {
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
            Calendar dateDebut = Calendar.getInstance();
            dateDebut.setTimeInMillis(message.getLongProperty("dateDebut"));
            Calendar dateFin = Calendar.getInstance();
            dateFin.setTimeInMillis(message.getLongProperty("dateFin"));
            MessageProducer producer = session.createProducer(null);
            Map<Long, List<Creneau>> listeDispo = this.gestionCreneau.InterrogerDisponibilite(dateDebut, dateFin);
            int cpt = 0;
            for (Map.Entry<Long, List<Creneau>> entry : listeDispo.entrySet()) {
                long idCommercial = entry.getKey();
                List<Creneau> liste = entry.getValue();
                Commercial comm = commercialFacade.find(idCommercial);
                for ( Creneau c:liste) {
                    TextMessage reply = session.createTextMessage();
                    reply.setLongProperty("idCommercial", idCommercial);
                    reply.setStringProperty("nom", comm.getName());
                    reply.setStringProperty("prenom", comm.getFirstName());
                    reply.setLongProperty("idCreneau", c.getId());
                    reply.setLongProperty("dateDebut", c.getDateDebut().getTimeInMillis());
                    reply.setLongProperty("dateFin", c.getDateFin().getTimeInMillis());
                    producer.send(message.getJMSReplyTo(), reply);
                }

            }
        } catch (NamingException ex) {
            Logger.getLogger(FileAppCa_SCommercial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JMSException ex) {
            Logger.getLogger(FileAppCa_SCommercial.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
