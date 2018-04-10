package com.erp.dao;

public class AreaMasterDAOFactory {
	
	public static  AreaMasterDAO getInstance(){
		return new AreaMasterDAOImpl();
	}

}
