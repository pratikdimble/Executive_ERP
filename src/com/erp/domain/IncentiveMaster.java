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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="ERP_INCENTIVE")
public class IncentiveMaster {
	private int incId;
	private String incDate;
	private String empName;
	private String prodName;
	private String prodType;
	private String serName;
	private String provider;
	
	private int target;
	private int achieved;
	private int workdone;
	private float incentive;
	private float amount;

	private EmployeeMaster emp;
	
	public IncentiveMaster() {
		System.out.println("IncentiveMaster:0-param constructor");
	}
	 @Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")
	 public int getIncId() {
			return incId;
		}
		public void setIncId(int incId) {
			this.incId = incId;
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
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getSerName() {
		return serName;
	}
	public void setSerName(String serName) {
		this.serName = serName;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getIncDate() {
		return incDate;
	}
	public void setIncDate(String incDate) {
		this.incDate = incDate;
	}
	
	@Column(length=30,nullable=false)
	@Type(type="int")
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	
	@Column(length=30,nullable=false)
	@Type(type="int")
	public int getAchieved() {
		return achieved;
	}
	public void setAchieved(int achieved) {
		this.achieved = achieved;
	}
	
	@Column(length=30,nullable=false)
	@Type(type="int")
	public int getWorkdone() {
		return workdone;
	}
	public void setWorkdone(int workdone) {
		this.workdone = workdone;
	}
	
	@Column(length=30,nullable=false)
	@Type(type="float")
	public float getIncentive() {
		return incentive;
	}
	public void setIncentive(float incentive) {
		this.incentive = incentive;
	}
	
	@Column(length=30,nullable=false)
	@Type(type="float")
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
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
