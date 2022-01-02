/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.metier;

import frbouhadjacheurfarobardet.entities.Affaire;
import frbouhadjacheurfarobardet.facade.RdvCommercialFacadeLocal;
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
 * @author JulienRobardet
 */
@Stateless
public class MetierRdvCommercial implements MetierRdvCommercialLocal {

    @EJB
    private RdvCommercialFacadeLocal rdvCommercialFacade;

    @Override
    public void creerRdvCommercial(Affaire affaire, Long idCreneau, Long idCommercial) {
        this.rdvCommercialFacade.creerRdvCommercial(affaire, idCreneau, idCommercial);
    }
    
    @Override
    public Map<Long, List<Long>> InterrogerDisponibilite(Calendar DateDebut, Calendar DateFin) {
        Map<Long, List<Long>> listeDisponibilite = new HashMap<Long, List<Long>>();
        return listeDisponibilite;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
