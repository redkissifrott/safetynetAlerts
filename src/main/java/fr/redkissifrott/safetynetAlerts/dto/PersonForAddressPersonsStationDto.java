package fr.redkissifrott.safetynetAlerts.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class PersonForAddressPersonsStationDto {

	private String firstName;

	private String lastName;

	private String phone;

	private Integer age;

	private String[] medications;

	private String[] allergies;

}
