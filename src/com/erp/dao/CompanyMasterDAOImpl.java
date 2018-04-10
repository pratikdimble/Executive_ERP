package com.erp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.erp.domain.CompanyMaster;
import com.erp.domain.ProductMaster;
import com.erp.utility.HibernateUtil;


public class CompanyMasterDAOImpl implements CompanyMasterDAO {
 private static final String HQL_GET_ALL_COMPANIES="from  CompanyMaster";

 @Override
 public int addCompany(CompanyMaster comp) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(comp);
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
	public List<CompanyMaster> loadAllCompanies() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<CompanyMaster> listcomp = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_COMPANIES);
		try {
			listcomp = query.list();
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
		return listcomp;
	}//method


}
