/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjaheurfarobardet.scashared;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author JulienRobardet
 */
public class RdvPoseurS implements Serializable {
    private Long id;
    
    private AffaireS affaire;
    private Long idPoseur;
    private CreneauS creneau;

    public RdvPoseurS() {
    }

    public RdvPoseurS(AffaireS affaire, CreneauS creneau, Long idPoseur) {
        this.affaire = affaire;
        this.idPoseur = idPoseur;
        this.creneau = creneau;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AffaireS getAffaires() {
        return affaire;
    }

    public void setAffaires(AffaireS affaire) {
        this.affaire = affaire;
    }

    public Long getIdPoseur() {
        return idPoseur;
    }

    public void setIdPoseur(Long idPoseur) {
        this.idPoseur = idPoseur;
    }

    public CreneauS getCreneau() {
        return creneau;
    }

    public void setCreneau(CreneauS creneau) {
        this.creneau = creneau;
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
        if (!(object instanceof RdvPoseurS)) {
            return false;
        }
        RdvPoseurS other = (RdvPoseurS) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "frbouhadjacheurfarobardet.entities.RdvPoseur[ id=" + id + " ]";
    }
    
}
