package com.erp.dao;

import java.util.List;

import com.erp.domain.CustAppointMaster;



public interface CustAppointMasterDAO {
	public List<CustAppointMaster> loadAllCustAppoints();
	public  int addCustAppoint(CustAppointMaster appoint);
	public List<CustAppointMaster> getCustAppoint(String name);
	public int  deleteCustAppoint(String name);
}
