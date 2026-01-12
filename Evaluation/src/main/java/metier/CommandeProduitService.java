package metier;

import classes.LigneCommandeProduit;
import dao.IDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import util.HibernateUtil;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public class CommandeProduitService implements IDao<LigneCommandeProduit> {

    @Autowired
    private SessionFactory sessionFactory;
    @Transactional
    @Override
    public boolean create(LigneCommandeProduit o) {

        Session session = sessionFactory.getCurrentSession();
        session.save(o);
        return true;
    }
    @Transactional
    @Override
    public LigneCommandeProduit getByID(int id) {
        return sessionFactory.getCurrentSession().get(LigneCommandeProduit.class, id);
    }
    @Transactional
    @Override
    public List<LigneCommandeProduit> getall() {
        return sessionFactory.getCurrentSession()
                .createQuery("from LigneCommandeProduit", LigneCommandeProduit.class)
                .list();
    }



    public LigneCommandeProduit getQuantity(int CommandeID, int idProduit) {
        Session session=null;
        Transaction tx=null;
        LigneCommandeProduit ligneCommandeProduit=null;

        try {
            session=HibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            ligneCommandeProduit=(LigneCommandeProduit)session.getNamedQuery("quantiteParCommande").setParameter("commande",CommandeID).setParameter("idProduit",idProduit).list().get(0);
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx!=null)
                tx.rollback();
            e.printStackTrace();
        }
        finally {
            if (session!=null)
                session.close();
        }

        return ligneCommandeProduit;
    }


}
