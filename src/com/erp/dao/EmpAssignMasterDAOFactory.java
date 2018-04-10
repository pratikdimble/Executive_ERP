package com.erp.dao;

public class EmpAssignMasterDAOFactory {
	
	public static  EmpAssignMasterDAO getInstance(){
		return new EmpAssignMasterDAOImpl();
	}

}
