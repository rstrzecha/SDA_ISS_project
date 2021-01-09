package pl.database.Entity;


import pl.api.JsonsSplit.LocationSplit;
import pl.api.apiInterface.SplitJsonInterface;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.io.IOException;

@Entity
@Table(name = "ISS_LOCATION")
public class IssLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double longitude;
    private double latitude;
    private long timestamp;
    private Double speed;
    private LocalDateTime date;

    public IssLocation(String json){
        SplitJsonInterface jsonSplit = new LocationSplit();
        String[] jsonArray = jsonSplit.splitJson(json);
        latitude = Double.parseDouble(jsonArray[0]);
        longitude = Double.parseDouble(jsonArray[1]);
        timestamp = Long.parseLong(jsonArray[2]);
    }

    public IssLocation(){}

    public Long getId() {
        return id;
    }

    public void setId (Long id){
        this.id = id;
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

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed ( double speed){
        this.speed = speed;
    }

    public LocalDateTime getDate () {
        return date;
    }

    public void setDate (LocalDateTime date){
        this.date = date;
    }
}
