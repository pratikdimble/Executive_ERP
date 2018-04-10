package com.erp.dao;

import java.util.List;

import com.erp.domain.CustomerMaster;

public interface CustomerMasterDAO {
	public List<CustomerMaster> loadAllCustomer();
	public  int addCustomer(CustomerMaster cust);
	
}
