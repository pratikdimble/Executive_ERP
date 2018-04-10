package com.erp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.erp.domain.BankMaster;
import com.erp.utility.HibernateUtil;


public class BankMasterDAOImpl implements BankMasterDAO {
 private static final String HQL_GET_ALL_BANKS="from  BankMaster";

 @Override
 public int addBank(BankMaster bank) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(bank);
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
	public List<BankMaster> loadAllBanks() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<BankMaster> listbank = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_BANKS);
		try {
			listbank= query.list();
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
		return listbank;
	}//method


}
