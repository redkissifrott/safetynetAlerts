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

import fr.redkissifrott.safetynetAlerts.dto.ChildAlertDto;
import fr.redkissifrott.safetynetAlerts.service.ChildAlertService;

/**
 * @author RedKissiFrott
 *
 *         Controler for list of child by address with household
 *
 */
@RestController
public class ChildAlertController {

	@Autowired
	ChildAlertService childAlertService;

	private final Logger logger = LoggerFactory.getLogger(ChildAlertController.class);

	@RequestMapping(value = "/childAlert", params = { "address" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ChildAlertDto> getChildAlertDto(@RequestParam("address") final String address) {
		logger.info("Request : GET http://localhost:8080/childAlert?address={}", address);
		ChildAlertDto childAlert = childAlertService.getChildAlert(address);
		if (childAlert != null) {
			logger.info("Return : Body :{}", childAlert);
			return ResponseEntity.ok().body(childAlert);
		} else {
			logger.error("Station {} not found in DB", address);
			return ResponseEntity.notFound().build();
		}
	}

}
