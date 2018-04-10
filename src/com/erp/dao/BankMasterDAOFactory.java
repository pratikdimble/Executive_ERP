package com.erp.dao;

public class BankMasterDAOFactory {
	
	public static  BankMasterDAO getInstance(){
		return new BankMasterDAOImpl();
	}

}
