/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author JulienRobardet
 */
@Entity
public class Affaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String etat;
    private Boolean encaissement1;
    private Boolean encaissement2;
    @OneToOne(mappedBy = "affaire")
    private Commande commande;
    @ManyToOne
    private Client client;

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Boolean getEncaissement1() {
        return encaissement1;
    }

    public void setEncaissement1(Boolean encaissement1) {
        this.encaissement1 = encaissement1;
    }

    public Boolean getEncaissement2() {
        return encaissement2;
    }

    public void setEncaissement2(Boolean encaissement2) {
        this.encaissement2 = encaissement2;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Affaire() {
    }

    public Affaire(Long id, String etat, Boolean encaissement1, Boolean encaissement2, Commande commande, Client client) {
        this.id = id;
        this.etat = etat;
        this.encaissement1 = encaissement1;
        this.encaissement2 = encaissement2;
        this.commande = commande;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Affaire)) {
            return false;
        }
        Affaire other = (Affaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "frbouhadjacheurfarobardet.entities.Affaire[ id=" + id + " ]";
    }
    
}
