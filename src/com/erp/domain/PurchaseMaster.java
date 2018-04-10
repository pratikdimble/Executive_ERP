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
@Table(name="ERP_PURCHASE")
public class PurchaseMaster {
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
	
	//private CustomerMaster customer;
	public PurchaseMaster() {
		System.out.println("PurchaseMaster:0-param constructor");
	}
	 @Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")
	 public int getEnqId() {
			return enqId;
		}
		public void setEnqId(int enqId) {
			this.enqId = enqId;
		}
	

	
	/*@ManyToOne(targetEntity=CustomerMaster.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="custid",referencedColumnName="custId")
	public CustomerMaster getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerMaster customer) {
		this.customer = customer;
	}*/

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
		
		@Column(length=30,nullable=false)
		@Type(type="int")
		public int getSuppId() {
			return suppId;
		}
		public void setSuppId(int suppId) {
			this.suppId = suppId;
		}
		
		@Column(length=30,nullable=false)
		@Type(type="string")
		public String getSuppName() {
			return suppName;
		}
		public void setSuppName(String suppName) {
			this.suppName = suppName;
		}
		
		@Column(length=30,nullable=false)
		@Type(type="int")
		public int getProdId() {
			return prodId;
		}
		public void setProdId(int prodId) {
			this.prodId = prodId;
		}

	

/*	@ManyToOne(targetEntity=EmployeeMaster.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="empId",referencedColumnName="empId")
	public EmployeeMaster getEmp() {
		return emp;
	}
	public void setEmp(EmployeeMaster emp) {
		this.emp = emp;
	}*/
	
	
}
