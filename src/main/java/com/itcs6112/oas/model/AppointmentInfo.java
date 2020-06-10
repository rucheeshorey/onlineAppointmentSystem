package com.itcs6112.oas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "appointment_info")
public class AppointmentInfo{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Override
	public String toString() {
		return "AppointmentInfo [id=" + id + ", patientId=" + patientId + ", doctorId=" + doctorId + ", notes=" + notes
				+ ", reasonForVisit=" + reasonForVisit + ", date_start=" + date_start + ", date_end=" + date_end
				+ ", cancelled=" + cancelled + "]";
	}
	@Column(name = "patient_id")
	@NotEmpty
	private Integer patientId;
	
	@Column(name = "doctor_id")
	@NotEmpty	
	private Integer doctorId;
	
	@Column(name = "appt_notes")
	@NotEmpty	
	private String notes;
	
	@Column(name = "reason_for_visit")
	@NotEmpty	
	private String reasonForVisit;
	
	@Column(name = "date_start")
	@NotEmpty	
	@DateTimeFormat
	private Date date_start;
	
	@Column(name = "date_end")
	@NotEmpty	
	@DateTimeFormat
	private Date date_end;
	
	@Column(name = "cancelled")
	@NotEmpty	
	private Boolean cancelled;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getReasonForVisit() {
		return reasonForVisit;
	}

	public void setReasonForVisit(String reasonForVisit) {
		this.reasonForVisit = reasonForVisit;
	}

	public Date getDate_start() {
		return date_start;
	}

	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}

	public Date getDate_end() {
		return date_end;
	}

	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}

	public Boolean getCancelled() {
		return cancelled;
	}

	public void setCancelled(Boolean cancelled) {
		this.cancelled = cancelled;
	}
	


}