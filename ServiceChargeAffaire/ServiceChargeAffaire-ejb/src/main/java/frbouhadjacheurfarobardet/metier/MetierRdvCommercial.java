/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.metier;

import frbouhadjacheurfarobardet.entities.Affaire;
import frbouhadjacheurfarobardet.entities.Creneau;
import frbouhadjacheurfarobardet.facade.RdvCommercialFacadeLocal;
import java.util.ArrayList;
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
    public void creerRdvCommercial(Affaire affaire, Creneau creneau, Long idCommercial) {
        this.rdvCommercialFacade.creerRdvCommercial(affaire, creneau, idCommercial);
    }

    @Override
    public Map<Long, Creneau> InterrogerDisponibilite(Date DateDebut, Date DateFin) {
        Map<Long, Creneau> listeDisponibilite = new HashMap<Long, Creneau>();
        //liste disponibilite = resultat requeteapi
        return listeDisponibilite;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
