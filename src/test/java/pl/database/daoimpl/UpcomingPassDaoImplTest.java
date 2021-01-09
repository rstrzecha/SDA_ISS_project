package pl.database.daoimpl;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.database.Entity.Astronaut;
import pl.database.Entity.UpcomingPass;
import pl.database.dao.UpcomingPassDao;
import pl.database.utils.HibernateUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UpcomingPassDaoImplTest {

    private UpcomingPassDao upcomingPassDao = new UpcomingPassDaoImpl();

    @BeforeEach
    void cleanTable() {
        Session session = HibernateUtils
                .getInstance()
                .getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        session
                .createSQLQuery("DELETE FROM UPCOMING_PASS")
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }


    @Test
    void save() {
        //GIVEN
        UpcomingPass upcomingPass = new UpcomingPass();
        upcomingPass.setDuration(155);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse("2020-12-12 12:30", formatter);
        upcomingPass.setRisetime(dateTime);

        //WHEN
        upcomingPassDao.save(upcomingPass);
        UpcomingPass saved = upcomingPassDao.findById(upcomingPass.getId());

        //THEN
        assertNotNull(saved);
        assertEquals(upcomingPass.getId(), saved.getId());
        assertEquals(upcomingPass.getDuration(), saved.getDuration());
        assertEquals(upcomingPass.getRisetime(), saved.getRisetime());
    }

    @Test
    void findAll() {
        //GIVEN
        UpcomingPass upcomingPass1 = new UpcomingPass();
        upcomingPass1.setDuration(155);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime1 = LocalDateTime.parse("2020-12-12 12:30", formatter);
        upcomingPass1.setRisetime(dateTime1);
        upcomingPassDao.save(upcomingPass1);
        UpcomingPass upcomingPass2 = new UpcomingPass();
        upcomingPass2.setDuration(52);
        LocalDateTime dateTime2 = LocalDateTime.parse("2021-01-12 22:30", formatter);
        upcomingPass2.setRisetime(dateTime2);
        upcomingPassDao.save(upcomingPass2);

        //WHEN
        List<UpcomingPass> upcomingPasses = upcomingPassDao.findAll();

        //THEN
        assertNotNull(upcomingPasses);
        assertEquals(2, upcomingPasses.size());
    }

    @Test
    void deleteById() {
        //GIVEN
        UpcomingPass upcomingPass = new UpcomingPass();
        upcomingPass.setDuration(155);
        upcomingPass.setRisetime(LocalDateTime.now());
        upcomingPassDao.save(upcomingPass);

        //WHEN
        upcomingPassDao.deleteById(upcomingPass.getId());
        UpcomingPass deleted = upcomingPassDao.findById(upcomingPass.getId());

        //THEN
        assertNull(deleted);
    }
}