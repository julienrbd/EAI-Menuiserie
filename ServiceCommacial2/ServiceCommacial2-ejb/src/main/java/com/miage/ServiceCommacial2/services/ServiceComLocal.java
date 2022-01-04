/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.ServiceCommacial2.services;

import com.miage.ServiceCommacial2.entities.CommandeClient;
import com.miage.ServiceCommacial2.entities.Commercial;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.metamodel.SingularAttribute;

/**
 *
 * @author AlaaCheurfa
 */
@Local
public interface ServiceComLocal {
   public CommandeClient creerCommande(String ReferenceCatalogue, String CoteExact, String Tarif,Commercial commercial, Long idAffaire);
      public List<CommandeClient> findAllComande() ;
      public CommandeClient ValiderCommande(Long idCommande);
       public Commercial findIdCom(Long idCommmercial);


    
}
