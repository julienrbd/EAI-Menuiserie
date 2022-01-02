/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjaheurfarobardet.scashared;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jroba
 */
public class ClientS implements Serializable{
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String mail;
    private String tel;
    private String geolocalisation;
    private List<AffaireS> listeAffaire;
    public ClientS() {
    }

    public ClientS(String nom, String prenom, String adresse, String mail, String tel, String geolocalisation) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.mail = mail;
        this.tel = tel;
        this.geolocalisation = geolocalisation;
    }

    public ClientS(Long id, String nom, String prenom, String adresse, String mail, String tel, String geolocalisation, List<AffaireS> listeAffaire) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.mail = mail;
        this.tel = tel;
        this.geolocalisation = geolocalisation;
        this.listeAffaire = listeAffaire;
    }

    public ClientS(String nom, String prenom, String adresse, String mail, String tel, String geolocalisation, List<AffaireS> listeAffaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.mail = mail;
        this.tel = tel;
        this.geolocalisation = geolocalisation;
        this.listeAffaire = listeAffaire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AffaireS> getListeAffaire() {
        return listeAffaire;
    }

    public void setListeAffaire(List<AffaireS> listeAffaire) {
        this.listeAffaire = listeAffaire;
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

    @Override
    public String toString() {
        return "Client{" + "nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", mail=" + mail + ", tel=" + tel + ", geolocalisation=" + geolocalisation + '}';
    }
}
