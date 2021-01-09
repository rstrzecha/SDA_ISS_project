package pl.database.Entity;

import pl.api.JsonsSplit.LocationSplit;
import pl.api.apiInterface.SplitJsonInterface;

import java.io.IOException;

public class IssLocation {
    private double longitude;
    private double latitude;
    private long timestamp;
    private final int speed = 28_000;
    SplitJsonInterface jsonSplit = new LocationSplit();

    public IssLocation(){
        String[] jsonArray = jsonSplit.splitJson();
        latitude = Double.parseDouble(jsonArray[0]);
        longitude = Double.parseDouble(jsonArray[1]);
        timestamp = Long.parseLong(jsonArray[2]);
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

    public int getSpeed() {
        return speed;
    }
}
