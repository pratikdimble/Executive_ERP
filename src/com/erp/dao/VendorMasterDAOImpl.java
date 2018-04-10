package com.erp.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erp.domain.VendorMaster;
import com.erp.domain.LoginMaster;
import com.erp.utility.HibernateUtil;


public class VendorMasterDAOImpl implements VendorMasterDAO {
 private static final String HQL_GET_ALL_VENDORS="from  VendorMaster";
 private static final String HQL_GET_VENDOR="from  VendorMaster where vendorName=?";
 private static final String HQL_DELETE_VENDOR="delete from  VendorMaster where vendorId=:vendorId";
 private static final String HQL_UPDATE_VENDOR="update VendorMaster set vendorName=:vendorName,website=:website"
			+ "vendorCountry=:vendorCountry,vendorState=:vendorState,vendorCity=:vendorCity,pin=:pin,"
			+ "vendorAddr=:vendorAddr,mobile=:mobile,vendorMail=:vendorMail,business=:business where vendorId=:vendorId";

 
 @Override
 public int addVendor(VendorMaster vendor) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(vendor);
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
 
 public int deleteVendor(int vendorId) {
	 Session ses = null;
		ses = HibernateUtil.getSession();
		Transaction tx=null;
		int count=0;
		Query query = null;
		// prepare query for update vendor
		query = ses.createQuery(HQL_DELETE_VENDOR);
		query.setParameter("vendorId", vendorId);

		try{
		 tx=ses.beginTransaction();
		   //update objs
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
	public int updateVendor(int vendorId, String vendorName, String website, String vendorCountry, String vendorState,
			String vendorCity, int pin, String vendorAddr, long mobile, String vendorMail, String business) {


 Session ses = null;
	ses = HibernateUtil.getSession();
	Transaction tx=null;
	int count=0;
	Query query = null;
	// prepare query for update vendor
	query = ses.createQuery(HQL_UPDATE_VENDOR);
	query.setParameter("vendorId", vendorId);
	query.setParameter("vendorName", vendorName);
	query.setParameter("website", website);
	
	query.setParameter("vendorCountry", vendorCountry);
	query.setParameter("vendorState", vendorState);
	query.setParameter("vendorCity", vendorCity);
	query.setParameter("pin", pin);

	query.setParameter("vendorAddr", vendorAddr);
	query.setParameter("mobile",mobile);
	query.setParameter("vendorMail", vendorMail);
	
	query.setParameter("business", business);

	try{
	 tx=ses.beginTransaction();
	   //update objs
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
	return vendorId;
}//method
 
 @Override
	public List<VendorMaster> loadAllVendor() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<VendorMaster> listvendor = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_VENDORS);
		try {
			listvendor = query.list();
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
		return listvendor;
	}//method

@Override
	public List<VendorMaster> getVendor(String name) {
	Session ses = null;
	ses = HibernateUtil.getSession();
	boolean flag = false;
	List<VendorMaster> listvendor = null;
	Query query = null;
	// prepare query
	query = ses.createQuery(HQL_GET_VENDOR);
	query.setParameter(0, name);
	System.out.println("*******"+name);
	try {
		listvendor = query.list();
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
	return listvendor;	
	}//method

}
