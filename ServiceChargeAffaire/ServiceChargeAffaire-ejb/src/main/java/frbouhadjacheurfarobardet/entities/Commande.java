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
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String reference;
    private String cote;
    private String tarif;
    @OneToOne
    private Affaire affaire;
    @ManyToOne
    private Poseur poseur;

    public Commande(Long id, String reference, String cote, String tarif, Affaire affaire, Poseur poseur) {
        this.id = id;
        this.reference = reference;
        this.cote = cote;
        this.tarif = tarif;
        this.affaire = affaire;
        this.poseur = poseur;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Affaire getAffaire() {
        return affaire;
    }

    public void setAffaire(Affaire affaire) {
        this.affaire = affaire;
    }

    public Poseur getPoseur() {
        return poseur;
    }

    public void setPoseur(Poseur poseur) {
        this.poseur = poseur;
    }

    public String getRef() {
        return reference;
    }

    public void setRef(String reference) {
        this.reference = reference;
    }

    public String getCote() {
        return cote;
    }

    public void setCote(String cote) {
        this.cote = cote;
    }

    public Commande(Long id, String reference, String cote, String tarif) {
        this.id = id;
        this.reference = reference;
        this.cote = cote;
        this.tarif = tarif;
    }

    public Commande() {
    }

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
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
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "frbouhadjacheurfarobardet.entities.Commande[ id=" + id + " ]";
    }
    
}
