package pl.api.apiInterfaces;

import pl.database.Entity.UpcomingRun;

import java.util.List;

public interface UpcomingRunsApi {

    List<UpcomingRun> getListOfUpcomingRuns();
}
