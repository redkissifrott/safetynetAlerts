package fr.redkissifrott.safetynetAlerts.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.redkissifrott.safetynetAlerts.model.Firestation;

@Repository
public interface FirestationRepository extends CrudRepository<Firestation, Integer> {

	Optional<Firestation> findByAddress(String address);

	@Transactional
	Object deleteByAddress(String address);

}
