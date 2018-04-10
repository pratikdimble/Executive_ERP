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
@Table(name="ERP_EMPASSIGN")
public class EmpAssignMaster {
	private int id;
	private String empName;
	private String design;
	private String assignDate;
	private String statusType;
	private String prodName;
	private String prodType;
	private String serName;
	private String region;
	private String area;
	private EmployeeMaster emp;
	public EmpAssignMaster() {
		System.out.println("EmpAssignMaster:0-param constructor");
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
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getAssignDate() {
		return assignDate;
	}
	public void setAssignDate(String assignDate) {
		this.assignDate = assignDate;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getStatusType() {
		return statusType;
	}
	public void setStatusType(String statusType) {
		this.statusType = statusType;
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
	
	@Column(length=20,nullable=true)
	@Type(type="string")
	public String getSerName() {
		return serName;
	}
	public void setSerName(String serName) {
		this.serName = serName;
	}
	
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@ManyToOne(targetEntity=EmployeeMaster.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="empId",referencedColumnName="empId")
	public EmployeeMaster getEmp() {
		return emp;
	}
	public void setEmp(EmployeeMaster emp) {
		this.emp = emp;
	}
}
