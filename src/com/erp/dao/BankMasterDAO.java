package com.erp.dao;

import java.util.List;

import com.erp.domain.BankMaster;

public interface BankMasterDAO {
	public List<BankMaster> loadAllBanks();
	public  int addBank(BankMaster bank);
	
}
