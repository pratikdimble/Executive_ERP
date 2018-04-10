package com.erp.dao;

import java.util.List;

import com.erp.domain.IncentiveMaster;


public interface IncentiveMasterDAO {
	public List<IncentiveMaster> loadAllIncentives();
	public List<IncentiveMaster> getIncentive(String empName);
	public  int addIncentive(int empId,IncentiveMaster incentive);
	//public  int updateIncentive(int pid,String name,String type,String company,float cost,int quantity,float warranty);
	public int  deleteIncentive(int id);
}
