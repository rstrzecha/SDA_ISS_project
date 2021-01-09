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
        json = json.replace("{\"message\": \"success\", \"iss_position\": {\"latitude\": \"" ,"");
        json = json.replace("\", \"longitude\": \"", ",");
        json = json.replace("\"}, \"timestamp\": ",",");
        json = json.replace("}","");
        return json.split(",");
    }
}
