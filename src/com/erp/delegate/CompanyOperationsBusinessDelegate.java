package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.erp.dao.CompanyMasterDAO;
import com.erp.dao.CompanyMasterDAOFactory;
import com.erp.domain.CompanyMaster;
import com.erp.dto.CompanyDTO;

import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;


public class CompanyOperationsBusinessDelegate {

	public String addCompany(String compName,String compAddr,long contact,String compWeb,String compMail,int compYear  )throws InsertOperationProblemException,InternalProblemException{
		CompanyMasterDAO dao=null;
		CompanyMaster company=null;
		int compId=0;
		//use dAO
		dao=CompanyMasterDAOFactory.getInstance();
		//prepare Company obj
		company=new CompanyMaster();
		company.setCompName(compName);company.setCompAddr(compAddr);company.setContact(contact);
		company.setCompWeb(compWeb);company.setCompMail(compMail);company.setCompYear(compYear);
		//invoke method
		try{
		 compId=dao.addCompany(company);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Company Added Succesfully with Id::"+compId;
	}//method
	
	
	public List<CompanyDTO> getAllCompanies()throws InternalProblemException{
		CompanyMasterDAO dao=null;
		List<CompanyMaster> listCompany=null;
		List<CompanyDTO> listCompanyDTOs=null;
		CompanyDTO companyDTO=null;
		//get DAO
		dao=CompanyMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listCompany=dao.loadAllCompanies();	
		 //convert ListCompany to ListCompanyDTO 
		 listCompanyDTOs=new ArrayList();
		 for(CompanyMaster company:listCompany){
			 //get Each DTO class object
			 companyDTO=new CompanyDTO();
			 companyDTO.setCompId(company.getCompId());
			 companyDTO.setCompName(company.getCompName());
			 companyDTO.setCompAddr(company.getCompAddr());
			 companyDTO.setContact(company.getContact());
			 companyDTO.setCompMail(company.getCompMail());
			 companyDTO.setCompWeb(company.getCompWeb());
			 companyDTO.setCompYear(company.getCompYear());

			 listCompanyDTOs.add(companyDTO);
		 }//for
		 return listCompanyDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	
	
	
	/*public List<CompanyDTO> findCompany(int sid)throws InternalProblemException{
		CompanyMasterDAO dao=null;
		List<CompanyMaster> listCompany=null;
		List<CompanyDTO> findCompanyDTOs=null;
		CompanyDTO CompanyDTO=null;
		//get DAO
		dao=CompanyMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listCompany=dao.findCompany(sid);
		 //convert ListCompany to ListCompanyDTO 
		 findCompanyDTOs=new ArrayList();
		 for(CompanyMaster Company:listCompany){
			 //get Each DTO class object
			 CompanyDTO=new CompanyDTO();
			 CompanyDTO.setSid(Company.getSid());
			 CompanyDTO.setName(Company.getName());
			 CompanyDTO.setProvider(Company.getProvider());

			 findCompanyDTOs.add(CompanyDTO);
		 }//for
		 return findCompanyDTOs;
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
