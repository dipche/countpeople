package fr.gso.squaresense.countpeople.infra.repository;

import fr.gso.squaresense.countpeople.domain.SensorEvent;
import fr.gso.squaresense.countpeople.infra.hibernate.SensorEventHibernate;

public class SensorEventHibernateMapper {

    public static SensorEvent fromSensorEventHibernate(SensorEventHibernate sensorEventHibernate) {
        return new SensorEvent(sensorEventHibernate.id,
                sensorEventHibernate.name,
                sensorEventHibernate.peopleIn,
                sensorEventHibernate.peopleOut,
                sensorEventHibernate.eventDate);
    }

    public static SensorEventHibernate fromSensorEvent(SensorEvent sensorEvent) {
        SensorEventHibernate sensorEventHibernate = new SensorEventHibernate();
        mapHibernateFields(sensorEvent, sensorEventHibernate);
        return sensorEventHibernate;
    }

    public static void mapHibernateFields(SensorEvent sensorEvent, SensorEventHibernate sensorEventHibernate) {
        sensorEventHibernate.id = sensorEvent.getId();
        sensorEventHibernate.name = sensorEvent.getSensorName();
        sensorEventHibernate.peopleIn = sensorEvent.getPeopleIn();
        sensorEventHibernate.peopleOut = sensorEvent.getPeopleOut();
        sensorEventHibernate.eventDate = sensorEvent.getEventDateTime();
    }
}
