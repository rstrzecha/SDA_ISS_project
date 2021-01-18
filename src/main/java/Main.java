import pl.api.apiImplements.UpcomingRunsJson;
import pl.api.apiInterface.APIInterface;
import pl.database.Entity.UpcomingPass;
import pl.database.Entity.UserLocation;
import pl.database.dao.UpcomingPassDao;
import pl.database.dao.UserLocationDao;
import pl.database.daoimpl.UpcomingPassDaoImpl;
import pl.database.daoimpl.UserLocationDaoImpl;
import pl.jsonToObject.mapping.JsonToUpcomingPassMapper;
import pl.jsonToObject.utils.TimestampToLocalDateTime;


import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        LocationRun locationRun = new LocationRun();
//        Thread thread = new Thread(() -> locationRun.run());
//        thread.start();

        UserLocation userLocation = new UserLocation();
        userLocation.setLongitude(51);
        userLocation.setLatitude(21);

        APIInterface upcomingRunsJson = new UpcomingRunsJson(userLocation);
        JsonToUpcomingPassMapper mapper = new JsonToUpcomingPassMapper(upcomingRunsJson.getJson());
        List<UpcomingPass> upcomingPassList = mapper.getListofPasses();


        /* ZAPIS DO BAZY POZYCJI I PRZELOTÓW */
        UserLocationDao userLocationDao = new UserLocationDaoImpl();
        userLocationDao.save(userLocation);         //Zapis pozycji Użytkownika
        System.out.println(userLocation.getId());

        for (UpcomingPass pass: upcomingPassList) {
            pass.setUser_location(userLocation);
        }

        System.out.println(upcomingPassList);
        UpcomingPassDao upcomingPassDao = new UpcomingPassDaoImpl();

        for (UpcomingPass pass: upcomingPassList) {     //Zapis do bazy nadchodzących przelotów z przypisaną pozycją Użytkownika
            upcomingPassDao.save(pass);
        }

        System.out.println("---------- Przeloty odczytane z bazy danych ----------");
        System.out.println(upcomingPassDao.findAll());













    }
}
