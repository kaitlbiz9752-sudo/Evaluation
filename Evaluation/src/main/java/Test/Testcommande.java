package Test;

import dao.IDao;
import metier.CommandeService;
import classes.Commande;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;

import java.util.Date;

public class Testcommande {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Commande> ps = context.getBean("commandeService",IDao.class);

        Commande c1=new Commande(new Date());
        Commande c2=new Commande(new Date());
        Commande c3=new Commande(new Date());
        Commande c4=new Commande(new Date());

        System.out.println("Ajouter les  Commandes");

        ps.create(c1);
        ps.create(c2);
        ps.create(c3);
        ps.create(c4);

        System.out.println("Afichages les  Commandes");
        for (Commande p:ps.getall())
        {
            System.out.println(p);
        }



        System.out.println("Le Commande 2"+ps.getByID(2));
    }
}
