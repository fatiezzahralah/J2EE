package pres;

import metier.IMetier;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresSpringXML {

    public static void main(String[] args) throws BeansException {
        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
        IMetier metier= (IMetier) context.getBean("metier");
        System.out.println("Résultat=>"+metier.calcul());

    }
}
