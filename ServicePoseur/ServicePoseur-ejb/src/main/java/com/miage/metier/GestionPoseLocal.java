/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.metier;

import javax.ejb.Local;

/**
 *
 * @author Mohamed-AmineBouhadj
 */
@Local
public interface GestionPoseLocal {
        
        public void validerPose (String idAffaire);
        public String AffairePoseur (String idAffaire );
}
