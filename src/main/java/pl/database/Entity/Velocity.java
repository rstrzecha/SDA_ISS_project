package pl.database.Entity;

import javax.persistence.*;

@Entity
@Table(name = "VELOCITY")
public class Velocity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double speed;

}
