package com.cg.apms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Appointment_Info")
public class AppointmentEntity {
	public Long getPatientid() {
		return patientid;
	}

	public void setPatientid(Long patientid) {
		this.patientid = patientid;
	}

	public String getCentername() {
		return centername;
	}

	public void setCentername(String centername) {
		this.centername = centername;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	@Id
	@Column(name="appointmentId")
	private Long patientid;
	
	@Column(name="appointment_Date")
//	@DateTimeFormat(iso=ISO.DATE)
	private String date;
	
	public void setDate(String date) {
		this.date = date;
	}

	@Column(name="center_name")
	private String centername;
	
	@Column(name="test_name")
	private String testName;

	public String getDate() {
		return date;
	}

}
