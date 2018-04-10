package com.erp.dao;

public class PurchaseMasterDAOFactory {
	
	public static  PurchaseMasterDAO getInstance(){
		return new PurchaseMasterDAOImpl();
	}

}
