package com.cg.dcms.entity;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="dc_table")
public class DiagnosticCenterEntity {

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

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_Id")
    private Long centerId;
	
	@Column(name="c_Name",nullable=false)
	private String centerName;
	
	@Column(name="c_Address",nullable=false)
	private String address;
	
    @Column(name="c_Info",nullable=false)
	private String contactInfo;
	
	
}
