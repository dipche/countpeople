package fr.gso.squaresense.countpeople.infrastructure;

import fr.gso.squaresense.countpeople.domain.PeopleStock;
import fr.gso.squaresense.countpeople.domain.SensorEvent;

import java.time.LocalDateTime;
import java.util.Optional;

public interface SensorEventRepository {

    Optional<SensorEvent> readSensorEvent(Long id);

    Long createSensorEvent(SensorEvent sensorEvent);

    PeopleStock readPeopleStock();

    PeopleStock readPeopleStockAtInstant(LocalDateTime dateTime);
}
