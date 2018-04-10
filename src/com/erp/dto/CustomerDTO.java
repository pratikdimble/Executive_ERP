package com.erp.dto;



public class CustomerDTO {
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
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopAddr() {
		return shopAddr;
	}
	public void setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getShopMail() {
		return shopMail;
	}
	public void setShopMail(String shopMail) {
		this.shopMail = shopMail;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public long getPersonMobile() {
		return personMobile;
	}
	public void setPersonMobile(long personMobile) {
		this.personMobile = personMobile;
	}
	
	
}