package pl.runs;

import pl.api.apiImplements.UpcomingRunsJson;
import pl.api.apiInterface.APIInterface;
import pl.database.Entity.UpcomingPass;
import pl.database.Entity.UserLocation;
import pl.database.dao.UpcomingPassDao;
import pl.database.dao.UserLocationDao;
import pl.database.daoimpl.UpcomingPassDaoImpl;
import pl.database.daoimpl.UserLocationDaoImpl;
import pl.jsonToObject.mapping.JsonToUpcomingPassMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UpcomingPassRun {

    private List<UpcomingPass> upcomingPassList = new ArrayList<>();
    private UserLocation userLocation;

    public UpcomingPassRun(UserLocation givenUserLocation) {
        userLocation = givenUserLocation;
        UserLocationDao userLocationDao = new UserLocationDaoImpl();
        userLocationDao.save(userLocation);         //Zapis do bazy pozycji Użytkownika
    }

    public List<UpcomingPass> getPasses(){
        APIInterface upcomingRunsJson = null;
        try {
            upcomingRunsJson = new UpcomingRunsJson(userLocation);
            JsonToUpcomingPassMapper mapper = new JsonToUpcomingPassMapper(upcomingRunsJson.getJson());
            List<UpcomingPass> upcomingPassList = mapper.getListofPasses();
            for (UpcomingPass pass: upcomingPassList) {
                pass.setUser_location(userLocation);
            }
            return upcomingPassList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return upcomingPassList;
    }

    public void savePassesToDataBase(List<UpcomingPass> givenUpcomingPassList){
        UpcomingPassDao upcomingPassDao = new UpcomingPassDaoImpl();
        for (UpcomingPass pass: upcomingPassList) {     //Zapis do bazy nadchodzących przelotów z przypisaną pozycją Użytkownika
            upcomingPassDao.save(pass);
        }
    }
}
