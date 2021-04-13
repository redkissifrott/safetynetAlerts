package fr.redkissifrott.safetynetAlerts.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import fr.redkissifrott.safetynetAlerts.dto.PersonMedicalrecordDto;
import fr.redkissifrott.safetynetAlerts.service.PersonMedicalrecordService;

@WebMvcTest(controllers = PersonMedicalrecordController.class)
public class PersonMedicalrecordControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PersonMedicalrecordService personMedicalrecordService;

	@Test
	public void getPersonMedicalrecordDtoTest() throws Exception {
		PersonMedicalrecordDto p = new PersonMedicalrecordDto();
		when(personMedicalrecordService.getPersonMedicalrecord("FirstName", "LastName")).thenReturn(p);
		mockMvc.perform(get("/personInfo?firstName=FirstName&lastName=LastName")).andExpect(status().isOk());
	}

}
