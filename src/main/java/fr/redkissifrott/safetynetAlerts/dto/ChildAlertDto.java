package fr.redkissifrott.safetynetAlerts.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Component
@NoArgsConstructor
public class ChildAlertDto {

	private List<ChildDto> children;

	private List<ChildHouseholdDto> childrenHousehold;

}
