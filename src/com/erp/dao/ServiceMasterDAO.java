package com.erp.dao;

import java.util.List;

import com.erp.domain.ServiceDataMaster;
import com.erp.domain.ServiceMaster;



public interface ServiceMasterDAO {
	public List<ServiceDataMaster> loadAllServices();
	public  int addService(ServiceMaster service);
	public  int addServiceData(ServiceDataMaster service,int serid);
	public List<ServiceDataMaster> getService(String name);
	public int  deleteService(int id);
}
