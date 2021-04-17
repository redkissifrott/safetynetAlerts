package fr.redkissifrott.safetynetAlerts.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.redkissifrott.safetynetAlerts.dto.ChildAlertDto;
import fr.redkissifrott.safetynetAlerts.dto.ChildDto;
import fr.redkissifrott.safetynetAlerts.dto.ChildHouseholdDto;
import fr.redkissifrott.safetynetAlerts.model.Person;
import fr.redkissifrott.safetynetAlerts.util.AgeFromBirthdate;

@Service
public class ChildAlertService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private AgeFromBirthdate ageFromBirthdate;

	public ChildAlertDto getChildAlert(String address) {

		ModelMapper modelMapper = new ModelMapper();

		List<ChildDto> listChildDto = new ArrayList<ChildDto>();
		List<ChildHouseholdDto> childHouseholdDto = new ArrayList<ChildHouseholdDto>();

		TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.address = ?1", Person.class);
		List<Person> listPersonsByAddress = query.setParameter(1, address).getResultList();

		for (Person person : listPersonsByAddress) {

			String firstName = person.getFirstName();
			String lastName = person.getLastName();
			TypedQuery<LocalDate> query1 = em.createQuery(
					"SELECT m.birthdate FROM Medicalrecord m WHERE m.firstName = ?1 AND m.lastName = ?2",
					LocalDate.class);
			LocalDate birthdate = query1.setParameter(1, firstName).setParameter(2, lastName).getSingleResult();
			Integer age = ageFromBirthdate.ageFromBirthdate(birthdate);

			if (age < 18) {
				ChildDto child = modelMapper.map(person, ChildDto.class);
				child.setAge(age);
				listChildDto.add(child);
			} else {
				childHouseholdDto.add(modelMapper.map(person, ChildHouseholdDto.class));
			}
		}
		if (!listChildDto.isEmpty()) {
			ChildAlertDto childAlertDto = new ChildAlertDto(listChildDto, childHouseholdDto);
			return childAlertDto;
		} else {
			return null;
		}

	}

}
