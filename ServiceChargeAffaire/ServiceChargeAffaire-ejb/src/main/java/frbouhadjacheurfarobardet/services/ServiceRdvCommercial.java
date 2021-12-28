/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frbouhadjacheurfarobardet.services;

import frbouhadjacheurfarobardet.entities.Affaire;
import frbouhadjacheurfarobardet.entities.Creneau;
import frbouhadjacheurfarobardet.metier.MetierRdvCommercialLocal;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Scanner;


/**
 *
 * @author jroba
 */
@Stateless
public class ServiceRdvCommercial implements ServiceRdvCommercialLocal {

    @EJB
    private MetierRdvCommercialLocal metierRdvCommercial;

    private void prendreRdvCommercial(Affaire affaire){
        Calendar DateDebut;
        DateDebut = Calendar.getInstance();
        
        Scanner scanner;
        scanner = new Scanner( System.in );
        
        int annee = scanner.nextInt();
        int mois = scanner.nextInt();
        int jour = scanner.nextInt();
        int heure = scanner.nextInt();
        
        DateDebut.set(annee,mois,jour,heure,0);
        
        Calendar DateFin;
        DateFin = Calendar.getInstance();
        
        
        int anneeFin = scanner.nextInt();
        int moisFin = scanner.nextInt();
        int jourFin = scanner.nextInt();
        int heureFin = scanner.nextInt();
        
        DateFin.set(anneeFin ,moisFin ,jourFin ,heureFin ,0);
        Map<Long, List<Creneau>> liste = metierRdvCommercial.InterrogerDisponibilite(DateDebut, DateFin);

        for(Map.Entry<Long,List<Creneau>> entry : liste.entrySet()){
            Long key = entry.getKey();
            List<Creneau> value = entry.getValue();
            System.out.println(value);
        }
        System.out.println("");
        
        
        

    }
}
