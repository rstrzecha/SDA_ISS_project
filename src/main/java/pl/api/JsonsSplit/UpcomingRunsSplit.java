package pl.api.JsonsSplit;

import pl.api.apiImplements.UpcomingRunsImpl;
import pl.api.apiInterface.APIInterface;
import pl.api.apiInterface.SplitJsonInterface;

import java.io.IOException;

public class UpcomingRunsSplit implements SplitJsonInterface {

    public UpcomingRunsSplit() throws IOException {
    }

    APIInterface upcomingRuns = new UpcomingRunsImpl();
    private String json = upcomingRuns.getJson();

    @Override
    public String[] splitJson() {
        return new String[0];
    }
}
