package com.erp.dao;

import java.util.List;

import com.erp.domain.PurchaseMaster;
import com.erp.domain.PurchaseQuotationMaster;



public interface PurchaseMasterDAO {
	public List<PurchaseMaster> loadAllPurchases();
	public List<PurchaseQuotationMaster> loadAllQUOTATION();
	public  int addPurchaseEnquiry(PurchaseMaster purchase);
	public  int addPurchaseQuotation(PurchaseQuotationMaster quota);
	public List<PurchaseMaster> getPurchaseByProduct(String name);
	public List<PurchaseMaster> getPurchaseBySupplier(String name);
	//public List<PurchaseQuotationMaster> editQuotation(int id);
	public int  deletePurchase(int id);
	public int  deleteQuotation(int id);
}
