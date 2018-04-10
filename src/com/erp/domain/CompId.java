package com.erp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Embeddable
public class CompId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String name;
	private String company;
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "CompId [name=" + name + ", company=" + company + "]";
	}
	
}