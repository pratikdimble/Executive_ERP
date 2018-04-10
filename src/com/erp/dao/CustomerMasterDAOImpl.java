package com.erp.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erp.domain.CustomerMaster;
import com.erp.utility.HibernateUtil;


public class CustomerMasterDAOImpl implements CustomerMasterDAO {
 private static final String HQL_GET_ALL_Customer="from  CustomerMaster";

 @Override
 public int addCustomer(CustomerMaster cust) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(cust);
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
	public List<CustomerMaster> loadAllCustomer() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<CustomerMaster> listcust = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_Customer);
		try {
			listcust = query.list();
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
		return listcust;
	}//method


}
