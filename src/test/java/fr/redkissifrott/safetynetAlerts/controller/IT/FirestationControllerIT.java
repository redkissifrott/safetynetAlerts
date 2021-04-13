package fr.redkissifrott.safetynetAlerts.controller.IT;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import fr.redkissifrott.safetynetAlerts.model.Firestation;
import fr.redkissifrott.safetynetAlerts.service.FirestationService;

@SpringBootTest
@AutoConfigureTestDatabase
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureMockMvc
public class FirestationControllerIT {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private FirestationService firestationService;

	@AfterAll
	private static void tearDown() {

	}

	@Test
	@Order(1)
	@Rollback(false)
	public void createFirestationTest() throws Exception {
		mockMvc.perform(post("/firestation").contentType(MediaType.APPLICATION_JSON)
				.content("{ \"address\":\"my address\", \"station\":\"7\" }").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
	}

	@Test
	@Order(2)
	public void createFirestationConstraintViolationTest() throws Exception {
		mockMvc.perform(post("/firestation").contentType(MediaType.APPLICATION_JSON).content("{ \"station\":\"7\" }")
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").doesNotExist());
	}

	@Test
	@Order(3)
	@Rollback(false)
	public void updateFirestationTest() throws Exception {
		mockMvc.perform(put("/firestation/my address").contentType(MediaType.APPLICATION_JSON).content("7")
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.station", is("7")));
	}

	@Test
	@Order(4)
	@Rollback(false)
	public void updateFirestationNotFoundTest() throws Exception {
		mockMvc.perform(put("/firestation/not my address").contentType(MediaType.APPLICATION_JSON)
				.content("{ \"station\":\"7\" }").accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound())
				.andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist());
	}

	@Test
	@Order(6)
	@Rollback(false)
	public void deleteFirestationTest() throws Exception {
		mockMvc.perform(delete("/firestation/my address")).andExpect(status().isOk());
		Optional<Firestation> deletedFirestation = firestationService.getFirestation("my address");
		assertThat(deletedFirestation).isEmpty();

	}

	@Test
	@Order(5)
	@Rollback(false)
	public void deleteFirestationNotFoundTest() throws Exception {
		mockMvc.perform(delete("/firestation/not my address").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
		Optional<Firestation> deletedFirestation = firestationService.getFirestation("my address");
		assertThat(deletedFirestation).isNotEmpty();
	}

}
