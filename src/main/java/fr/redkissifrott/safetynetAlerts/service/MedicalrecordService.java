package fr.redkissifrott.safetynetAlerts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.redkissifrott.safetynetAlerts.model.Medicalrecord;
import fr.redkissifrott.safetynetAlerts.repository.MedicalrecordRepository;
import lombok.Data;

@Data
@Service
public class MedicalrecordService {

	@Autowired
	private MedicalrecordRepository medicalrecordRepository;

	public void saveMedicalrecord(Medicalrecord medicalrecord) {
		medicalrecordRepository.save(medicalrecord);
	}

}
