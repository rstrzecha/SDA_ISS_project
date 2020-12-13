package pl.api.apiInterfaces;

import pl.database.Entity.Location;

import java.io.IOException;

public interface LocationApi {
    Location getLocation() throws IOException;
}
