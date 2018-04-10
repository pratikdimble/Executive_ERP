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
@Table(name="ERP_AREA")
public class AreaMaster {
	private int areaId;
	private String regName;
	private String areaName;
	private String description;

	
	public AreaMaster() {
		System.out.println("AreaMaster:0-param constructor");
	}
	@Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")
		public int getAreaId() {
			return areaId;
		}
		public void setAreaId(int areaId) {
			this.areaId = areaId;
		}
		
		@Column(length=30,nullable=false)
		@Type(type="string")
		public String getRegName() {
			return regName;
		}
		public void setRegName(String regName) {
			this.regName = regName;
		}
		 
		@Column(length=30,nullable=false)
		@Type(type="string")
		public String getAreaName() {
			return areaName;
		}
		public void setAreaName(String areaName) {
			this.areaName = areaName;
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
