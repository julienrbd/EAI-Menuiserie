/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.Entities;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mohamed-AmineBouhadj
 */
@Local
public interface CommandeFournisseurFacadeLocal {

        void create(CommandeFournisseur commandeFournisseur);

        void edit(CommandeFournisseur commandeFournisseur);

        void remove(CommandeFournisseur commandeFournisseur);

        CommandeFournisseur find(Object id);

        List<CommandeFournisseur> findAll();

        List<CommandeFournisseur> findRange(int[] range);

        int count();
        
}
