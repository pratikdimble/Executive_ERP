package com.erp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="ERP_PRODUCT")
/*,uniqueConstraints=
{@UniqueConstraint(columnNames={"NAME"}),
	@UniqueConstraint(columnNames={"COMPANY"})})*/
public class ProductMaster {
	private int prodid;
	private String name;
	private String type;

	public ProductMaster() {
		System.out.println("ProductMaster:0-param constructor");
	}
	@Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")
	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	@Column(length=20,nullable=false,unique=true)
	@Type(type="string")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
