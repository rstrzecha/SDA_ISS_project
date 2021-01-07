package pl.api.JsonsSplit;

import pl.api.apiImplements.LocationImpl;
import pl.api.apiInterface.APIInterface;
import pl.api.apiInterface.SplitJsonInterface;

import java.io.IOException;

public class LocationSplit implements SplitJsonInterface {

    APIInterface location = new LocationImpl();
    private String json;

    {
        try {
            json = location.getJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String[] splitJson() {
        json = json
                .replace("{\"iss_position\": {\"latitude\": \"","")
                .replace("\", \"longitude\": \"", ",")
                .replace("\"}, \"message\": \"success\", \"timestamp\": ",",")
                .replace("}","");
        return json.split(",");
    }
}
