package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.erp.dao.PaymentSlipMasterDAO;
import com.erp.dao.PaymentSlipMasterDAOFactory;
import com.erp.domain.PaymentSlipMaster;
import com.erp.dto.PaymentSlipDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;
//import com.erp.errors.PaymentSlipRemovalProblemException;


public class PaymentSlipOperationsBusinessDelegate {

	public String addPaymentSlip(String salMonth,int empId,String empName,long mobile,String dsgn,
			float basic,float service,float hra,float income,float da,float incentive,float transport,float netpay)throws InsertOperationProblemException,InternalProblemException{
		PaymentSlipMasterDAO dao=null;
		PaymentSlipMaster payment=null;
		int pid=0;
		//use dAO
		dao=PaymentSlipMasterDAOFactory.getInstance();
		//prepare PaymentSlip object
		payment=new PaymentSlipMaster();
		payment.setSalMonth(salMonth);payment.setEmpId(empId);payment.setEmpName(empName);payment.setDesignation(dsgn);
		payment.setMobile(mobile);payment.setBasic(basic);payment.setService(service);payment.setHra(hra);
		payment.setIncome(income);payment.setDa(da);payment.setIncentive(incentive);payment.setTransport(transport);
		payment.setNetpay(netpay);
		//invoke method
		try{
		 pid=dao.addPaymentSlip(payment);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " PaymentSlip Added Succesfully with Id::"+pid;
	}//method
	
	
	public List<PaymentSlipDTO> getAllPaymentSlips()throws InternalProblemException{
		PaymentSlipMasterDAO dao=null;
		List<PaymentSlipMaster> listpayment=null;
		List<PaymentSlipDTO> listpaymentDTOs=null;
		PaymentSlipDTO paymentDTO=null;
		//get DAO
		dao=PaymentSlipMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listpayment=dao.loadAllPaymentSlips();	
		 //convert ListPaymentSlip to ListPaymentSlipDTO 
		 listpaymentDTOs=new ArrayList();
		 for(PaymentSlipMaster payment:listpayment){
			 //get Each DTO class object
			 paymentDTO=new PaymentSlipDTO();
			 paymentDTO.setSlipId(payment.getSlipId());
			 paymentDTO.setSalMonth(payment.getSalMonth());
			 paymentDTO.setEmpName(payment.getEmpName());
			 paymentDTO.setEmpId(payment.getEmpId());
			 paymentDTO.setMobile(payment.getMobile());
			 paymentDTO.setDesignation(payment.getDesignation());
			 
			 paymentDTO.setBasic(payment.getBasic());
			 paymentDTO.setService(payment.getService());
			 paymentDTO.setHra(payment.getHra());
			 paymentDTO.setIncome(payment.getIncome());
			 paymentDTO.setDa(payment.getDa());
			 paymentDTO.setIncentive(payment.getIncentive());
			 paymentDTO.setTransport(payment.getTransport());
			 paymentDTO.setNetpay(payment.getNetpay());

			 listpaymentDTOs.add(paymentDTO);
		 }//for
		 return listpaymentDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	public List<PaymentSlipDTO> getPaymentSlip(String name)throws InternalProblemException{
		PaymentSlipMasterDAO dao=null;
		List<PaymentSlipMaster> listpayment=null;
		List<PaymentSlipDTO> listpaymentDTOs=null;
		PaymentSlipDTO paymentDTO=null;
		//get DAO
		dao=PaymentSlipMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listpayment=dao.getPaymentSlip(name);	
		 //convert ListPaymentSlip to ListPaymentSlipDTO 
		 listpaymentDTOs=new ArrayList();
		 for(PaymentSlipMaster payment:listpayment){
			 //get Each DTO class object
			 paymentDTO=new PaymentSlipDTO();
			 paymentDTO=new PaymentSlipDTO();
			 paymentDTO.setSlipId(payment.getSlipId());
			 paymentDTO.setSalMonth(payment.getSalMonth());
			 paymentDTO.setEmpName(payment.getEmpName());
			 paymentDTO.setEmpId(payment.getEmpId());
			 paymentDTO.setMobile(payment.getMobile());
			 paymentDTO.setDesignation(payment.getDesignation());
			 
			 paymentDTO.setBasic(payment.getBasic());
			 paymentDTO.setService(payment.getService());
			 paymentDTO.setHra(payment.getHra());
			 paymentDTO.setIncome(payment.getIncome());
			 paymentDTO.setDa(payment.getDa());
			 paymentDTO.setIncentive(payment.getIncentive());
			 paymentDTO.setTransport(payment.getTransport());
			 paymentDTO.setNetpay(payment.getNetpay());

			 listpaymentDTOs.add(paymentDTO);
		 }//for
		 return listpaymentDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	public List<PaymentSlipDTO> getEmpPaymentSlip(String name,String month)throws InternalProblemException{
		PaymentSlipMasterDAO dao=null;
		List<PaymentSlipMaster> listpayment=null;
		List<PaymentSlipDTO> listpaymentDTOs=null;
		PaymentSlipDTO paymentDTO=null;
		//get DAO
		dao=PaymentSlipMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listpayment=dao.getEmpPaymentSlip(name,month);	
		 //convert ListPaymentSlip to ListPaymentSlipDTO 
		 listpaymentDTOs=new ArrayList();
		 for(PaymentSlipMaster payment:listpayment){
			 //get Each DTO class object
			 paymentDTO=new PaymentSlipDTO();
			 paymentDTO=new PaymentSlipDTO();
			 paymentDTO.setSlipId(payment.getSlipId());
			 paymentDTO.setSalMonth(payment.getSalMonth());
			 paymentDTO.setEmpName(payment.getEmpName());
			 paymentDTO.setEmpId(payment.getEmpId());
			 paymentDTO.setMobile(payment.getMobile());
			 paymentDTO.setDesignation(payment.getDesignation());
			 
			 paymentDTO.setBasic(payment.getBasic());
			 paymentDTO.setService(payment.getService());
			 paymentDTO.setHra(payment.getHra());
			 paymentDTO.setIncome(payment.getIncome());
			 paymentDTO.setDa(payment.getDa());
			 paymentDTO.setIncentive(payment.getIncentive());
			 paymentDTO.setTransport(payment.getTransport());
			 paymentDTO.setNetpay(payment.getNetpay());

			 listpaymentDTOs.add(paymentDTO);
		 }//for
		 return listpaymentDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
}//class
