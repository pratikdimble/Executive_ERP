package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;


import com.erp.dao.CustAppointMasterDAO;
import com.erp.dao.CustAppointMasterDAOFactory;
import com.erp.domain.CustAppointMaster;
import com.erp.dto.CustAppointDTO;

import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;
import com.erp.errors.CustAppointRemovalProblemException;


public class CustAppointOperationsBusinessDelegate {

	public String addCustAppoint(String custName,String appointTo,String type,String subject,String appointDate,String time,String venue,String contact)throws InsertOperationProblemException,InternalProblemException{
		CustAppointMasterDAO dao=null;
		CustAppointMaster appoint=null;
		int id=0;
		//use dAO
		dao=CustAppointMasterDAOFactory.getInstance();
		//prepare CustAppoint obj
		appoint=new CustAppointMaster();
		appoint.setCustName(custName);appoint.setAppointTo(appointTo);appoint.setAppointType(type);
		appoint.setSubject(subject);appoint.setAppointDate(appointDate);appoint.setTime(time);appoint.setVenue(venue);appoint.setContact(contact);
		//invoke method
		try{
		 id=dao.addCustAppoint(appoint);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " CustAppoint Added Succesfully with Id::"+id;
	}//method
	
	
	public List<CustAppointDTO> getAllCustAppoints()throws InternalProblemException{
		CustAppointMasterDAO dao=null;
		List<CustAppointMaster> listappoint=null;
		List<CustAppointDTO> listappointDTOs=null;
		CustAppointDTO appointDTO=null;
		//get DAO
		dao=CustAppointMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listappoint=dao.loadAllCustAppoints();	
		 //convert ListCustAppoint to ListCustAppointDTO 
		 listappointDTOs=new ArrayList();
		 for(CustAppointMaster appoint:listappoint){
			 //get Each DTO class object
			 appointDTO=new CustAppointDTO();
			 appointDTO.setId(appoint.getId());
			 appointDTO.setCustName(appoint.getCustName());
			 appointDTO.setAppointTo(appoint.getAppointTo());
			 appointDTO.setAppointType(appoint.getAppointType());
			 appointDTO.setSubject(appoint.getSubject());
			 appointDTO.setAppointDate(appoint.getAppointDate());
			 appointDTO.setTime(appoint.getTime());
			 appointDTO.setVenue(appoint.getVenue());
			 appointDTO.setContact(appoint.getContact());

			 listappointDTOs.add(appointDTO);
		 }//for
		 return listappointDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	public List<CustAppointDTO> getCustAppoint(String name)throws InternalProblemException{
		CustAppointMasterDAO dao=null;
		List<CustAppointMaster> listappoint=null;
		List<CustAppointDTO> listappointDTOs=null;
		CustAppointDTO appointDTO=null;
		//get DAO
		dao=CustAppointMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listappoint=dao.getCustAppoint(name);	
		 //convert ListCustAppoint to ListCustAppointDTO 
		 listappointDTOs=new ArrayList();
		 for(CustAppointMaster appoint:listappoint){
			 //get Each DTO class object
			 appointDTO=new CustAppointDTO();
			 appointDTO=new CustAppointDTO();
			 appointDTO.setId(appoint.getId());
			 appointDTO.setCustName(appoint.getCustName());
			 appointDTO.setAppointTo(appoint.getAppointTo());
			 appointDTO.setAppointType(appoint.getAppointType());
			 appointDTO.setSubject(appoint.getSubject());
			 appointDTO.setAppointDate(appoint.getAppointDate());
			 appointDTO.setTime(appoint.getTime());
			 appointDTO.setVenue(appoint.getVenue());
			 appointDTO.setContact(appoint.getContact());

			 listappointDTOs.add(appointDTO);
		 }//for
		 return listappointDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	public String deleteCustAppoint(String name)throws CustAppointRemovalProblemException{
		CustAppointMasterDAO dao=null;
		int count=0;
		String msg=null;
		//get DAO
		dao=CustAppointMasterDAOFactory.getInstance();
		try{
		  count=dao.deleteCustAppoint(name);
		  if(count==0)
			 
			  msg="CustAppoint is Not Removed";
		  else
			  msg="CustAppoint is  Removed";
		}
		catch(HibernateException he){
			throw new CustAppointRemovalProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new CustAppointRemovalProblemException(e.getMessage());
		}
		return msg;
	}//method
	
	
}//class
