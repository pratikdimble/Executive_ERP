package com.erp.dao;

public class PaymentSlipMasterDAOFactory {
	
	public static  PaymentSlipMasterDAO getInstance(){
		return new PaymentSlipMasterDAOImpl();
	}

}
