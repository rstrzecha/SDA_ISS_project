import pl.api.apiImplements.LocationImpl;
import pl.api.apiImplements.UpcomingRunsImpl;
import pl.database.Entity.Location;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        LocationImpl locationimpl = new LocationImpl();
        System.out.println(locationimpl.getJson());
        Location location = new Location();
        System.out.println(location.getLongitude());
        System.out.println(location.getLatitude());
        System.out.println(location.getTimestamp());

        UpcomingRunsImpl upcomingRuns = new UpcomingRunsImpl();
        System.out.println(UpcomingRunsImpl.getBaseUrl());
        System.out.println(upcomingRuns.getJson());
    }
}
