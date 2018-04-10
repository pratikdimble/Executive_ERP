package com.erp.dao;

public class BranchMasterDAOFactory {
	
	public static  BranchMasterDAO getInstance(){
		return new BranchMasterDAOImpl();
	}

}
