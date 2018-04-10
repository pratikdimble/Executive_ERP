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
@Table(name="ERP_PAYMENTSLIP")
public class PaymentSlipMaster {
	private int slipId;
	private String salMonth;
	private int empId;
	private String empName;
	private String designation;
	private long mobile;
	
	private float basic;
	private float service;
	private float hra;
	private float income;
	private float da;
	private float incentive;
	private float transport;
	private float netpay;
	
	public PaymentSlipMaster() {
		System.out.println("PaymentSlipMaster:0-param constructor");
	}

	 @Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")
	 public int getSlipId() {
			return slipId;
		}

		public void setSlipId(int slipId) {
			this.slipId = slipId;
		}
	
		@Column(length=30,nullable=false)
		@Type(type="string")
		public String getSalMonth() {
			return salMonth;
		}

		public void setSalMonth(String salMonth) {
			this.salMonth = salMonth;
		}
		
		@Column(length=30,nullable=false)
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

	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Column(length=10,nullable=false)
	@Type(type="long")
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	@Column(length=10,nullable=false)
	@Type(type="float")
	public float getBasic() {
		return basic;
	}
	public void setBasic(float basic) {
		this.basic = basic;
	}

	@Column(length=10,nullable=false)
	@Type(type="float")
	public float getService() {
		return service;
	}
	public void setService(float service) {
		this.service = service;
	}

	@Column(length=10,nullable=false)
	@Type(type="float")
	public float getHra() {
		return hra;
	}
	public void setHra(float hra) {
		this.hra = hra;
	}
	
	@Column(length=10,nullable=false)
	@Type(type="float")
	public float getIncome() {
		return income;
	}
	public void setIncome(float income) {
		this.income = income;
	}

	@Column(length=10,nullable=false)
	@Type(type="float")
	public float getDa() {
		return da;
	}
	public void setDa(float da) {
		this.da = da;
	}

	@Column(length=10,nullable=false)
	@Type(type="float")	
	public float getIncentive() {
		return incentive;
	}
	public void setIncentive(float incentive) {
		this.incentive = incentive;
	}

	@Column(length=10,nullable=false)
	@Type(type="float")
	public float getTransport() {
		return transport;
	}
	public void setTransport(float transport) {
		this.transport = transport;
	}
	
	@Column(length=10,nullable=false)
	@Type(type="float")
	public float getNetpay() {
		return netpay;
	}
	public void setNetpay(float netpay) {
		this.netpay = netpay;
	}
}
