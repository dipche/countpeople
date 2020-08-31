package fr.gso.squaresense.countpeople.infra.repository;

import fr.gso.squaresense.countpeople.domain.PeopleStock;
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

    public static final String SENSORNAME = "Irisys";
    public static final long PEOPLE_IN = 3;
    public static final long PEOPLE_OUT = 1;
    private static final LocalDateTime EVENT_DATE = LocalDateTime.of(2020, Month.AUGUST,
            27,15,47,30);

    public static final long PEOPLE_IN_2 = 19;
    public static final long PEOPLE_OUT_2 = 7;
    public static final String SENSORNAME_2 = "Leuze";
    private static final LocalDateTime EVENT_DATE_2 = LocalDateTime.of(2020, Month.AUGUST,
            28,10,23, 0);

    @Autowired
    private SensorEventRepository sensorEventRepository;

    @Test
    public void testCreate() {
        SensorEvent sensorEvent = new SensorEvent(SENSORNAME, PEOPLE_IN, PEOPLE_OUT, EVENT_DATE);

        Long createdId = sensorEventRepository.createSensorEvent(sensorEvent);

        assertThat(createdId).isNotNull();

        Optional<SensorEvent> read = sensorEventRepository.readSensorEvent(createdId);

        assertThat(read.isPresent()).isTrue();
        assertThat(read.get().getId()).isEqualTo(createdId);
        assertThat(read.get().getEventDateTime()).isEqualTo(EVENT_DATE);
        assertThat(read.get().getPeopleOut()).isEqualTo(PEOPLE_OUT);
        assertThat(read.get().getPeopleIn()).isEqualTo(PEOPLE_IN);
        assertThat(read.get().getSensorName()).isEqualTo(SENSORNAME);
    }

    @Test
    public void testPeopleStock() {
        PeopleStock peopleStock = sensorEventRepository.readPeopleStock();
        assertThat(peopleStock.getPeopleStock()).isEqualTo(PEOPLE_IN+PEOPLE_IN_2-PEOPLE_OUT-PEOPLE_OUT_2);
    }


    @Test
    public void testPeopleStockAtExactInstant() {
        PeopleStock peopleStock = sensorEventRepository.readPeopleStockAtInstant(EVENT_DATE_2);
        assertThat(peopleStock.getPeopleStock()).isEqualTo(PEOPLE_IN+PEOPLE_IN_2-PEOPLE_OUT-PEOPLE_OUT_2);
    }

    @Test
    public void testPeopleStockAtExactInstant2() {
        PeopleStock peopleStock = sensorEventRepository.readPeopleStockAtInstant(EVENT_DATE);
        assertThat(peopleStock.getPeopleStock()).isEqualTo(PEOPLE_IN-PEOPLE_OUT);
    }

    @Test
    public void testPeopleStockAtInstantBeforeAllEntries() {
        LocalDateTime givenTime = LocalDateTime.of(2020, Month.AUGUST,
                25,10,23, 0);
        PeopleStock peopleStock = sensorEventRepository.readPeopleStockAtInstant(givenTime);
        assertThat(peopleStock.getPeopleStock()).isEqualTo(0L);
    }


    @Test
    public void testPeopleStockAtInstantAfterAllEntries() {
        LocalDateTime givenTime = LocalDateTime.of(2020, Month.AUGUST,
                30,10,23, 0);
        PeopleStock peopleStock = sensorEventRepository.readPeopleStockAtInstant(givenTime);
        assertThat(peopleStock.getPeopleStock()).isEqualTo(PEOPLE_IN+PEOPLE_IN_2-PEOPLE_OUT-PEOPLE_OUT_2);
    }
}
