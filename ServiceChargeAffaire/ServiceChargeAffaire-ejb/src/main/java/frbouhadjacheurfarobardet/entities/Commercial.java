/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
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
public class Commercial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nom;
    private String prenom;
    
    @OneToMany
    private List<Creneau> listeDisponibilité;
    
    @OneToMany(mappedBy = "commercial")
    private List<RdvCommercial> listeRdv;

    public Commercial(Long id, String nom, String prenom, List<Creneau> listeDisponibilité, List<RdvCommercial> listeRdv) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.listeDisponibilité = listeDisponibilité;
        this.listeRdv = listeRdv;
    }

    public List<RdvCommercial> getListeRdv() {
        return listeRdv;
    }

    public void setListeRdv(List<RdvCommercial> listeRdv) {
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

    public List<Creneau> getListeDisponibilité() {
        return listeDisponibilité;
    }

    public void setListeDisponibilité(List<Creneau> listeDisponibilité) {
        this.listeDisponibilité = listeDisponibilité;
    }

    public Commercial(Long id, String nom, String prenom, List<Creneau> listeDisponibilité) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.listeDisponibilité = listeDisponibilité;
    }

    public Commercial() {
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
        if (!(object instanceof Commercial)) {
            return false;
        }
        Commercial other = (Commercial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "frbouhadjacheurfarobardet.entities.Commercial[ id=" + id + " ]";
    }
    
}
