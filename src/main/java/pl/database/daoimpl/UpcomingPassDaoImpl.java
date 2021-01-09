package pl.database.daoimpl;

import org.hibernate.Session;
import pl.database.Entity.UpcomingPass;
import pl.database.dao.UpcomingPassDao;
import pl.database.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class UpcomingPassDaoImpl implements UpcomingPassDao {

    @Override
    public void save(UpcomingPass upcomingPass) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session.saveOrUpdate(upcomingPass);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public UpcomingPass findById(Long id) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        UpcomingPass upcomingPass = null;

        try {
            upcomingPass = session
                    .createQuery("from UpcomingPass where id=:id", UpcomingPass.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {}

        session.getTransaction().commit();
        session.close();

        return upcomingPass;
    }

    @Override
    public List<UpcomingPass> findAll() {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        List<UpcomingPass> upcomingPasses = new ArrayList<>();

        try {

            upcomingPasses = session
                    .createQuery("from UpcomingPass", UpcomingPass.class)
                    .list();

        } catch (NoResultException e) {}

        session.getTransaction().commit();
        session.close();

        return upcomingPasses;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();

        session
                .createQuery("delete UpcomingPass where id=:id")
                .setParameter("id", id)
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}