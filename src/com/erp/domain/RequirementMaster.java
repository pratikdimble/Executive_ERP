package com.erp.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="ERP_REQUIREMENT")
public class RequirementMaster {
	private int reqId;
	private String empName;
	private String dsgn;
	private String custName;
	
	private String prodName;
	private String prodType;
	private String prodCompany;
	private int quantity;
	
	private String status;
	
	private  EmployeeMaster empMaster;
	private  CustomerMaster custMaster;
//	private Set<EmployeeMaster> empMaster;
//	private  Set<CustomerMaster> custMaster;
	
	public RequirementMaster() {
		System.out.println("RequirementMaster:0-param constructor");
	}

	@Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getDsgn() {
		return dsgn;
	}
	public void setDsgn(String dsgn) {
		this.dsgn = dsgn;
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
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getProdCompany() {
		return prodCompany;
	}
	public void setProdCompany(String prodCompany) {
		this.prodCompany = prodCompany;
	}

	@Column(length=10,nullable=false)
	@Type(type="int")
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(length=30,nullable=false)
	@Type(type="string")	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne(targetEntity=EmployeeMaster.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="employeeid",referencedColumnName="empId")
	public EmployeeMaster getEmpMaster() {
		return empMaster;
	}

	public void setEmpMaster(EmployeeMaster empMaster) {
		this.empMaster = empMaster;
	}

	@ManyToOne(targetEntity=CustomerMaster.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="customerid",referencedColumnName="custId")

	public CustomerMaster getCustMaster() {
		return custMaster;
	}

	public void setCustMaster(CustomerMaster custMaster) {
		this.custMaster = custMaster;
	}
	
	
}
