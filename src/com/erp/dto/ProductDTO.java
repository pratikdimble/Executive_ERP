package com.erp.dto;


public class ProductDTO {
	private int prodid;
	private String name;
	private String type;


	public ProductDTO() {
		System.out.println("ProductMaster:0-param constructor");
	}

	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	

}
