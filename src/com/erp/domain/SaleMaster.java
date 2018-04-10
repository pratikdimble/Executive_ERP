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
@Table(name="ERP_SALE")
public class SaleMaster {
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

	public SaleMaster() {
		System.out.println("SaleMaster:0-param constructor");
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
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}
	
	@ManyToOne(targetEntity=CustomerMaster.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="custid",referencedColumnName="custId")
	public CustomerMaster getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerMaster customer) {
		this.customer = customer;
	}
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
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
	public String getCustReq() {
		return custReq;
	}
	public void setCustReq(String custReq) {
		this.custReq = custReq;
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
	@Column(length=20,nullable=true)
	@Type(type="string")
	public String getSerName() {
		return serName;
	}
	public void setSerName(String serName) {
		this.serName = serName;
	}
	@Column(length=20,nullable=true)
	@Type(type="string")
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}

	@Column(length=20,nullable=false)
	@Type(type="float")
	public float getSerCost() {
		return serCost;
	}
	public void setSerCost(float serCost) {
		this.serCost = serCost;
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
