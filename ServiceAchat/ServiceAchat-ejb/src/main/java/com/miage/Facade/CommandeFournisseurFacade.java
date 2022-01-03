/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.Entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;




/**
 *
 * @author Mohamed-AmineBouhadj
 */
@Stateless
public class CommandeFournisseurFacade extends AbstractFacade<CommandeFournisseur> implements CommandeFournisseurFacadeLocal {

        @PersistenceContext(unitName = "com.miage_ServiceAchat-ejb_ejb_1.0PU")
        private EntityManager em;

        @Override
        protected EntityManager getEntityManager() {
                return em;
        }

        public CommandeFournisseurFacade() {
                super(CommandeFournisseur.class);
        }
        
}
