/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.ServiceCommacial2.entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author AlaaCheurfa
 */
@Entity
public class CommandeClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="ReferenceCatalogue", nullable = false)
    private String ReferenceCatalogue;

    @Column(name="CoteExact", nullable = false)
    private String CoteExact;
    
    @Column(name="Tarif", nullable = false)
    private String Tarif;

    @Column(name="IDRDV", nullable = false)
    private String IDRDV;
    
      @OneToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_COMMERCIAL", nullable = true)
    private Commercial commercial;
      
        @Column(name="STATUT", nullable = false)
    private String statut;
    
    
       public static final String statutDebutCommande = "Commande en cours";
    public static final String statutCommandeValidé = "Commande Validé";
    
    public Long getIdIdCommande() {
        return id;
    }

    public void setIdIdCommande(Long id) {
        this.id = id;
    }
    
public CommandeClient(String ReferenceCatalogue, String CoteExact, String Tarif, String IDRDV,Commercial commercial){
        this.ReferenceCatalogue = ReferenceCatalogue;
        this.CoteExact = CoteExact;
        this.Tarif = Tarif;
        this.IDRDV = IDRDV;
        this.commercial=commercial;
        this.statut=statut;
        
              
    }
 public String getReferenceCatalogue() {
        return ReferenceCatalogue;
    }

    public void setReferenceCatalogue(String getReferenceCatalogue) {
        this.ReferenceCatalogue = ReferenceCatalogue;
    }
    
     public String getCoteExact() {
        return CoteExact;
    }

    public void setCoteExact(String CoteExact) {
        this.CoteExact = CoteExact;
    }
     public String getTarif() {
        return Tarif;
    }

    public void setTarif(String Tarif) {
        this.Tarif = Tarif;
    }
    
      public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
     public String getIDRDV() {
        return IDRDV;
    }

    public void setIDRDV(String IDRDV) {
        this.IDRDV = IDRDV;
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
        if (!(object instanceof CommandeClient)) {
            return false;
        }
        CommandeClient other = (CommandeClient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.miage.ServiceCommacial2.CommandeClient[ id=" + id + " ]";
    }
    
}