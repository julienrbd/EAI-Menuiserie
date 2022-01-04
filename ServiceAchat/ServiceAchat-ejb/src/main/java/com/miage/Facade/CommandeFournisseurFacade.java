/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.Facade;

import com.miage.Entities.CommandeFournisseur;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jroba
 */
public class CommandeFournisseurFacade extends AbstractFacade<CommandeFournisseur> implements CommandeFournisseurFacadeLocal{

    @PersistenceContext(unitName = "com.miage_ServiceAchat-ejb_ejb_1.0PU")
    private EntityManager em;

    public CommandeFournisseurFacade(Class<CommandeFournisseur> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
