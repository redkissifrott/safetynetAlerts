package fr.redkissifrott.safetynetAlerts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.redkissifrott.safetynetAlerts.model.Firestation;
import fr.redkissifrott.safetynetAlerts.repository.FirestationRepository;
import lombok.Data;

@Data
@Service
public class FirestationService {

	@Autowired
	private FirestationRepository firestationRepository;

	public void saveFirestation(Firestation firestation) {
		firestationRepository.save(firestation);
	}

}
