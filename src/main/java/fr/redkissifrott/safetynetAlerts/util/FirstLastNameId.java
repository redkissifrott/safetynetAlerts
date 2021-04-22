package fr.redkissifrott.safetynetAlerts.util;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FirstLastNameId implements Serializable {

	private String firstName;
	private String lastName;

	public FirstLastNameId(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
