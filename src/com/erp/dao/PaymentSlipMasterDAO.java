package com.erp.dao;

import java.util.List;

import com.erp.domain.PaymentSlipMaster;


public interface PaymentSlipMasterDAO {
	public List<PaymentSlipMaster> loadAllPaymentSlips();
	public List<PaymentSlipMaster> getPaymentSlip(String name);
	public List<PaymentSlipMaster> getEmpPaymentSlip(String name,String month);
	public  int addPaymentSlip(PaymentSlipMaster payment);

}
