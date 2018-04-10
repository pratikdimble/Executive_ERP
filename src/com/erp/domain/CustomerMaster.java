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
@Table(name="ERP_CUSTOMER")
public class CustomerMaster {
	private int custId;
	private String custName;
	private String shopName;
	private String shopAddr;
	private int pin;
	private String delivery;
	private long mobile;
	private String shopMail;
	private String contactPerson;
	private long personMobile;


	
	
	public CustomerMaster() {
		System.out.println("CustomerMaster:0-param constructor");
	}

	 @Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")
	 public int getCustId() {
			return custId;
		}

		public void setCustId(int custId) {
			this.custId = custId;
		}
	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}
	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	@Column(length=70,nullable=false)
	@Type(type="string")
	public String getShopAddr() {
		return shopAddr;
	}

	public void setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
	}
	
	@Column(length=6,nullable=false)
	@Type(type="int")

	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	@Column(length=10,nullable=false)
	@Type(type="long")
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getShopMail() {
		return shopMail;
	}

	public void setShopMail(String shopMail) {
		this.shopMail = shopMail;
	}
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	@Column(length=10,nullable=false)
	@Type(type="long")
	public long getPersonMobile() {
		return personMobile;
	}

	public void setPersonMobile(long personMobile) {
		this.personMobile = personMobile;
	}

	
	
}
