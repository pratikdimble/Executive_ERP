package com.erp.dao;

public class ProductMasterDAOFactory {
	
	public static  ProductMasterDAO getInstance(){
		return new ProductMasterDAOImpl();
	}

}
