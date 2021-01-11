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
        try(Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession()) {
            session.beginTransaction();

            session.saveOrUpdate(upcomingPass);
            session.getTransaction().commit();
        }
    }

    @Override
    public UpcomingPass findById(Long id) {
        UpcomingPass upcomingPass = null;
        try(Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession()) {
            session.beginTransaction();

            upcomingPass = session
                    .createQuery("from UpcomingPass where id=:id", UpcomingPass.class)
                    .setParameter("id", id)
                    .getSingleResult();

            session.getTransaction().commit();

        } catch (NoResultException e) {}

        return upcomingPass;
    }

    @Override
    public List<UpcomingPass> findAll() {
        List<UpcomingPass> upcomingPasses = new ArrayList<>();
        try(Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession()) {
            session.beginTransaction();

            upcomingPasses = session
                    .createQuery("from UpcomingPass", UpcomingPass.class)
                    .list();

            session.getTransaction().commit();

        } catch (NoResultException e) {}

        return upcomingPasses;
    }

    @Override
    public void deleteById(Long id) {
        try(Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession()) {
            session.beginTransaction();

            session
                    .createQuery("delete UpcomingPass where id=:id")
                    .setParameter("id", id)
                    .executeUpdate();

            session.getTransaction().commit();
        }
    }
}