package com.erp.dao;

public class VendorMasterDAOFactory {
	
	public static  VendorMasterDAO getInstance(){
		return new VendorMasterDAOImpl();
	}

}
