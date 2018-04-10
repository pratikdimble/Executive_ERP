package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.erp.dao.LeaveMasterDAO;
import com.erp.dao.LeaveMasterDAOFactory;
import com.erp.dao.RegionMasterDAO;
import com.erp.dao.RegionMasterDAOFactory;
import com.erp.domain.LeaveMaster;
import com.erp.dto.LeaveDTO;
import com.erp.errors.LeaveRemovalProblemException;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;


public class LeaveOperationsBusinessDelegate {

	public String addLeave(int empId,String empName,String dsgn, String leaveType,String dateFrom,String dateTo,int days)throws InsertOperationProblemException,InternalProblemException{
		LeaveMasterDAO dao=null;
		LeaveMaster leave=null;
		int leaveId=0;
		//use dAO
		dao=LeaveMasterDAOFactory.getInstance();
		//prepare Leave obj
		leave=new LeaveMaster();
			leave.setEmpId(empId);leave.setEmpName(empName);leave.setDesignation(dsgn);
			leave.setLeaveType(leaveType);leave.setDateFrom(dateFrom);
			leave.setDateTo(dateTo);leave.setDays(days);leave.setStatus("Pending");
		//invoke method
		try{
		 leaveId=dao.addLeave(leave);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Leave Added Succesfully with Id::"+leaveId;
	}//method
	

	
	public List<LeaveDTO> getAllLeave()throws InternalProblemException{
		LeaveMasterDAO dao=null;
		List<LeaveMaster> listLeave=null;
		List<LeaveDTO> listLeaveDTOs=null;
		LeaveDTO leaveDTO=null;
		//get DAO
		dao=LeaveMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listLeave=dao.loadAllLeave();	
		 //convert ListLeave to ListLeaveDTO 
		 listLeaveDTOs=new ArrayList();
		 for(LeaveMaster leave:listLeave){
			 //get Each DTO class object
			 leaveDTO=new LeaveDTO();
			 leaveDTO.setLeaveId(leave.getLeaveId());
			 leaveDTO.setEmpId(leave.getEmpId());
			 leaveDTO.setEmpName(leave.getEmpName());
			 leaveDTO.setDesignation(leave.getDesignation());
			 
			 leaveDTO.setLeaveType(leave.getLeaveType());
			 leaveDTO.setDateFrom(leave.getDateFrom());
			 leaveDTO.setDateTo(leave.getDateTo());
			 leaveDTO.setDays(leave.getDays());
			 leaveDTO.setStatus(leave.getStatus());

			 listLeaveDTOs.add(leaveDTO);
		 }//for
		 return listLeaveDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	public List<LeaveDTO> getApprovedLeave()throws InternalProblemException{
		LeaveMasterDAO dao=null;
		List<LeaveMaster> listLeave=null;
		List<LeaveDTO> listLeaveDTOs=null;
		LeaveDTO leaveDTO=null;
		//get DAO
		dao=LeaveMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listLeave=dao.loadApprovedLeave();	
		 //convert ListLeave to ListLeaveDTO 
		 listLeaveDTOs=new ArrayList();
		 for(LeaveMaster leave:listLeave){
			 //get Each DTO class object
			 leaveDTO=new LeaveDTO();
			 leaveDTO.setLeaveId(leave.getLeaveId());
			 leaveDTO.setEmpId(leave.getEmpId());
			 leaveDTO.setEmpName(leave.getEmpName());
			 leaveDTO.setDesignation(leave.getDesignation());
			 
			 leaveDTO.setLeaveType(leave.getLeaveType());
			 leaveDTO.setDateFrom(leave.getDateFrom());
			 leaveDTO.setDateTo(leave.getDateTo());
			 leaveDTO.setDays(leave.getDays());
			 leaveDTO.setStatus(leave.getStatus());

			 listLeaveDTOs.add(leaveDTO);
		 }//for
		 return listLeaveDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method

	public String deleteLeave(int id)throws LeaveRemovalProblemException{
		LeaveMasterDAO dao=null;
		int count=0;
		String msg=null;
		//get DAO
		dao=LeaveMasterDAOFactory.getInstance();
		try{
		  count=dao.deleteLeave(id);
		  if(count==0)
			 
			  msg="Leave is Not Removed";
		  else
			  msg="Leave is  Removed";
		}
		catch(HibernateException he){
			throw new LeaveRemovalProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new LeaveRemovalProblemException(e.getMessage());
		}
		return msg;
	}//method
	public String updateStatus(int id,String Status)throws InternalProblemException{
		LeaveMasterDAO dao=null;
		int count=0;
		String msg=null;
		//get DAO
		dao=LeaveMasterDAOFactory.getInstance();
		try{
		  count=dao.updateStatus(id,Status);
		  if(count==0)
			 
			  msg="ID Number"+id+"Leave is Not Updated";
		  else
			  msg="ID Number"+id+"Leave is Updated";
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
		return msg;
	}//method
	public List<LeaveDTO> getUserLeave(int empId)throws InternalProblemException{
		LeaveMasterDAO dao=null;
		List<LeaveMaster> listLeave=null;
		List<LeaveDTO> listLeaveDTOs=null;
		LeaveDTO leaveDTO=null;
		//get DAO
		dao=LeaveMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listLeave=dao.loadUserLeave(empId);	
		 //convert ListLeave to ListLeaveDTO 
		 listLeaveDTOs=new ArrayList();
		 for(LeaveMaster leave:listLeave){
			 //get Each DTO class object
			 leaveDTO=new LeaveDTO();
			 leaveDTO.setLeaveId(leave.getLeaveId());
			 leaveDTO.setEmpId(leave.getEmpId());
			 leaveDTO.setEmpName(leave.getEmpName());
			 leaveDTO.setDesignation(leave.getDesignation());
			 
			 leaveDTO.setLeaveType(leave.getLeaveType());
			 leaveDTO.setDateFrom(leave.getDateFrom());
			 leaveDTO.setDateTo(leave.getDateTo());
			 leaveDTO.setDays(leave.getDays());
			 leaveDTO.setStatus(leave.getStatus());

			 listLeaveDTOs.add(leaveDTO);
		 }//for
		 return listLeaveDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
}//class
