/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.metier;

import frbouhadjacheurfarobardet.entities.Affaire;
import frbouhadjacheurfarobardet.entities.Client;
import frbouhadjacheurfarobardet.entities.EtatAffaire;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JulienRobardet
 */
@Local
public interface MetierAffaireLocal {
    
    public void creerAffaire(Client client, List<String> adresses, String geolocalisation);
    public void updateAffaire(Long idAffaire, EtatAffaire etat);
    public void cloturerAffaire(Long idAffaire);
    public void declencherEncaissement(Affaire affaire);
    
    
}
