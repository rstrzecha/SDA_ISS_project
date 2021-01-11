package pl.api.JsonsSplit;

import pl.api.apiInterface.SplitJsonInterface;

public class LocationSplit implements SplitJsonInterface {


    @Override
    public String[] splitJson(String json) {
        if(json.startsWith("{\"message\"")){
            json = json.replace("{\"message\": \"success\", \"iss_position\": {\"latitude\": \"" ,"");
            json = json.replace("\", \"longitude\": \"", ",");
            json = json.replace("\"}, \"timestamp\": ",",");
            json = json.replace("}","");
            return json.split(",");
        } else {
            json = json.replace("{\"iss_position\": {\"latitude\": \"","");
            json = json.replace("\", \"longitude\": \"",",");
            json = json.replace("\"}, \"message\": \"success\", \"timestamp\": ",",");
            json = json.replace("}","");
            return json.split(",");
        }
    }
}
