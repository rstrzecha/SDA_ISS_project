package pl.database.daoimpl;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.database.Entity.UserLocation;
import pl.database.dao.UserLocationDao;
import pl.database.utils.HibernateUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserLocationDaoImplTest {

    private UserLocationDao userLocationDao = new UserLocationDaoImpl();

    @BeforeEach
    void cleanTable() {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        session
                .createSQLQuery("DELETE FROM User_Location")
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    @Test
    void save() {
        //GIVEN
        UserLocation userLocation = new UserLocation();
        userLocation.setLongitude(51.106771165348775);
        userLocation.setLatitude(20.846680217332693);

        //WHEN
        userLocationDao.save(userLocation);
        UserLocation saved = userLocationDao.findById(userLocation.getId());

        //THEN
        assertNotNull(saved);
        assertEquals(userLocation.getLongitude(), saved.getLongitude());
        assertEquals(userLocation.getLatitude(), saved.getLatitude());
    }

    @Test
    void findAll() {
        //GIVEN
        UserLocation userLocation1 = new UserLocation();
        userLocation1.setLongitude(51.106771165348775);
        userLocation1.setLatitude(20.846680217332693);
        userLocationDao.save(userLocation1);
        UserLocation userLocation2 = new UserLocation();
        userLocation2.setLongitude(51.135408639718776);
        userLocation2.setLatitude(20.741729709553702);
        userLocationDao.save(userLocation2);

        //WHEN
        List<UserLocation> userLocations = userLocationDao.findAll();

        //THEN
        assertNotNull(userLocations);
        assertEquals(2, userLocations.size());
    }

    @Test
    void deleteById() {
        //GIVEN
        UserLocation userLocation = new UserLocation();
        userLocation.setLongitude(51.106771165348775);
        userLocation.setLatitude(20.846680217332693);
        userLocationDao.save(userLocation);

        //WHEN
        userLocationDao.deleteById(userLocation.getId());
        UserLocation deleted = userLocationDao.findById(userLocation.getId());

        //THEN
        assertNull(deleted);
    }
}