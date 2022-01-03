/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.metier;

import javax.ejb.Stateless;

/**
 *
 * @author Mohamed-AmineBouhadj
 */
@Stateless
public abstract class CommandeFournisseur implements CommandeFournisseurLocal {
        
        public void CreerCommandeFournisseur(String commandeC[]){
              commandeFourniseur  commandeF=new commandeFourniseur(commandeC);
        }
        
}
