package com.erp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.erp.domain.HolidayMaster;
import com.erp.utility.HibernateUtil;


public class HolidayMasterDAOImpl implements HolidayMasterDAO {
 private static final String HQL_GET_ALL_holidays="from  HolidayMaster";
 private static final String HQL_GET_holiday="from  HolidayMaster where holidayDate=:hdate";

 @Override
 public int addHoliday(HolidayMaster holiday) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(holiday);
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
	public List<HolidayMaster> loadAllHolidays() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<HolidayMaster> listholiday = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_holidays);
		try {
			listholiday= query.list();
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
		return listholiday;
	}//method
@Override
	public List<HolidayMaster> getHoliday(String holidayDate) {
	Session ses = null;
	ses = HibernateUtil.getSession();
	boolean flag = false;
	List<HolidayMaster> listholiday = null;
	Query query = null;
	// prepare query
	query = ses.createQuery(HQL_GET_holiday);
	query.setParameter("hdate", holidayDate);
	try {
		listholiday= query.list();
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
	return listholiday;
}//method

}
