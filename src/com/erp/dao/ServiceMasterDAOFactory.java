package com.erp.dao;

public class ServiceMasterDAOFactory {
	
	public static  ServiceMasterDAO getInstance(){
		return new ServiceMasterDAOImpl();
	}

}
