package com.erp.dao;

public class DesignationMasterDAOFactory {
	
	public static  DesignationMasterDAO getInstance(){
		return new DesignationMasterDAOImpl();
	}

}
