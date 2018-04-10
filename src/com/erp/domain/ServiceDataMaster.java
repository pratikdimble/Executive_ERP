package com.erp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="ERP_SERVICEDATA")
public class ServiceDataMaster {
	private int serid;
	private String name;
	private String provider;
	private float serviceCost;
	private ServiceMaster servicemaster;
	
	public ServiceDataMaster() {
		System.out.println("ServiceMaster:0-param constructor");
	}
	 @Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")
		public int getSerid() {
			return serid;
		}
		public void setSerid(int serid) {
			this.serid = serid;
		}
	
	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="float")
	public float getServiceCost() {
		return serviceCost;
	}
	public void setServiceCost(float serviceCost) {
		this.serviceCost = serviceCost;
	}
	@ManyToOne(targetEntity=ServiceMaster.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="unid",referencedColumnName="sid")
	public ServiceMaster getServicemaster() {
		return servicemaster;
	}
	public void setServicemaster(ServiceMaster servicemaster) {
		this.servicemaster = servicemaster;
	}




}
