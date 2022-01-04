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
    public CommandeClient creerCommande(String ReferenceCatalogue, String CoteExact, String Tarif,Commercial commercial) {
    final  CommandeClient c = commandeClientFacade.creerCommande(ReferenceCatalogue, CoteExact, Tarif,commercial);
 
      
       
        return c;
      
    }
    
        @Override
    public List<CommandeClient> findAllComande() {
        List<CommandeClient> commandeC = commandeClientFacade.findAll();
        
        return commandeC;
    }
    
    
    //Etape3 Valider commande 
        @Override
    public CommandeClient ValiderCommande(Long idCommande)  {
        final CommandeClient commande = this.commandeClientFacade.find(idCommande);
     
         commande.setStatut(statutCommandeValidé);
         return commande;
    
    }
     @Override
    public Commercial findIdCom(Long idCommmercial){
        final Commercial commercial = this.commercialFacade.find(idCommmercial);
        return commercial;
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
