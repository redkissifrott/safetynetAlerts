
package fr.redkissifrott.safetynetAlerts.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import fr.redkissifrott.safetynetAlerts.util.DateFromString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medicalrecords")
public class Medicalrecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "First name must not be empty")
	private String firstName;

	@NotEmpty(message = "Last name must not be empty")
	private String lastName;

	@JsonDeserialize(using = DateFromString.class)
	private LocalDate birthdate;

	private String[] medications;

	private String[] allergies;

}
