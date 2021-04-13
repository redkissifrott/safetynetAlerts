package fr.redkissifrott.safetynetAlerts.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.redkissifrott.safetynetAlerts.dto.PersonMedicalrecordDto;
import fr.redkissifrott.safetynetAlerts.model.Person;

@Service
public class PersonMedicalrecordServiceModelMapper {

	@Autowired
	private PersonService personService;

	@Autowired
	private ModelMapper modelMapper;

	private final Logger logger = LoggerFactory.getLogger(PersonMedicalrecordServiceModelMapper.class);

	public PersonMedicalrecordDto getPersonMedicalrecord(String firstName, String lastName) {
		logger.debug(personService.getPerson(firstName, lastName).toString());
		return convertToDto(personService.getPerson(firstName, lastName));
	}

	private PersonMedicalrecordDto convertToDto(Optional<Person> person) {
//		modelMapper.getConfiguration().setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
//				.setMatchingStrategy(MatchingStrategies.LOOSE);
		PersonMedicalrecordDto personMedicalrecordDto = modelMapper.map(person, PersonMedicalrecordDto.class);
		return personMedicalrecordDto;
	}

}
