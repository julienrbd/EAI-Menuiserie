/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.servicesCommercial2.facacde;

import com.miage.ServiceCommacial2.entities.CommandeClient;
import static com.miage.ServiceCommacial2.entities.CommandeClient.statutDebutCommande;
import static com.miage.ServiceCommacial2.entities.CommandeClient_.statut;
import com.miage.ServiceCommacial2.entities.Commercial;
import java.util.Calendar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AlaaCheurfa
 */
@Stateless
public class CommandeClientFacade extends AbstractFacade<CommandeClient> implements CommandeClientFacadeLocal {

    @PersistenceContext(unitName = "com.miage.ServiceCommacial2_ServiceCommacial2-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeClientFacade() {
        super(CommandeClient.class);
    }
    
    
    @Override
    public CommandeClient creerCommande(String ReferenceCatalogue, String CoteExact, String Tarif,Commercial commercial) {
        CommandeClient nouvelleCommande = new CommandeClient(ReferenceCatalogue, CoteExact, Tarif,commercial);
        nouvelleCommande.setStatut(statutDebutCommande);
        this.create(nouvelleCommande);
        
        return nouvelleCommande;
        
        
     
    }

}
