package com.erp.dto;

public class IncentiveDTO {
	private int incId;
	private String empName;
	private String incDate;
	private String prodName;
	private String prodType;
	private String serName;
	private String provider;
	private int target;
	private int achieved;
	private int workdone;
	private float incentive;
	private float amount;
	
	public int getIncId() {
		return incId;
	}
	public void setIncId(int incId) {
		this.incId = incId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getIncDate() {
		return incDate;
	}
	public void setIncDate(String incDate) {
		this.incDate = incDate;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public int getAchieved() {
		return achieved;
	}
	public void setAchieved(int achieved) {
		this.achieved = achieved;
	}
	public int getWorkdone() {
		return workdone;
	}
	public void setWorkdone(int workdone) {
		this.workdone = workdone;
	}
	public float getIncentive() {
		return incentive;
	}
	public void setIncentive(float incentive) {
		this.incentive = incentive;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getSerName() {
		return serName;
	}
	public void setSerName(String serName) {
		this.serName = serName;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
}
