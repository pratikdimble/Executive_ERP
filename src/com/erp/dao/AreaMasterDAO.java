package com.erp.dao;

import java.util.List;

import com.erp.domain.AreaMaster;

public interface AreaMasterDAO {
	public List<AreaMaster> loadAllArea();
	public  int addArea(AreaMaster area);
	public int  deleteArea(int id);
	
}
