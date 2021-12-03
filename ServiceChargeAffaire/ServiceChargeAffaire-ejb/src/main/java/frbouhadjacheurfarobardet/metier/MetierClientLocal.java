/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.metier;

import frbouhadjacheurfarobardet.entities.Affaire;
import frbouhadjacheurfarobardet.entities.Client;
import javax.ejb.Local;

/**
 *
 * @author JulienRobardet
 */
@Local
public interface MetierClientLocal {
    
    void CreerClient(String nom, String prenom, String adresse, String mail, String tel, String geolocalisation);
    
    void addAffaire(Client client, Affaire affaire);
    
}
