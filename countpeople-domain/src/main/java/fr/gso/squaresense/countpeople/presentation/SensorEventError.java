package fr.gso.squaresense.countpeople.presentation;

public class SensorEventError {

    public final String code;
    public final String field;
    public final String description;

    public SensorEventError(String code, String field, String description) {
        this.code = code;
        this.field = field;
        this.description = description;
    }
}
