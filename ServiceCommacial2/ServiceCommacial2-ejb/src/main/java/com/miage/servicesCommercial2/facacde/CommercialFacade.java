/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.servicesCommercial2.facacde;

import com.miage.ServiceCommacial2.entities.Commercial;
import com.miage.ServiceCommacial2.entities.Creneau;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
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

    @EJB
    private CreneauFacadeLocal creneauFacade;

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
    public void create(String name, String firstName) {
        System.out.println("create dans la facade");
        Commercial c = new Commercial(name, firstName);
        Calendar dateD = Calendar.getInstance();
        Calendar dateF = Calendar.getInstance();
        List<Integer> listeH = new ArrayList<>();
        List<Creneau> listeC = new ArrayList<>();
        listeH.add(8);
        listeH.add(10);
        listeH.add(14);
        listeH.add(16);
        for (int i = 0; i < 7; i++) {
            for (int j : listeH) {
                dateD.set(2022, 0, i + 2, j, 0);
                dateF.set(2022, 0, i + 2, j + 2, 0);
                System.out.println(" Jour :" + dateD.get(Calendar.DAY_OF_MONTH) + "/"+dateD.get(Calendar.MONTH) + ":"+dateD.get(Calendar.HOUR_OF_DAY) );
                Creneau creneau = new Creneau(dateD, dateF);
                this.creneauFacade.create(creneau);
                listeC.add(creneau);
            }
        }
        c.setCreneau(listeC);
        this.create(c);

    }

}
