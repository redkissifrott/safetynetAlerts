package fr.redkissifrott.safetynetAlerts.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.redkissifrott.safetynetAlerts.model.Medicalrecord;
import fr.redkissifrott.safetynetAlerts.repository.MedicalrecordRepository;

@Service
public class MedicalrecordService {

	@Autowired
	private MedicalrecordRepository medicalrecordRepository;

	public Optional<Medicalrecord> getMedicalrecord(String firstName, String lastName) {
		return medicalrecordRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	public Iterable<Medicalrecord> getMedicalrecords() {
		return medicalrecordRepository.findAll();
	}

	public Medicalrecord saveMedicalrecord(Medicalrecord medicalrecord) {
		return medicalrecordRepository.save(medicalrecord);
	}

	public void deleteMedicalrecord(String firstName, String lastName) {
		medicalrecordRepository.deleteByFirstNameAndLastName(firstName, lastName);
	}

}
