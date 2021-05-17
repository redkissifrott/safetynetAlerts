package fr.redkissifrott.safetynetAlerts.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import fr.redkissifrott.safetynetAlerts.dto.AddressPersonsStationDto;
import fr.redkissifrott.safetynetAlerts.service.AddressPersonsStationService;

@WebMvcTest(controllers = AddressPersonsStationController.class)
public class AddressPersonsStationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AddressPersonsStationService addressPersonsStationService;

	@Test
	public void getAddressPersonsStationDtotest() throws Exception {
		AddressPersonsStationDto a = new AddressPersonsStationDto();
		when(addressPersonsStationService.getAddressPersonsStation("1509 Culver St")).thenReturn(a);
		mockMvc.perform(get("/fire?address=1509 Culver St")).andExpect(status().isOk());
	}

}
