/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.Consumer;

import frbouhadjacheurfarobardet.entities.Affaire;
import frbouhadjacheurfarobardet.entities.EtatAffaire;
import frbouhadjacheurfarobardet.facade.AffaireFacadeLocal;
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
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "AppAchat_SCA")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class fileAppAchat_SCA implements MessageListener {

    @EJB
    private AffaireFacadeLocal affaireFacade;
    
    public fileAppAchat_SCA() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            long idCommande = message.getLongProperty("idCommande");
            for (Affaire a : this.affaireFacade.findAll()){
            if (a.getIdCommande() == idCommande){
                a.setEtat(EtatAffaire.LIVRE);
                this.affaireFacade.edit(a);
            }
        }
        } catch (JMSException ex) {
            Logger.getLogger(fileAppAchat_SCA.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
