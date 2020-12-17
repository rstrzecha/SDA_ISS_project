import pl.database.Entity.Location;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Location location = new Location();
        System.out.println(location.getLongitude());
        System.out.println(location.getLatitude());
        System.out.println(location.getTimestamp());
    }
}
