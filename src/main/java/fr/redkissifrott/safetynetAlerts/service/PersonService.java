package fr.redkissifrott.safetynetAlerts.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.redkissifrott.safetynetAlerts.model.Person;
import fr.redkissifrott.safetynetAlerts.repository.PersonRepository;

//@Data
@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Optional<Person> getPerson(String firstName, String lastName) {
		return personRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	public Iterable<Person> getPersons() {
		return personRepository.findAll();
	}

	public Person savePerson(Person person) {
		Person savedPerson = personRepository.save(person);
		return savedPerson;
	}

	public void deletePerson(String firstName, String lastName) {
		personRepository.deleteByFirstNameAndLastName(firstName, lastName);
	}

}
