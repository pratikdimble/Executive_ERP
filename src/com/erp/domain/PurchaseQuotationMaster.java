package com.erp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="ERP_PURCHASEQUOTATION")
public class PurchaseQuotationMaster {
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
	

	public PurchaseQuotationMaster() {
		System.out.println("urchaseQuotation:0-param constructor");
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
	
	
	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

/*	
	@ManyToOne(targetEntity=CustomerMaster.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="custid",referencedColumnName="custId")
	public CustomerMaster getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerMaster customer) {
		this.customer = customer;
	}*/
	@Column(length=10,nullable=false)
	@Type(type="int")
	public int getSuppId() {
		return suppId;
	}
	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getSuppName() {
		return suppName;
	}
	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}
	@Column(length=10,nullable=true)
	@Type(type="long")
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Column(length=20,nullable=true)
	@Type(type="string")
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	@Column(length=20,nullable=true)
	@Type(type="string")
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Column(length=20,nullable=false)
	@Type(type="int")
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

@Column(length=20,nullable=false)
@Type(type="float")
	public float getProdCost() {
		return prodCost;
	}
	public void setProdCost(float prodCost) {
		this.prodCost = prodCost;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="float")
	public float getProdAmount() {
		return prodAmount;
	}
	public void setProdAmount(float prodAmount) {
		this.prodAmount = prodAmount;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="float")
	public float getProdTax() {
		return prodTax;
	}
	public void setProdTax(float prodTax) {
		this.prodTax = prodTax;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="float")
	public float getProdGross() {
		return prodGross;
	}
	public void setProdGross(float prodGross) {
		this.prodGross = prodGross;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="float")
	public float getProdDiscount() {
		return prodDiscount;
	}
	public void setProdDiscount(float prodDiscount) {
		this.prodDiscount = prodDiscount;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="float")
	public float getProdGrand() {
		return prodGrand;
	}
	public void setProdGrand(float prodGrand) {
		this.prodGrand = prodGrand;
	}
	

	
}
