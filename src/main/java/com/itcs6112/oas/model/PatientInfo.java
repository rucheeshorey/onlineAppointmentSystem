package com.itcs6112.oas.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "patient_info")
public class PatientInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "patient_dob")
	@NotEmpty
	private Date patientDOB;

	public Integer getId() {
		return id;
	}

	public Date getDOB() {
		return patientDOB;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDOB(Date date) {
		this.patientDOB = date;
	}

}