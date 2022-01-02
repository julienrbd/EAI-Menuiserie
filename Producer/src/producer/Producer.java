/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer;

import frbouhadjaheurfarobardet.scashared.AffaireS;
import frbouhadjaheurfarobardet.scashared.ClientS;
import frbouhadjaheurfarobardet.scommercialshared.CreneauS;
import frbouhadjaheurfarobardet.scommercialshared.CommercialS;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.jms.ConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueReceiver;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author jroba
 */
public class Producer {

    /**
     * @param args the command line arguments
     */
    public static void creerClient(ClientS client) {
        Context context = null;
        ConnectionFactory factory = null;
        Connection connection = null;
        String factoryName = "MenuiserieConnectionFactory";
        String destName = "AppCa_SCA";
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
                message.setJMSType("CreerClient");
                message.setObject((Serializable) client);
                sender.send(message);
                System.out.println("Sent: " + client.toString());
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
    }

    public static void creerAffaire(AffaireS affaire, long idClient) {
        Context context = null;
        ConnectionFactory factory = null;
        Connection connection = null;
        String factoryName = "MenuiserieConnectionFactory";
        String destName = "AppCa_SCA";
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
                message.setObject((Serializable) affaire);
                message.setJMSType("CreerAffaire");
                message.setLongProperty("id", idClient);

                sender.send(message);
                System.out.println("Sent: " + affaire.toString() + idClient);
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
    }

    public static void getClients() {
        Context context = null;
        ConnectionFactory factory = null;
        Connection connection = null;
        String factoryName = "MenuiserieConnectionFactory";
        String destName = "AppCa_SCA";
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
                /*
                TextMessage message = session.createTextMessage();
                Queue tempQueue = session.createTemporaryQueue();
                TextMessage request = session.createTextMessage(); 
                request.setJMSType("getClient");
                request.setJMSReplyTo(tempQueue);
                QueueReceiver receiver = session.createReceiver(tempQueue);
                Message response = receiver.receive();

                sender.send(message);
                System.out.println("Sent: " + affaire.toString());
                 */

                Queue tmpQueue = session.createTemporaryQueue();
                MessageConsumer consumer = session.createConsumer(tmpQueue);

                // boucle de production
                TextMessage MsgGetDispoCom = session.createTextMessage();
                MsgGetDispoCom.setText("getClient");
                MsgGetDispoCom.setJMSReplyTo(tmpQueue);
                sender.send(MsgGetDispoCom);
                System.out.println("[CA] Sent: " + MsgGetDispoCom.getText());

                // Wait for response
                for (int cpt = 0; cpt < 5; cpt++) {
                    Message reply = consumer.receive();
                    TextMessage tm = (TextMessage) reply;
                    System.out.println("[CA] Got reply: " + tm.getLongProperty("id") + tm.getStringProperty("nom") + tm.getStringProperty("prenom"));
                }
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
    }

    public static void getDispo(Calendar dateDebut, Calendar dateFin) {
        Context context = null;
        ConnectionFactory factory = null;
        Connection connection = null;
        String factoryName = "MenuiserieConnectionFactory";
        String destName = "AppCa_SCommercial";
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

                Queue tmpQueue = session.createTemporaryQueue();
                MessageConsumer consumer = session.createConsumer(tmpQueue);

                // boucle de production
                TextMessage MsgGetDispoCom = session.createTextMessage();
                MsgGetDispoCom.setJMSType("GetDispo");
                MsgGetDispoCom.setText("getDispoCommerciaux");
                MsgGetDispoCom.setLongProperty("dateDebut", dateDebut.getTimeInMillis());
                MsgGetDispoCom.setLongProperty("dateFin", dateFin.getTimeInMillis());
                MsgGetDispoCom.setJMSReplyTo(tmpQueue);
                sender.send(MsgGetDispoCom);
                System.out.println("[CA] Sent: " + MsgGetDispoCom.getText());

                // Wait for response
                Calendar dateD = Calendar.getInstance();
                Calendar dateF = Calendar.getInstance();
                
                for (int cpt = 0; cpt < 28; cpt++) {
                    Message reply = consumer.receive();
                    TextMessage tm = (TextMessage) reply;
                    dateD.setTimeInMillis(tm.getLongProperty("dateDebut"));
                    dateF.setTimeInMillis(tm.getLongProperty("dateFin"));
                    System.out.println("[CA] Got reply: Commercial : " + tm.getLongProperty("idCommercial") + tm.getStringProperty("nom") + tm.getStringProperty("prenom"));
                    System.out.println("[CA] Got reply: Creneau : " + tm.getLongProperty("idCreneau") + dateD.toString() + dateF.toString());

                }
                Message reply = consumer.receive();
                TextMessage tm = (TextMessage) reply;
                System.out.println("[CA] Got reply: " + tm.getLongProperty("id") + tm.getStringProperty("nom") + tm.getStringProperty("prenom"));
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
    }

    public static void creerRdvCommercial(long idAffaire, long idCommercial, long idCreneau) {
        Context context = null;
        ConnectionFactory factory = null;
        Connection connection = null;
        String factoryName = "MenuiserieConnectionFactory";
        String destName = "AppCa_SCA";
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
                message.setJMSType("CreerRdvCommercial");

                message.setLongProperty("idAffaire", idAffaire);
                message.setLongProperty("idCreneau", idCreneau);
                message.setLongProperty("idCommercial", idCommercial);
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
        //ConfirmationRdv(idAffaire, idCommercial, idCreneau);
    }

    public static void ConfirmationRdv(Long idAffaire, Long idCommercial, Long idCreneau) {
        Context context = null;
        ConnectionFactory factory = null;
        Connection connection = null;
        String factoryName = "MenuiserieConnectionFactory";
        String destName = "AppCa_SCommercial";
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
                TextMessage message = session.createTextMessage();
                message.setJMSType("ConfirmerRdvClient");

                message.setLongProperty("idAffaire", idAffaire);
                message.setLongProperty("idCreneau", idCreneau);
                message.setLongProperty("idCommercial", idCommercial);
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
    }

    public static void main(String[] args) {
        ClientS client = new ClientS("nom", "prenom", "adresse", "mail", "tel", "geolocalisation");
        creerClient(client);

        ClientS client2 = new ClientS("nom2", "prenom2", "adresse2", "mail2", "tel2", "geolocalisation2");
        creerClient(client2);

        ClientS client3 = new ClientS("nom3", "prenom3", "adresse2", "mail2", "tel2", "geolocalisation2");
        creerClient(client3);

        ClientS client4 = new ClientS("nom4", "prenom4", "adresse2", "mail2", "tel2", "geolocalisation2");
        creerClient(client4);
        ClientS client5 = new ClientS("nom5", "prenom5", "adresse2", "mail2", "tel2", "geolocalisation2");
        creerClient(client5);
        ClientS client6 = new ClientS("nom6", "prenom6", "adresse2", "mail2", "tel2", "geolocalisation2");
        creerClient(client6);

        getClients();
        //envoie msg jms
        List<String> liste = new ArrayList<>();
        liste.add("mail");
        liste.add("postale");
        AffaireS affaire = new AffaireS("geolocalisation", liste);
        creerAffaire(affaire, (long) 1);
        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();
        date2.set(Calendar.DAY_OF_MONTH, date1.get(Calendar.DAY_OF_MONTH)+7 );
        getDispo(date1, date2);

        long idCommercial = (long) 1;
        long idCreneau = (long) 1;

        creerRdvCommercial((long) 1, idCommercial, idCreneau);
    }

}
