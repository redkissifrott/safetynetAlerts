package fr.redkissifrott.safetynetAlerts.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonMedicalrecordDtoServiceTest {

	@Autowired
	PersonMedicalrecordDtoService tryPersonMed;

	@Test
	@AutoConfigureTestDatabase(replace = Replace.NONE)
	void test() {
		tryPersonMed.getPersonMedicalrecordDto("Brian", "Stelzer");
	}

}
