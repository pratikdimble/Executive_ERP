package com.erp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.erp.domain.DepartmentMaster;
import com.erp.utility.HibernateUtil;


public class DepartmentMasterDAOImpl implements DepartmentMasterDAO {
 private static final String HQL_GET_ALL_Department="from  DepartmentMaster";

 @Override
 public int addDepartment(DepartmentMaster dept) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(dept);
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
	public List<DepartmentMaster> loadAllDepartments() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<DepartmentMaster> listdept = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_Department);
		try {
			listdept= query.list();
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
		return listdept;
	}//method


}
