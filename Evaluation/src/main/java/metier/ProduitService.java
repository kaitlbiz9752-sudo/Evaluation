package metier;

import classes.Produit;
import dao.IDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class ProduitService implements IDao<Produit> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean create(Produit o) {
        sessionFactory.getCurrentSession().save(o);
        return true;
    }

    @Override
    public Produit getByID(int id) {
        return sessionFactory.getCurrentSession().get(Produit.class, id);
    }

    @Override
    public List<Produit> getall() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Produit", Produit.class)
                .list();
    }

    public List<Produit> produitParCategorie(int catId) {
        return sessionFactory.getCurrentSession()
                .createNamedQuery("ProduitparCategorie", Produit.class)
                .setParameter("categorie", catId)
                .getResultList();
    }

    public List<Produit> produitParDate(Date date) {
        return sessionFactory.getCurrentSession()
                .createNamedQuery("produitByDate", Produit.class)
                .setParameter("date", date)
                .getResultList();
    }

    public List<Produit> produitParCommande(int idCommande) {
        return sessionFactory.getCurrentSession()
                .createNamedQuery("produitParCommande", Produit.class)
                .setParameter("idCommande", idCommande)
                .getResultList();
    }

    public List<Produit> produitParPrix() {
        return sessionFactory.getCurrentSession()
                .createNamedQuery("ProduitParPrix", Produit.class)
                .getResultList();
    }
}
