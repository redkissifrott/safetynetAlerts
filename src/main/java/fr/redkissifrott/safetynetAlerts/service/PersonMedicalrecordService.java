package fr.redkissifrott.safetynetAlerts.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.redkissifrott.safetynetAlerts.dto.PersonMedicalrecordDto;
import fr.redkissifrott.safetynetAlerts.model.Medicalrecord;
import fr.redkissifrott.safetynetAlerts.model.Person;

@Service
public class PersonMedicalrecordService {

	@Autowired
	PersonService personService;

	@Autowired
	MedicalrecordService medicalrecordService;

	public PersonMedicalrecordDto getPersonMedicalrecord(String firstName, String lastName) {
		Optional<Person> person = personService.getPerson(firstName, lastName);
		Optional<Medicalrecord> medicalrecord = medicalrecordService.getMedicalrecord(firstName, lastName);
		PersonMedicalrecordDto personMedicalrecord = new PersonMedicalrecordDto();
		if (person.isPresent() & medicalrecord.isPresent()) {
			personMedicalrecord.setFirstName(firstName);
			personMedicalrecord.setLastName(lastName);
			personMedicalrecord.setAge(medicalrecord.get().getAge());
			personMedicalrecord.setEmail(person.get().getEmail());
			personMedicalrecord.setMedications(medicalrecord.get().getMedications());
			personMedicalrecord.setAllergies(medicalrecord.get().getAllergies());
		} else {
			personMedicalrecord = null;
		}
		return personMedicalrecord;
	}

}
