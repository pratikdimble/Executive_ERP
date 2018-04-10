package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.erp.dao.VendorMasterDAO;
import com.erp.dao.VendorMasterDAOFactory;
import com.erp.domain.VendorMaster;
import com.erp.dto.VendorDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;
import com.erp.errors.VendorRemovalProblemException;


public class VendorOperationsBusinessDelegate {

	public String addVendor(String vendorName, String website, String vendorCountry, String vendorState,
			String vendorCity, int pin, String vendorAddr, long mobile, String vendorMail, String business) throws InsertOperationProblemException,InternalProblemException{

		VendorMasterDAO dao=null;
		VendorMaster vendor=null;
		int vendorId=0;
		//use dAO
		dao=VendorMasterDAOFactory.getInstance();
		//prepare Vendor obj
		vendor=new VendorMaster();
		vendor.setVendorName(vendorName);vendor.setWebsite(website);
		vendor.setVendorCountry(vendorCountry);vendor.setVendorState(vendorState);vendor.setVendorCity(vendorCity);vendor.setPin(pin);
		vendor.setVendorAddr(vendorAddr);vendor.setMobile(mobile);vendor.setVendorMail(vendorMail);
		vendor.setBusiness(business);

		//invoke method
		try{
		 vendorId=dao.addVendor(vendor);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Vendor Added Succesfully with Id::"+vendorId;
	}//method
	
	public String deleteVendor(int vendorId) throws VendorRemovalProblemException,InternalProblemException{

		VendorMasterDAO dao=null;
		VendorMaster vendor=null;
		
		//use dAO
		dao=VendorMasterDAOFactory.getInstance();
		//invoke method
		try{
		 vendorId=dao.deleteVendor(vendorId);
		}
		catch(HibernateException he){
			throw new VendorRemovalProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Vendor Removed Succesfully with Id::"+vendorId;
	}//method
	
	public String updateVendor(int vendorId, String vendorName, String website, String vendorCountry, String vendorState,
			String vendorCity, int pin, String vendorAddr, long mobile, String vendorMail, String business) throws InsertOperationProblemException,InternalProblemException{

				VendorMasterDAO dao=null;
				VendorMaster vendor=null;
//int vendorId=0,loginId=0;
					//use dAO
						dao=VendorMasterDAOFactory.getInstance();

						//invoke method
							try{
									vendorId=dao.updateVendor(vendorId, vendorName,website,vendorCountry,vendorState,vendorCity, pin, vendorAddr,mobile, vendorMail, business);
							}
							catch(HibernateException he){
								throw new InsertOperationProblemException(he.getMessage());
							}
							catch(Exception e){
								throw new InternalProblemException(e.getMessage());
							}
							return " Vendor Details Successfully Updated::"+vendorId;
	}//method
	

	public List<VendorDTO> getAllVendor()throws InternalProblemException{
		VendorMasterDAO dao=null;
		List<VendorMaster> listVendor=null;
		List<VendorDTO> listVendorDTOs=null;
		VendorDTO vendorDTO=null;
		//get DAO
		dao=VendorMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listVendor=dao.loadAllVendor();	
		 //convert ListVendor to ListVendorDTO 
		 listVendorDTOs=new ArrayList();
		 for(VendorMaster vendor:listVendor){
			 //get Each DTO class object
			 vendorDTO=new VendorDTO();
			 vendorDTO.setVendorId(vendor.getVendorId());
			 vendorDTO.setVendorName(vendor.getVendorName());
			 vendorDTO.setWebsite(vendor.getWebsite());
			 
			 vendorDTO.setVendorCountry(vendor.getVendorCountry());
			 vendorDTO.setVendorState(vendor.getVendorState());
			 vendorDTO.setVendorCity(vendor.getVendorCity());
			 vendorDTO.setPin( vendor.getPin());
			 
			 vendorDTO.setVendorAddr( vendor.getVendorAddr());
			 vendorDTO.setMobile( vendor.getMobile());
			 vendorDTO.setVendorMail( vendor.getVendorMail());
			
			
			 vendorDTO.setBusiness(vendor.getBusiness());

			 listVendorDTOs.add(vendorDTO);
		 }//for
		 return listVendorDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	public List<VendorDTO> getVendor(String name)throws InternalProblemException{
		VendorMasterDAO dao=null;
		List<VendorMaster> listVendor=null;
		List<VendorDTO> listVendorDTOs=null;
		VendorDTO vendorDTO=null;
		//get DAO
		dao=VendorMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listVendor=dao.getVendor(name);	
		 //convert ListVendor to ListVendorDTO 
		 listVendorDTOs=new ArrayList();
		 for(VendorMaster vendor:listVendor){
			 //get Each DTO class object
			 vendorDTO=new VendorDTO();
			 vendorDTO.setVendorId(vendor.getVendorId());
			 vendorDTO.setVendorName(vendor.getVendorName());
			 vendorDTO.setWebsite(vendor.getWebsite());
			 
			 vendorDTO.setVendorCountry(vendor.getVendorCountry());
			 vendorDTO.setVendorState(vendor.getVendorState());
			 vendorDTO.setVendorCity(vendor.getVendorCity());
			 vendorDTO.setPin( vendor.getPin());
			 
			 vendorDTO.setVendorAddr( vendor.getVendorAddr());
			 vendorDTO.setMobile( vendor.getMobile());
			 vendorDTO.setVendorMail( vendor.getVendorMail());
			
			
			 vendorDTO.setBusiness(vendor.getBusiness());

			 listVendorDTOs.add(vendorDTO);
		 }//for
		 return listVendorDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method

	
	
}//class
