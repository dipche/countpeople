package fr.gso.squaresense.countpeople.presentation;

import java.util.List;

public class SensorEventDomainException extends Exception{

    public final List<SensorEventError> errors;

    public SensorEventDomainException(List<SensorEventError> errors) {
        this.errors=errors;
    }
}
