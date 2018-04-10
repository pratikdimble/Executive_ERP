package com.erp.dao;

public class SaleMasterDAOFactory {
	
	public static  SaleMasterDAO getInstance(){
		return new SaleMasterDAOImpl();
	}

}
