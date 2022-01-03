/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.ServiceCommercial2.metier;

import com.miage.ServiceCommacial2.entities.CommandeClient;
import static com.miage.ServiceCommacial2.entities.CommandeClient.statutCommandeValidé;
import static com.miage.ServiceCommacial2.entities.CommandeClient.statutDebutCommande;
import com.miage.ServiceCommacial2.entities.Commercial;
import com.miage.servicesCommercial2.facacde.CommandeClientFacadeLocal;
import com.miage.servicesCommercial2.facacde.CommercialFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AlaaCheurfa
 */
@Stateless
public class GestionCommandeClient implements GestionCommandeClientLocal {

  

    @EJB
    private CommandeClientFacadeLocal commandeClientFacade;

  
  
   
    
   
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
