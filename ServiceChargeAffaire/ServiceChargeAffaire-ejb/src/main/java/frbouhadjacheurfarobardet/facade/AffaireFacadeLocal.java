/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.facade;

import frbouhadjacheurfarobardet.entities.Affaire;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JulienRobardet
 */
@Local
public interface AffaireFacadeLocal {

    void create(Affaire affaire);

    void edit(Affaire affaire);

    void remove(Affaire affaire);

    Affaire find(Object id);

    List<Affaire> findAll();

    List<Affaire> findRange(int[] range);

    int count();
    
}
