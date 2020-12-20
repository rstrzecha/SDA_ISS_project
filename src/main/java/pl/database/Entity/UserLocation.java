package pl.database.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USER_LOCATION")
public class UserLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double longitude;
    private double latitude;

    @OneToMany(mappedBy = "user_location", fetch = FetchType.EAGER)
    private Set<UpcomingPass> passes;

    public UserLocation() {
    }

    public Long getId() {
        return id;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
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
}
