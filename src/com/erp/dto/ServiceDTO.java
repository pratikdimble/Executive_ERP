package com.erp.dto;



public class ServiceDTO {
	private int sid;
	private String name;
	private String provider;
	private float serviceCost;
	
	 public int getSid() {
			return sid;
		}
		public void setSid(int sid) {
			this.sid = sid;
		}
	
	public String getName() {
		return name;
	}
	
	public String getProvider() {
		return provider;
	}
	
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getServiceCost() {
		return serviceCost;
	}
	public void setServiceCost(float serviceCost) {
		this.serviceCost = serviceCost;
	}
	

}
