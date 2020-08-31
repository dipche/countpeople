package fr.gso.squaresense.countpeople.app.restcalls.read;

public class SensorEventReadJSONResponse {

    private final Long inside;

    public SensorEventReadJSONResponse(Long inside) {
        this.inside = inside;
    }

    public Long getInside() {
        return inside;
    }
}
