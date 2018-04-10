package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.erp.dao.PurchaseMasterDAO;
import com.erp.dao.PurchaseMasterDAOFactory;
import com.erp.domain.PurchaseMaster;
import com.erp.domain.PurchaseQuotationMaster;
import com.erp.dto.PurchaseDTO;
import com.erp.dto.PurchaseQuotationDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;
import com.erp.errors.PurchaseRemovalProblemException;


public class PurchaseOperationsBusinessDelegate {

	public String addPurchaseEnquiry(int suppId,String suppName,String addr,long contact,
								int prodId,String prodName,String prodType,String company,int quantity,float prodCost)throws InsertOperationProblemException,InternalProblemException{
		PurchaseMasterDAO dao=null;
		PurchaseMaster purchase=null;
		int sid=0;
		//use dAO
		dao=PurchaseMasterDAOFactory.getInstance();
		//prepare Purchase obj
		purchase=new PurchaseMaster();
		purchase.setSuppId(suppId);
		purchase.setSuppName(suppName);purchase.setAddr(addr);purchase.setContact(contact);
		purchase.setProdId(prodId);
		purchase.setProdName(prodName);purchase.setProdType(prodType);purchase.setCompany(company);purchase.setQuantity(quantity);purchase.setProdCost(prodCost);
		//invoke method
		try{
		 sid=dao.addPurchaseEnquiry(purchase);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Purchase Added Succesfully with Id::"+sid;
	}//method
	
	
	public String addPurchaseQuotation(String empName,int suppId,String suppName,String addr,long contact,
			String prodName,String prodType,String company,int quantity,float prodCost,
			float prodAmount,float prodTax,float prodGross,float prodDiscount,float prodGrand)throws InsertOperationProblemException,InternalProblemException{

		PurchaseMasterDAO dao=null;
		PurchaseQuotationMaster purchase=null;
			int sid=0;
				//use dAO
					dao=PurchaseMasterDAOFactory.getInstance();
					//prepare Purchase obj
						purchase=new PurchaseQuotationMaster();
						purchase.setEmpName(empName);
						purchase.setSuppId(suppId);purchase.setSuppName(suppName);purchase.setAddr(addr);purchase.setContact(contact);
									purchase.setProdName(prodName);purchase.setProdType(prodType);purchase.setCompany(company);purchase.setQuantity(quantity);purchase.setProdCost(prodCost);
									purchase.setProdAmount(prodAmount);purchase.setProdTax(prodTax);purchase.setProdGross(prodGross);purchase.setProdDiscount(prodDiscount);purchase.setProdGrand(prodGrand);
							//invoke method
							try{
								sid=dao.addPurchaseQuotation(purchase);
							}
							catch(HibernateException he){
								throw new InsertOperationProblemException(he.getMessage());
							}
							catch(Exception e){
								throw new InternalProblemException(e.getMessage());
							}
							return " Purchase Quotation Added Succesfully with Id::"+sid;
	}//method
	
	public List<PurchaseDTO> getAllPurchases()throws InternalProblemException{
		PurchaseMasterDAO dao=null;
		List<PurchaseMaster> listpurchase=null;
		List<PurchaseDTO> listpurchaseDTOs=null;
		PurchaseDTO purchaseDTO=null;
		//get DAO
		dao=PurchaseMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listpurchase=dao.loadAllPurchases();	
		 //convert ListPurchase to ListPurchaseDTO 
		 listpurchaseDTOs=new ArrayList();
		 for(PurchaseMaster purchase:listpurchase){
			 //get Each DTO class object
			 purchaseDTO=new PurchaseDTO();
			 purchaseDTO.setEnqId(purchase.getEnqId());
			 
			 purchaseDTO.setSuppName(purchase.getSuppName());
			 purchaseDTO.setAddr(purchase.getAddr());
			 purchaseDTO.setContact(purchase.getContact());
			 
			 purchaseDTO.setProdId(purchase.getProdId());
			 purchaseDTO.setProdName(purchase.getProdName());
			 purchaseDTO.setProdType(purchase.getProdType());
			 purchaseDTO.setCompany(purchase.getCompany());
			 purchaseDTO.setQuantity(purchase.getQuantity());
			 purchaseDTO.setProdCost(purchase.getProdCost());
			 listpurchaseDTOs.add(purchaseDTO);
		 }//for
		 return listpurchaseDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	public List<PurchaseDTO> getPurchaseByProduct(String name)throws InternalProblemException{
		PurchaseMasterDAO dao=null;
		List<PurchaseMaster> listpurchase=null;
		List<PurchaseDTO> listpurchaseDTOs=null;
		PurchaseDTO purchaseDTO=null;
		//get DAO
		dao=PurchaseMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listpurchase=dao.getPurchaseByProduct(name);	
		 //convert ListPurchase to ListPurchaseDTO 
		 listpurchaseDTOs=new ArrayList();
		 for(PurchaseMaster purchase:listpurchase){
			 //get Each DTO class object
			 purchaseDTO=new PurchaseDTO();
		 purchaseDTO.setEnqId(purchase.getEnqId());
			 
			 purchaseDTO.setSuppName(purchase.getSuppName());
			 purchaseDTO.setAddr(purchase.getAddr());
			 purchaseDTO.setContact(purchase.getContact());
			 
			 purchaseDTO.setProdId(purchase.getProdId());
			 purchaseDTO.setProdName(purchase.getProdName());
			 purchaseDTO.setProdType(purchase.getProdType());
			 purchaseDTO.setCompany(purchase.getCompany());
			 purchaseDTO.setQuantity(purchase.getQuantity());
			 purchaseDTO.setProdCost(purchase.getProdCost());
			 listpurchaseDTOs.add(purchaseDTO);
		 }//for
		 return listpurchaseDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	public List<PurchaseDTO> getPurchaseBySupplier(String name)throws InternalProblemException{
		PurchaseMasterDAO dao=null;
		List<PurchaseMaster> listpurchase=null;
		List<PurchaseDTO> listpurchaseDTOs=null;
		PurchaseDTO purchaseDTO=null;
		//get DAO
		dao=PurchaseMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listpurchase=dao.getPurchaseBySupplier(name);	
		 //convert ListPurchase to ListPurchaseDTO 
		 listpurchaseDTOs=new ArrayList();
		 for(PurchaseMaster purchase:listpurchase){
			 //get Each DTO class object
			 purchaseDTO=new PurchaseDTO();
		 purchaseDTO.setEnqId(purchase.getEnqId());
			 
			 purchaseDTO.setSuppName(purchase.getSuppName());
			 purchaseDTO.setAddr(purchase.getAddr());
			 purchaseDTO.setContact(purchase.getContact());
			 
			 purchaseDTO.setProdId(purchase.getProdId());
			 purchaseDTO.setProdName(purchase.getProdName());
			 purchaseDTO.setProdType(purchase.getProdType());
			 purchaseDTO.setCompany(purchase.getCompany());
			 purchaseDTO.setQuantity(purchase.getQuantity());
			 purchaseDTO.setProdCost(purchase.getProdCost());
			 listpurchaseDTOs.add(purchaseDTO);
		 }//for
		 return listpurchaseDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	public List<PurchaseQuotationDTO> loadAllQUOTATION()throws InternalProblemException{
		PurchaseMasterDAO dao=null;
		List<PurchaseQuotationMaster> listpurchase=null;
		List<PurchaseQuotationDTO> listpurchaseDTOs=null;
		PurchaseQuotationDTO purchaseDTO=null;
		//get DAO
		dao=PurchaseMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listpurchase=dao.loadAllQUOTATION();	
		 //convert ListPurchase to ListPurchaseDTO 
		 listpurchaseDTOs=new ArrayList();
		 for(PurchaseQuotationMaster purchase:listpurchase){
			 //get Each DTO class object
			 purchaseDTO=new PurchaseQuotationDTO();
			 purchaseDTO.setId(purchase.getId());
			 purchaseDTO.setEmpName(purchase.getEmpName());
			 purchaseDTO.setSuppName(purchase.getSuppName());
			 purchaseDTO.setAddr(purchase.getAddr());
			 purchaseDTO.setContact(purchase.getContact());
			 purchaseDTO.setProdName(purchase.getProdName());
			 purchaseDTO.setProdType(purchase.getProdType());
			 purchaseDTO.setCompany(purchase.getCompany());
			 purchaseDTO.setQuantity(purchase.getQuantity());
			 purchaseDTO.setProdCost(purchase.getProdCost());
			 purchaseDTO.setProdAmount(purchase.getProdAmount());
			 purchaseDTO.setProdTax(purchase.getProdTax());
			 purchaseDTO.setProdGross(purchase.getProdGross());
			 purchaseDTO.setProdDiscount(purchase.getProdDiscount());
			 purchaseDTO.setProdGrand(purchase.getProdGrand());

			 listpurchaseDTOs.add(purchaseDTO);
		 }//for
		 return listpurchaseDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	/*public List<PurchaseQuotationDTO> editQUOTATION(int id)throws InternalProblemException{
		PurchaseMasterDAO dao=null;
		List<PurchaseQuotationMaster> listpurchase=null;
		List<PurchaseQuotationDTO> listpurchaseDTOs=null;
		PurchaseQuotationDTO purchaseDTO=null;
		//get DAO
		dao=PurchaseMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listpurchase=dao.editQuotation(id);	
		 //convert ListPurchase to ListPurchaseDTO 
		 listpurchaseDTOs=new ArrayList();
		 for(PurchaseQuotationMaster purchase:listpurchase){
			 //get Each DTO class object
			 purchaseDTO=new PurchaseQuotationDTO();
			 purchaseDTO.setId(purchase.getId());
			 purchaseDTO.setCustName(purchase.getCustName());
			 purchaseDTO.setAddr(purchase.getAddr());
			 purchaseDTO.setContact(purchase.getContact());
			 purchaseDTO.setCustReq(purchase.getCustReq());
			 purchaseDTO.setProdName(purchase.getProdName());
			 purchaseDTO.setProdType(purchase.getProdType());
			 purchaseDTO.setCompany(purchase.getCompany());
			 purchaseDTO.setQuantity(purchase.getQuantity());
			 purchaseDTO.setProdCost(purchase.getProdCost());
			 purchaseDTO.setProdAmount(purchase.getProdAmount());
			 purchaseDTO.setProdTax(purchase.getProdTax());
			 purchaseDTO.setProdGross(purchase.getProdGross());
			 purchaseDTO.setProdDiscount(purchase.getProdDiscount());
			 purchaseDTO.setProdGrand(purchase.getProdGrand());
			 purchaseDTO.setSerName(purchase.getSerName());
			 purchaseDTO.setProvider(purchase.getProvider());
			 purchaseDTO.setSercost(purchase.getSercost());
			 purchaseDTO.setSerAmount(purchase.getSerAmount());
			 purchaseDTO.setSerTax(purchase.getSerTax());
			 purchaseDTO.setSerGross(purchase.getSerGross());
			 purchaseDTO.setSerDiscount(purchase.getSerDiscount());
			 purchaseDTO.setSerGrand(purchase.getSerGrand());

			 listpurchaseDTOs.add(purchaseDTO);
		 }//for
		 return listpurchaseDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	
	
	public List<PurchaseQuotationDTO> loadAllPRODUCTQUOTATION()throws InternalProblemException{
		PurchaseMasterDAO dao=null;
		List<PurchaseQuotationMaster> listpurchase=null;
		List<PurchaseQuotationDTO> listpurchaseDTOs=null;
		PurchaseQuotationDTO purchaseDTO=null;
		//get DAO
		dao=PurchaseMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listpurchase=dao.loadAllPRODUCTQUOTATION();	
		 //convert ListPurchase to ListPurchaseDTO 
		 listpurchaseDTOs=new ArrayList();
		 for(PurchaseQuotationMaster purchase:listpurchase){
			 //get Each DTO class object
			 purchaseDTO=new PurchaseQuotationDTO();
			 purchaseDTO.setId(purchase.getId());
			 purchaseDTO.setEmpName(purchase.getEmpName());
			 purchaseDTO.setCustName(purchase.getCustName());
			 purchaseDTO.setProdName(purchase.getProdName());
			 purchaseDTO.setProdType(purchase.getProdType());
			 purchaseDTO.setCompany(purchase.getCompany());
			 purchaseDTO.setQuantity(purchase.getQuantity());
			 purchaseDTO.setProdCost(purchase.getProdCost());
			 purchaseDTO.setProdAmount(purchase.getProdAmount());
			 purchaseDTO.setProdTax(purchase.getProdTax());
			 purchaseDTO.setProdGross(purchase.getProdGross());
			 purchaseDTO.setProdDiscount(purchase.getProdDiscount());
			 purchaseDTO.setProdGrand(purchase.getProdGrand());

			 listpurchaseDTOs.add(purchaseDTO);
		 }//for
		 return listpurchaseDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
*/	
	public String deletePurchase(int id)throws PurchaseRemovalProblemException{
		PurchaseMasterDAO dao=null;
		int count=0;
		String msg=null;
		//get DAO
		dao=PurchaseMasterDAOFactory.getInstance();
		try{
		  count=dao.deletePurchase(id);
		  if(count==0)
			 
			  msg="Purchase is Not Removed";
		  else
			  msg="Purchase is  Removed";
		}
		catch(HibernateException he){
			throw new PurchaseRemovalProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new PurchaseRemovalProblemException(e.getMessage());
		}
		return msg;
	}//method
	
	public String deleteQuotation(int id)throws PurchaseRemovalProblemException{
		PurchaseMasterDAO dao=null;
		int count=0;
		String msg=null;
		//get DAO
		dao=PurchaseMasterDAOFactory.getInstance();
		try{
		  count=dao.deleteQuotation(id);
		  if(count==0)
			 
			  msg="Purchase Quotation is Not Removed";
		  else
			  msg="Purchase Quotation is  Removed";
		}
		catch(HibernateException he){
			throw new PurchaseRemovalProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new PurchaseRemovalProblemException(e.getMessage());
		}
		return msg;
	}//method
	
}//class
