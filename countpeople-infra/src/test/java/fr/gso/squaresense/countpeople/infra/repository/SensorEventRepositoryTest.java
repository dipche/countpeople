package fr.gso.squaresense.countpeople.infra.repository;

import fr.gso.squaresense.countpeople.domain.SensorEvent;
import fr.gso.squaresense.countpeople.infra.InfraConfiguration;
import fr.gso.squaresense.countpeople.infrastructure.SensorEventRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {InfraConfiguration.class})
@ActiveProfiles({"test"})
@DataJpaTest
public class SensorEventRepositoryTest {

    public static final long ID = 12L;
    public static final String SENSORNAME = "sensorname";
    public static final long PEOPLE_IN = 9;
    public static final long PEOPLE_OUT = 8;
    private static final LocalDateTime EVENT_DATE_1 = LocalDateTime.of(2020, Month.AUGUST,
            10,9,45,30);
    private static final String EVENT_DATE = "2020-08-10T09:45:30Z";

    @Autowired
    private SensorEventRepository sensorEventRepository;

    @Test
    public void testCreate() {
        SensorEvent sensorEvent = new SensorEvent(SENSORNAME, PEOPLE_OUT, PEOPLE_IN, EVENT_DATE);

        Long createdId = sensorEventRepository.createSensorEvent(sensorEvent);

        assertThat(createdId).isNotNull();

        Optional<SensorEvent> read = sensorEventRepository.readSensorEvent(createdId);

        assertThat(read.isPresent()).isTrue();
        assertThat(read.get().getId()).isEqualTo(createdId);
        assertThat(read.get().getEventDateTime()).isEqualTo(EVENT_DATE_1);
        assertThat(read.get().getPeopleOut()).isEqualTo(PEOPLE_OUT);
        assertThat(read.get().getPeopleIn()).isEqualTo(PEOPLE_IN);
        assertThat(read.get().getSensorName()).isEqualTo(SENSORNAME);
    }
}
