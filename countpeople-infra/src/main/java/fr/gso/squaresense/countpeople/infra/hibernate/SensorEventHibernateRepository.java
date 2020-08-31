package fr.gso.squaresense.countpeople.infra.hibernate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface SensorEventHibernateRepository extends CrudRepository<SensorEventHibernate, Long> {
    List<SensorEventHibernate> findByEventDate(LocalDateTime eventDate);
}
