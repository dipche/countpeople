package fr.gso.squaresense.countpeople.app.restcalls.create;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SensorEventCreationJSONRequest {

    public final String sensorName;

    public final Long peopleOut;

    public final Long peopleIn;

    public final String eventDateTime;

    public SensorEventCreationJSONRequest(@JsonProperty("sensor") String sensorName, @JsonProperty("out") Long peopleOut,
                                          @JsonProperty("in") Long peopleIn, @JsonProperty("ts") String eventDateTime) {
        this.sensorName = sensorName;
        this.peopleOut = peopleOut;
        this.peopleIn = peopleIn;
        this.eventDateTime = eventDateTime;
    }
}
