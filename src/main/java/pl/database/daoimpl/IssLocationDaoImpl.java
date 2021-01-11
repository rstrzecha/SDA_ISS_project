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
        try(Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession()) {
            session.beginTransaction();

            session.saveOrUpdate(issLocation);
            session.getTransaction().commit();
        }
    }

    @Override
    public IssLocation findById(Long id) {
        IssLocation issLocation = null;
        try(Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession()) {
            session.beginTransaction();

            issLocation = session
                    .createQuery("from IssLocation where id=:id", IssLocation.class)
                    .setParameter("id", id)
                    .getSingleResult();

            session.getTransaction().commit();

        } catch (NoResultException e) {}

        return issLocation;
    }

    @Override
    public List<IssLocation> findAll() {
        List<IssLocation> issLocations = new ArrayList<>();
        try(Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession()) {
            session.beginTransaction();

            issLocations = session
                    .createQuery("from IssLocation", IssLocation.class)
                    .list();

            session.getTransaction().commit();

        } catch (NoResultException e) {}

        return issLocations;
    }

    @Override
    public void deleteById(Long id) {
        try(Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession()) {
            session.beginTransaction();

            session
                    .createQuery("delete IssLocation where id=:id")
                    .setParameter("id", id)
                    .executeUpdate();

            session.getTransaction().commit();
        }
    }
}
