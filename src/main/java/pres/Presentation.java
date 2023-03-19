package pres;

import ext.DaoImpl2;
import metier.MetierImpl;

public class Presentation {
    public static void main(String[] args) {
         /*l'injection des dependances par
          l'instanciation static  (new=>couplage fort)
         */
        DaoImpl2 dao= new DaoImpl2();
        //DaoImpl dao=new DaoImpl();
        MetierImpl metier=new MetierImpl();
        //l'injection des dependances
        metier.setDao(dao);
        System.out.println("Résultat="+metier.calcul());
    }
}
