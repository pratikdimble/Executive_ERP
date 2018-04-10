package com.erp.dao;

import java.util.List;

import com.erp.domain.DesignationMaster;

public interface DesignationMasterDAO {
	public List<DesignationMaster> loadAllDesignations();
	public  int addDesignation(DesignationMaster dsgn);
	
}
