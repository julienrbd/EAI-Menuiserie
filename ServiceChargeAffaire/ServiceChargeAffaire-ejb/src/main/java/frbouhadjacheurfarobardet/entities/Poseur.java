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
import javax.persistence.OneToMany;

/**
 *
 * @author JulienRobardet
 */
@Entity
public class Poseur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    @OneToMany
    private List<Creneau> listeDisponibilite;
    @OneToMany(mappedBy = "poseur")
    private List<Commande> listeCommandes;
    @OneToMany(mappedBy = "poseur")
    private List<RdvPoseur> listeRdv;

    public Poseur(Long id, String nom, String prenom, List<Creneau> listeDisponibilite, List<Commande> listeCommandes, List<RdvPoseur> listeRdv) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.listeDisponibilite = listeDisponibilite;
        this.listeCommandes = listeCommandes;
        this.listeRdv = listeRdv;
    }

    public List<Commande> getListeCommandes() {
        return listeCommandes;
    }

    public void setListeCommandes(List<Commande> listeCommandes) {
        this.listeCommandes = listeCommandes;
    }

    public List<RdvPoseur> getListeRdv() {
        return listeRdv;
    }

    public void setListeRdv(List<RdvPoseur> listeRdv) {
        this.listeRdv = listeRdv;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Creneau> getListeDisponibilite() {
        return listeDisponibilite;
    }

    public void setListeDisponibilite(List<Creneau> listeDisponibilite) {
        this.listeDisponibilite = listeDisponibilite;
    }

    public Poseur() {
    }

    public Poseur(Long id, String nom, String prenom, List<Creneau> listeDisponibilite) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.listeDisponibilite = listeDisponibilite;
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
        if (!(object instanceof Poseur)) {
            return false;
        }
        Poseur other = (Poseur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "frbouhadjacheurfarobardet.entities.Poseur[ id=" + id + " ]";
    }
    
}
