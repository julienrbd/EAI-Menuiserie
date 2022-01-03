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
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "SCommercial_SCA")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class FileSCommercial_SCA implements MessageListener {

    @EJB
    private AffaireFacadeLocal affaireFacade;
    
    public FileSCommercial_SCA() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            if(message.getJMSType().equals("CreerRdvClient")){
                long idAffaire = message.getLongProperty("idAffaire");
                long idCommande = message.getLongProperty("idCommande");
                Affaire affaire = affaireFacade.find(idAffaire);
                affaire.setIdCommande(idCommande);
                affaire.setEtat(EtatAffaire.VALIDEE);
                affaireFacade.edit(affaire);
            }   
        } catch (JMSException ex) {
            Logger.getLogger(FileSCommercial_SCA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
