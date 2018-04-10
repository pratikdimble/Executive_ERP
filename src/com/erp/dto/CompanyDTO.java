package com.erp.dto;



public class CompanyDTO {
	private int compId;
	private String compName;
	private String compAddr;
	private long contact;
	private String compMail;
	private String compWeb;
	private int compYear;
	

	public int getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompAddr() {
		return compAddr;
	}

	public void setCompAddr(String compAddr) {
		this.compAddr = compAddr;
	}

	public String getCompMail() {
		return compMail;
	}

	public void setCompMail(String compMail) {
		this.compMail = compMail;
	}

	public String getCompWeb() {
		return compWeb;
	}

	public void setCompWeb(String compWeb) {
		this.compWeb = compWeb;
	}

	public int getCompYear() {
		return compYear;
	}

	public void setCompYear(int compYear) {
		this.compYear = compYear;
	}

	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}


}
