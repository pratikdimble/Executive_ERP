package com.erp.dao;

public class DepartmentMasterDAOFactory {
	
	public static  DepartmentMasterDAO getInstance(){
		return new DepartmentMasterDAOImpl();
	}

}
