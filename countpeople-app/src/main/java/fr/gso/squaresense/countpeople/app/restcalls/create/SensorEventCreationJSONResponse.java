package fr.gso.squaresense.countpeople.app.restcalls.create;

public class SensorEventCreationJSONResponse {

    private final Long id;

    public SensorEventCreationJSONResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
