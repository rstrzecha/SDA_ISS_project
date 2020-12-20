package pl.database.daoimpl;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.database.Entity.IssLocation;
import pl.database.dao.IssLocationDao;
import pl.database.utils.HibernateUtils;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IssLocationDaoImplTest {

    private IssLocationDao issLocationDao = new IssLocationDaoImpl();

    @BeforeEach
    void cleanTable() {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        session
                .createSQLQuery("DELETE FROM Iss_location")
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    @Test
    void save() {
        //GIVEN
        IssLocation issLocation = new IssLocation();
        issLocation.setLatitude(-94.2867);
        issLocation.setLongitude(17.0364);
        issLocation.setDate(LocalDateTime.now());

        //WHEN
        issLocationDao.save(issLocation);
        IssLocation saved = issLocationDao.findById(issLocation.getId());

        //THEN
        assertNotNull(saved);
        assertEquals(issLocation.getId(), saved.getId());
        assertEquals(issLocation.getLatitude(), saved.getLatitude());
        assertEquals(issLocation.getLongitude(), saved.getLongitude());
    }

    @Test
    void findAll() {
        //GIVEN
        IssLocation issLocation1 = new IssLocation();
        issLocation1.setLatitude(17.0364);
        issLocation1.setLongitude(-94.2867);
        issLocation1.setDate(LocalDateTime.now());
        issLocationDao.save(issLocation1);
        IssLocation issLocation2 = new IssLocation();
        issLocation2.setLatitude(-49.3382);
        issLocation2.setLongitude(24.2383);
        issLocation2.setDate(LocalDateTime.now());
        issLocationDao.save(issLocation2);

        //WHEN
        List<IssLocation> issLocations = issLocationDao.findAll();

        //THEN
        assertNotNull(issLocations);
        assertEquals(2, issLocations.size());
    }

    @Test
    void deleteById() {
        //GIVEN
        IssLocation issLocation = new IssLocation();
        issLocation.setLatitude(-94.2867);
        issLocation.setLongitude(17.0364);
        issLocation.setDate(LocalDateTime.now());
        issLocationDao.save(issLocation);

        //WHEN
        issLocationDao.deleteById(issLocation.getId());
        IssLocation deleted = issLocationDao.findById(issLocation.getId());

        //THEN
        assertNull(deleted);
    }
}