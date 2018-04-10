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
@Table(name="ERP_ATTENDANCE")
public class AttendanceMaster {
	private int attendId;
	private int empId;
	private String attendDate;
	private String empName;
	private String entryStatus;
	private String inTime;
	private String outTime;
	
	public AttendanceMaster() {
		System.out.println("AttendanceMaster:0-param constructor");
	}
	@Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")

	public int getAttendId() {
		return attendId;
	}

	public void setAttendId(int attendId) {
		this.attendId = attendId;
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
	public String getAttendDate() {
		return attendDate;
	}
	public void setAttendDate(String attendDate) {
		this.attendDate = attendDate;
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
	public String getEntryStatus() {
		return entryStatus;
	}
	public void setEntryStatus(String entryStatus) {
		this.entryStatus = entryStatus;
	}

	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
}
