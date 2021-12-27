/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.ServiceCommercial2.metier;

import com.miage.ServiceCommacial2.entities.CommandeClient;
import static com.miage.ServiceCommacial2.entities.CommandeClient.statutCommandeValidé;
import static com.miage.ServiceCommacial2.entities.CommandeClient.statutDebutCommande;
import com.miage.servicesCommercial2.facacde.CommandeClientFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AlaaCheurfa
 */
@Stateless
public class GestionCommandeClient implements GestionCommandeClientLocal {

     @EJB
    private CommandeClientFacadeLocal CommandeClient;
       @Override
    public void ValiderCommande(Long idCommande)  {
        final CommandeClient commande = this.CommandeClient.find(idCommande);
     
         CommandeClient.setStatut(statutCommandeValidé);
    
    
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
