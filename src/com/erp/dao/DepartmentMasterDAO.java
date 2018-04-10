package com.erp.dao;

import java.util.List;

import com.erp.domain.DepartmentMaster;

public interface DepartmentMasterDAO {
	public List<DepartmentMaster> loadAllDepartments();
	public  int addDepartment(DepartmentMaster dept);
	
}
