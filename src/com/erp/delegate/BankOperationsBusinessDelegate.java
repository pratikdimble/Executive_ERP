package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.erp.dao.BankMasterDAO;
import com.erp.dao.BankMasterDAOFactory;
import com.erp.domain.BankMaster;
import com.erp.dto.BankDTO;

import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;


public class BankOperationsBusinessDelegate {

	public String addBank(String bankName)throws InsertOperationProblemException,InternalProblemException{
		BankMasterDAO dao=null;
		BankMaster bank=null;
		int bankId=0;
		//use dAO
		dao=BankMasterDAOFactory.getInstance();
		//prepare Bank obj
		bank=new BankMaster();
		bank.setBankName(bankName);
		//invoke method
		try{
		 bankId=dao.addBank(bank);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Bank Added Succesfully with Id::"+bankId;
	}//method
	
	
	public List<BankDTO> getAllCompanies()throws InternalProblemException{
		BankMasterDAO dao=null;
		List<BankMaster> listBank=null;
		List<BankDTO> listBankDTOs=null;
		BankDTO bankDTO=null;
		//get DAO
		dao=BankMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listBank=dao.loadAllBanks();	
		 //convert ListBank to ListBankDTO 
		 listBankDTOs=new ArrayList();
		 for(BankMaster bank:listBank){
			 //get Each DTO class object
			 bankDTO=new BankDTO();
			 bankDTO.setBankId(bank.getBankId());
			 bankDTO.setBankName(bank.getBankName());
			 

			 listBankDTOs.add(bankDTO);
		 }//for
		 return listBankDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	
	
	
	/*public List<BankDTO> findBank(int sid)throws InternalProblemException{
		BankMasterDAO dao=null;
		List<BankMaster> listBank=null;
		List<BankDTO> findBankDTOs=null;
		BankDTO BankDTO=null;
		//get DAO
		dao=BankMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listBank=dao.findBank(sid);
		 //convert ListBank to ListBankDTO 
		 findBankDTOs=new ArrayList();
		 for(BankMaster Bank:listBank){
			 //get Each DTO class object
			 BankDTO=new BankDTO();
			 BankDTO.setSid(Bank.getSid());
			 BankDTO.setName(Bank.getName());
			 BankDTO.setProvider(Bank.getProvider());

			 findBankDTOs.add(BankDTO);
		 }//for
		 return findBankDTOs;
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
