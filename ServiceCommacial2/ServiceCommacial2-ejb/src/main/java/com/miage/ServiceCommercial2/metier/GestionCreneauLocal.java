/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.ServiceCommercial2.metier;

import com.miage.ServiceCommacial2.entities.Creneau;
import java.util.Date;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author AlaaCheurfa
 */
@Local
public interface GestionCreneauLocal {
    public Map<Long, Creneau> InterrogerDisponibilite(Date DateDebut, Date DateFin);
}
