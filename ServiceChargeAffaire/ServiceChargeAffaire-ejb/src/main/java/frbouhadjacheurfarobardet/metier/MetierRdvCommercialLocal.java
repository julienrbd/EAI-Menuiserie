/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.metier;

import frbouhadjacheurfarobardet.entities.Affaire;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author JulienRobardet
 */
@Local
public interface MetierRdvCommercialLocal {
    public void creerRdvCommercial(Affaire affaire, Long idCreneau, Long idCommercial);
    public Map<Long, List<Long>> InterrogerDisponibilite(Calendar DateDebut, Calendar DateFin);
}
