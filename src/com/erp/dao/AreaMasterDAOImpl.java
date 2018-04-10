package com.erp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.erp.domain.AreaMaster;
import com.erp.utility.HibernateUtil;


public class AreaMasterDAOImpl implements AreaMasterDAO {
 private static final String HQL_GET_ALL_AREA="from  AreaMaster";

 @Override
 public int addArea(AreaMaster area) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(area);
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
	public List<AreaMaster> loadAllArea() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<AreaMaster> listArea = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_AREA);
		try {
			listArea = query.list();
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
		return listArea;
	}//method
 
@Override
	public int deleteArea(int id) {
	Session ses = null;
	ses = HibernateUtil.getSession();
	Transaction tx=null;
	int count=0;
	AreaMaster area=null;
	//load  obj
	area=ses.get(AreaMaster.class,id);
	try{
	 tx=ses.beginTransaction();
	   //delete objs
	 ses.delete(area);
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
}
