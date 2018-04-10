package com.erp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.erp.domain.LeaveMaster;
import com.erp.utility.HibernateUtil;


public class LeaveMasterDAOImpl implements LeaveMasterDAO {
 private static final String HQL_GET_ALL_PENDING_LEAVES="from  LeaveMaster where status=:status";
 private static final String HQL_GET_ALL_APPROVED_LEAVES="from  LeaveMaster where status=:status";
 private static final String HQL_GET_USER_LEAVE="from  LeaveMaster where empId=:empId";
 private static final String HQL_UPDATE_STATUS="update LeaveMaster set status=:status where leaveId=:leaveId";


 @Override
 public int addLeave(LeaveMaster leave) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(leave);
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
	public List<LeaveMaster> loadUserLeave(int empId) {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<LeaveMaster> listLeave = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_USER_LEAVE);
		query.setParameter("empId", empId);
		try {
			listLeave = query.list();
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
		return listLeave;
	}//method
 
 
 @Override
	public List<LeaveMaster> loadAllLeave() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<LeaveMaster> listLeave = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_PENDING_LEAVES);
		query.setParameter("status", "Pending");
		try {
			listLeave = query.list();
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
		return listLeave;
	}//method
 @Override
	public List<LeaveMaster> loadApprovedLeave() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<LeaveMaster> listLeave = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_APPROVED_LEAVES);
		query.setParameter("status", "Approved");
		try {
			listLeave = query.list();
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
		return listLeave;
	}//method
 
@Override
	public int deleteLeave(int id) {
	Session ses = null;
	ses = HibernateUtil.getSession();
	Transaction tx=null;
	int count=0;
	LeaveMaster leave=null;
	//load  obj
	leave=ses.get(LeaveMaster.class,id);
	try{
	 tx=ses.beginTransaction();
	   //delete objs
	 ses.delete(leave);
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
	public int updateStatus(int id, String Status) {
	Session ses = null;
	ses = HibernateUtil.getSession();
	Transaction tx=null;
	int count=0;
	Query query = null;
	// prepare query for update status
	query = ses.createQuery(HQL_UPDATE_STATUS);
	query.setParameter("leaveId", id);
	query.setParameter("status", Status);


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
	return id;
}//method
 
	}

