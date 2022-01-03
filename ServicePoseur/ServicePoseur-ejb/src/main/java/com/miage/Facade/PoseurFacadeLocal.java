/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.Facade;

import com.miage.entities.Poseur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mohamed-AmineBouhadj
 */
@Local
public interface PoseurFacadeLocal {

        void create(Poseur poseur);

        void edit(Poseur poseur);

        void remove(Poseur poseur);

        Poseur find(Object id);

        List<Poseur> findAll();

        List<Poseur> findRange(int[] range);

        int count();

        public void setStatut(String poseV);
        
}
