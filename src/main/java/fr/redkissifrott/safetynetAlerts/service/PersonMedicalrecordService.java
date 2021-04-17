package fr.redkissifrott.safetynetAlerts.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.redkissifrott.safetynetAlerts.dto.PersonInfoDto;
import fr.redkissifrott.safetynetAlerts.model.Medicalrecord;
import fr.redkissifrott.safetynetAlerts.model.Person;

@Service
public class PersonMedicalrecordService {

	@Autowired
	PersonService personService;

	@Autowired
	MedicalrecordService medicalrecordService;

	public PersonInfoDto getPersonMedicalrecord(String firstName, String lastName) {
		Optional<Person> person = Optional.of(personService.getPerson(firstName, lastName));
		Optional<Medicalrecord> medicalrecord = Optional.of(medicalrecordService.getMedicalrecord(firstName, lastName));
		PersonInfoDto personMedicalrecord = new PersonInfoDto();
		if (person.isPresent() & medicalrecord.isPresent()) {
			personMedicalrecord.setFirstName(firstName);
			personMedicalrecord.setLastName(lastName);
			personMedicalrecord.setEmail(person.get().getEmail());
			personMedicalrecord.setMedications(medicalrecord.get().getMedications());
			personMedicalrecord.setAllergies(medicalrecord.get().getAllergies());
		} else {
			personMedicalrecord = null;
		}
		return personMedicalrecord;
	}
}
