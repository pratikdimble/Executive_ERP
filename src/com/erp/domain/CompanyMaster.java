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
@Table(name="ERP_COMPANY")
public class CompanyMaster {
	private int compId;
	private String compName;
	private String compAddr;
	private long contact;
	private String compMail;
	private String compWeb;
	private int compYear;
	
	public CompanyMaster() {
		System.out.println("CompanyMaster:0-param constructor");
	}
	 @Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")
	public int getCompId() {
		return compId;
	}
	public void setCompId(int compId) {
		this.compId = compId;
	}
	
	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	
	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getCompAddr() {
		return compAddr;
	}
	public void setCompAddr(String compAddr) {
		this.compAddr = compAddr;
	}
	
	@Column(length=10,nullable=false)
	@Type(type="long")
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	
	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getCompMail() {
		return compMail;
	}


	public void setCompMail(String compMail) {
		this.compMail = compMail;
	}
	
	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getCompWeb() {
		return compWeb;
	}

	public void setCompWeb(String compWeb) {
		this.compWeb = compWeb;
	}
	
	@Column(length=10,nullable=false)
	@Type(type="int")
	public int getCompYear() {
		return compYear;
	}
	public void setCompYear(int compYear) {
		this.compYear = compYear;
	}
}
