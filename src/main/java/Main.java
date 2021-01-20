import pl.database.Entity.UpcomingPass;
import pl.database.Entity.UserLocation;
import pl.runs.UpcomingPassRun;


import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        LocationRun locationRun = new LocationRun();
//        Thread thread = new Thread(() -> locationRun.run());
//        thread.start();

        double longitude = 51;  //Pozycja Użytkownika
        double latitude = 21;

        //wywołanie listy przelotów ISS dla zadanej pozycji Użytkownika
        UpcomingPassRun upcomingPassRun = new UpcomingPassRun(new UserLocation(longitude, latitude));
        List<UpcomingPass> upcomingPassList = upcomingPassRun.getPasses();
        System.out.println(upcomingPassList);

        //Zapis do bazy danych przelotów ISS dla zadanej pozycji Użytkownika
        upcomingPassRun.savePassesToDataBase(upcomingPassList);
    }
}
