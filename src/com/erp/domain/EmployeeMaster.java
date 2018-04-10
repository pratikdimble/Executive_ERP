package com.erp.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="ERP_EMPLOYEE")
public class EmployeeMaster {
	private int empId;
	private String empName;
	private String empAddr;
	private String empCity;
	private int pin;
	private String designation;
	private String department;
	private String qualification;
	private String workExp;
	private String doj;
	private long mobile;
	private String empMail;
	private String userName;
	
	public EmployeeMaster() {
		System.out.println("EmployeeMaster:0-param constructor");
	}

	 @Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@Column(length=70,nullable=false)
	@Type(type="string")
	public String getEmpAddr() {
		return empAddr;
	}
	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}
	@Column(length=15,nullable=false)
	@Type(type="string")
	public String getEmpCity() {
		return empCity;
	}
	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}
	@Column(length=6,nullable=false)
	@Type(type="int")

	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Column(length=10,nullable=false)
	@Type(type="string")
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	@Column(length=10,nullable=false)
	@Type(type="string")
		public String getWorkExp() {
		return workExp;
	}
	public void setWorkExp(String workExp) {
		this.workExp = workExp;
	}
	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	@Column(length=10,nullable=false)
	@Type(type="long")
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getEmpMail() {
		return empMail;
	}
	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getUserName() {
		return userName;
	}public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(length=50,nullable=false)
	@Type(type="string")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
}
