package com.erp.dao;

public class CompanyMasterDAOFactory {
	
	public static  CompanyMasterDAO getInstance(){
		return new CompanyMasterDAOImpl();
	}

}
