/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.ServiceCommacial2.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author AlaaCheurfa
 */
@Entity
public class Commercial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

     
    private String Name;

 
    private String FirstName;
    
            
    @OneToMany 
    private List<Creneau> Creneau;
    
     public Commercial(){
        
    }

  
    public Commercial(String name, String firstname){

        this.Name = name;
        this.FirstName = firstname;
        
    }
   
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    public List<Creneau> getCreneau() {
        return Creneau;
    }

    public void setVoyages(List<Creneau> Creneau) {
        this.Creneau = Creneau;
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
        return "com.miage.ServiceCommacial2.entities.Commercial[ id=" + id + " ]";
    }
    
}
