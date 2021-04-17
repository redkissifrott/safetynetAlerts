package fr.redkissifrott.safetynetAlerts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "persons")
public class Person {

	public Person() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "First name must not be empty")
	private String firstName;

	@NotEmpty(message = "Last name must not be empty")
	private String lastName;

	@NotEmpty(message = "Adress must not be empty")
	private String address;

	@NotEmpty(message = "City name must not be empty")
	private String city;

	@NotEmpty(message = "Zip name must not be empty")
	private String zip;

	@NotEmpty(message = "Phone name must not be empty")
	private String phone;

	@NotEmpty(message = "Email must not be empty")
	@Email(message = "Email must be a valid email address")
	private String email;

}
