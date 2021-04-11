package fr.redkissifrott.safetynetAlerts.controller.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import fr.redkissifrott.safetynetAlerts.service.PersonMedicalrecordService;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonMedicalrecordIT {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PersonMedicalrecordService personMedicalrecordService;

	@Test
	@AutoConfigureTestDatabase(replace = Replace.NONE)
	public void getPersonMedicalrecordDtoTest() throws Exception {
		mockMvc.perform(get("/personInfo?firstName=John&lastName=Boyd"));
	}

}
