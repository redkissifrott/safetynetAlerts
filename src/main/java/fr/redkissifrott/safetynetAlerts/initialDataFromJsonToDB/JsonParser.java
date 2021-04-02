package fr.redkissifrott.safetynetAlerts.initialDataFromJsonToDB;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonParser {

	public AllData readJsonWithObjectMapper() throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		AllData allData = objectMapper.readValue(new File("src/main/resources/data.json"), AllData.class);
		return allData;
	}

}
