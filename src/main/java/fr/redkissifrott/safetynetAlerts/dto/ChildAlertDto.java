package fr.redkissifrott.safetynetAlerts.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Component
public class ChildAlertDto {

	private List<ChildDto> children;

	private List<ChildHouseholdDto> childrenHousehold;

}
