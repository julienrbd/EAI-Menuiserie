/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.metier;

import com.miage.Facade.PoseurFacadeLocal;
import com.miage.entities.Crenau;
import com.miage.entities.Poseur;
import static com.miage.entities.Poseur.statutPoseurValidé;
import static com.miage.entities.Poseur_.Creneau;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Mohamed-AmineBouhadj
 */
@Stateless
public class GestionPose implements GestionPoseLocal {

    @EJB
    private PoseurFacadeLocal poseurFacade;

    
        @Override
        public Poseur validerPose(String idPoseur) {
            final Poseur pose = this.poseurFacade.find(idPoseur);
            pose.setStatut(statutPoseurValidé);
            return pose;
            
               //To change body of generated methods, choose Tools | Templates.
        }
        

        // Add business logic below. (Right-click in editor and choose
        // "Insert Code > Add Business Method")

         @Override
    public Map<Long, List<Crenau>> InterrogerDisponibilite(Calendar DateDebut, Calendar DateFin) {

        Map<Long, List<Crenau>> listeDisponibilite = new HashMap<Long, List<Crenau>>();
        List<Poseur> ListPoseur = new ArrayList<Poseur>();
        ListPoseur = this.poseurFacade.findAll();
        List<Crenau> ListCreneau = new ArrayList<Crenau>();
        List<Long> ListIDPoseur = new ArrayList<Long>();

        for (Poseur poseur : ListPoseur) {
            ListCreneau = poseur.getCreneau();
            List<Crenau> ListCreneauValide = new ArrayList<Crenau>();
            ListIDPoseur.add(poseur.getId());

            for (Crenau creneau : ListCreneau) {
                if (creneau.getDateDebut().after(DateDebut) && (creneau.getDateFin().before(DateFin))) {
                    ListCreneauValide.add(creneau);
                }
            }
            listeDisponibilite.put(poseur.getId(), ListCreneauValide);
        }

        return listeDisponibilite;
    }
}
