/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer;

import frbouhadjaheurfarobardet.scashared.AffaireS;
import frbouhadjaheurfarobardet.scashared.ClientS;
import java.util.ArrayList;
import java.util.List;
import static producer.Producer.creerAffaire;
import static producer.Producer.creerClient;
import static producer.Producer.getClients;

/**
 *
 * @author jroba
 */
public class Etape0 {
    public static void main(String [] args){
        ClientS client = new ClientS("nom", "prenom", "adresse", "mail", "tel", "geolocalisation");
        creerClient(client);

        ClientS client2 = new ClientS("nom2", "prenom2", "adresse2", "mail2", "tel2", "geolocalisation2");
        creerClient(client2);

        ClientS client3 = new ClientS("nom3", "prenom3", "adresse2", "mail2", "tel2", "geolocalisation2");
        creerClient(client3);

        ClientS client4 = new ClientS("nom4", "prenom4", "adresse2", "mail2", "tel2", "geolocalisation2");
        creerClient(client4);
        ClientS client5 = new ClientS("nom5", "prenom5", "adresse2", "mail2", "tel2", "geolocalisation2");
        creerClient(client5);
        ClientS client6 = new ClientS("nom6", "prenom6", "adresse2", "mail2", "tel2", "geolocalisation2");
        creerClient(client6);

        getClients();
        
        List<String> liste = new ArrayList<>();
        liste.add("mail");
        liste.add("postale");
        AffaireS affaire = new AffaireS("geolocalisation", liste);
        creerAffaire(affaire, (long) 1);
    }
}
