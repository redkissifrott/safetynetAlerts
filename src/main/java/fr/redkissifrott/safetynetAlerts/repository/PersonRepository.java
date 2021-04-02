package fr.redkissifrott.safetynetAlerts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.redkissifrott.safetynetAlerts.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
