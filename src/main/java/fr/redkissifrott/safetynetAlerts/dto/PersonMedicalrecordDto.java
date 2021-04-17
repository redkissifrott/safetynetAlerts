package fr.redkissifrott.safetynetAlerts.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class PersonMedicalrecordDto {

	private String firstName;

	private String lastName;

	private String address;

	private String city;

	private String zip;

	private LocalDate birthdate;

	private String phone;

	private String email;

	private String[] medications;

	private String[] allergies;

	private Integer age;

}
