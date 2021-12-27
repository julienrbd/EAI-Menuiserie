/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.ServiceCommercial2.metier;

import com.miage.ServiceCommacial2.entities.CommandeClient;
import com.miage.ServiceCommacial2.entities.Commercial;
import com.miage.ServiceCommacial2.entities.Creneau;

import com.miage.servicesCommercial2.facacde.CommandeClientFacadeLocal;
import com.miage.servicesCommercial2.facacde.CommercialFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AlaaCheurfa
 */
@Stateless
public class GestionCreneau implements GestionCreneauLocal {
    
    @EJB
    private CommercialFacadeLocal Commercial;
      
     @Override
    public Map<Long, Creneau> InterrogerDisponibilite(Date DateDebut, Date DateFin) {
        
        Map<Long, Creneau> listeDisponibilite = new HashMap<Long, Creneau>();
        List<Commercial > ListCommercial = new ArrayList<Commercial>();
       ListCommercial=this.Commercial.findAll();
        List<Creneau > ListCreneau = new ArrayList<Creneau>();
        for(Commercial commercial:ListCommercial){
            
        }
       
//liste disponibilite = resultat requeteapi
        return listeDisponibilite;   }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
