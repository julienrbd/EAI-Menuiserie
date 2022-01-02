/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.servicesCommercial2.facacde;

import com.miage.ServiceCommacial2.entities.Commercial;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author AlaaCheurfa
 */
@Stateless
public class CommercialFacade extends AbstractFacade<Commercial> implements CommercialFacadeLocal {

    @PersistenceContext(unitName = "com.miage.ServiceCommacial2_ServiceCommacial2-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommercialFacade() {
        super(Commercial.class);
    }
  
    
}
