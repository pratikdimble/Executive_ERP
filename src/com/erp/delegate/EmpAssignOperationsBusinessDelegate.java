package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;


import com.erp.dao.EmpAssignMasterDAO;
import com.erp.dao.EmpAssignMasterDAOFactory;
import com.erp.domain.EmpAssignMaster;
import com.erp.dto.EmpAssignDTO;

import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;
import com.erp.errors.EmpAssignRemovalProblemException;


public class EmpAssignOperationsBusinessDelegate {

	public String addEmpProductAssign(String empName,String design,String assignDate,String statusType,String prodName,String prodType,String serName,String region,String area)throws InsertOperationProblemException,InternalProblemException{
		EmpAssignMasterDAO dao=null;
		EmpAssignMaster assign=null;
		int sid=0;
		//use dAO
		dao=EmpAssignMasterDAOFactory.getInstance();
		//prepare EmpAssign obj
		assign=new EmpAssignMaster();
		assign.setEmpName(empName);assign.setDesign(design);assign.setAssignDate(assignDate);
		assign.setStatusType(statusType);assign.setProdName(prodName);
		assign.setProdType(prodType);assign.setSerName(serName);
		assign.setRegion(region);assign.setArea(area);
		//invoke method
		try{
		 sid=dao.addEmpProductAssign(assign);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " EmpAssign Added Succesfully with Id::"+sid;
	}//method
	
	
	public List<EmpAssignDTO> getAllEmpAssigns()throws InternalProblemException{
		EmpAssignMasterDAO dao=null;
		List<EmpAssignMaster> listassign=null;
		List<EmpAssignDTO> listassignDTOs=null;
		EmpAssignDTO assignDTO=null;
		//get DAO
		dao=EmpAssignMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listassign=dao.loadAllEmpAssigns();	
		 //convert ListEmpAssign to ListEmpAssignDTO 
		 listassignDTOs=new ArrayList();
		 for(EmpAssignMaster assign:listassign){
			 //get Each DTO class object
			 assignDTO=new EmpAssignDTO();
			 assignDTO.setId(assign.getId());
			 assignDTO.setEmpName(assign.getEmpName());
			 assignDTO.setDesign(assign.getDesign());
			 assignDTO.setAssignDate(assign.getAssignDate());
			 assignDTO.setStatusType(assign.getStatusType());
			 assignDTO.setProdName(assign.getProdName());
			 assignDTO.setProdType(assign.getProdType());
			 assignDTO.setSerName(assign.getSerName());
						 assignDTO.setRegion(assign.getRegion());
			 assignDTO.setArea(assign.getArea());

			 listassignDTOs.add(assignDTO);
		 }//for
		 return listassignDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	public List<EmpAssignDTO> getEmpAssign(String name)throws InternalProblemException{
		EmpAssignMasterDAO dao=null;
		List<EmpAssignMaster> listassign=null;
		List<EmpAssignDTO> listassignDTOs=null;
		EmpAssignDTO assignDTO=null;
		//get DAO
		dao=EmpAssignMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listassign=dao.getEmpAssign(name);	
		 //convert ListEmpAssign to ListEmpAssignDTO 
		 listassignDTOs=new ArrayList();
		 for(EmpAssignMaster assign:listassign){
			 //get Each DTO class object
			 assignDTO=new EmpAssignDTO();
			 assignDTO.setId(assign.getId());
			 assignDTO.setEmpName(assign.getEmpName());
			 assignDTO.setDesign(assign.getDesign());
			 assignDTO.setAssignDate(assign.getAssignDate());
			 assignDTO.setStatusType(assign.getStatusType());
			 assignDTO.setProdName(assign.getProdName());
			 assignDTO.setProdType(assign.getProdType());
			 assignDTO.setSerName(assign.getSerName());
			 assignDTO.setRegion(assign.getRegion());
			 assignDTO.setArea(assign.getArea());

			 listassignDTOs.add(assignDTO);
		 }//for
		 return listassignDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	public String deleteEmpAssign(String name)throws EmpAssignRemovalProblemException{
		EmpAssignMasterDAO dao=null;
		int count=0;
		String msg=null;
		//get DAO
		dao=EmpAssignMasterDAOFactory.getInstance();
		try{
		  count=dao.deleteEmpAssign(name);
		  if(count==0)
			 
			  msg="EmpAssign is Not Removed";
		  else
			  msg="EmpAssign is  Removed";
		}
		catch(HibernateException he){
			throw new EmpAssignRemovalProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new EmpAssignRemovalProblemException(e.getMessage());
		}
		return msg;
	}//method
	
	
}//class
