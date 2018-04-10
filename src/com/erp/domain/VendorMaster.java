package com.erp.domain;

import java.util.Date;

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
@Table(name="ERP_VENDOR")
public class VendorMaster {
	private int vendorId;
	private String vendorName;
	private String website;
	
	private String vendorCountry;
	private String vendorState;	
	private String vendorCity;
	private int pin;
	
	private String vendorAddr;
	private long mobile;
	private String vendorMail;
	
	private String business;
	
	public VendorMaster() {
		System.out.println("vendorMaster:0-param constructor");
	}

	 @Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")
	 public int getVendorId() {
			return vendorId;
		}
		public void setVendorId(int vendorId) {
			this.vendorId = vendorId;
		}

		@Column(length=30,nullable=false,unique=true)
		@Type(type="string")
		public String getVendorName() {
			return vendorName;
		}
		public void setVendorName(String vendorName) {
			this.vendorName = vendorName;
		}

		@Column(length=30,nullable=false,unique=true)
		@Type(type="string")
		public String getWebsite() {
			return website;
		}
		public void setWebsite(String website) {
			this.website = website;
		}

		@Column(length=30,nullable=false)
		@Type(type="string")
		public String getVendorCountry() {
			return vendorCountry;
		}
		public void setVendorCountry(String vendorCountry) {
			this.vendorCountry = vendorCountry;
		}

		@Column(length=30,nullable=false)
		@Type(type="string")
		public String getVendorState() {
			return vendorState;
		}
		public void setVendorState(String vendorState) {
			this.vendorState = vendorState;
		}

		@Column(length=30,nullable=false)
		@Type(type="string")
		public String getVendorCity() {
			return vendorCity;
		}
		public void setVendorCity(String vendorCity) {
			this.vendorCity = vendorCity;
		}
		
	@Column(length=6,nullable=false)
	@Type(type="int")

	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	@Column(length=70,nullable=false)
	@Type(type="string")
	public String getVendorAddr() {
		return vendorAddr;
	}
	public void setVendorAddr(String vendorAddr) {
		this.vendorAddr = vendorAddr;
	}
	
	@Column(length=10,nullable=false,unique=true)
	@Type(type="long")
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	@Column(length=30,nullable=false,unique=true)
	@Type(type="string")
	public String getVendorMail() {
		return vendorMail;
	}
	public void setVendorMail(String vendorMail) {
		this.vendorMail = vendorMail;
	}

	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	
	
}
