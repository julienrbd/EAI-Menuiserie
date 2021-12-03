/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.facade;

import frbouhadjacheurfarobardet.entities.Affaire;
import frbouhadjacheurfarobardet.entities.Client;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JulienRobardet
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {

    @PersistenceContext(unitName = "frbouhadjacheurfarobardet_ServiceChargeAffaire-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

    @Override
    public void CreerClient(String nom, String prenom, String adresse, String mail, String tel, String geolocalisation) {
        Client client = new Client(nom, prenom, adresse, mail, tel, geolocalisation);
        this.create(client);
    }

    @Override
    public void addAffaire(Client client , Affaire affaire) {
        client = this.find(client.getId());
        List<Affaire> list = client.getListeAffaire();
        list.add(affaire);
        client.setListeAffaire(list);
        this.edit(client);
    }
    
}
