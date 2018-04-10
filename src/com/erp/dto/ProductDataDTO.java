package com.erp.dto;

import com.erp.domain.ProductMaster;

public class ProductDataDTO {
	private int pid;
	private String name;
	private String type;
	private String company;
	private float cost;
	private int quantity;
	private float warranty;
	private ProductMaster product;
	public ProductDataDTO() {
		System.out.println("ProductDataDTO:0-param constructor");
	}

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getWarranty() {
		return warranty;
	}
	public void setWarranty(float warranty) {
		this.warranty = warranty;
	}

	public ProductMaster getProduct() {
		return product;
	}

	public void setProduct(ProductMaster product) {
		this.product = product;
	}
	

}
