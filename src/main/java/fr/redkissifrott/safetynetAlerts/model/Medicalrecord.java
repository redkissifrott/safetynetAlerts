
package fr.redkissifrott.safetynetAlerts.model;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import fr.redkissifrott.safetynetAlerts.util.DateFromString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
@Entity
@Table(name = "medicalrecords")
public class Medicalrecord {

//	@Autowired
//	CalculateAge calculateAge;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "First name must not be empty")
	private String firstName;

	@NotEmpty(message = "Last name must not be empty")
	private String lastName;

//	@NotEmpty(message = "Birthdate name must not be empty")
	@JsonDeserialize(using = DateFromString.class)
	private LocalDate birthdate;

	@Transient
	@Setter(AccessLevel.NONE)
	private int age;

	public int getAge() {
		return age;
	}

	@PostLoad
	private void onLoad() {
		age = Period.between(birthdate, LocalDate.now()).getYears();
	}

	private String[] medications;

	private String[] allergies;

	public Medicalrecord() {

	}

}
