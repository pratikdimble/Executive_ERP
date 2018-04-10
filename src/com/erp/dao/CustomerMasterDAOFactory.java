package com.erp.dao;

public class CustomerMasterDAOFactory {
	
	public static  CustomerMasterDAO getInstance(){
		return new CustomerMasterDAOImpl();
	}

}
