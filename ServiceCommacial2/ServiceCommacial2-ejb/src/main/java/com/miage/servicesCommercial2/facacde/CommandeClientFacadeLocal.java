/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.servicesCommercial2.facacde;

import com.miage.ServiceCommacial2.entities.CommandeClient;
import com.miage.ServiceCommacial2.entities.Commercial;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AlaaCheurfa
 */
@Local
public interface CommandeClientFacadeLocal {

 

    void create(CommandeClient commandeClient);
    
    public CommandeClient creerCommande(String ReferenceCatalogue, String CoteExact, String Tarif,Commercial commercial) ;

    void edit(CommandeClient commandeClient);

    void remove(CommandeClient commandeClient);

    CommandeClient find(Object id);

    List<CommandeClient> findAll();

    List<CommandeClient> findRange(int[] range);

    int count();

   
    
}
