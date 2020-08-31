package fr.gso.squaresense.countpeople.domain;

import java.time.LocalDateTime;

public class SensorEvent {

    private Long id;

    private String sensorName;

    private Long peopleOut;

    private Long peopleIn;

    private LocalDateTime eventDateTime;

    public SensorEvent(String sensorName, Long peopleIn, Long peopleOut, LocalDateTime eventDateTime) {
        this.sensorName = sensorName;
        this.peopleIn = peopleIn;
        this.peopleOut = peopleOut;
        this.eventDateTime = eventDateTime;
    }

    public SensorEvent(Long id, String sensorName, Long peopleIn, Long peopleOut, LocalDateTime eventDateTime) {
        this.id = id;
        this.sensorName = sensorName;
        this.peopleIn = peopleIn;
        this.peopleOut = peopleOut;
        this.eventDateTime = eventDateTime;
    }

    public String getSensorName() {
        return sensorName;
    }

    public Long getPeopleOut() {
        return peopleOut;
    }

    public Long getPeopleIn() {
        return peopleIn;
    }

    public LocalDateTime getEventDateTime() {
        return eventDateTime;
    }

    public Long getId() {
        return id;
    }

}
