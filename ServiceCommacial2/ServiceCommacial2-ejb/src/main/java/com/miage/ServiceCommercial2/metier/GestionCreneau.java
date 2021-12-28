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
import java.util.Calendar;
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
    public Map<Long,List<Creneau>> InterrogerDisponibilite(Calendar DateDebut, Calendar DateFin) {
        
        Map<Long, List<Creneau>> listeDisponibilite = new HashMap<Long, List<Creneau>>();
        List<Commercial > ListCommercial = new ArrayList<Commercial>();
       ListCommercial=this.Commercial.findAll();
        List<Creneau > ListCreneau = new ArrayList<Creneau>();
         List<Long > ListIDcommercial = new ArrayList<Long>();
        
        for(Commercial commercial:ListCommercial){
            ListCreneau=commercial.getCreneau();
            List<Creneau > ListCreneauValide = new ArrayList<Creneau>();
            ListIDcommercial.add(commercial.getId());
            
            for(Creneau creneau:ListCreneau){
                if (creneau.getDateDebut().after(DateDebut) && (creneau.getDateFin().before(DateFin))){
                    ListCreneauValide.add(creneau);
                    
                    
                    
                }
            }
         listeDisponibilite.put(commercial.getId(),ListCreneauValide);
        }
        
        
       
//liste disponibilite = resultat requeteapi
        return listeDisponibilite;   }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
