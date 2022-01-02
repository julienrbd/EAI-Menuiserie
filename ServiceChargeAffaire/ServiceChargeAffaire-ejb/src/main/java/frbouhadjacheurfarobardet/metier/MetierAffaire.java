/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.metier;

import frbouhadjacheurfarobardet.entities.Affaire;
import frbouhadjacheurfarobardet.entities.Client;
import frbouhadjacheurfarobardet.entities.EtatAffaire;
import frbouhadjacheurfarobardet.facade.AffaireFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author JulienRobardet
 */
@Stateless
public class MetierAffaire implements MetierAffaireLocal {

    @EJB
    private AffaireFacadeLocal affaireFacade;

    @Override
    public void creerAffaire(Client client, List<String> adresses, String geolocalisation) {
        this.affaireFacade.creerAffaire(client, adresses, geolocalisation);
    }

    @Override
    public void updateAffaire(Long idAffaire, EtatAffaire etat) {
        Affaire affaire = this.affaireFacade.find(idAffaire);
        affaire.setEtat(etat);
        this.affaireFacade.edit(affaire);
    }

    @Override
    public void cloturerAffaire(Long idAffaire) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void declencherEncaissement(Affaire affaire) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
