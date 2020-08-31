package fr.gso.squaresense.countpeople.infrastructure;

import fr.gso.squaresense.countpeople.domain.SensorEvent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SensorEventRepository {

    List<SensorEvent> readEvents();

    Optional<SensorEvent> readSensorEvent(Long id);

    Long createSensorEvent(SensorEvent sensorEvent);

    Long readPeopleStock();

    Long readPeopleStockAtInstant(LocalDateTime dateTime);
}
