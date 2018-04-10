package com.erp.dao;

public class IncentiveMasterDAOFactory {
	
	public static  IncentiveMasterDAO getInstance(){
		return new IncentiveMasterDAOImpl();
	}

}
