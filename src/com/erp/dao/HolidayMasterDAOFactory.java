package com.erp.dao;

public class HolidayMasterDAOFactory {
	
	public static  HolidayMasterDAO getInstance(){
		return new HolidayMasterDAOImpl();
	}

}
