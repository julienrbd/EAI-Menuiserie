/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.entities;

import java.io.Serializable;
import java.util.List;
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

    private EtatAffaire etat;

    private String geolocalisation;

    private List<String> adresses;

    private Boolean encaissement1;

    private Boolean encaissement2;

    private Long idCommande;
    @ManyToOne
    private Client client;
    
    @OneToOne
    private RdvCommercial rdvCommercial;
    
    @OneToOne
    private RdvPoseur rdvPoseur;

    public Affaire(Long id, EtatAffaire etat, String geolocalisation, List<String> adresses, Boolean encaissement1, Boolean encaissement2, Long idCommande, Client client, RdvCommercial rdvCommercial, RdvPoseur rdvPoseur) {
        this.id = id;
        this.etat = etat;
        this.geolocalisation = geolocalisation;
        this.adresses = adresses;
        this.encaissement1 = encaissement1;
        this.encaissement2 = encaissement2;
        this.idCommande = idCommande;
        this.client = client;
        this.rdvCommercial = rdvCommercial;
        this.rdvPoseur = rdvPoseur;
    }

    public RdvCommercial getRdvCommercial() {
        return rdvCommercial;
    }

    public void setRdvCommercial(RdvCommercial rdvCommercial) {
        this.rdvCommercial = rdvCommercial;
    }

    public RdvPoseur getRdvPoseur() {
        return rdvPoseur;
    }

    public void setRdvPoseur(RdvPoseur rdvPoseur) {
        this.rdvPoseur = rdvPoseur;
    }

    public List<String> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<String> adresses) {
        this.adresses = adresses;
    }

    public String getGeolocalisation() {
        return geolocalisation;
    }

    public void setGeolocalisation(String geolocalisation) {
        this.geolocalisation = geolocalisation;
    }

    public EtatAffaire getEtat() {
        return etat;
    }

    public void setEtat(EtatAffaire etat) {
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Affaire() {
    }

    public Affaire(Client client, List<String> adresses, String geolocalisation) {
        this.geolocalisation = geolocalisation;
        this.adresses = adresses;
        this.client = client;
        this.encaissement1 = false;
        this.encaissement2 = false;
        this.etat = EtatAffaire.CREE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
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
