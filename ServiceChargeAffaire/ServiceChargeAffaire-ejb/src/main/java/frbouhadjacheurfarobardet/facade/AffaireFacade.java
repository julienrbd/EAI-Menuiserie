/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.facade;

import frbouhadjacheurfarobardet.entities.Affaire;
import frbouhadjacheurfarobardet.entities.Client;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JulienRobardet
 */
@Stateless
public class AffaireFacade extends AbstractFacade<Affaire> implements AffaireFacadeLocal {

    @PersistenceContext(unitName = "frbouhadjacheurfarobardet_ServiceChargeAffaire-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AffaireFacade() {
        super(Affaire.class);
    }

    @Override
    public void creerAffaire(Client client, List<String> adresses, String geolocalisation) {
        Affaire affaire = new Affaire(client, adresses, geolocalisation);
        this.create(affaire);
    }
    
}
