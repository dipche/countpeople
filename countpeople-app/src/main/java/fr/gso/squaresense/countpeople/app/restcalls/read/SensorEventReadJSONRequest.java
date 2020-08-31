package fr.gso.squaresense.countpeople.app.restcalls.read;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SensorEventReadJSONRequest {

    public final String sensorName;

    public final Long peopleOut;

    public final Long peopleIn;

    public final String eventDateTime;

    public SensorEventReadJSONRequest(@JsonProperty("sensor") String sensorName, @JsonProperty("out") Long peopleOut,
                                      @JsonProperty("in") Long peopleIn, @JsonProperty("ts") String eventDateTime) {
        this.sensorName = sensorName;
        this.peopleOut = peopleOut;
        this.peopleIn = peopleIn;
        this.eventDateTime = eventDateTime;
    }
}
