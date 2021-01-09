package pl.database.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ASTRONAUT")
public class Astronaut {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private LocalDateTime date;

    public Astronaut() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

