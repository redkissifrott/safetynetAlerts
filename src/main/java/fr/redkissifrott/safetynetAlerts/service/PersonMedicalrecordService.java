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
public class PersonMedicalrecordService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	PersonService personService;

	@Autowired
	private MedicalrecordService medicalrecordService;

	@Autowired
	private AgeFromBirthdate ageFromBirthdate;

	ModelMapper modelMapper = new ModelMapper();

	/**
	 * Get PersonMedicalrecord from first and last name
	 * 
	 * @param firstName
	 * @param lastName
	 * @return Persons and Medicalrecords Infos
	 */
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

	/**
	 * Get PersonMedicalrecord from Person
	 * 
	 * @param person
	 * @return Persons and Medicalrecords Infos
	 */
	public PersonMedicalrecordDto personToPersonMedDto(Person person) {
		PersonMedicalrecordDto personMedDto = getPersonMedicalrecordDto(person.getFirstName(), person.getLastName());
		return personMedDto;
	}

	/**
	 * Get PersonMedicalrecord from address
	 * 
	 * @param address
	 * @return Persons and Medicalrecords Infos
	 */
	public List<PersonMedicalrecordDto> getPersonsMedicalrecordByAddress(String address) {
		TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.address = ?1", Person.class);
		List<Person> listPersonsByAddress = query.setParameter(1, address).getResultList();
		List<PersonMedicalrecordDto> listPersonsMedicalByAddress = new ArrayList<PersonMedicalrecordDto>();
		for (Person person : listPersonsByAddress) {
			listPersonsMedicalByAddress.add(personToPersonMedDto(person));
		}
		return listPersonsMedicalByAddress;
	}

	/**
	 * Get PersonMedicalrecord from list of addresses
	 * 
	 * @param addresses LIst
	 * @return Persons and Medicalrecords Infos
	 */
	public List<PersonMedicalrecordDto> getPersonsMedicalrecordByAddresses(List<String> addresses) {
		TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.address IN :addresses", Person.class);
		List<Person> listPersonsByAddresses = query.setParameter("addresses", addresses).getResultList();
		List<PersonMedicalrecordDto> listPersonsMedicalByAddresses = new ArrayList<PersonMedicalrecordDto>();
		for (Person person : listPersonsByAddresses) {
			listPersonsMedicalByAddresses.add(personToPersonMedDto(person));
		}
		return listPersonsMedicalByAddresses;
	}

}
