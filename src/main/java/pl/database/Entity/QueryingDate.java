package pl.database.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "QUERYING_DATE")
public class QueryingDate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime date;


}
