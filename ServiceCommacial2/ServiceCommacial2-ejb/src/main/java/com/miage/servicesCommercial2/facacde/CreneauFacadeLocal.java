/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.servicesCommercial2.facacde;

import com.miage.ServiceCommacial2.entities.Creneau;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AlaaCheurfa
 */
@Local
public interface CreneauFacadeLocal {

    void create(Creneau creneau);

    void edit(Creneau creneau);

    void remove(Creneau creneau);

    Creneau find(Object id);

    List<Creneau> findAll();

    List<Creneau> findRange(int[] range);

    int count();
    
}
