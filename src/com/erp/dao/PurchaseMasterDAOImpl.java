package com.erp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erp.domain.CustomerMaster;
import com.erp.domain.PurchaseMaster;
import com.erp.domain.PurchaseQuotationMaster;
import com.erp.domain.ServiceMaster;
import com.erp.utility.HibernateUtil;


public class PurchaseMasterDAOImpl implements PurchaseMasterDAO {
 private static final String HQL_GET_ALL_PURCHASE_ENQUIRY="from  PurchaseMaster";
 private static final String HQL_GET_PRODUCT_PURCHASE_ENQUIRY="from  PurchaseMaster where prodName=?";
 private static final String HQL_GET_SUPPLIER_PURCHASE_ENQUIRY="from  PurchaseMaster where suppName=?";
 private static final String HQL_DELETE_PURCHASE_ENQUIRY="Delete from  PurchaseMaster where enqId=?";
 private static final String HQL_GET_ALL_Quotation="from  PurchaseQuotationMaster ";
 private static final String HQL_DELETE_PURCHASE_Quotation="Delete from  PurchaseQuotationMaster where id=?";
 ///private static final String HQL_EDIT_SALE_Quotation="from  PurchaseQuotationMaster where id=?";
// private static final String HQL_GET_ALL_SERVICE_Quotation="from  PurchaseQuotationMaster where custReq='Service Only'";
 //private static final String HQL_GET_ALL_PRODUCT_Quotation="from  PurchaseQuotationMaster where custReq='Product Only'";
@Override
	public int addPurchaseEnquiry(PurchaseMaster purchase) {

		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(purchase);
       flag=true;			
		}//try
		catch(HibernateException he){
			flag=false;
			throw he;
		}
		catch(Exception e){
			flag=false;
			throw e;
		}
		finally{
			if(flag){
				tx.commit();
				
			}
			else{
				tx.rollback();
			}
		 //close Session
			HibernateUtil.closeSession();
		}//finally
		return idVal;
	}//method
	@Override
		public int addPurchaseQuotation(PurchaseQuotationMaster quota) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(quota);
       flag=true;			
		}//try
		catch(HibernateException he){
			flag=false;
			throw he;
		}
		catch(Exception e){
			flag=false;
			throw e;
		}
		finally{
			if(flag){
				tx.commit();
				
			}
			else{
				tx.rollback();
			}
		 //close Session
			HibernateUtil.closeSession();
		}//finally
		return idVal;
	}//method
 
 
 
 @Override
	public List<PurchaseMaster> loadAllPurchases() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<PurchaseMaster> listpurchase = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_PURCHASE_ENQUIRY);
		try {
			listpurchase = query.list();
		} // try
		catch (HibernateException he) {
			flag = false;
			throw he;
		} catch (Exception e) {
			flag = false;
			throw e;
		} finally {
			// close Session
			HibernateUtil.closeSession();
		} // finally
		return listpurchase;
	}//method
	
 @Override
	public int deletePurchase(int id) {
	Session ses = null;
	ses = HibernateUtil.getSession();
	Transaction tx=null;
	int count=0;
	PurchaseMaster purchase=null;
	Query query = null;
	//prepare Query
	query = ses.createQuery(HQL_DELETE_PURCHASE_ENQUIRY);
	query.setParameter(0, id);
	try{
	 tx=ses.beginTransaction();
	   //delete objs
	 query.executeUpdate();
     count=1;		
	}//try
	catch(HibernateException he){
		count=0;
		throw he;
	}
	catch(Exception e){
		count=0;
		throw e;
	}
	finally{
		if(count==1){
			tx.commit();
		}
		else{
			tx.rollback();
		}
	 //close Session
		HibernateUtil.closeSession();
	}//finally	
	return count;
}//method
 
@Override
	public int deleteQuotation(int id) {
		Session ses = null;
		ses = HibernateUtil.getSession();
		Transaction tx=null;
		int count=0;
		PurchaseQuotationMaster purchase=null;
		Query query = null;
		//prepare Query
		query = ses.createQuery(HQL_DELETE_PURCHASE_Quotation);
		query.setParameter(0, id);
		try{
		 tx=ses.beginTransaction();
		   //delete objs
		 query.executeUpdate();
	     count=1;		
		}//try
		catch(HibernateException he){
			count=0;
			throw he;
		}
		catch(Exception e){
			count=0;
			throw e;
		}
		finally{
			if(count==1){
				tx.commit();
			}
			else{
				tx.rollback();
			}
		 //close Session
			HibernateUtil.closeSession();
		}//finally	
		return count;
	}//method
/*
 @Override
	public List<PurchaseQuotationMaster> editQuotation(int id) {
	 Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<PurchaseQuotationMaster> listpurchase = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_EDIT_SALE_Quotation);
		query.setParameter(0, id);
		try {
			listpurchase = query.list();
		} // try
		catch (HibernateException he) {
			flag = false;
			throw he;
		} catch (Exception e) {
			flag = false;
			throw e;
		} finally {
			// close Session
			HibernateUtil.closeSession();
		} // finally
		return listpurchase;
	}*/
 
 @Override
	public List<PurchaseMaster> getPurchaseByProduct(String name) {
	 Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<PurchaseMaster> listpurchase = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_PRODUCT_PURCHASE_ENQUIRY);
		query.setParameter(0, name);
		try {
			listpurchase = query.list();
		} // try
		catch (HibernateException he) {
			flag = false;
			throw he;
		} catch (Exception e) {
			flag = false;
			throw e;
		} finally {
			// close Session
			HibernateUtil.closeSession();
		} // finally
		return listpurchase;
	}
 @Override
	public List<PurchaseMaster> getPurchaseBySupplier(String name) {

		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<PurchaseMaster> listpurchase = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_SUPPLIER_PURCHASE_ENQUIRY);
		query.setParameter(0, name);
		try {
			listpurchase = query.list();
		} // try
		catch (HibernateException he) {
			flag = false;
			throw he;
		} catch (Exception e) {
			flag = false;
			throw e;
		} finally {
			// close Session
			HibernateUtil.closeSession();
		} // finally
		return listpurchase;
	}
 
 public List<PurchaseQuotationMaster> loadAllQUOTATION() {
	 Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<PurchaseQuotationMaster> listpurchase = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_Quotation);
		try {
			listpurchase = query.list();
		} // try
		catch (HibernateException he) {
			flag = false;
			throw he;
		} catch (Exception e) {
			flag = false;
			throw e;
		} finally {
			// close Session
			HibernateUtil.closeSession();
		} // finally
		return listpurchase;
	}
 
 
}
