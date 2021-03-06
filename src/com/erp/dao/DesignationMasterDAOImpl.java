package com.erp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.erp.domain.DesignationMaster;
import com.erp.utility.HibernateUtil;


public class DesignationMasterDAOImpl implements DesignationMasterDAO {
 private static final String HQL_GET_ALL_DESIGNATION="from  DesignationMaster";

 @Override
 public int addDesignation(DesignationMaster dsgn) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(dsgn);
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
	public List<DesignationMaster> loadAllDesignations() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<DesignationMaster> listdsgn = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_DESIGNATION);
		try {
			listdsgn= query.list();
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
		return listdsgn;
	}//method


}
