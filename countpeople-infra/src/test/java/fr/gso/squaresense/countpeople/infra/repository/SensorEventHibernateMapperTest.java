package fr.gso.squaresense.countpeople.infra.repository;

import fr.gso.squaresense.countpeople.domain.SensorEvent;
import fr.gso.squaresense.countpeople.infra.hibernate.SensorEventHibernate;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class SensorEventHibernateMapperTest {

    public static final long ID = 12L;
    public static final String NAME = "sensorname";
    public static final long PEOPLE_IN = 9;
    public static final long PEOPLE_OUT = 8;
    private static final LocalDateTime EVENT_DATE = LocalDateTime.of(2020, Month.AUGUST,
            10,9,45,30);

    @Test
    public void fromSensorEventTest() {
        SensorEventHibernate sensorEventHibernate = new SensorEventHibernate();
        sensorEventHibernate.id = ID;
        sensorEventHibernate.name = NAME;
        sensorEventHibernate.peopleOut = PEOPLE_OUT;
        sensorEventHibernate.peopleIn = PEOPLE_IN;
        sensorEventHibernate.eventDate = EVENT_DATE;

        SensorEvent sensorEvent = SensorEventHibernateMapper.fromSensorEventHibernate(sensorEventHibernate);

        assertThat(sensorEvent.getId()).isEqualTo(ID);
        assertThat(sensorEvent.getSensorName()).isEqualTo(NAME);
        assertThat(sensorEvent.getPeopleIn()).isEqualTo(PEOPLE_IN);
        assertThat(sensorEvent.getPeopleOut()).isEqualTo(PEOPLE_OUT);
        assertThat(sensorEvent.getEventDateTime()).isEqualTo(EVENT_DATE);
    }

    @Test
    public void fromSensorEvent() {
        SensorEvent sensorEvent = new SensorEvent(ID,NAME,PEOPLE_OUT,PEOPLE_IN,EVENT_DATE);

        SensorEventHibernate sensorEventHibernate = SensorEventHibernateMapper.fromSensorEvent(sensorEvent);

        assertThat(sensorEventHibernate.id).isEqualTo(ID);
        assertThat(sensorEventHibernate.name).isEqualTo(NAME);
        assertThat(sensorEventHibernate.peopleIn).isEqualTo(PEOPLE_IN);
        assertThat(sensorEventHibernate.peopleOut).isEqualTo(PEOPLE_OUT);
        assertThat(sensorEventHibernate.eventDate).isEqualTo(EVENT_DATE);
    }

    @Test
    public void mapFields() {
        SensorEvent sensorEvent = new SensorEvent(ID,NAME,PEOPLE_OUT,PEOPLE_IN,EVENT_DATE);

        SensorEventHibernate sensorEventHibernate = new SensorEventHibernate();

        SensorEventHibernateMapper.mapHibernateFields(sensorEvent, sensorEventHibernate);
        assertThat(sensorEventHibernate.id).isEqualTo(ID);
        assertThat(sensorEventHibernate.name).isEqualTo(NAME);
        assertThat(sensorEventHibernate.peopleOut).isEqualTo(PEOPLE_OUT);
        assertThat(sensorEventHibernate.peopleIn).isEqualTo(PEOPLE_IN);
        assertThat(sensorEventHibernate.eventDate).isEqualTo(EVENT_DATE);
    }
}
