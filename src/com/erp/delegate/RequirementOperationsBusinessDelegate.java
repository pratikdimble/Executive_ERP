package com.erp.delegate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;

import com.erp.dao.AreaMasterDAO;
import com.erp.dao.AreaMasterDAOFactory;
import com.erp.dao.LeaveMasterDAO;
import com.erp.dao.LeaveMasterDAOFactory;
import com.erp.dao.RequirementMasterDAO;
import com.erp.dao.RequirementMasterDAOFactory;
import com.erp.dao.RequirementMasterDAO;
import com.erp.dao.RequirementMasterDAOFactory;
import com.erp.domain.AreaMaster;
import com.erp.domain.CustomerMaster;
import com.erp.domain.EmployeeMaster;
import com.erp.domain.RequirementMaster;
import com.erp.domain.RequirementMaster;
import com.erp.dto.RequirementDTO;
import com.erp.dto.RequirementDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;

public class RequirementOperationsBusinessDelegate {

	public String addRequirement(int empid,int custid,String empName,String custName,String dsgn,String prodName,String prodType,String company,int quantity,int stock)throws InsertOperationProblemException,InternalProblemException{
		RequirementMasterDAO dao=null;
		RequirementMaster enquiry=null;
		//AreaMasterDAO areadao=null;
		AreaMaster area=null;
		int enquiryId=0;
		//use dAO
		dao=RequirementMasterDAOFactory.getInstance();
		//areadao=AreaMasterDAOFactory.getInstance();
		//prepare Requirement obj
		enquiry=new RequirementMaster();
		enquiry.setEmpName(empName);enquiry.setCustName(custName);enquiry.setDsgn(dsgn);
		enquiry.setProdName(prodName);enquiry.setProdType(prodType);enquiry.setProdCompany(company);
		enquiry.setQuantity(quantity);
		enquiry.setStatus("Pending");
		
		//invoke method
		try{
			enquiryId=(Integer)dao.addRequirement(empid, custid, enquiry);
			dao.deliverStock(quantity,prodName,prodType,company,stock);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Requirement Added Succesfully with Id::"+enquiryId;
	}//method
	
	public List<RequirementDTO> getUserRequirement(String empName)throws InternalProblemException{
		RequirementMasterDAO dao=null;
		List<RequirementMaster> listRequirement=null;
		List<RequirementDTO> listRequirementDTOs=null;
		RequirementDTO enquiryDTO=null;
		//get DAO
		dao=RequirementMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listRequirement=dao.loadPendingRequirements(empName);	
		 //convert ListRequirement to ListRequirementDTO 
		 listRequirementDTOs=new ArrayList();
		 for(RequirementMaster enquiry:listRequirement){
			 //get Each DTO class object
			 enquiryDTO=new RequirementDTO();
			 enquiryDTO.setReqId(enquiry.getReqId());
			 enquiryDTO.setCustName(enquiry.getCustName());
			 enquiryDTO.setProdName(enquiry.getProdName());
			 enquiryDTO.setProdType(enquiry.getProdType());
			 enquiryDTO.setProdCompany(enquiry.getProdCompany());
			 enquiryDTO.setQuantity(enquiry.getQuantity());
			 enquiryDTO.setStatus(enquiry.getStatus());

			 listRequirementDTOs.add(enquiryDTO);
		 }//for
		 return listRequirementDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	public String updateStatusDeliver(int id,String Status)throws InternalProblemException{
		RequirementMasterDAO dao=null;
		int count=0;
		String msg=null;
		//get DAO
		dao=RequirementMasterDAOFactory.getInstance();
		try{
		  count=dao.updateStatusDeliver(id, Status);
		  if(count==0)
			 
			  msg="ID Number"+id+"Requirement is Not Delivered";
		  else
			  msg="ID Number"+id+"Requirement is Delivered";
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
		return msg;
	}//method
	
	public String updateStatusCancel(int id,String Status,String prodName,String prodType,String company,int quantity,int stock)throws InternalProblemException{
		RequirementMasterDAO dao=null;
		int count=0;
		String msg=null;
		//get DAO
		dao=RequirementMasterDAOFactory.getInstance();
		try{
		  count=dao.updateStatusCancel(id, Status, quantity, prodName, prodType, company, stock);;
		  if(count==0)
			 
			  msg="ID Number"+id+"Requirement is not Canceled";
		  else
			  msg="ID Number"+id+"Requirement is Canceled";
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
		return msg;
	}//method
	
	public List<RequirementDTO> getAllRequirements()throws InternalProblemException{
		RequirementMasterDAO dao=null;
		List<RequirementMaster> listRequirement=null;
		List<RequirementDTO> listRequirementDTOs=null;
		RequirementDTO enquiryDTO=null;
		//get DAO
		dao=RequirementMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listRequirement=dao.loadAllRequirements();	
		 //convert ListRequirement to ListRequirementDTO 
		 listRequirementDTOs=new ArrayList();
		 for(RequirementMaster enquiry:listRequirement){
			 //get Each DTO class object
			 enquiryDTO=new RequirementDTO();
			 enquiryDTO.setReqId(enquiry.getReqId());
			 enquiryDTO.setEmpName(enquiry.getEmpName());
			 enquiryDTO.setCustName(enquiry.getCustName());
			 enquiryDTO.setDsgn(enquiry.getDsgn());
			 enquiryDTO.setProdName(enquiry.getProdName());
			 enquiryDTO.setProdType(enquiry.getProdType());
			 enquiryDTO.setProdCompany(enquiry.getProdCompany());
			 enquiryDTO.setQuantity(enquiry.getQuantity());
			 enquiryDTO.setStatus(enquiry.getStatus());

			 listRequirementDTOs.add(enquiryDTO);
		 }//for
		 return listRequirementDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	
	
	/*public List<RequirementDTO> findRequirement(int sid)throws InternalProblemException{
		RequirementMasterDAO dao=null;
		List<RequirementMaster> listRequirement=null;
		List<RequirementDTO> findRequirementDTOs=null;
		RequirementDTO RequirementDTO=null;
		//get DAO
		dao=RequirementMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listRequirement=dao.findRequirement(sid);
		 //convert ListRequirement to ListRequirementDTO 
		 findRequirementDTOs=new ArrayList();
		 for(RequirementMaster Requirement:listRequirement){
			 //get Each DTO class object
			 RequirementDTO=new RequirementDTO();
			 RequirementDTO.setSid(Requirement.getSid());
			 RequirementDTO.setName(Requirement.getName());
			 RequirementDTO.setProvider(Requirement.getProvider());

			 findRequirementDTOs.add(RequirementDTO);
		 }//for
		 return findRequirementDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	*/
	
}//class
