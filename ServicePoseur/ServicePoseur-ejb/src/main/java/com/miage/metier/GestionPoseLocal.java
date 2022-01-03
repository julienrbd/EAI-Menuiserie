/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.metier;

import com.miage.entities.Crenau;
import com.miage.entities.Poseur;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author Mohamed-AmineBouhadj
 */
@Local
public interface GestionPoseLocal {
        
         public Poseur validerPose(String idPoseur);
        public Map<Long, List<Crenau>> InterrogerDisponibilite(Calendar DateDebut, Calendar DateFin);
        
        
}
