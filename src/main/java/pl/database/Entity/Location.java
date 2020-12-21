package pl.database.Entity;

import pl.api.apiImplements.LocationImpl;
import pl.api.apiInterface.APIInterface;

import java.io.IOException;

public class Location {
    private double longitude;
    private double latitude;
    private long timestamp;
    APIInterface location = new LocationImpl();
    private String json = location.getJson();

    public Location() throws IOException {
        String[] jsonArray = jsonProcess();
        longitude = Double.parseDouble(jsonArray[1]);
        latitude = Double.parseDouble(jsonArray[0]);
        timestamp = Long.parseLong(jsonArray[2]);
    }

    private String[] jsonProcess(){
        json = json
                .replace("{\"iss_position\": {\"latitude\": \"","")
                .replace("\", \"longitude\": \"", ",")
                .replace("\"}, \"message\": \"success\", \"timestamp\": ",",")
                .replace("}","");
        return json.split(",");
    }


    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
