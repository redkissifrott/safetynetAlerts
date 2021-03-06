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

import fr.redkissifrott.safetynetAlerts.dto.AddressPersonsStationDto;
import fr.redkissifrott.safetynetAlerts.service.AddressPersonsStationService;

/**
 * @author RedKissiFrott
 * 
 *         Controller for list of persons, number of children and adults by
 *         stations
 *
 */
@RestController
public class AddressPersonsStationController {

	@Autowired
	AddressPersonsStationService addressPersonsStationService;

	private final Logger logger = LoggerFactory.getLogger(AddressPersonsStationService.class);

	/**
	 * Read - Get list of persons and station number by address
	 * 
	 * @param address
	 * @return AddressPersonsStationDto
	 */
	@RequestMapping(value = "/fire", params = { "address" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<AddressPersonsStationDto> getAddressPersonsStationDto(
			@RequestParam("address") final String address) {
		logger.info("Request : GET http://localhost:8080/fire?address={}", address);
		AddressPersonsStationDto addressPersonsStation = addressPersonsStationService.getAddressPersonsStation(address);
		logger.info("Return : Body :{}", addressPersonsStation);
		return ResponseEntity.ok().body(addressPersonsStation);
	}

}
