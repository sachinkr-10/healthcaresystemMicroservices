package com.cg.dcms.model;

import java.util.List;

public class DiagnosticCenterModel {
	
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
	
    private Long centerId;
	
	
	private String centerName;
	

	private String address;
	
    
	private String contactInfo;
	  
	private List<TestDataModel> testList;

	public List<TestDataModel> getTestList() {
		return testList;
	}

	public void setTestList(List<TestDataModel> testList) {
		this.testList = testList;
	}


}
