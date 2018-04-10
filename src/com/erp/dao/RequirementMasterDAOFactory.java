package com.erp.dao;

public class RequirementMasterDAOFactory {
	
	public static  RequirementMasterDAO getInstance(){
		return new RequirementMasterDAOImpl();
	}

}
