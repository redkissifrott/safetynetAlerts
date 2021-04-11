package fr.redkissifrott.safetynetAlerts.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.redkissifrott.safetynetAlerts.model.Medicalrecord;

@Repository
public interface MedicalrecordRepository extends CrudRepository<Medicalrecord, Integer> {

	Optional<Medicalrecord> findByFirstNameAndLastName(String firstName, String lastName);

	@Transactional
	void deleteByFirstNameAndLastName(String firstName, String lastName);

}
