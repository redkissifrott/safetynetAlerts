package fr.redkissifrott.safetynetAlerts.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ChildDto {

	private String firstName;

	private String lastName;

	private int age;

}
