package frbouhadjacheurfarobardet.entities;

import frbouhadjacheurfarobardet.entities.Affaire;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-29T15:47:13")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile ListAttribute<Client, Affaire> listeAffaire;
    public static volatile SingularAttribute<Client, String> mail;
    public static volatile SingularAttribute<Client, String> adresse;
    public static volatile SingularAttribute<Client, String> tel;
    public static volatile SingularAttribute<Client, Long> id;
    public static volatile SingularAttribute<Client, String> nom;
    public static volatile SingularAttribute<Client, String> prenom;
    public static volatile SingularAttribute<Client, String> geolocalisation;

}