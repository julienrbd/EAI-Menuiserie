/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.facade;

import frbouhadjacheurfarobardet.entities.Affaire;
import frbouhadjacheurfarobardet.entities.Creneau;
import frbouhadjacheurfarobardet.entities.RdvPoseur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JulienRobardet
 */
@Stateless
public class RdvPoseurFacade extends AbstractFacade<RdvPoseur> implements RdvPoseurFacadeLocal {

    @PersistenceContext(unitName = "frbouhadjacheurfarobardet_ServiceChargeAffaire-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RdvPoseurFacade() {
        super(RdvPoseur.class);
    }

    @Override
    public void creerRdvPose(Affaire affaire, Creneau creneau, Long idPoseur) {
        RdvPoseur rdvPoseur = new RdvPoseur(affaire, creneau, idPoseur);
        this.create(rdvPoseur);
    }
    
}
