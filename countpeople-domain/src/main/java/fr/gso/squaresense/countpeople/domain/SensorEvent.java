package fr.gso.squaresense.countpeople.domain;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class SensorEvent {

    private Long id;

    private String sensorName;

    private Long peopleOut;

    private Long peopleIn;

    private LocalDateTime eventDateTime;

    public SensorEvent(String sensorName, Long peopleOut, Long peopleIn, String eventDateTime) {
        this.sensorName = sensorName;
        this.peopleOut = peopleOut;
        this.peopleIn = peopleIn;
        this.eventDateTime = timeStampToLocalDate(eventDateTime);
    }

    public SensorEvent(Long id, String sensorName, Long peopleOut, Long peopleIn, LocalDateTime eventDateTime) {
        this.id = id;
        this.sensorName = sensorName;
        this.peopleOut = peopleOut;
        this.peopleIn = peopleIn;
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


    private LocalDateTime timeStampToLocalDate(String eventDateTime) {
        return LocalDateTime.ofInstant(Instant.parse(eventDateTime), TimeZone
                .getDefault().toZoneId());
    }
}
