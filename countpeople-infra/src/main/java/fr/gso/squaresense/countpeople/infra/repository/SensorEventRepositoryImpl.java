package fr.gso.squaresense.countpeople.infra.repository;

import fr.gso.squaresense.countpeople.domain.PeopleStock;
import fr.gso.squaresense.countpeople.domain.SensorEvent;
import fr.gso.squaresense.countpeople.infra.hibernate.SensorEventHibernate;
import fr.gso.squaresense.countpeople.infra.hibernate.SensorEventHibernateRepository;
import fr.gso.squaresense.countpeople.infrastructure.SensorEventRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public class SensorEventRepositoryImpl implements SensorEventRepository {

    private SensorEventHibernateRepository sensorEventHibernateRepository;

    public SensorEventRepositoryImpl(SensorEventHibernateRepository sensorEventHibernateRepository) {
        this.sensorEventHibernateRepository = sensorEventHibernateRepository;
    }

    @Override
    public Optional<SensorEvent> readSensorEvent(Long id) {
        Optional<SensorEventHibernate> sensorEventHibernate = this.sensorEventHibernateRepository.findById(id);
        return sensorEventHibernate.map(SensorEventHibernateMapper::fromSensorEventHibernate);
    }

    @Override
    public Long createSensorEvent(SensorEvent sensorEvent) {
        SensorEventHibernate sensorEventHibernate = SensorEventHibernateMapper.fromSensorEvent(sensorEvent);
        SensorEventHibernate saved = this.sensorEventHibernateRepository.save(sensorEventHibernate);
        return saved.id;
    }

    @Override
    public PeopleStock readPeopleStock() {
        List<SensorEventHibernate> sensorEventsHibernate = (List<SensorEventHibernate>) this.sensorEventHibernateRepository.findAll();
        return new PeopleStock(computePeopleStock(sensorEventsHibernate));
    }

    @Override
    public PeopleStock readPeopleStockAtInstant(LocalDateTime dateTime) {
        List<SensorEventHibernate> sensorEventsHibernate = this.sensorEventHibernateRepository.findByEventDateLessThanEqual(dateTime);
        return new PeopleStock(computePeopleStock(sensorEventsHibernate));
    }


    private Long computePeopleStock(List<SensorEventHibernate> sensorEvents) {
        long peopleStock = 0L;
        if (sensorEvents != null) {
            peopleStock = sensorEvents
                    .stream()
                    .mapToLong(sensorEvent -> sensorEvent.peopleIn - sensorEvent.peopleOut)
                    .sum();
        }
        return peopleStock;
    }

}
