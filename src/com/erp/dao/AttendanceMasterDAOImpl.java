package com.erp.dao;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erp.domain.AttendanceMaster;
import com.erp.utility.HibernateUtil;


public class AttendanceMasterDAOImpl implements AttendanceMasterDAO {
 private static final String HQL_GET_ALL_ATTENDANCES="from  AttendanceMaster";
 private static final String HQL_GET_ATTENDANCE="from  AttendanceMaster where empName=?";

 @Override
	public int addAttendance(AttendanceMaster attend) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(attend);
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
	public List<AttendanceMaster> loadAllAttendances() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<AttendanceMaster> listattend = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_ATTENDANCES);
		try {
			listattend = query.list();
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
		return listattend;
	}//method
 
 @Override
	public List<AttendanceMaster> getAttendance(String name) {
	Session ses = null;
	ses = HibernateUtil.getSession();
	boolean flag = false;
	List<AttendanceMaster> listattend = null;
	Query query = null;
	// prepare query
	query = ses.createQuery(HQL_GET_ATTENDANCE);
	query.setParameter(0, name);
	try {
		listattend = query.list();
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
	return listattend;
	}
 
}//class
