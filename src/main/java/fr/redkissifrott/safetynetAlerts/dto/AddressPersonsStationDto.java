package fr.redkissifrott.safetynetAlerts.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AddressPersonsStationDto {
	private List<PersonForAddressPersonsStationDto> personForAdress;

	private String station;
}
