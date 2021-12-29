package frbouhadjacheurfarobardet.entities;

import frbouhadjacheurfarobardet.entities.Client;
import frbouhadjacheurfarobardet.entities.EtatAffaire;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-29T15:47:13")
@StaticMetamodel(Affaire.class)
public class Affaire_ { 

    public static volatile SingularAttribute<Affaire, Boolean> encaissement2;
    public static volatile SingularAttribute<Affaire, Boolean> encaissement1;
    public static volatile SingularAttribute<Affaire, Client> client;
    public static volatile SingularAttribute<Affaire, List> adresses;
    public static volatile SingularAttribute<Affaire, Long> id;
    public static volatile SingularAttribute<Affaire, EtatAffaire> etat;
    public static volatile SingularAttribute<Affaire, String> geolocalisation;
    public static volatile SingularAttribute<Affaire, Long> idCommande;

}