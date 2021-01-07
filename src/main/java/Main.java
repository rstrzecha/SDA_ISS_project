import pl.api.apiImplements.LocationImpl;
import pl.api.apiImplements.UpcomingRunsImpl;
import pl.database.Entity.Location;
import pl.runs.LocationRun;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LocationRun locationRun = new LocationRun();
        Thread thread = new Thread(() -> locationRun.run());
        thread.start();
    }
}
