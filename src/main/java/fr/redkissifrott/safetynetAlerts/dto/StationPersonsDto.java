package fr.redkissifrott.safetynetAlerts.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class StationPersonsDto {

	private List<PersonByStationDto> listPersonsByStation;

	private int childs;

	private int adults;
}
