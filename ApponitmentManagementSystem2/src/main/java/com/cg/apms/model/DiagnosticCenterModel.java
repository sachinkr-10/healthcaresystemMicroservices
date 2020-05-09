package com.cg.apms.model;

import java.util.List;

public class DiagnosticCenterModel {
private 	Long centerId;
	
	private String centerName;
	
	private String address;
	

	private String contactInfo;
	private List<TestDataModel> testList;
	public DiagnosticCenterModel() {
		
	}


	public DiagnosticCenterModel(Long centerId, String centerName, String address, String contactInfo,
			List<TestDataModel> testList) {
		super();
		this.centerId = centerId;
		this.centerName = centerName;
		this.address = address;
		this.contactInfo = contactInfo;
		this.testList = testList;
	}

	
	public List<TestDataModel> getTestList() {
		return testList;
	}

	public void setTestList(List<TestDataModel> testList) {
		this.testList = testList;
	}

	public Long getCenterId() {
		return centerId;
	}

	public void setCenterId(Long centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	
	

	
}
