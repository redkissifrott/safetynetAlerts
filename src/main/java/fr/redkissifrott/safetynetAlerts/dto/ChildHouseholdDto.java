package fr.redkissifrott.safetynetAlerts.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ChildHouseholdDto {

	private String firstName;

	private String lastName;

}
