package com.erp.dao;

import java.util.List;

import com.erp.domain.ProductDataMaster;
import com.erp.domain.ProductMaster;


public interface ProductMasterDAO {
	public List<ProductDataMaster> loadAllProducts();
	public List<ProductDataMaster> getProduct(String name);
	public  int addProduct(ProductMaster prod);
	public  int addProductData(ProductDataMaster prod,int productId);
	public  int updateProduct(int pid,String name,String type,String company,float cost,int quantity,float warranty);
	public int  deleteProduct(String name);
}
