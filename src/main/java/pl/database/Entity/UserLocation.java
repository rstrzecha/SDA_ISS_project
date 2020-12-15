package pl.database.Entity;

import javax.persistence.*;

@Entity
@Table(name = "USER_LOCATION")
public class UserLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double longitude;
    private double latitude;

}
