package fr.gso.squaresense.countpeople.api;

import fr.gso.squaresense.countpeople.domain.PeopleStock;
import fr.gso.squaresense.countpeople.domain.SensorEvent;
import fr.gso.squaresense.countpeople.infrastructure.SensorEventRepository;
import fr.gso.squaresense.countpeople.presentation.SensorEventCreationRequest;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;


public class SensorEventApis {

    private SensorEventRepository sensorEventRepository;

    public SensorEventApis(SensorEventRepository sensorEventRepository) {
        this.sensorEventRepository = sensorEventRepository;
    }

    @Transactional
    public Long createSensorEvent(SensorEventCreationRequest request) {
        SensorEvent sensorEvent = new SensorEvent(request.sensorName,
                request.peopleIn,
                request.peopleOut,
                timeStampToLocalDate(request.eventDateTime));
        return sensorEventRepository.createSensorEvent(sensorEvent);
    }


    public PeopleStock readPeopleStock() {
        PeopleStock defaultPeopleStock = new PeopleStock(0L);
        PeopleStock peopleStock = sensorEventRepository.readPeopleStock();
        if (peopleStock.getPeopleStock() < 0) {
            return  defaultPeopleStock;
        } else {
            return peopleStock;
        }
    }

    public PeopleStock readPeopleStockAtInstant(String instantDateTime) {
        PeopleStock defaultPeopleStock = new PeopleStock(0L);
        PeopleStock peopleStockAtInstant = sensorEventRepository.readPeopleStockAtInstant(timeStampToLocalDate(instantDateTime));
        if (peopleStockAtInstant.getPeopleStock() < 0) {
            return defaultPeopleStock;
        } else {
            return peopleStockAtInstant;
        }
    }

    private LocalDateTime timeStampToLocalDate(String eventDateTime) {
        return LocalDateTime.ofInstant(Instant.parse(eventDateTime), TimeZone
                .getDefault().toZoneId());
    }
}
