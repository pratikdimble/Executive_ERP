package com.erp.dto;

import com.erp.domain.CustomerMaster;

public class PurchaseQuotationDTO {
	private int id;

	private String empName;
	
	private int suppId;
	private String suppName;
	private String addr;
	private long contact;
	
	private String prodName;
	private String prodType;
	private String company;
	private int quantity;
	private float prodCost;
	
	private float prodAmount;
	private float prodTax;
	private float prodGross;
	private float prodDiscount;
	private float prodGrand;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
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
	public float getProdAmount() {
		return prodAmount;
	}
	public void setProdAmount(float prodAmount) {
		this.prodAmount = prodAmount;
	}
	public float getProdTax() {
		return prodTax;
	}
	public void setProdTax(float prodTax) {
		this.prodTax = prodTax;
	}
	public float getProdGross() {
		return prodGross;
	}
	public void setProdGross(float prodGross) {
		this.prodGross = prodGross;
	}
	public float getProdDiscount() {
		return prodDiscount;
	}
	public void setProdDiscount(float prodDiscount) {
		this.prodDiscount = prodDiscount;
	}
	public float getProdGrand() {
		return prodGrand;
	}
	public void setProdGrand(float prodGrand) {
		this.prodGrand = prodGrand;
	}
	
	
	
	
	
}
