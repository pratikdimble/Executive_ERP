package com.erp.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="ERP_REGION")
public class RegionMaster {
	private int regId;
	private String regName;
	private String regDesc;
	private Set<AreaMaster> areamaster;
	
	public RegionMaster() {
		System.out.println("RegionMaster:0-param constructor");
	}
	@Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")
	public int getRegId() {
		return regId;
	}
	public void setRegId(int regId) {
		this.regId = regId;
	}

	@Column(length=30,nullable=false,unique=true)
	@Type(type="string")
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}

	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getRegDesc() {
		return regDesc;
	}
	public void setRegDesc(String regDesc) {
		this.regDesc = regDesc;
	}
	@OneToMany(targetEntity=AreaMaster.class,cascade=CascadeType.ALL,
			fetch=FetchType.LAZY,orphanRemoval=true)
@JoinColumn(name="unid",referencedColumnName="regId")
	public Set<AreaMaster> getAreamaster() {
		return areamaster;
	}
	public void setAreamaster(Set<AreaMaster> areamaster) {
		this.areamaster = areamaster;
	}
	
	
}
