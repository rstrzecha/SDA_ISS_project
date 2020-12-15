package pl.api.apiInterfaces;

import pl.database.Entity.IssLocation;

import java.io.IOException;

public interface LocationApi {
    IssLocation getLocation() throws IOException;
}
