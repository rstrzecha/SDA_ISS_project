package pl.database.daoimpl;

import org.hibernate.Session;
import pl.database.Entity.UserLocation;
import pl.database.dao.UserLocationDao;
import pl.database.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class UserLocationDaoImpl implements UserLocationDao {
    @Override
    public void save(UserLocation userLocation) {
        try(Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession()) {
            session.beginTransaction();

            session.saveOrUpdate(userLocation);
            session.getTransaction().commit();
        }
    }

    @Override
    public UserLocation findById(Long id) {
        UserLocation userLocation = null;
        try(Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession()) {
            session.beginTransaction();

            userLocation = session
                    .createQuery("from UserLocation where id=:id", UserLocation.class)
                    .setParameter("id", id)
                    .getSingleResult();

            session.getTransaction().commit();

        } catch (NoResultException e) {}

        return userLocation;
    }

    @Override
    public List<UserLocation> findAll() {
        List<UserLocation> userLocations = new ArrayList<>();
        try(Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession()) {
            session.beginTransaction();

            userLocations = session
                    .createQuery("from UserLocation", UserLocation.class)
                    .list();

            session.getTransaction().commit();


        } catch (NoResultException e) {}

        return userLocations;
    }

    @Override
    public void deleteById(Long id) {
        try(Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession()) {
            session.beginTransaction();

            session
                    .createQuery("delete UserLocation where id=:id")
                    .setParameter("id", id)
                    .executeUpdate();

            session.getTransaction().commit();
        }
    }
}