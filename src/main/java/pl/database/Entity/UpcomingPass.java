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

}
