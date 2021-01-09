package pl.database.daoimpl;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.database.Entity.Astronaut;
import pl.database.dao.AstronautDao;
import pl.database.utils.HibernateUtils;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AstronautDaoImplTest {

    private AstronautDao astronautDao = new AstronautDaoImpl();

    @BeforeEach
    void cleanTable() {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        session
                .createSQLQuery("DELETE FROM ASTRONAUT")
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    @Test
    void save() {
        //GIVEN
        Astronaut astronaut = new Astronaut();
        astronaut.setName("Buzz");
        astronaut.setSurname("Aldrin");
        astronaut.setDate(LocalDateTime.now());

        //WHEN
        astronautDao.save(astronaut);
        Astronaut saved = astronautDao.findById(astronaut.getId());

        //THEN
        assertNotNull(saved);
        assertEquals(astronaut.getId(), saved.getId());
        assertEquals(astronaut.getName(), saved.getName());
    }

    @Test
    void findAll() {
        //GIVEN
        Astronaut astronaut1 = new Astronaut();
        astronaut1.setName("Buzz");
        astronaut1.setSurname("Aldrin");
        astronaut1.setDate(LocalDateTime.now());
        astronautDao.save(astronaut1);
        Astronaut astronaut2 = new Astronaut();
        astronaut2.setName("Neil");
        astronaut2.setSurname("Armstrong");
        astronaut2.setDate(LocalDateTime.now());
        astronautDao.save(astronaut2);

        //WHEN
        List<Astronaut> astronauts = astronautDao.findAll();

        //THEN
        assertNotNull(astronauts);
        assertEquals(2, astronauts.size());
    }

    @Test
    void deleteById() {
        //GIVEN
        Astronaut astronaut = new Astronaut();
        astronaut.setName("Buzz");
        astronaut.setSurname("Aldrin");
        astronaut.setDate(LocalDateTime.now());
        astronautDao.save(astronaut);

        //WHEN
        astronautDao.deleteById(astronaut.getId());
        Astronaut deleted = astronautDao.findById(astronaut.getId());

        //THEN
        assertNull(deleted);
    }
}