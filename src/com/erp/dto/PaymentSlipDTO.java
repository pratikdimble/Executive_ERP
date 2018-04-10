package com.erp.dto;



public class PaymentSlipDTO {
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
	
	public int getSlipId() {
		return slipId;
	}
	public void setSlipId(int slipId) {
		this.slipId = slipId;
	}
	public String getSalMonth() {
		return salMonth;
	}
	public void setSalMonth(String salMonth) {
		this.salMonth = salMonth;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public float getBasic() {
		return basic;
	}
	public void setBasic(float basic) {
		this.basic = basic;
	}
	public float getService() {
		return service;
	}
	public void setService(float service) {
		this.service = service;
	}
	public float getHra() {
		return hra;
	}
	public void setHra(float hra) {
		this.hra = hra;
	}
	public float getIncome() {
		return income;
	}
	public void setIncome(float income) {
		this.income = income;
	}
	public float getDa() {
		return da;
	}
	public void setDa(float da) {
		this.da = da;
	}
	public float getIncentive() {
		return incentive;
	}
	public void setIncentive(float incentive) {
		this.incentive = incentive;
	}
	public float getTransport() {
		return transport;
	}
	public void setTransport(float transport) {
		this.transport = transport;
	}
	public float getNetpay() {
		return netpay;
	}
	public void setNetpay(float netpay) {
		this.netpay = netpay;
	}
	
	
}