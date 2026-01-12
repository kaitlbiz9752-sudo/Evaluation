package metier;

import classes.Categorie;
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
public class CategorieService implements IDao<Categorie> {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public boolean create(Categorie o) {

        Session session = sessionFactory.getCurrentSession();
        session.save(o);
        return true;
    }
    @Transactional
    @Override
    public Categorie getByID(int id) {
        return sessionFactory.getCurrentSession().get(Categorie.class, id);

    }
    @Transactional
    @Override
    public List<Categorie> getall() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Categorie", Categorie.class)
                .list();
    }



}
