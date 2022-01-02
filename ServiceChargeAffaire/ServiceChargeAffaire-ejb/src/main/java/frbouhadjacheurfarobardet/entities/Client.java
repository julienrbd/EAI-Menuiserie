/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String mail;
    private String tel;
    private String geolocalisation;
    @OneToMany(mappedBy = "client")
    private List<Affaire> listeAffaire;

    public Client(String nom, String prenom, String adresse, String mail, String tel, String geolocalisation) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.mail = mail;
        this.tel = tel;
        this.geolocalisation = geolocalisation;
        this.listeAffaire = new ArrayList<>();
    }

    public Client(Long id, String nom, String prenom, String adresse, String mail, String tel, String geolocalisation, List<Affaire> listeAffaire) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.mail = mail;
        this.tel = tel;
        this.geolocalisation = geolocalisation;
        this.listeAffaire = listeAffaire;
    }
    
    
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGeolocalisation() {
        return geolocalisation;
    }

    public void setGeolocalisation(String geolocalisation) {
        this.geolocalisation = geolocalisation;
    }

    public List<Affaire> getListeAffaire() {
        return listeAffaire;
    }

    public void setListeAffaire(List<Affaire> listeAffaire) {
        this.listeAffaire = listeAffaire;
    }

    public Client(Long id, String nom, String prenom, String adresse, String mail, String tel, String geolocalisation) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.mail = mail;
        this.tel = tel;
        this.geolocalisation = geolocalisation;
    }

    public Client(Long id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Client() {
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "frbouhadjacheurfarobardet.entities.Client[ id=" + id + " ]";
    }
    
}
