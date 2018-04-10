package com.erp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erp.domain.CustAppointMaster;
import com.erp.utility.HibernateUtil;


public class CustAppointMasterDAOImpl implements CustAppointMasterDAO {
 private static final String HQL_GET_ALL_APPOINTS="from  CustAppointMaster";
 private static final String HQL_GET_APPOINT="from  CustAppointMaster where custName=?";
 private static final String HQL_DELETE_APPOINT="Delete from  CustAppointMaster where custName=?";

 @Override
 public int addCustAppoint(CustAppointMaster appoint) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(appoint);
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
	public List<CustAppointMaster> loadAllCustAppoints() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<CustAppointMaster> listappoint = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_APPOINTS);
		try {
			listappoint = query.list();
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
		return listappoint;
	}//method
	
 @Override
	public int deleteCustAppoint(String name) {
	Session ses = null;
	ses = HibernateUtil.getSession();
	Transaction tx=null;
	int count=0;
	CustAppointMaster appoint=null;
	Query query = null;
	//prepare Query
	query = ses.createQuery(HQL_DELETE_APPOINT);
	query.setParameter(0, name);
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
	public List<CustAppointMaster> getCustAppoint(String name) {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<CustAppointMaster> listappoint = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_APPOINT);
		query.setParameter(0, name);
		try {
			listappoint = query.list();
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
		return listappoint;
	}
}
