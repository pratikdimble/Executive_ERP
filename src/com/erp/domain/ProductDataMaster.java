package com.erp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="ERP_PRODUCTDATA")

public class ProductDataMaster {

	private int pid;
	private String name;
	private String type;
	private String company;
	private float cost;
	private int quantity;
	private float warranty;
	private ProductMaster product;
	
	public ProductDataMaster() {
		System.out.println("ProductDataMaster:0-param constructor");
	}


	@Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Column(length=10,nullable=false)
	@Type(type="float")
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	@Column(length=10,nullable=false)
	@Type(type="int")
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Column(length=10,nullable=false)
	@Type(type="float")
	public float getWarranty() {
		return warranty;
	}
	public void setWarranty(float warranty) {
		this.warranty = warranty;
	}
	@ManyToOne(targetEntity=ProductMaster.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="unid",referencedColumnName="prodid")
	public ProductMaster getProduct() {
		return product;
	}
	public void setProduct(ProductMaster product) {
		this.product = product;
	}

}
