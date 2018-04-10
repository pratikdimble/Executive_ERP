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
@Table(name="ERP_DESIGNATION")
public class DesignationMaster {
	private int dsgnId;
	private String dsgnName;

	
	public DesignationMaster() {
		System.out.println("DesignationMaster:0-param constructor");
	}
	 @Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")
		public int getDsgnId() {
			return dsgnId;
		}
		public void setDsgnId(int dsgnId) {
			this.dsgnId = dsgnId;
		}
		
	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getDsgnName() {
		return dsgnName;
	}
	public void setDsgnName(String dsgnName) {
		this.dsgnName = dsgnName;
	}
}
