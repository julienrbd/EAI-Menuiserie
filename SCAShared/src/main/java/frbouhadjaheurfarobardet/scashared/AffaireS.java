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
public class AffaireS implements Serializable {

    private Long id;

    private EtatAffaireS etat;

    private String geolocalisation;

    private List<String> adresses;

    private Boolean encaissement1;

    private Boolean encaissement2;

    private Long idCommande;
    
    private ClientS client;

    private RdvCommercialS rdvCommercial;

    private RdvPoseurS rdvPoseur;

    public AffaireS() {
    }

    public AffaireS(String geolocalisation, List<String> adresses) {
        this.geolocalisation = geolocalisation;
        this.adresses = adresses;
    }

    public AffaireS(String geolocalisation, List<String> adresses, ClientS client) {
        this.geolocalisation = geolocalisation;
        this.adresses = adresses;
        this.client = client;
    }

    public AffaireS(String geolocalisation, List<String> adresses, Boolean encaissement1, Boolean encaissement2, Long idCommande, ClientS client) {
        this.geolocalisation = geolocalisation;
        this.adresses = adresses;
        this.encaissement1 = encaissement1;
        this.encaissement2 = encaissement2;
        this.idCommande = idCommande;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EtatAffaireS getEtat() {
        return etat;
    }

    public void setEtat(EtatAffaireS etat) {
        this.etat = etat;
    }

    public RdvCommercialS getRdvCommercial() {
        return rdvCommercial;
    }

    public void setRdvCommercial(RdvCommercialS rdvCommercial) {
        this.rdvCommercial = rdvCommercial;
    }

    public RdvPoseurS getRdvPoseur() {
        return rdvPoseur;
    }

    public void setRdvPoseur(RdvPoseurS rdvPoseur) {
        this.rdvPoseur = rdvPoseur;
    }
    

    public String getGeolocalisation() {
        return geolocalisation;
    }

    public void setGeolocalisation(String geolocalisation) {
        this.geolocalisation = geolocalisation;
    }

    public List<String> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<String> adresses) {
        this.adresses = adresses;
    }

    public Boolean getEncaissement1() {
        return encaissement1;
    }

    public void setEncaissement1(Boolean encaissement1) {
        this.encaissement1 = encaissement1;
    }

    public Boolean getEncaissement2() {
        return encaissement2;
    }

    public void setEncaissement2(Boolean encaissement2) {
        this.encaissement2 = encaissement2;
    }

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public ClientS getClient() {
        return client;
    }

    public void setClient(ClientS client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Affaire{" + "geolocalisation=" + geolocalisation + ", adresses=" + adresses + ", encaissement1=" + encaissement1 + ", encaissement2=" + encaissement2 + ", idCommande=" + idCommande + ", client=" + client + '}';
    }
}
