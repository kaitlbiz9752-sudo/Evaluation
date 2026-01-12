package Test;

import classes.Categorie;
import classes.Commande;
import classes.LigneCommandeProduit;
import dao.IDao;
import metier.CategorieService;
import metier.CommandeProduitService;
import metier.CommandeService;
import metier.ProduitService;
import classes.Produit;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;

import java.sql.Date;
import java.util.List;

public class TestProduit {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Categorie> cs = context.getBean("categorieService",IDao.class);
        IDao<Produit> ps = context.getBean("produitService",IDao.class);
        IDao<Commande> cm = context.getBean("commandeService",IDao.class);
        IDao<LigneCommandeProduit> cps = context.getBean("commandeProduitService",IDao.class);


//        Produit p1=new Produit("P1",1000);
//        Produit p2=new Produit("P2",2000);
//        Produit p3=new Produit("P3",4000);
//        Produit p4=new Produit("P4",5000);
//
//        p1.setCategorie(cs.getByID(1));
//        p2.setCategorie(cs.getByID(1));
//        p3.setCategorie(cs.getByID(1));
//        p4.setCategorie(cs.getByID(2));
//
//        System.out.println("Ajouter les  Produits");
//
//        ps.create(p1);
//        ps.create(p2);
//        ps.create(p3);
//        ps.create(p4);

        System.out.println("Afichages les  Produits");
        for (Produit p:ps.getall())
        {
            System.out.println(p);
        }


//        ProduitService cs2 = context.getBean(ProduitService.class);
//
//        System.out.println("Le Produit 9"+ps.getByID(9));
//
//        System.out.println("Afichages les  Produits Par Categories 1");
//
//        for (Produit p:cs2.produitParCategorie(1))
//        {
//            System.out.println(p);
//        }
//
//
//        System.out.println("Produit par date");
//        for (Produit p:cs2.produitParDate( Date.valueOf("2025-10-13")))
//        {
//            System.out.println(p);
//        }



//        List<Produit> produits=cs2.produitParCommande(5);
//        String chaine="";
//        for (Produit p:produits)
//        {
//            chaine+=p.getReference()+"  "+ p.getPrix()+"     "+cps.getQuantity(5,p.getId()).getQuantite()+"\n";
//        }
//
//        System.out.println("Produits par Commande");
//        System.out.println("Commande : "+cm.getByID(5).getId()+" Date : "+cm.getByID(5).getDate());
//        System.out.println("Liste Des Produits : ");
//        System.out.println("Réf  Prix    Quantité  ");
//        System.out.println(chaine);
//
//
//        System.out.println("Produits par Prix Sup à 2000");
//        for (Produit p:ps.ProduitParPrix())
//        {
//            System.out.println(p);
//        }

    }
}
