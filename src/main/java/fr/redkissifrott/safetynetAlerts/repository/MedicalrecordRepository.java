package fr.redkissifrott.safetynetAlerts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.redkissifrott.safetynetAlerts.model.Medicalrecord;

@Repository
public interface MedicalrecordRepository extends CrudRepository<Medicalrecord, Integer> {

}
