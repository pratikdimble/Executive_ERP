package com.erp.dao;

public class RegionMasterDAOFactory {
	
	public static  RegionMasterDAO getInstance(){
		return new RegionMasterDAOImpl();
	}

}
