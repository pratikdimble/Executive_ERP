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
@Table(name="ERP_BRANCH")
public class BranchMaster {
	private int branchId;
	private String bankName;
	private String branchName;
	private String description;

	
	public BranchMaster() {
		System.out.println("BranchMaster:0-param constructor");
	}
	 @Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")
	 public int getBranchId() {
			return branchId;
		}
		public void setBranchId(int branchId) {
			this.branchId = branchId;
		}
	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
		
}
