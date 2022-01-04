/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer;

import java.util.Calendar;
import static producer.Producer.creerRdvCommercial;
import static producer.Producer.getDispo;

/**
 *
 * @author jroba
 */
public class Etape1 {

    public static void main(String[] args) {
        
        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();
        date2.set(Calendar.DAY_OF_MONTH, date1.get(Calendar.DAY_OF_MONTH)+7 );
        getDispo(date1, date2);

        long idCommercial = (long) 1;
        long idCreneau = (long) 1;

        creerRdvCommercial((long) 1, idCommercial, idCreneau);
    }

}
