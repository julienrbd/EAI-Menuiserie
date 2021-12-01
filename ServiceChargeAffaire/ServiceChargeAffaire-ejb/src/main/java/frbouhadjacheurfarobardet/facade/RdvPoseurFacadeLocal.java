/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.facade;

import frbouhadjacheurfarobardet.entities.RdvPoseur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JulienRobardet
 */
@Local
public interface RdvPoseurFacadeLocal {

    void create(RdvPoseur rdvPoseur);

    void edit(RdvPoseur rdvPoseur);

    void remove(RdvPoseur rdvPoseur);

    RdvPoseur find(Object id);

    List<RdvPoseur> findAll();

    List<RdvPoseur> findRange(int[] range);

    int count();
    
}
