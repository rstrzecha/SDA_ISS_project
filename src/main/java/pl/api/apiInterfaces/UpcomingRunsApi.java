package pl.api.apiInterfaces;

import pl.database.Entity.UpcomingPass;

import java.util.List;

public interface UpcomingRunsApi {

    List<UpcomingPass> getListOfUpcomingRuns();
}
