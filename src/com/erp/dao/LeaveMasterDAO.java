package com.erp.dao;

import java.util.List;

import com.erp.domain.LeaveMaster;

public interface LeaveMasterDAO {
	public List<LeaveMaster> loadAllLeave();
	public List<LeaveMaster> loadApprovedLeave();
	public List<LeaveMaster> loadUserLeave(int empId);
	public  int addLeave(LeaveMaster leave);
	public int  deleteLeave(int id);
	public int updateStatus(int id,String Status);
	
}
