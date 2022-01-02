/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author JulienRobardet
 */
@Entity
public class RdvCommercial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Long idCreneau;
    
    private Long idCommercial;
    
    @OneToOne(mappedBy = "rdvCommercial")
    private Affaire affaire;

    public RdvCommercial() {
    }

    public RdvCommercial(Long idCreneau, Long idCommercial, Affaire affaire) {
        this.idCreneau = idCreneau;
        this.idCommercial = idCommercial;
        this.affaire = affaire;
    }
    
    public Long getIdCommercial() {
        return idCommercial;
    }

    public void setIdCommercial(Long idCommercial) {
        this.idCommercial = idCommercial;
    }

    public Affaire getAffaire() {
        return affaire;
    }

    public void setAffaire(Affaire affaire) {
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
        if (!(object instanceof RdvCommercial)) {
            return false;
        }
        RdvCommercial other = (RdvCommercial) object;
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
