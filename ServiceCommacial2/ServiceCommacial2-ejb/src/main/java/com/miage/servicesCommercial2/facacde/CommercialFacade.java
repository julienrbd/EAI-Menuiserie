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
    
        @Override
    public Commercial findByPrenomAndNom(String Name, String FirstName) {
        try {
            CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
            CriteriaQuery<Commercial> cq = cb.createQuery(Commercial.class);
            Root<Commercial> root = cq.from(Commercial.class);
            cq.where(
                    cb.and(
                            cb.equal(cb.upper(root.get("Name").as(String.class)), Name.toUpperCase()),
                            cb.equal(cb.upper(root.get("FirstName").as(String.class)), FirstName.toUpperCase())
                    )
            );
            return getEntityManager().createQuery(cq).getSingleResult();
        } catch (NoResultException noRes) {
            return null;
        }
    }
    
}
