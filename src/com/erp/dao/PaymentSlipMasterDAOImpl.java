package com.erp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.erp.domain.PaymentSlipMaster;
import com.erp.utility.HibernateUtil;


public class PaymentSlipMasterDAOImpl implements PaymentSlipMasterDAO {
 private static final String HQL_GET_ALL_PAYMENTSLIPS="from  PaymentSlipMaster";
 private static final String HQL_GET_SLIP="from  PaymentSlipMaster where empName=?";
 private static final String HQL_GET_MONTHSLIP="from  PaymentSlipMaster where empName=:name and salMonth=:month";

 @Override
	public int addPaymentSlip(PaymentSlipMaster payment) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(payment);
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
	public List<PaymentSlipMaster> loadAllPaymentSlips() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<PaymentSlipMaster> listpayment = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_PAYMENTSLIPS);
		try {
			listpayment = query.list();
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
		return listpayment;
	}//method
 
 
	
	@Override
		public List<PaymentSlipMaster> getEmpPaymentSlip(String name,String month) {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		System.out.println("Name:: "+name+"\tMonth:: "+month);
		List<PaymentSlipMaster> listpayment = null;
		Query query = null;
/*		Criteria c=ses.createCriteria(PaymentSlipMaster.class);	
			c.add(Restrictions.and(
					//Restrictions.eq("empName", name).ignoreCase(),
							Restrictions.like("empName", name, MatchMode.ANYWHERE),
								Restrictions.eq("salMonth", month)
									));	*/
		// prepare query
		query = ses.createQuery(HQL_GET_MONTHSLIP);
		query.setParameter("name", name);
		query.setParameter("month", month);
		try {
			listpayment = query.list();
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
		return listpayment;
		}
	@Override
	public List<PaymentSlipMaster> getPaymentSlip(String name) {
	Session ses = null;
	ses = HibernateUtil.getSession();
	boolean flag = false;
	List<PaymentSlipMaster> listpayment = null;
	Query query = null;
	// prepare query
	query = ses.createQuery(HQL_GET_SLIP);
	query.setParameter(0, name);
	try {
		listpayment = query.list();
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
	return listpayment;
	}
}//class
