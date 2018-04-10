package com.erp.dao;

public class LeaveMasterDAOFactory {
	
	public static  LeaveMasterDAO getInstance(){
		return new LeaveMasterDAOImpl();
	}

}
