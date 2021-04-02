package fr.redkissifrott.safetynetAlerts.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class DateFromString extends StdDeserializer<LocalDate> {

//	public DateFromString() {
//		this(null);
//	}

	public DateFromString(Class<?> clazz) {
		super(clazz);
	}

	protected DateFromString() {
		super(LocalDate.class);
	}

	@Override
	public LocalDate deserialize(JsonParser jsonparser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		String date = jsonparser.getText();
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//		try {
		return LocalDate.parse(date, pattern);
//		} catch (Exception e) {
//			return null;
//		}
	}

}
