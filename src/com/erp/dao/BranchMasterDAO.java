package com.erp.dao;

import java.util.List;

import com.erp.domain.BranchMaster;
import com.erp.domain.ServiceMaster;

public interface BranchMasterDAO {
	public List<BranchMaster> loadAllBranch();
	public  int addBranch(BranchMaster branch);
	public int  deleteBranch(String name);
	public List<BranchMaster> getBranch(String name);

}
