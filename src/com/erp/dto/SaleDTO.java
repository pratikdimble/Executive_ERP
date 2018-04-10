package com.erp.dto;

import com.erp.domain.CustomerMaster;

public class SaleDTO {
private int id;
	
	private String empName;
	private String design;
	
	private CustomerMaster customer;
	private String custName;
	private String addr;
	private long contact;
	private String custReq;
	
	private String prodName;
	private String prodType;
	private String company;
	private int quantity;
	private float prodCost;
	
	private String serName;
	private String provider;
	private float serCost;

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

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}
	
	public CustomerMaster getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerMaster customer) {
		this.customer = customer;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
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

	public String getSerName() {
		return serName;
	}

	public void setSerName(String serName) {
		this.serName = serName;
	}

	public String getCustReq() {
		return custReq;
	}

	public void setCustReq(String custReq) {
		this.custReq = custReq;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public float getProdCost() {
		return prodCost;
	}

	public void setProdCost(float prodCost) {
		this.prodCost = prodCost;
	}

	public float getSerCost() {
		return serCost;
	}

	public void setSerCost(float serCost) {
		this.serCost = serCost;
	}
	
	
}
