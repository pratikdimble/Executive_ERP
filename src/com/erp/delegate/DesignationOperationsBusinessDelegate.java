package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.erp.dao.DesignationMasterDAO;
import com.erp.dao.DesignationMasterDAOFactory;
import com.erp.domain.DesignationMaster;
import com.erp.dto.DesignationDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;


public class DesignationOperationsBusinessDelegate {

	public String addDesignation(String dsgnName)throws InsertOperationProblemException,InternalProblemException{
		DesignationMasterDAO dao=null;
		DesignationMaster dsgn=null;
		int dsgnId=0;
		//use dAO
		dao=DesignationMasterDAOFactory.getInstance();
		//prepare Designation obj
		dsgn=new DesignationMaster();
		dsgn.setDsgnName(dsgnName);
		//invoke method
		try{
		 dsgnId=dao.addDesignation(dsgn);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Designation Added Succesfully with Id::"+dsgnId;
	}//method
	
	
	public List<DesignationDTO> getAllDesignation()throws InternalProblemException{
		DesignationMasterDAO dao=null;
		List<DesignationMaster> listDesignation=null;
		List<DesignationDTO> listDesignationDTOs=null;
		DesignationDTO dsgnDTO=null;
		//get DAO
		dao=DesignationMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listDesignation=dao.loadAllDesignations();	
		 //convert ListDesignation to ListDesignationDTO 
		 listDesignationDTOs=new ArrayList();
		 for(DesignationMaster dsgn:listDesignation){
			 //get Each DTO class object
			 dsgnDTO=new DesignationDTO();
			 dsgnDTO.setDsgnId(dsgn.getDsgnId());
			 dsgnDTO.setDsgnName(dsgn.getDsgnName());
			 

			 listDesignationDTOs.add(dsgnDTO);
		 }//for
		 return listDesignationDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method

	
}//class
