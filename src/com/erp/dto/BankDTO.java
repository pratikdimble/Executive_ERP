package com.erp.dto;



public class BankDTO {
	private int bankId;
	private String bankName;

	
	public BankDTO() {
		System.out.println("BankDTO:0-param constructor");
	}


	public int getBankId() {
		return bankId;
	}


	public void setBankId(int bankId) {
		this.bankId = bankId;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	
}
}