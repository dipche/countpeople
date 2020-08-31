package fr.gso.squaresense.countpeople.infra.hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name="SENSOR_EVENT")
public class SensorEventHibernate {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "EVENT_ID")
    public Long id;

    @Column(name = "SENSOR_NAME")
    public String name;

    @Column(name = "PEOPLE_IN")
    public Long peopleIn;

    @Column(name = "PEOPLE_OUT")
    public Long peopleOut;

    @Column(name = "EVENT_DATE")
    public LocalDateTime eventDate;

    public SensorEventHibernate() {
    }
}
