package fr.redkissifrott.safetynetAlerts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.redkissifrott.safetynetAlerts.model.Firestation;
import fr.redkissifrott.safetynetAlerts.repository.FirestationRepository;

@Service
public class FirestationService {

	@Autowired
	private FirestationRepository firestationRepository;

	public Firestation saveFirestation(Firestation firestation) {
		return firestationRepository.save(firestation);
	}

	public Firestation getFirestation(String address) {
		return firestationRepository.findByAddress(address);
	}

	public void deleteFirestation(String address) {
		firestationRepository.deleteByAddress(address);
	}

	public List<String> getAddresses(String station) {
		return firestationRepository.findByStation(station);
	}

}
