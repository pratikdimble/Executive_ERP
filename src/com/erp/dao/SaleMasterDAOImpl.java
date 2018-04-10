package com.erp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erp.domain.CustomerMaster;
import com.erp.domain.SaleMaster;
import com.erp.domain.SaleQuotationMaster;
import com.erp.domain.ServiceMaster;
import com.erp.utility.HibernateUtil;


public class SaleMasterDAOImpl implements SaleMasterDAO {
 private static final String HQL_GET_ALL_SALES_ENQUIRY="from  SaleMaster";
 private static final String HQL_GET_SALE_ENQUIRY="from  SaleMaster where empName=?";
 private static final String HQL_DELETE_SALE_ENQUIRY="Delete from  SaleMaster where id=?";
 private static final String HQL_DELETE_SALE_Quotation="Delete from  SaleQuotationMaster where id=?";
 private static final String HQL_EDIT_SALE_Quotation="from  SaleQuotationMaster where id=?";
 private static final String HQL_GET_ALL_SERVICE_Quotation="from  SaleQuotationMaster where custReq='Service Only'";
 private static final String HQL_GET_ALL_PRODUCT_Quotation="from  SaleQuotationMaster where custReq='Product Only'";
@Override
	public int addSaleEnquiry(SaleMaster sale,int custId) {

		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		CustomerMaster cm=null;
		System.out.println("\n\t***CustomerMaster ID::"+custId);
		//prepare Product obj
		cm=new CustomerMaster();
			//load parent  obj
				cm=ses.get(CustomerMaster.class,custId);
				//set the child
					sale.setCustomer(cm);
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(sale);
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
		public int addSaleQuotation(SaleQuotationMaster quota) {
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
	public List<SaleMaster> loadAllSales() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<SaleMaster> listsale = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_SALES_ENQUIRY);
		try {
			listsale = query.list();
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
		return listsale;
	}//method
	
 @Override
	public int deleteSale(int id) {
	Session ses = null;
	ses = HibernateUtil.getSession();
	Transaction tx=null;
	int count=0;
	SaleMaster sale=null;
	Query query = null;
	//prepare Query
	query = ses.createQuery(HQL_DELETE_SALE_ENQUIRY);
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
		SaleQuotationMaster sale=null;
		Query query = null;
		//prepare Query
		query = ses.createQuery(HQL_DELETE_SALE_Quotation);
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
	public List<SaleQuotationMaster> editQuotation(int id) {
	 Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<SaleQuotationMaster> listsale = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_EDIT_SALE_Quotation);
		query.setParameter(0, id);
		try {
			listsale = query.list();
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
		return listsale;
	}
 
 
 @Override
	public List<SaleMaster> getSale(String name) {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<SaleMaster> listsale = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_SALE_ENQUIRY);
		query.setParameter(0, name);
		try {
			listsale = query.list();
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
		return listsale;
	}
 
 @Override
	public List<SaleQuotationMaster> loadAllPRODUCTQUOTATION() {
	 Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<SaleQuotationMaster> listsale = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_PRODUCT_Quotation);
		try {
			listsale = query.list();
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
		return listsale;
	}
 @Override
	public List<SaleQuotationMaster> loadAllSERVICEQUOTATION() {
	 Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<SaleQuotationMaster> listsale = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_SERVICE_Quotation);
		try {
			listsale = query.list();
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
		return listsale;
	}
}
