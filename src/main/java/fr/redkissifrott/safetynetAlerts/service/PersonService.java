package fr.redkissifrott.safetynetAlerts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.redkissifrott.safetynetAlerts.model.Person;
import fr.redkissifrott.safetynetAlerts.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Person getPerson(String firstName, String lastName) {
		return personRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	public Iterable<Person> getPersons() {
		return personRepository.findAll();
	}

	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	public void deletePerson(String firstName, String lastName) {
		personRepository.deleteByFirstNameAndLastName(firstName, lastName);
	}

}
