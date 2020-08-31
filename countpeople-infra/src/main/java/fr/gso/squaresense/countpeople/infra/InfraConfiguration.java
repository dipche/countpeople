package fr.gso.squaresense.countpeople.infra;

import fr.gso.squaresense.countpeople.infra.hibernate.SensorEventHibernateRepository;
import fr.gso.squaresense.countpeople.infra.repository.SensorEventRepositoryImpl;
import fr.gso.squaresense.countpeople.infrastructure.SensorEventRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("fr.gso.squaresense.countpeople.infra.hibernate")
@EntityScan("fr.gso.squaresense.countpeople.infra.hibernate")
public class InfraConfiguration {

    @Bean
    SensorEventRepository sensorEventRepository(SensorEventHibernateRepository sensorEventHibernateRepository) {
        return new SensorEventRepositoryImpl(sensorEventHibernateRepository);
    }
}
