package com.erp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erp.domain.CustomerMaster;
import com.erp.domain.EmployeeMaster;
import com.erp.domain.RequirementMaster;
import com.erp.utility.HibernateUtil;


public class RequirementMasterDAOImpl implements RequirementMasterDAO {
 private static final String HQL_GET_ALL_REGIONS="from  RequirementMaster";
 private static final String HQL_UPDATE_STATUS_DELIVER="update RequirementMaster set status=:status where reqId=:reqId";
 private static final String HQL_GET_ALL_PENDING_REQUIREMENTS="from  RequirementMaster where status=:status and empName=:empName";
 private static final String HQL_UPDATE_STOCK_DELIVER="update ProductMaster set quantity=:quantity where name=:prodName and type=:prodType and company=:company ";
 private static final String HQL_UPDATE_STATUS_CANCEL="update RequirementMaster set status=:status where reqId=:reqId";
 private static final String HQL_UPDATE_STOCK_CANCEL="update ProductMaster set quantity=:quantity where name=:prodName and type=:prodType and company=:company ";
 
 @Override
 public int addRequirement(int empid,int custid,RequirementMaster enquiry) {
 		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		EmployeeMaster emp=null;
		CustomerMaster cust=null;
		RequirementMaster req=null;
		int idVal=0;
		System.out.println("\n\t***Employee ID::"+empid);
		System.out.println("\n\t***Customer ID::"+custid);
		
		//prepare Employee obj
		 emp=new EmployeeMaster();
		//emp.setEmpId(empid);
		//prepare CustomerMaster obj
		 cust=new CustomerMaster();
		//cust.setCustId(custid);
		 
		//load parent  obj
		 emp=ses.get(EmployeeMaster.class,empid);
			cust=ses.get(CustomerMaster.class, custid);
		//set the child
		enquiry.setEmpMaster(emp);
		enquiry.setCustMaster(cust);

		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(Integer)ses.save(enquiry);
		 System.out.println("Requirement Saved with:: "+idVal);
			 //loadAllRequirementsWithArea();
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
				 System.out.println("Requirement Saved with:: "+idVal);
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
	public void deliverStock(int quantity, String prodName, String prodType, String company, int stock) {
	 Session ses = null;
	 ses = HibernateUtil.getSession();
		Transaction tx=null;
		int count=0;
		quantity=stock-quantity;
		Query query = null;
		// prepare query for update status
		query = ses.createQuery(HQL_UPDATE_STOCK_DELIVER);
		query.setParameter("quantity", quantity);
		query.setParameter("prodName", prodName);
		query.setParameter("prodType", prodType);
		query.setParameter("company", company);
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
	}//method


@Override
	public int updateStatusCancel(int id, String Status, int quantity, String prodName, String prodType, String company,
			int stock) {
	 Session ses = null;
	 ses = HibernateUtil.getSession();
		Transaction tx=null;
		int count=0;
		quantity=stock+quantity;
		Query query = null,query2=null;
		// prepare query for Stock update
		query = ses.createQuery(HQL_UPDATE_STOCK_CANCEL);
		query.setParameter("quantity", quantity);
		query.setParameter("prodName", prodName);
		query.setParameter("prodType", prodType);
		query.setParameter("company", company);
		// prepare query for update status
		query2 = ses.createQuery(HQL_UPDATE_STATUS_CANCEL);
		query2.setParameter("reqId", id);
		query2.setParameter("status", Status);
		try{
		 tx=ses.beginTransaction();
		   //delete objs
		 query.executeUpdate();
		 query2.executeUpdate();
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
	public List<RequirementMaster> loadAllRequirements() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<RequirementMaster> listRequirement = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_REGIONS);
		try {
			listRequirement= query.list();
			//loadAllRequirementsWithArea();
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
		return listRequirement;
	}//method
 
 @Override
	public List<RequirementMaster> loadPendingRequirements(String empName) {
	 Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<RequirementMaster> listRequirement = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_PENDING_REQUIREMENTS);
		query.setParameter("empName", empName);
		query.setParameter("status", "Pending");
		try {
			listRequirement= query.list();
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
		return listRequirement;
	}//method
 
 @Override
	public int updateStatusDeliver(int id, String Status) {
	 Session ses = null;
	 ses = HibernateUtil.getSession();
		Transaction tx=null;
		int count=0;
		Query query = null;
		// prepare query for update status
		query = ses.createQuery(HQL_UPDATE_STATUS_DELIVER);
		query.setParameter("reqId", id);
		query.setParameter("status", Status);


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
		return id;
	}//method

}
