/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.metier;

import frbouhadjacheurfarobardet.entities.Affaire;
import frbouhadjacheurfarobardet.facade.RdvPoseurFacadeLocal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author JulienRobardet
 */
@Stateless
public class MetierRdvPose implements MetierRdvPoseLocal {

    @EJB
    private RdvPoseurFacadeLocal rdvPoseurFacade;

    @Override
    public void creerRdvPose(Affaire affaire, Long idCreneau, Long idPoseur) {
        this.rdvPoseurFacade.creerRdvPose(affaire, idCreneau, idPoseur);
    }

    @Override
    public Map<Long, Long> InterrogerDisponibilite(Date DateDebut, Date DateFin) {
        Map<Long, Long> listeDisponibilite = new HashMap<Long, Long>();
        //liste disponibilite = resultat requeteapi
        return listeDisponibilite;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
