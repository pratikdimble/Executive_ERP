package com.erp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="ERP_CUSTAPPOINT")
public class CustAppointMaster {
	private int id;
	private String custName;
	private String appointTo;
	private String appointType;
	private String subject;
	private String appointDate;
	private String time;
	private String venue;
	private String contact;
	
	public CustAppointMaster() {
		System.out.println("CustAppointMaster:0-param constructor");
	}
	 @Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")
	 public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getAppointTo() {
		return appointTo;
	}
	public void setAppointTo(String appointTo) {
		this.appointTo = appointTo;
	}
	
	@Column(length=10,nullable=false)
	@Type(type="string")
	public String getAppointType() {
		return appointType;
	}
	public void setAppointType(String appointType) {
		this.appointType = appointType;
	}
	
	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getAppointDate() {
		return appointDate;
	}
	public void setAppointDate(String appointDate) {
		this.appointDate = appointDate;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
}
