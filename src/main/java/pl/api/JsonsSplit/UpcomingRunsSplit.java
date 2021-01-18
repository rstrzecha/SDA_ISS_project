package pl.api.JsonsSplit;

import pl.api.apiInterface.SplitJsonInterface;

import java.io.IOException;

public class UpcomingRunsSplit implements SplitJsonInterface {

    public UpcomingRunsSplit() /*throws IOException */{
    }

    @Override
    public String[] splitJson(String givenJson) {
        String[] result = {givenJson.substring(176,514)};
        return result;
    }
}