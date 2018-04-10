package com.erp.dao;

public class AttendanceMasterDAOFactory {
	
	public static  AttendanceMasterDAO getInstance(){
		return new AttendanceMasterDAOImpl();
	}

}
