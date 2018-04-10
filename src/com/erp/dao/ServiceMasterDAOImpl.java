package com.erp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erp.domain.ProductMaster;
import com.erp.domain.ServiceDataMaster;
import com.erp.domain.ServiceMaster;
import com.erp.utility.HibernateUtil;


public class ServiceMasterDAOImpl implements ServiceMasterDAO {
 private static final String HQL_GET_ALL_SERVICES="from  ServiceDataMaster";
 private static final String HQL_GET_SERVICE="from  ServiceDataMaster where name=?";
 private static final String HQL_DELETE_SERVICE="Delete from  ServiceDataMaster where serid=?";

 @Override
 public int addService(ServiceMaster service) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(service);
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
	
 public int addServiceData(ServiceDataMaster service,int serid) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		ServiceMaster sm=null;
		System.out.println("\n\t***Product ID::"+serid);
		//prepare Product obj
		sm=new ServiceMaster();
			//load parent  obj
				sm=ses.get(ServiceMaster.class,serid);
				//set the child
					service.setServicemaster(sm);
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(service);
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
	public List<ServiceDataMaster> loadAllServices() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<ServiceDataMaster> listservice = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_SERVICES);
		try {
			listservice = query.list();
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
		return listservice;
	}//method
	
 @Override
	public int deleteService(int id) {
	Session ses = null;
	ses = HibernateUtil.getSession();
	Transaction tx=null;
	int count=0;
	ServiceDataMaster service=null;
	Query query = null;
	//prepare Query
	query = ses.createQuery(HQL_DELETE_SERVICE);
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
	public List<ServiceDataMaster> getService(String name) {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<ServiceDataMaster> listservice = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_SERVICE);
		query.setParameter(0, name);
		try {
			listservice = query.list();
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
		return listservice;
	}
}
