package com.erp.dao;

import java.util.List;

import com.erp.domain.SaleMaster;
import com.erp.domain.SaleQuotationMaster;



public interface SaleMasterDAO {
	public List<SaleMaster> loadAllSales();
	public List<SaleQuotationMaster> loadAllSERVICEQUOTATION();
	public List<SaleQuotationMaster> loadAllPRODUCTQUOTATION();
	public  int addSaleEnquiry(SaleMaster sale,int custId);
	public  int addSaleQuotation(SaleQuotationMaster quota);
	public List<SaleMaster> getSale(String name);
	public List<SaleQuotationMaster> editQuotation(int id);
	public int  deleteSale(int id);
	public int  deleteQuotation(int id);
}
