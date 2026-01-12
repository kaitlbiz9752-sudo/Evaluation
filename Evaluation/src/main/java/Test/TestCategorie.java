package Test;

import classes.Produit;
import dao.IDao;
import metier.CategorieService;
import classes.Categorie;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;

public class TestCategorie {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Categorie> cs = context.getBean("categorieService",IDao.class);


        Categorie c=new Categorie("CAT1","Libelle1");
        Categorie c2=new Categorie("CAT2","Libelle2");


        System.out.println("Ajouter les  Commandes");

        cs.create(c);
        cs.create(c2);


        System.out.println("Afichages les  Commandes");
        for (Categorie p:cs.getall())
        {
            System.out.println(p);
        }



        System.out.println("Le Categorie 2"+cs.getByID(2));
    }
}
