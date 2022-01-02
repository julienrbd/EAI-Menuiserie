/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.ServiceCommercial2.metier;

import com.miage.ServiceCommacial2.entities.CommandeClient;
import com.miage.ServiceCommacial2.entities.Commercial;
import javax.ejb.Local;

/**
 *
 * @author AlaaCheurfa
 */
@Local
public interface GestionCommandeClientLocal {
    
      public void  creerCommande(String ReferenceCatalogue, String CoteExact, String tarif, Commercial commercial);
      public void ValiderCommande(Long idCommande);
    
}
