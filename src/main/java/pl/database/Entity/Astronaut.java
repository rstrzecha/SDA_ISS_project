package pl.database.Entity;

import javax.persistence.*;

@Entity
@Table(name = "ASTRONAUT")
public class Astronaut {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
}
