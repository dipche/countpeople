package fr.gso.squaresense.countpeople.app;

import fr.gso.squaresense.countpeople.api.SensorEventApis;
import fr.gso.squaresense.countpeople.infra.InfraConfiguration;
import fr.gso.squaresense.countpeople.infrastructure.SensorEventRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(InfraConfiguration.class)
public class CountPeopleConfiguration {

    @Bean
    SensorEventApis standardSensorEventApi(SensorEventRepository repository) {
        return new SensorEventApis(repository);
    }
}
