package com.erp.dao;

import java.util.List;

import com.erp.domain.EmpAssignMaster;



public interface EmpAssignMasterDAO {
	public List<EmpAssignMaster> loadAllEmpAssigns();
	public  int addEmpProductAssign(EmpAssignMaster assign);
	public List<EmpAssignMaster> getEmpAssign(String name);
	public int  deleteEmpAssign(String name);
}
