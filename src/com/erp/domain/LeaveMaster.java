package com.erp.domain;

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
@Table(name="ERP_Leave")
public class LeaveMaster {
	private int leaveId;
	private int empId;
	private String empName;
	private String designation;
	
	private String leaveType;
	private String dateFrom;
	private String dateTo;
	private int days;
	private String status;
	
	public LeaveMaster() {
		System.out.println("LeaveMaster:0-param constructor");
	}
	@Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	
	@Column(length=10,nullable=false)
	@Type(type="int")
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
		
	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	
	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	
	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}	
	
	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	
	@Column(length=10,nullable=false)
	@Type(type="int")
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	
	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
