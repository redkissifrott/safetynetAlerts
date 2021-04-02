package fr.redkissifrott.safetynetAlerts.initialDataFromJsonToDB;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import fr.redkissifrott.safetynetAlerts.model.Firestation;
import fr.redkissifrott.safetynetAlerts.model.Medicalrecord;
import fr.redkissifrott.safetynetAlerts.model.Person;
import fr.redkissifrott.safetynetAlerts.service.FirestationService;
import fr.redkissifrott.safetynetAlerts.service.MedicalrecordService;
import fr.redkissifrott.safetynetAlerts.service.PersonService;

@Component
public class InitialDataInDB implements CommandLineRunner {
	@Autowired
	private PersonService personService;
	@Autowired
	private FirestationService firestationService;
	@Autowired
	private MedicalrecordService medicalrecordService;
	@Autowired
	private JsonParser jsonParser;

	private final Logger logger = LoggerFactory.getLogger(InitialDataInDB.class);

	public void initialDataInDB() throws IOException {

		AllData allData = jsonParser.readJsonWithObjectMapper();
		logger.info(allData.toString());
		List<Person> persons = allData.getPersons();
		List<Firestation> firestations = allData.getFirestations();
		List<Medicalrecord> medicalrecords = allData.getMedicalrecords();

		for (Person person : persons) {
			personService.savePerson(person);
		}

		for (Firestation firestation : firestations) {
			firestationService.saveFirestation(firestation);
		}

		for (Medicalrecord medicalrecord : medicalrecords) {
			medicalrecordService.saveMedicalrecord(medicalrecord);
		}
	}

	@Override
	public void run(String... args) throws Exception {
		initialDataInDB();
	}
}
