package com.erp.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erp.domain.EmployeeMaster;
import com.erp.domain.LoginMaster;
import com.erp.utility.HibernateUtil;


public class EmployeeMasterDAOImpl implements EmployeeMasterDAO {
 private static final String HQL_GET_ALL_EMPLOYEES="from  EmployeeMaster";
 private static final String HQL_GET_EMPLOYEES="from  EmployeeMaster where userName=?";
 private static final String HQL_GET_EMPLOYEE_LOGIN="from  LoginMaster where name=?";
 private static final String HQL_UPDATE_EMPLOYEE="update EmployeeMaster set empName=:empName,"
			+ "empAddr=:empAddr,empCity=:empCity,pin=:pin,designation=:designation,qualification=:qualification,"
			+ "workExp=:workExp,doj=:doj,mobile=:mobile,empMail=:empMail where empId=:empId";
 private static final String HQL_UPDATE_DEPARTMENT="update EmployeeMaster set department=:dept where empId=:empId";
 private static final String HQL_UPDATE_LOGIN_EMPLOYEE="update LoginMaster set role=:role where id=:id";
 private static final String HQL_CHANGE_PASSWORD="update LoginMaster set password=:password where id=:id";

 
 @Override
 public int addEmployee(EmployeeMaster emp) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(emp);
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
 public int addEmployeeInfo(LoginMaster log) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int id=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 id=(int)ses.save(log);
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
		return id;
	}//method
@Override
	public int changePassword(int id, String password) {
		Session ses = null;
		ses = HibernateUtil.getSession();
		Transaction tx=null;
		int count=0;
		Query query = null,query2=null;
		// prepare query for update employee
		query = ses.createQuery(HQL_CHANGE_PASSWORD);
		query.setParameter("id", id);
		query.setParameter("password",password);

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

	 @Override
		public int updateEmployee(int loginId, int empId, String empName, String empAddr, String empCity, int pin,
				String designation, String qualification, String workExp, String doj, long mobile, String empMail) {

 Session ses = null;
	ses = HibernateUtil.getSession();
	Transaction tx=null;
	int count=0;
	Query query = null,query2=null;
	// prepare query for update employee
	query = ses.createQuery(HQL_UPDATE_EMPLOYEE);
	query.setParameter("empId", empId);
	query.setParameter("empName", empName);
	query.setParameter("empAddr", empAddr);
	query.setParameter("empCity", empCity);
	query.setParameter("pin", pin);
	query.setParameter("designation", designation);
	query.setParameter("qualification", qualification);
	query.setParameter("workExp", workExp);
	query.setParameter("doj", doj);
	query.setParameter("mobile",mobile);
	query.setParameter("empMail", empMail);
	
	//prepare query for update login role
	query2 = ses.createQuery(HQL_UPDATE_LOGIN_EMPLOYEE);
	query2.setParameter("id", loginId);
	query2.setParameter("role", designation);
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
	return empId;
}//method
 
 @Override
	public List<EmployeeMaster> loadAllEmployee() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<EmployeeMaster> listemp = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_EMPLOYEES);
		try {
			listemp = query.list();
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
		return listemp;
	}//method

@Override
	public List<EmployeeMaster> getEmployee(String name) {
	Session ses = null;
	ses = HibernateUtil.getSession();
	boolean flag = false;
	List<EmployeeMaster> listemp = null;
	Query query = null;
	// prepare query
	query = ses.createQuery(HQL_GET_EMPLOYEES);
	query.setParameter(0, name);
	System.out.println("*******"+name);
	try {
		listemp = query.list();
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
	return listemp;	
	}//method
@Override
	public List<LoginMaster> getEmployeeLogin(String name) {
	Session ses = null;
	ses = HibernateUtil.getSession();
	boolean flag = false;
	List<LoginMaster> listLogin = null;
	Query query = null;
	// prepare query
	query = ses.createQuery(HQL_GET_EMPLOYEE_LOGIN);
	query.setParameter(0, name);
	System.out.println("*******"+name);
	try {
		listLogin = query.list();
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
	return listLogin;	
	}//method

@Override
	public int changeDepartment(int id, String dept) {
		Session ses = null;
				ses = HibernateUtil.getSession();
					Transaction tx=null;
						int count=0;
							Query query = null;
								// prepare query for update employee
								query = ses.createQuery(HQL_UPDATE_DEPARTMENT);
									query.setParameter("empId", id);
										query.setParameter("dept", dept);

										try{
												tx=ses.beginTransaction();
													//update the dept
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
