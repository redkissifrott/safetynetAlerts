package fr.redkissifrott.safetynetAlerts.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import fr.redkissifrott.safetynetAlerts.model.Person;
import fr.redkissifrott.safetynetAlerts.service.PersonService;

@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PersonService personService;

	@Test
	public void createPersonTest() throws Exception {
		mockMvc.perform(post("/person").contentType(MediaType.APPLICATION_JSON).content(
				"{ \"firstName\":\"CreatedFirstName\", \"lastName\":\"CreatedLastName\", \"address\":\"1509 Culver St\", \"city\":\"Culver\", \"zip\":\"97451\", \"phone\":\"841-874-6512\", \"email\":\"jaboyd@email.com\" }"))
				.andExpect(status().isOk());
	}

	@Test
	public void updatePersonTest() throws Exception {
		Optional<Person> p = Optional.of(new Person(null, "CreatedFirstName", "CreatedLastName", "1509 Culver St",
				"Culver", "97451", "841-874-6512", "jaboyd@email.com"));
		when(personService.getPerson("CreatedFirstName", "CreatedLastName")).thenReturn(p);
		mockMvc.perform(put("/person/CreatedFirstName CreatedLastName").contentType(MediaType.APPLICATION_JSON).content(
				"{ \"address\":\"UpdatedAddress\", \"city\":\"Culver\", \"zip\":\"97451\", \"phone\":\"841-874-6512\", \"email\":\"jaboyd@email.com\" }"))
				.andExpect(status().isOk());
	}

	@Test
	public void deletePersonTest() throws Exception {
		Optional<Person> p = Optional.of(new Person(null, "CreatedFirstName", "CreatedLastName", "1509 Culver St",
				"Culver", "97451", "841-874-6512", "jaboyd@email.com"));
		when(personService.getPerson("CreatedFirstName", "CreatedLastName")).thenReturn(p);
		mockMvc.perform(delete("/person/CreatedFirstName CreatedLastName")).andExpect(status().isOk());
	}

}
