package pl.database.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ISS_LOCATION")
public class IssLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double longitude;
    private double latitude;
    private Double speed;
    private LocalDateTime date;

    public IssLocation() {}

    public Long getId() {
        return id;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getSpeed() {
        return speed;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
