package pl.api.apiInterfaces;

import pl.database.Entity.Astronaut;

import java.util.List;

public interface AstronautApi {
    List<Astronaut> getAstronauts();
}
