package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.erp.dao.DepartmentMasterDAO;
import com.erp.dao.DepartmentMasterDAOFactory;
import com.erp.domain.DepartmentMaster;
import com.erp.dto.DepartmentDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;


public class DepartmentOperationsBusinessDelegate {

	public String addDepartment(String deptName)throws InsertOperationProblemException,InternalProblemException{
		DepartmentMasterDAO dao=null;
		DepartmentMaster dept=null;
		int deptId=0;
		//use dAO
		dao=DepartmentMasterDAOFactory.getInstance();
		//prepare Department obj
		dept=new DepartmentMaster();
		dept.setDeptName(deptName);
		//invoke method
		try{
		 deptId=dao.addDepartment(dept);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Department Added Succesfully with Id::"+deptId;
	}//method
	
	
	public List<DepartmentDTO> getAllDepartment()throws InternalProblemException{
		DepartmentMasterDAO dao=null;
		List<DepartmentMaster> listDepartment=null;
		List<DepartmentDTO> listDepartmentDTOs=null;
		DepartmentDTO deptDTO=null;
		//get DAO
		dao=DepartmentMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listDepartment=dao.loadAllDepartments();	
		 //convert ListDepartment to ListDepartmentDTO 
		 listDepartmentDTOs=new ArrayList();
		 for(DepartmentMaster dept:listDepartment){
			 //get Each DTO class object
			 deptDTO=new DepartmentDTO();
			 deptDTO.setDeptId(dept.getDeptId());
			 deptDTO.setDeptName(dept.getDeptName());
			 

			 listDepartmentDTOs.add(deptDTO);
		 }//for
		 return listDepartmentDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method

	
}//class
