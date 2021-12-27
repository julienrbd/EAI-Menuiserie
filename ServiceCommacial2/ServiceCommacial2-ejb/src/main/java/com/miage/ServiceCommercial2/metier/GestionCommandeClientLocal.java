/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.ServiceCommercial2.metier;

import javax.ejb.Local;

/**
 *
 * @author AlaaCheurfa
 */
@Local
public interface GestionCommandeClientLocal {
     public void ValiderCommande(Long idCommande);
    
}
