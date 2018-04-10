package com.erp.dto;



public class DesignationDTO {
	private int dsgnId;
	private String dsgnName;

	
	public DesignationDTO() {
		System.out.println("DesignationDTO:0-param constructor");
	}


	public int getDsgnId() {
		return dsgnId;
	}


	public void setDsgnId(int dsgnId) {
		this.dsgnId = dsgnId;
	}


	public String getDsgnName() {
		return dsgnName;
	}


	public void setDsgnName(String dsgnName) {
		this.dsgnName = dsgnName;
	}


}