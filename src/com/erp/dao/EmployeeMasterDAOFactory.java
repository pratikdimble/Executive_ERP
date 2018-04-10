package com.erp.dao;

public class EmployeeMasterDAOFactory {
	
	public static  EmployeeMasterDAO getInstance(){
		return new EmployeeMasterDAOImpl();
	}

}
