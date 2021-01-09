import pl.api.apiImplements.AstronautImpl;
import pl.api.apiImplements.LocationImpl;
import pl.api.apiImplements.UpcomingRunsImpl;
import pl.api.apiInterface.APIInterface;
import pl.database.Entity.Location;
import pl.runs.LocationRun;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LocationRun locationRun = new LocationRun();
        Thread thread = new Thread(() -> locationRun.run());
        thread.start();



        APIInterface upcomingRuns = new UpcomingRunsImpl();
        System.out.println(upcomingRuns.getJson());
        /*AstronautImpl astronauts = new AstronautImpl();
        System.out.println(astronauts.getJson());*/
    }
}
