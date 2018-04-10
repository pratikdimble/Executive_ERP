package com.erp.dto;

import com.erp.domain.CustomerMaster;

public class PurchaseDTO {
private int enqId;
	
	private int suppId;
	
	private String suppName;
	private String addr;
	private long contact;
	
	private int prodId;
	private String prodName;
	private String prodType;
	private String company;
	private int quantity;
	private float prodCost;
	
	public int getEnqId() {
		return enqId;
	}
	public void setEnqId(int enqId) {
		this.enqId = enqId;
	}
	public int getSuppId() {
		return suppId;
	}
	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}
	public String getSuppName() {
		return suppName;
	}
	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getProdCost() {
		return prodCost;
	}
	public void setProdCost(float prodCost) {
		this.prodCost = prodCost;
	}
	
	
	
}
