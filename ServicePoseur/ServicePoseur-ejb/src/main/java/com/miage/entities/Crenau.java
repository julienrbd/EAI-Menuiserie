/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Mohamed-AmineBouhadj
 */
@Entity
public class Crenau implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String debut;
        private String fin ;

        public Crenau(Long id, String debut, String fin) {
                this.id = id;
                this.debut = debut;
                this.fin = fin;
        }
        

        public String getDebut() {
                return debut;
        }

        public void setDebut(String debut) {
                this.debut = debut;
        }

        public String getFin() {
                return fin;
        }

        public void setFin(String fin) {
                this.fin = fin;
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
                if (!(object instanceof Crenau)) {
                        return false;
                }
                Crenau other = (Crenau) object;
                if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "com.miage.Facade.entities.Crenau[ id=" + id + " ]";
        }
        
}
