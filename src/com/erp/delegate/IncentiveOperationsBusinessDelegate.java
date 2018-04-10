package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.erp.dao.IncentiveMasterDAO;
import com.erp.dao.IncentiveMasterDAOFactory;
import com.erp.domain.IncentiveMaster;
import com.erp.dto.IncentiveDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;

import oracle.net.aso.i;

import com.erp.errors.IncentiveRemovalProblemException;


public class IncentiveOperationsBusinessDelegate {

	public String addIncentiveProduct(int empId,String empName,String incDate,String prodName,String prodType,float incentivepp,int target,int achieved,int workdone,float amount)throws InsertOperationProblemException,InternalProblemException{
		IncentiveMasterDAO dao=null;
		IncentiveMaster incentive=null;
		int pid=0;
		//use dAO
		dao=IncentiveMasterDAOFactory.getInstance();
		//prepare Incentive object
		incentive=new IncentiveMaster();
		incentive.setIncDate(incDate); incentive.setEmpName(empName);incentive.setProdType(prodType);incentive.setProdName(prodName);
		incentive.setTarget(target);incentive.setIncentive(incentivepp);incentive.setAchieved(achieved);incentive.setWorkdone(workdone);incentive.setAmount(amount);
		incentive.setSerName("Null");incentive.setProvider("Null");
		//invoke method
		try{
		 pid=dao.addIncentive(empId,incentive);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Incentive Added Succesfully with Id::"+pid;
	}//method
	public String addIncentiveService(int empId,String empName,String incDate,String serName,String provider,float incentivepp,int target,int achieved,int workdone,float amount)throws InsertOperationProblemException,InternalProblemException{
		IncentiveMasterDAO dao=null;
		IncentiveMaster incentive=null;
		int pid=0;
		//use dAO
		dao=IncentiveMasterDAOFactory.getInstance();
		//prepare Incentive object
		incentive=new IncentiveMaster();
		incentive.setIncDate(incDate); incentive.setEmpName(empName);incentive.setProdType("Null");incentive.setProdName("Null");
		incentive.setTarget(target);incentive.setIncentive(incentivepp);incentive.setAchieved(achieved);incentive.setWorkdone(workdone);incentive.setAmount(amount);
		incentive.setSerName(serName);incentive.setProvider(provider);
		//invoke method
		try{
		 pid=dao.addIncentive(empId,incentive);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Incentive Added Succesfully with Id::"+pid;
	}//method
	
	
	public List<IncentiveDTO> getAllIncentives()throws InternalProblemException{
		IncentiveMasterDAO dao=null;
		List<IncentiveMaster> listincentive=null;
		List<IncentiveDTO> listincentiveDTOs=null;
		IncentiveDTO incentiveDTO=null;
		//get DAO
		dao=IncentiveMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listincentive=dao.loadAllIncentives();	
		 //convert ListIncentive to ListIncentiveDTO 
		 listincentiveDTOs=new ArrayList();
		 for(IncentiveMaster incentive:listincentive){
			 //get Each DTO class object
			 incentiveDTO=new IncentiveDTO();
			 incentiveDTO.setIncId(incentive.getIncId());
			 incentiveDTO.setIncDate(incentive.getIncDate());
			 incentiveDTO.setEmpName(incentive.getEmpName());
			 
			 incentiveDTO.setProdName(incentive.getProdName());
			 incentiveDTO.setProdType(incentive.getProdType());
			 
			 incentiveDTO.setSerName(incentive.getSerName());
			 incentiveDTO.setProvider(incentive.getProvider());
			 
			 incentiveDTO.setTarget(incentive.getTarget());
			 incentiveDTO.setIncentive(incentive.getIncentive());
			 incentiveDTO.setAchieved(incentive.getAchieved());
			 incentiveDTO.setWorkdone(incentive.getWorkdone());
			 incentiveDTO.setAmount(incentive.getAmount());
			 
			 listincentiveDTOs.add(incentiveDTO);
		 }//for
		 return listincentiveDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	public List<IncentiveDTO> getIncentive(String empName)throws InternalProblemException{
		IncentiveMasterDAO dao=null;
		List<IncentiveMaster> listincentive=null;
		List<IncentiveDTO> listincentiveDTOs=null;
		IncentiveDTO incentiveDTO=null;
		//get DAO
		dao=IncentiveMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listincentive=dao.getIncentive(empName);	
		 //convert ListIncentive to ListIncentiveDTO 
		 listincentiveDTOs=new ArrayList();
		 for(IncentiveMaster incentive:listincentive){
			 //get Each DTO class object
			 incentiveDTO=new IncentiveDTO();
			 incentiveDTO.setIncId(incentive.getIncId());
			 incentiveDTO.setIncDate(incentive.getIncDate());
			 incentiveDTO.setEmpName(incentive.getEmpName());
			 
			 incentiveDTO.setProdName(incentive.getProdName());
			 incentiveDTO.setProdType(incentive.getProdType());
			 
			 incentiveDTO.setSerName(incentive.getSerName());
			 incentiveDTO.setProvider(incentive.getProvider());
			 
			 incentiveDTO.setTarget(incentive.getTarget());
			 incentiveDTO.setIncentive(incentive.getIncentive());
			 incentiveDTO.setAchieved(incentive.getAchieved());
			 incentiveDTO.setWorkdone(incentive.getWorkdone());
			 incentiveDTO.setAmount(incentive.getAmount());

			 listincentiveDTOs.add(incentiveDTO);
		 }//for
		 return listincentiveDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	public String deleteIncentive(int id)throws IncentiveRemovalProblemException{
		IncentiveMasterDAO dao=null;
		int count=0;
		//get DAO
		dao=IncentiveMasterDAOFactory.getInstance();
		try{
		  count=dao.deleteIncentive(id);
		  if(count==0)
			  return "Incentive is Not Deleted";
		  else
			  return "Incentive Is Deleted";
		}
		catch(HibernateException he){
			throw new IncentiveRemovalProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new IncentiveRemovalProblemException(e.getMessage());
		}
	}//method
	
}//class
