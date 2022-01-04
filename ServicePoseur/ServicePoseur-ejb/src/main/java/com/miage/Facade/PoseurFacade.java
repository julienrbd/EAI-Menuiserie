/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.Facade;

import com.miage.entities.Poseur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mohamed-AmineBouhadj
 */
@Stateless
public class PoseurFacade extends AbstractFacade<Poseur> implements PoseurFacadeLocal {

    @PersistenceContext(unitName = "com.miage_ServicePoseur-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PoseurFacade() {
        super(Poseur.class);
    }

    @Override
    public void create(String nom, String prenom) {
        
        Poseur p = new Poseur(nom, prenom);
        this.create(p);

    }

}
