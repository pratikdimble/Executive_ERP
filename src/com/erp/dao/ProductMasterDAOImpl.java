package com.erp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erp.domain.EmployeeMaster;
import com.erp.domain.ProductDataMaster;
import com.erp.domain.ProductMaster;
import com.erp.utility.HibernateUtil;


public class ProductMasterDAOImpl implements ProductMasterDAO {
 private static final String HQL_GET_ALL_PRODUCTS="from  ProductDataMaster";
 private static final String HQL_GET_PRODUCT="from  ProductDataMaster where name=?";
 private static final String HQL_UPDATE_PRODUCT="update ProductDataMaster set company=:company,cost=:cost,quantity=:quantity,warranty=:warranty where pid=:id";
 private static final String HQL_DELETE_PRODUCT="Delete from  ProductDataMaster where name=?";
	
 @Override
	public int addProduct(ProductMaster prod) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(prod);
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
	public int addProductData(ProductDataMaster prod,int productId) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		ProductMaster product=null;
		boolean flag=false;
		System.out.println("\n\t***Product ID::"+productId);
		//prepare Product obj
		product=new ProductMaster();
			//load parent  obj
				product=ses.get(ProductMaster.class, productId);
				//set the child
					prod.setProduct(product);
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(prod);
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
	public int updateProduct(int pid, String name, String type, String company, float cost, int quantity,
			float warranty) {

	Session ses = null;
	ses = HibernateUtil.getSession();
	Transaction tx=null;
	int count=0;
	Query query = null;
	// prepare query
	query = ses.createQuery(HQL_UPDATE_PRODUCT);
	query.setParameter("id", pid);
	//query.setParameter("name", name);
	//query.setParameter("type", type);
	query.setParameter("company", company);
	query.setParameter("cost", cost);
	query.setParameter("quantity", quantity);
	query.setParameter("warranty", warranty);
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
	return pid;
}//method
 
 
 @Override
	public List<ProductDataMaster> loadAllProducts() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<ProductDataMaster> listprod = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_PRODUCTS);
		try {
			listprod = query.list();
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
		return listprod;
	}//method
 
 
	@Override
	public int deleteProduct(String name) {
	Session ses = null;
	ses = HibernateUtil.getSession();
	Transaction tx=null;
	int count=0;
	Query query = null;
	// prepare query
	query = ses.createQuery(HQL_DELETE_PRODUCT);
	query.setParameter(0, name);
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
		public List<ProductDataMaster> getProduct(String name) {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<ProductDataMaster> listprod = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_PRODUCT);
		query.setParameter(0, name);
		try {
			listprod = query.list();
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
		return listprod;
		}

}//class
