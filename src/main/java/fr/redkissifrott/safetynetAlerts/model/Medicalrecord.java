
package fr.redkissifrott.safetynetAlerts.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import fr.redkissifrott.safetynetAlerts.util.DateFromString;
import lombok.Data;

@Data

@Entity

@Table(name = "medicalrecords")
public class Medicalrecord {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String firstName;

	private String lastName;

	@JsonDeserialize(using = DateFromString.class)
	private Date birthdate;

	private String[] medications;

	private String[] allergies;

}
