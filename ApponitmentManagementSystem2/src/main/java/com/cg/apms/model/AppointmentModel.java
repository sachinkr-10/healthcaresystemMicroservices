package com.cg.apms.model;



//import java.util.List;


public class AppointmentModel {
//public List<DiagnosticCenterModel> getCenterList() {
//		return CenterList;
//	}
//
//	public void setCenterList(List<DiagnosticCenterModel> CenterList) {
//		this.CenterList = CenterList;
//	}

	public String getDate() {
		return date;
	}

    private Long patientid;
	
	
	
	private String  date;
	
	public void setDate(String date) {
		this.date = date;
	}

	private String centername;
	
	private String testName;

//	 private List<DiagnosticCenterModel> CenterList;
//	private List<TesetDataModel> testList;
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



	
	

}
