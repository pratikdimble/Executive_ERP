package com.erp.dao;

import java.util.List;

import com.erp.domain.AreaMaster;
import com.erp.domain.RequirementMaster;

public interface RequirementMasterDAO {
	public List<RequirementMaster> loadAllRequirements();
	public  int addRequirement(int empid,int custid,RequirementMaster enquiry);
	public int updateStatusDeliver(int id,String Status);
	public int updateStatusCancel(int id,String Status,int quantity,String prodName,String prodType,String company,int stock);
	public List<RequirementMaster> loadPendingRequirements(String empName);
	public void deliverStock(int quantity,String prodName,String prodType,String company,int stock);
}
