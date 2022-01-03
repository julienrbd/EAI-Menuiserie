/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjaheurfarobardet.scommercialshared;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author AlaaCheurfa
 */
public class CommandeClientS implements Serializable {
    
    private Long id;
   
    private String ReferenceCatalogue;

    
    private String CoteExact;
    
  
    private String Tarif;

    private CommercialS commercial;
      
        
    private String statut;
    
    
    public static final String statutDebutCommande = "Commande en cours";
    public static final String statutCommandeValidé = "Commande Validé";
    
    public CommandeClientS(){
        
    }
 
    
public CommandeClientS(String ReferenceCatalogue, String CoteExact, String Tarif,CommercialS commercial,String statut){
        this.ReferenceCatalogue = ReferenceCatalogue;
        this.CoteExact = CoteExact;
        this.Tarif = Tarif;
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
 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommandeClientS)) {
            return false;
        }
        CommandeClientS other = (CommandeClientS) object;
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
