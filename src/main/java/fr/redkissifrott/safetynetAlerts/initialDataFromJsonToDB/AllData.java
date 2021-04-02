package fr.redkissifrott.safetynetAlerts.initialDataFromJsonToDB;

import java.util.List;

import fr.redkissifrott.safetynetAlerts.model.Firestation;
import fr.redkissifrott.safetynetAlerts.model.Medicalrecord;
import fr.redkissifrott.safetynetAlerts.model.Person;
import lombok.Data;

@Data
public class AllData {
	List<Person> persons;
	List<Firestation> firestations;
	List<Medicalrecord> medicalrecords;

}
