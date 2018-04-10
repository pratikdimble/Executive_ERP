package com.erp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erp.domain.EmpAssignMaster;
import com.erp.utility.HibernateUtil;


public class EmpAssignMasterDAOImpl implements EmpAssignMasterDAO {
 private static final String HQL_GET_ALL_ASSIGNS="from  EmpAssignMaster";
 private static final String HQL_GET_ASSIGN="from  EmpAssignMaster where empName=?";
 private static final String HQL_DELETE_ASSIGN="Delete from  EmpAssignMaster where empName=?";

 @Override
 public int addEmpProductAssign(EmpAssignMaster assign) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(assign);
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
	public List<EmpAssignMaster> loadAllEmpAssigns() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<EmpAssignMaster> listassign = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_ASSIGNS);
		try {
			listassign = query.list();
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
		return listassign;
	}//method
	
 @Override
	public int deleteEmpAssign(String name) {
	Session ses = null;
	ses = HibernateUtil.getSession();
	Transaction tx=null;
	int count=0;
	EmpAssignMaster assign=null;
	Query query = null;
	//prepare Query
	query = ses.createQuery(HQL_DELETE_ASSIGN);
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
	public List<EmpAssignMaster> getEmpAssign(String name) {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<EmpAssignMaster> listassign = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ASSIGN);
		query.setParameter(0, name);
		try {
			listassign = query.list();
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
		return listassign;
	}
}
