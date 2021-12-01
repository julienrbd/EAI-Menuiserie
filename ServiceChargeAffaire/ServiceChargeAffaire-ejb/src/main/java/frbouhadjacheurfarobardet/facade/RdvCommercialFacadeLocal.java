/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.facade;

import frbouhadjacheurfarobardet.entities.RdvCommercial;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JulienRobardet
 */
@Local
public interface RdvCommercialFacadeLocal {

    void create(RdvCommercial rdvCommercial);

    void edit(RdvCommercial rdvCommercial);

    void remove(RdvCommercial rdvCommercial);

    RdvCommercial find(Object id);

    List<RdvCommercial> findAll();

    List<RdvCommercial> findRange(int[] range);

    int count();
    
}
