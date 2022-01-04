/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer;

import java.util.Calendar;
import static producer.Producer.creerRdvPoseur;
import static producer.Producer.getCommandeLivre;
import static producer.Producer.getDispo;
import static producer.Producer.getDispoPoseur;

/**
 *
 * @author jroba
 */
public class Etape5 {

    public static void main(String[] args) {
        getCommandeLivre();
        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();
        date2.set(Calendar.DAY_OF_MONTH, date1.get(Calendar.DAY_OF_MONTH) + 7);
        getDispoPoseur(date1, date2);
        long idPoseur = (long) 1;
        long idCreneau = (long) 1;
        long idAffaire = (long) 1;
        creerRdvPoseur(idAffaire, idPoseur, idCreneau);
    }
}
