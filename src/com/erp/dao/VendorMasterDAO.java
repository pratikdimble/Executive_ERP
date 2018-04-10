package com.erp.dao;

import java.util.List;

import com.erp.domain.VendorMaster;
import com.erp.domain.LoginMaster;
import com.erp.dto.LoginDTO;

public interface VendorMasterDAO {
	public List<VendorMaster> loadAllVendor();
	public List<VendorMaster> getVendor(String name);
	public  int addVendor(VendorMaster vendor);
	public  int deleteVendor(int vendorId);
	public  int updateVendor(int vendorId,String vendorName,String website, String vendorCountry,String vendorState,	
				String vendorCity,int pin,String vendorAddr,long mobile,String vendorMail,String business);
}
