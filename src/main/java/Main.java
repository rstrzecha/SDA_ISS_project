import pl.api.apiImplements.UpcomingRunsJson;
import pl.api.apiInterface.APIInterface;
import pl.runs.LocationRun;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LocationRun locationRun = new LocationRun();
        Thread thread = new Thread(() -> locationRun.run());
        thread.start();

        /*APIInterface upcomingRuns = new UpcomingRunsJson();
        System.out.println(upcomingRuns.getJson());*/

    }
}
