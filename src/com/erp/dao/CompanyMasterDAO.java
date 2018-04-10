package com.erp.dao;

import java.util.List;

import com.erp.domain.CompanyMaster;

public interface CompanyMasterDAO {
	public List<CompanyMaster> loadAllCompanies();
	public  int addCompany(CompanyMaster comp);
	
}
