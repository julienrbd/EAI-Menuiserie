/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.metier;

import com.miage.Facade.PoseurFacadeLocal;
import javax.ejb.Stateless;

/**
 *
 * @author Mohamed-AmineBouhadj
 */
@Stateless
public class GestionPose implements GestionPoseLocal {
        PoseurFacadeLocal listeAffaire;
        PoseurFacadeLocal pose;
        String poseV= "poseV";
        @Override
        public void validerPose(String idAffaire) {
               PoseurFacadeLocal pose = (PoseurFacadeLocal) this.pose.find(idAffaire);
               
               pose.setStatut(poseV);
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        

        // Add business logic below. (Right-click in editor and choose
        // "Insert Code > Add Business Method")

        @Override
        public String AffairePoseur(String idAffaire) {
                listeAffaire=this.pose.find(idAffaire);
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return listeAffaire;
        }
}
