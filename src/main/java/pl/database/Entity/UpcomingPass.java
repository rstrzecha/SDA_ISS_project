package pl.database.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "UPCOMING_PASS")
public class UpcomingPass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int duration;
    private LocalDateTime risetime;

    @ManyToOne
    @JoinColumn(name = "user_position_id")
    private UserLocation user_location;

    public UpcomingPass() {
    }

    public Long getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public LocalDateTime getRisetime() {
        return risetime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setRisetime(LocalDateTime risetime) {
        this.risetime = risetime;
    }

    public UserLocation getUser_location() {
        return user_location;
    }

    public void setUser_location(UserLocation user_location) {
        this.user_location = user_location;
    }

    @Override
    public String toString() {
        return "UpcomingPass{" +
                "id=" + id +
                ", duration=" + duration +
                ", risetime=" + risetime +
                ", user_location=" + user_location +
                '}';
    }
}
