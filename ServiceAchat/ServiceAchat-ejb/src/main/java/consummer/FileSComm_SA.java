/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consummer;

import com.miage.Entities.CommandeFournisseur;
import com.miage.Facade.CommandeFournisseurFacadeLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author jroba
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "SCommercial_SAchat")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class FileSComm_SA implements MessageListener {

    @EJB
    private CommandeFournisseurFacadeLocal commandeFournisseurFacade;

    public FileSComm_SA() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            long idCmd = message.getLongProperty("idCommande");
            CommandeFournisseur commandeFournisseur = new CommandeFournisseur(idCmd);
            this.commandeFournisseurFacade.create(commandeFournisseur);
        } catch (JMSException ex) {
            Logger.getLogger(FileSComm_SA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
