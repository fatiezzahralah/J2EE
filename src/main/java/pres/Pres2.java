package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {
    //FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
    public static void main(String[] args) throws  Exception{
       /*l'injection des dependances par
          l'instanciation dynamique
         */
        Scanner scanner=new Scanner(new File("config.txt"));
        //il faut connaitre le nom de la class
        String daoClassName=scanner.nextLine();
        //charger la classe en memoire
        Class cDao=Class.forName(daoClassName);
        //New instance c'est un objet de type object ici exactemet de type IDao
        IDao dao=(IDao) cDao.newInstance();

        String metierClassName=scanner.nextLine();
        Class cMetier=Class.forName(metierClassName);
        IMetier metier=(IMetier) cMetier.newInstance();

        Method method=cMetier.getMethod("setDao",IDao.class);
        // metier.setDao(dao)=>static invoquer dao sur lobjet metier
        //la 2eme methode invoke=>dynamique -l'injection des dependances dynamiquement
        method.invoke(metier,dao);

        System.out.println("Résultat="+ metier.calcul());
    }
}
