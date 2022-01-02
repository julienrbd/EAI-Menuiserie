/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjaheurfarobardet.scommercialshared;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author AlaaCheurfa
 */
public class CommercialS implements Serializable {
    private Long id;

     
    private String Name;

 
    private String FirstName;
    
    private List<CreneauS> Creneau;
    
     public CommercialS(){
        
    }

  
    public CommercialS(String name, String firstname){

        this.Name = name;
        this.FirstName = firstname;
        
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public List<CreneauS> getCreneau() {
        return Creneau;
    }

    public void setCreneau(List<CreneauS> Creneau) {
        this.Creneau = Creneau;
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
        if (!(object instanceof CommercialS)) {
            return false;
        }
        CommercialS other = (CommercialS) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.miage.ServiceCommacial2.entities.Commercial[ id=" + id + " ]";
    }
    
}
