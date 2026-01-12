package Test;

import classes.Categorie;
import classes.Commande;
import classes.LigneCommandeProduit;
import classes.Produit;
import dao.IDao;
import metier.CommandeProduitService;
import metier.CommandeService;
import metier.ProduitService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;

public class LigneCommandeProduitTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Categorie> cs = context.getBean("categorieService",IDao.class);
        IDao<Produit> ps = context.getBean("produitService",IDao.class);
        IDao<Commande> cm = context.getBean("commandeService",IDao.class);
        IDao<LigneCommandeProduit> cps = context.getBean("commandeProduitService",IDao.class);



        // 1 Première ligne

        LigneCommandeProduit l3 = new LigneCommandeProduit(100,ps.getByID(1),cm.getByID(1));

        cps.create(l3);



    }

}
