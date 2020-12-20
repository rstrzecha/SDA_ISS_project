package pl.database.daoimpl;

import org.hibernate.Session;
import pl.database.Entity.IssLocation;
import pl.database.dao.IssLocationDao;
import pl.database.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class IssLocationDaoImpl implements IssLocationDao {

    @Override
    public void save(IssLocation issLocation) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session.saveOrUpdate(issLocation);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public IssLocation findById(Long id) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        IssLocation issLocation = null;

        try {
            issLocation = session
                    .createQuery("from IssLocation where id=:id", IssLocation.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {}

        session.getTransaction().commit();
        session.close();

        return issLocation;
    }

    @Override
    public List<IssLocation> findAll() {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        List<IssLocation> issLocations = new ArrayList<>();

        try {

            issLocations = session
                    .createQuery("from IssLocation", IssLocation.class)
                    .list();

        } catch (NoResultException e) {}

        session.getTransaction().commit();
        session.close();

        return issLocations;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session
                .createQuery("delete IssLocation where id=:id")
                .setParameter("id", id)
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}
