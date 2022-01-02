/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.metier;

import frbouhadjacheurfarobardet.entities.Affaire;
import java.util.Date;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author JulienRobardet
 */
@Local
public interface MetierRdvPoseLocal {

    public void creerRdvPose(Affaire affaire, Long idCreneau, Long idPoseur);
    public Map<Long, Long> InterrogerDisponibilite(Date DateDebut, Date DateFin);
    
}
