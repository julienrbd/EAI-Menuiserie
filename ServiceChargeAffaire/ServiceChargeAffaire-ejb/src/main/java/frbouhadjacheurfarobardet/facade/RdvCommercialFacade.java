/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.facade;

import frbouhadjacheurfarobardet.entities.Affaire;
import frbouhadjacheurfarobardet.entities.RdvCommercial;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JulienRobardet
 */
@Stateless
public class RdvCommercialFacade extends AbstractFacade<RdvCommercial> implements RdvCommercialFacadeLocal {

    @PersistenceContext(unitName = "frbouhadjacheurfarobardet_ServiceChargeAffaire-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RdvCommercialFacade() {
        super(RdvCommercial.class);
    }

    @Override
    public void creerRdvCommercial(Affaire affaire, Long idCreneau, Long idCommercial) {
        RdvCommercial rdv = new RdvCommercial(idCreneau, idCommercial, affaire);
        this.create(rdv);
    }
    
    
}
