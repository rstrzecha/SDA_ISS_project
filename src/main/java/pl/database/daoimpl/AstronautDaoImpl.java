package pl.database.daoimpl;

import org.hibernate.Session;
import pl.database.Entity.Astronaut;
import pl.database.dao.AstronautDao;
import pl.database.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class AstronautDaoImpl implements AstronautDao {
    @Override
    public void save(Astronaut astronaut) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session.saveOrUpdate(astronaut);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Astronaut findById(Long id) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        Astronaut astronaut = null;

        try {
            astronaut = session
                    .createQuery("from Astronaut where id=:id", Astronaut.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {}

        session.getTransaction().commit();
        session.close();

        return astronaut;
    }

    @Override
    public List<Astronaut> findAll() {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        List<Astronaut> astronauts = new ArrayList<>();

        try {

            astronauts = session
                    .createQuery("from Astronaut", Astronaut.class)
                    .list();

        } catch (NoResultException e) {}

        session.getTransaction().commit();
        session.close();

        return astronauts;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session
                .createQuery("delete Astronaut where id=:id")
                .setParameter("id", id)
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}
