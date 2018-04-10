package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.erp.dao.BranchMasterDAO;
import com.erp.dao.BranchMasterDAOFactory;
import com.erp.domain.BranchMaster;
import com.erp.dto.BranchDTO;
import com.erp.errors.BranchRemovalProblemException;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;


public class BranchOperationsBusinessDelegate {

	public String addBranch(String bankName,String branchName, String description)throws InsertOperationProblemException,InternalProblemException{
		BranchMasterDAO dao=null;
		BranchMaster branch=null;
		int branchId=0;
		//use dAO
		dao=BranchMasterDAOFactory.getInstance();
		//prepare Branch obj
		branch=new BranchMaster();
		branch.setBankName(bankName);
		branch.setBranchName(branchName);
		branch.setDescription(description);
		//invoke method
		try{
		 branchId=dao.addBranch(branch);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Branch Added Succesfully with Id::"+branchId;
	}//method
	
	
	public List<BranchDTO> getAllBranch()throws InternalProblemException{
		BranchMasterDAO dao=null;
		List<BranchMaster> listBranch=null;
		List<BranchDTO> listBranchDTOs=null;
		BranchDTO branchDTO=null;
		//get DAO
		dao=BranchMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listBranch=dao.loadAllBranch();	
		 //convert ListBranch to ListBranchDTO 
		 listBranchDTOs=new ArrayList();
		 for(BranchMaster branch:listBranch){
			 //get Each DTO class object
			 branchDTO=new BranchDTO();
			 branchDTO.setBranchId(branch.getBranchId());
			 branchDTO.setBankName(branch.getBankName());
			 branchDTO.setBranchName(branch.getBranchName());
			 branchDTO.setDescription(branch.getDescription());
			 

			 listBranchDTOs.add(branchDTO);
		 }//for
		 return listBranchDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	public List<BranchDTO> getBranch(String name)throws InternalProblemException{
		BranchMasterDAO dao=null;
		List<BranchMaster> listBranch=null;
		List<BranchDTO> listBranchDTOs=null;
		BranchDTO branchDTO=null;
		//get DAO
		dao=BranchMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listBranch=dao.getBranch(name);	
		 //convert ListBranch to ListBranchDTO 
		 listBranchDTOs=new ArrayList();
		 for(BranchMaster branch:listBranch){
			 //get Each DTO class object
			 branchDTO=new BranchDTO();
			 branchDTO.setBranchId(branch.getBranchId());
			 branchDTO.setBankName(branch.getBankName());
			 branchDTO.setBranchName(branch.getBranchName());
			 branchDTO.setDescription(branch.getDescription());
			 

			 listBranchDTOs.add(branchDTO);
		 }//for
		 return listBranchDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	public String deleteBranch(String name)throws BranchRemovalProblemException{
		BranchMasterDAO dao=null;
		int count=0;
		String msg=null;
		//get DAO
		dao=BranchMasterDAOFactory.getInstance();
		try{
		  count=dao.deleteBranch(name);
		  if(count==0)
			 
			  msg="Branch is Not Removed";
		  else
			  msg="Branch is  Removed";
		}
		catch(HibernateException he){
			throw new BranchRemovalProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new BranchRemovalProblemException(e.getMessage());
		}
		return msg;
	}//method
	
	
	
	
	/*public List<BranchDTO> findBranch(int sid)throws InternalProblemException{
		BranchMasterDAO dao=null;
		List<BranchMaster> listBranch=null;
		List<BranchDTO> findBranchDTOs=null;
		BranchDTO BranchDTO=null;
		//get DAO
		dao=BranchMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listBranch=dao.findBranch(sid);
		 //convert ListBranch to ListBranchDTO 
		 findBranchDTOs=new ArrayList();
		 for(BranchMaster Branch:listBranch){
			 //get Each DTO class object
			 BranchDTO=new BranchDTO();
			 BranchDTO.setSid(Branch.getSid());
			 BranchDTO.setName(Branch.getName());
			 BranchDTO.setProvider(Branch.getProvider());

			 findBranchDTOs.add(BranchDTO);
		 }//for
		 return findBranchDTOs;
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
