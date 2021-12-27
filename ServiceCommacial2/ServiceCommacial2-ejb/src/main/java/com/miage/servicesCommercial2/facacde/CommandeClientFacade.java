/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.servicesCommercial2.facacde;

import com.miage.ServiceCommacial2.entities.CommandeClient;
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
    public CommandeClient creerCommande(String ReferenceCatalogue, String CoteExact, String tarif, String IDVRDV, Commercial commercial) {
        CommandeClient nouvelleCommande = new CommandeClient(ReferenceCatalogue, CoteExact, CommandeClient.statutDebutCommande, tarif, commercial);
        this.create(nouvelleCommande);
        return nouvelleCommande;
    }

    @Override
    public void setStatut(String statutDebutCommande) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
