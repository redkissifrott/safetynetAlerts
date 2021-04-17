package fr.redkissifrott.safetynetAlerts.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.redkissifrott.safetynetAlerts.dto.PersonInfoDto;
import fr.redkissifrott.safetynetAlerts.dto.PersonMedicalrecordDto;

@Service
public class PersonInfoService {

	@Autowired
	PersonMedicalrecordDtoService personMedicalrecordDtoService;

	public PersonInfoDto getPersonInfo(String firstName, String lastName) {
		PersonMedicalrecordDto personMedicalrecordDto = personMedicalrecordDtoService
				.getPersonMedicalrecordDto(firstName, lastName);
		if (personMedicalrecordDto != null) {
			ModelMapper modelMapper = new ModelMapper();
			PersonInfoDto personInfoDto = modelMapper.map(personMedicalrecordDto, PersonInfoDto.class);
			return personInfoDto;
		} else {
			return null;
		}
	}
}
