/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.metier;

import frbouhadjacheurfarobardet.entities.Affaire;
import frbouhadjacheurfarobardet.entities.Client;
import frbouhadjacheurfarobardet.facade.ClientFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author JulienRobardet
 */
@Stateless
public class MetierClient implements MetierClientLocal {

    @EJB
    private ClientFacadeLocal clientFacade;

    public MetierClient() {
    }
    
    @Override
    public void CreerClient(String nom, String prenom, String adresse, String mail, String tel, String geolocalisation) {
        this.clientFacade.CreerClient(nom,prenom,adresse,mail,tel,geolocalisation);
    }

    @Override
    public void addAffaire(Client client, Affaire affaire) {
        this.clientFacade.addAffaire(client, affaire);
    }
}
