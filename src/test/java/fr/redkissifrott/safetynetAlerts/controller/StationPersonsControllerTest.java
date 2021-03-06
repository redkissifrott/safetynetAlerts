package fr.redkissifrott.safetynetAlerts.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import fr.redkissifrott.safetynetAlerts.dto.StationPersonsDto;
import fr.redkissifrott.safetynetAlerts.service.StationPersonsService;

@WebMvcTest(controllers = StationPersonsController.class)
class StationPersonsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StationPersonsService stationPersonsService;

	@Test
	public void getStationPersonsDtoTest() throws Exception {
		StationPersonsDto s = new StationPersonsDto();
		when(stationPersonsService.getStationPersons("1")).thenReturn(s);
		mockMvc.perform(get("/firestation?stationNumber=1")).andExpect(status().isOk());
	}

	@Test
	public void getStationPersonsDtoNotFoundTest() throws Exception {
		when(stationPersonsService.getStationPersons("1")).thenReturn(null);
		mockMvc.perform(get("/firestation?stationNumber=1")).andExpect(status().isNotFound());
	}

}
