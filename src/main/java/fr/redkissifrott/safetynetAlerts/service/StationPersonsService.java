package fr.redkissifrott.safetynetAlerts.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.redkissifrott.safetynetAlerts.dto.PersonByStationDto;
import fr.redkissifrott.safetynetAlerts.dto.PersonMedicalrecordDto;
import fr.redkissifrott.safetynetAlerts.dto.StationPersonsDto;

@Service
public class StationPersonsService {

	@Autowired
	private FirestationService firestationService;

	@Autowired
	private PersonMedicalrecordService personMedicalrecordDtoService;

	public StationPersonsDto getStationPersons(String stationNumber) {

		List<String> addresses = firestationService.getAddresses(stationNumber);
		if (!addresses.isEmpty()) {

//			TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.address IN :addresses",
//					Person.class);
//			List<Person> listPersonsByStation = query.setParameter("addresses", addresses).getResultList();

//			ModelMapper modelMapper = new ModelMapper();
//			Type listType = new TypeToken<List<PersonByStationDto>>() {
//			}.getType();
//			List<PersonByStationDto> listPersonsByStationDto = modelMapper.map(listPersonsByStation, listType);
//
//			int children = 0;
//			int adults = 0;
//
//			for (Person person : listPersonsByStation) {
//				String firstName = person.getFirstName();
//				String lastName = person.getLastName();
//				TypedQuery<LocalDate> query1 = em.createQuery(
//						"SELECT m.birthdate FROM Medicalrecord m WHERE m.firstName = ?1 AND m.lastName = ?2",
//						LocalDate.class);
//				LocalDate birthdate = query1.setParameter(1, firstName).setParameter(2, lastName).getSingleResult();
//				Integer age = ageFromBirthdate.ageFromBirthdate(birthdate);
//				if (age < 18) {
//					children++;
//				} else {
//					adults++;
//				}
//			}
//			StationPersonsDto stationsPerson = new StationPersonsDto(listPersonsByStationDto, children, adults);
			List<PersonMedicalrecordDto> listPersonsByStation = personMedicalrecordDtoService
					.getPersonsMedicalrecordByAddresses(addresses);
			List<PersonByStationDto> listPersonsByStationDto = new ArrayList<PersonByStationDto>();
			int children = 0;
			int adults = 0;
			for (PersonMedicalrecordDto personMedByStation : listPersonsByStation) {
				ModelMapper modelMapper = new ModelMapper();
				PersonByStationDto personByStationDto = modelMapper.map(personMedByStation, PersonByStationDto.class);
				listPersonsByStationDto.add(personByStationDto);
				if (personMedByStation.getAge() < 18) {
					children++;
				} else {
					adults++;
				}
			}
			StationPersonsDto stationsPerson = new StationPersonsDto(listPersonsByStationDto, children, adults);
			return stationsPerson;
		} else {
			return null;
		}

	}
}
