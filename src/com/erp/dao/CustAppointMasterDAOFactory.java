package com.erp.dao;

public class CustAppointMasterDAOFactory {
	
	public static  CustAppointMasterDAO getInstance(){
		return new CustAppointMasterDAOImpl();
	}

}
