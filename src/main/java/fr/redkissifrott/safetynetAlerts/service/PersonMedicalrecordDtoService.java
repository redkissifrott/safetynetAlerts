package fr.redkissifrott.safetynetAlerts.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.redkissifrott.safetynetAlerts.dto.PersonMedicalrecordDto;
import fr.redkissifrott.safetynetAlerts.model.Medicalrecord;
import fr.redkissifrott.safetynetAlerts.model.Person;
import fr.redkissifrott.safetynetAlerts.util.AgeFromBirthdate;

@Service
public class PersonMedicalrecordDtoService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	PersonService personService;

	@Autowired
	private MedicalrecordService medicalrecordService;

	@Autowired
	private AgeFromBirthdate ageFromBirthdate;

	ModelMapper modelMapper = new ModelMapper();

	public PersonMedicalrecordDto getPersonMedicalrecordDto(String firstName, String lastName) {
		Person person = personService.getPerson(firstName, lastName);
		Medicalrecord medicalrecord = medicalrecordService.getMedicalrecord(firstName, lastName);
		if (person != null & medicalrecord != null) {
			PersonMedicalrecordDto personMedDto = modelMapper.map(person, PersonMedicalrecordDto.class);
			modelMapper.map(medicalrecord, personMedDto);
			Integer age = ageFromBirthdate.ageFromBirthdate(personMedDto.getBirthdate());
			personMedDto.setAge(age);
			return personMedDto;
		} else {
			return null;
		}
	}

	public PersonMedicalrecordDto personToPersonMedDto(Person person) {
		PersonMedicalrecordDto personMedDto = getPersonMedicalrecordDto(person.getFirstName(), person.getLastName());
		return personMedDto;
	}

	public List<PersonMedicalrecordDto> getPersonsMedicalrecordByAddress(String address) {
		TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.address = ?1", Person.class);
		List<Person> listPersonsByAddress = query.setParameter(1, address).getResultList();
		List<PersonMedicalrecordDto> listPersonsMedicalByAddress = new ArrayList<PersonMedicalrecordDto>();
//		Type listType = new TypeToken<List<PersonMedicalrecordDto>>() {
//		}.getType();
//		List<PersonMedicalrecordDto> listPersonsMedicalByAddress = modelMapper.map(listPersonsByAddress, listType);
		for (Person person : listPersonsByAddress) {
			listPersonsMedicalByAddress.add(personToPersonMedDto(person));
		}
		return listPersonsMedicalByAddress;
	}

	public List<PersonMedicalrecordDto> getPersonsMedicalrecordByAddresses(List<String> addresses) {
		TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.address IN :addresses", Person.class);
		List<Person> listPersonsByAddresses = query.setParameter("addresses", addresses).getResultList();
		List<PersonMedicalrecordDto> listPersonsMedicalByAddresses = new ArrayList<PersonMedicalrecordDto>();
//		Type listType = new TypeToken<List<PersonMedicalrecordDto>>() {
//		}.getType();
//		List<PersonMedicalrecordDto> listPersonsMedicalByAddresses = modelMapper.map(listPersonsByAddresses, listType);
		for (Person person : listPersonsByAddresses) {
			listPersonsMedicalByAddresses.add(personToPersonMedDto(person));
		}
		return listPersonsMedicalByAddresses;
	}

}
