package fr.gso.squaresense.countpeople.presentation;

public class SensorEventCreationRequest {

    public static final String SENSOR = "sensor";
    public static final String TS = "ts";
    public static final String IN = "in";
    public static final String OUT = "out";

    public final String sensorName;

    public final Long peopleOut;

    public final Long peopleIn;

    public final String eventDateTime;

    public SensorEventCreationRequest(String sensorName, Long peopleIn, Long peopleOut, String eventDateTime) {
        this.sensorName = sensorName;
        this.peopleIn = peopleIn;
        this.peopleOut = peopleOut;
        this.eventDateTime = eventDateTime;
    }

    public static SensorEventCreationRequest createSensorEventRequest(String sensorName, Long peopleIn, Long peopleOut, String eventDateTime) throws SensorEventDomainException {
        //TODO build data validation
        return new SensorEventCreationRequest(sensorName, peopleIn, peopleOut, eventDateTime);
    }
}
