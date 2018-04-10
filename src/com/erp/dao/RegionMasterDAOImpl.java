package com.erp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erp.domain.AreaMaster;
import com.erp.domain.RegionMaster;
import com.erp.utility.HibernateUtil;


public class RegionMasterDAOImpl implements RegionMasterDAO {
 private static final String HQL_GET_ALL_REGIONS="from  RegionMaster";
 private static final String HQL_GET_EXISTING_REGION="from  RegionMaster where name=?";
 private static final String HQL_GET_ALL_REGIONS_WITH_AREA="from  RegionMaster";
 @Override
 public int addRegion(RegionMaster region) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(Integer)ses.save(region);
		 System.out.println("Region Saved with:: "+idVal);
		 //loadAllRegionsWithArea();
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
	public List<RegionMaster> loadAllRegions() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<RegionMaster> listRegion = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_REGIONS);
		try {
			listRegion= query.list();
			loadAllRegionsWithArea();
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
		return listRegion;
	}//method
 
 
@Override
	public String addNewAreaToExistingRegion(String rname,AreaMaster area) {
	Session ses=null;
	ses=HibernateUtil.getSession();
	Transaction tx=null;
	boolean flag=false;
	int idVal=0,rid=0,myid=0;
	
	RegionMaster reg=null;
	AreaMaster ar=null;
  
	   Connection con=null;
		Statement st=null;
		ResultSet rs=null;
			try
			{
				Class.forName("oracle.jdbc.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
				String sql="select regid from erp_region where regname='"+rname+"'";
				st=con.createStatement();
				rs=st.executeQuery(sql);
				while(rs.next())
				{
					myid = rs.getInt(1);
				}
			}//try
			catch (Exception e2) {
				e2.printStackTrace();
			}//catch
			finally
			{
				try {
					//	CLOSE THE RESOURSES
					con.close();
					st.close();
					rs.close();
				}//try 
				catch (Exception e2) {
					e2.printStackTrace();
				}//catch
			}//finally
	try {
		System.out.print("\n\t"+myid);
	      //load parent  obj
			reg=ses.get(RegionMaster.class, myid);
				//load child obj
				Set<AreaMaster> childs=reg.getAreamaster();
			//create new child i.e new area
			AreaMaster am=new AreaMaster();
			am=area;
		try{
		 tx=ses.beginTransaction();
		 childs.add(am);
		   //save objs
		 //idVal=(int)ses.save(region);
		 System.out.println("NEW AREA ADDED IN REGION:: "+rname);
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
 
	 //   }
	} // try
	catch(Exception e){
		//count=0;
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

	return "NEW AREA ADDED IN REGION:: "+rname;
}//method
@Override
	public List<RegionMaster> loadAllRegionsWithArea() {
	Session ses = null;
	Set<AreaMaster> childs=null;
	ses = HibernateUtil.getSession();
	boolean flag = false;
	List<RegionMaster> listRegion = null;
	Query query = null;
	// prepare query
	query = ses.createQuery(HQL_GET_ALL_REGIONS_WITH_AREA);
	try {
		listRegion= query.list();
			for(RegionMaster parent:listRegion)
			{
				//System.out.println("***Region--->> "+parent);
				System.out.println("\n\t***Region--->>:: "+parent.getRegId()+"\t"+parent.getRegName()+"\t"+parent.getRegDesc());
				//get all childs
					childs=parent.getAreamaster();
				for(AreaMaster child:childs)
				{
					System.out.println("\n\t***Area-->>:: "+child.getAreaId()+"\t"+child.getAreaName()+
							"\t"+child.getDescription()+"\t"+child.getRegName());
					//System.out.println("***Area-->> :"+child);
						
				}
			}
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
	return listRegion;
}//method

}
