package fr.redkissifrott.safetynetAlerts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.redkissifrott.safetynetAlerts.dto.PersonMedicalrecordDto;
import fr.redkissifrott.safetynetAlerts.service.PersonMedicalrecordService;

@RestController
public class PersonMedicalrecordController {

	@Autowired
	private PersonMedicalrecordService personMedicalrecordService;

	private final Logger logger = LoggerFactory.getLogger(PersonMedicalrecordController.class);

	/**
	 * Read - Get PersonInfo - Person and Medicalrecord
	 * 
	 * @param firstName
	 * @param lastName
	 * @return person and medicalrecord DTO
	 */
	@RequestMapping(value = "/personInfo", params = { "firstName", "lastName" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<PersonMedicalrecordDto> getPersonMedicalrecordDto(
			@RequestParam("firstName") final String firstName, @RequestParam("lastName") final String lastName) {
		logger.info("Request : GET http://localhost:8080/personInfo?firstName={}&lastName={}", firstName, lastName);
		PersonMedicalrecordDto personMedicalrecord = personMedicalrecordService.getPersonMedicalrecord(firstName,
				lastName);
		if (personMedicalrecord != null) {
			logger.info("Return : Body :{}", personMedicalrecord);
			return ResponseEntity.ok().body(personMedicalrecord);
		} else {
			logger.error("Person {} {} not found in DB", firstName, lastName);
			return ResponseEntity.notFound().build();
		}
	}

}
