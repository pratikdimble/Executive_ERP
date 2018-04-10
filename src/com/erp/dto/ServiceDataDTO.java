package com.erp.dto;

import com.erp.domain.ServiceMaster;

public class ServiceDataDTO {
	private int serid;
	private String name;
	private String provider;
	private float serviceCost;
	private ServiceMaster servicemaster;

	public int getSerid() {
		return serid;
	}
	public void setSerid(int serid) {
		this.serid = serid;
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

	public ServiceMaster getServicemaster() {
		return servicemaster;
	}
	public void setServicemaster(ServiceMaster servicemaster) {
		this.servicemaster = servicemaster;
	}
	

}
