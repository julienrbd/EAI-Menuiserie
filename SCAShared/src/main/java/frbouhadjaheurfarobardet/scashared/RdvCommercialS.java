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
public class RdvCommercialS implements Serializable {

    private Long id;
    
    private CreneauS creneau;
    
    private Long idCommercial;
    
    private AffaireS affaire;

    public RdvCommercialS() {
    }

    public RdvCommercialS(AffaireS affaire, CreneauS creneau, Long idCommercial) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public CreneauS getCreneau() {
        return creneau;
    }

    public void setCreneau(CreneauS creneau) {
        this.creneau = creneau;
    }

    public Long getIdCommercial() {
        return idCommercial;
    }

    public void setIdCommercial(Long idCommercial) {
        this.idCommercial = idCommercial;
    }

    public AffaireS getAffaireS() {
        return affaire;
    }

    public void setAffaireS(AffaireS affaire) {
        this.affaire = affaire;
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
        if (!(object instanceof RdvCommercialS)) {
            return false;
        }
        RdvCommercialS other = (RdvCommercialS) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "frbouhadjacheurfarobardet.entities.RdvCommercial[ id=" + id + " ]";
    }
    
}
