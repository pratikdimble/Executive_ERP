package com.erp.dao;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erp.domain.EmployeeMaster;
import com.erp.domain.IncentiveMaster;
import com.erp.utility.HibernateUtil;


public class IncentiveMasterDAOImpl implements IncentiveMasterDAO {
 private static final String HQL_GET_ALL_INCENTIVES="from  IncentiveMaster";
 private static final String HQL_GET_INCENTIVE="from  IncentiveMaster where empName=?";
 private static final String HQL_DELETE_INCENTIVE="Delete from  IncentiveMaster where incId=?";
	
 @Override
	public int addIncentive(int empId,IncentiveMaster incentive) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		//load the parent obj
		EmployeeMaster emp=(EmployeeMaster)ses.get(EmployeeMaster.class, empId);
		//set incentive to the employee
		incentive.setEmp(emp);
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(incentive);
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
	public List<IncentiveMaster> loadAllIncentives() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<IncentiveMaster> listIncentive = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_INCENTIVES);
		try {
			listIncentive = query.list();
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
		return listIncentive;
	}//method
 
 
	@Override
	public int deleteIncentive(int id) {
	Session ses = null;
	ses = HibernateUtil.getSession();
	Transaction tx=null;
	int count=0;
	Query query = null;
	// prepare query
	query = ses.createQuery(HQL_DELETE_INCENTIVE);
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
		public List<IncentiveMaster> getIncentive(String empName) {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<IncentiveMaster> listIncentive = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_INCENTIVE);
		query.setParameter(0, empName);
		try {
			 listIncentive = query.list();
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
		return listIncentive;
		}

}//class
