package pl.api.JsonsSplit;

import pl.api.apiImplements.UpcomingRunsJson;
import pl.api.apiInterface.APIInterface;
import pl.api.apiInterface.SplitJsonInterface;

import java.io.IOException;

public class UpcomingRunsSplit implements SplitJsonInterface {

    public UpcomingRunsSplit() throws IOException {
    }

    APIInterface upcomingRuns = new UpcomingRunsJson();
    private String json = upcomingRuns.getJson();

    @Override
    public String[] splitJson(String json) {
        return new String[0];
    }
}
