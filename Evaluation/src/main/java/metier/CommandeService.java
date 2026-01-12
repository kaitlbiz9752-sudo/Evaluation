package metier;

import classes.Commande;
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
public class CommandeService implements IDao<Commande> {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public boolean create(Commande o) {
        Session session = sessionFactory.getCurrentSession();
        session.save(o);
        return true;
    }
    @Transactional
    @Override
    public Commande getByID(int id) {
        return sessionFactory.getCurrentSession().get(Commande.class, id);
    }
    @Transactional
    @Override
    public List<Commande> getall() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Commande", Commande.class)
                .list();
    }





}
