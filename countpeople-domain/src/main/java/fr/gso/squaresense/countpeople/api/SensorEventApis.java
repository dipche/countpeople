package fr.gso.squaresense.countpeople.api;

import fr.gso.squaresense.countpeople.domain.SensorEvent;
import fr.gso.squaresense.countpeople.infrastructure.SensorEventRepository;
import fr.gso.squaresense.countpeople.presentation.PeopleStockResponse;
import fr.gso.squaresense.countpeople.presentation.SensorEventCreationRequest;

import javax.transaction.Transactional;


public class SensorEventApis {

    private SensorEventRepository sensorEventRepository;

    public SensorEventApis(SensorEventRepository sensorEventRepository) {
        this.sensorEventRepository = sensorEventRepository;
    }

    @Transactional
    public Long createSensorEvent(SensorEventCreationRequest request) {
        SensorEvent sensorEvent = new SensorEvent(request.sensorName, request.peopleIn, request.peopleOut, request.eventDateTime);
        return sensorEventRepository.createSensorEvent(sensorEvent);
    }


    public Long readPeopleStock(){
        return sensorEventRepository.readPeopleStock();
    }
}
