package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.erp.dao.SaleMasterDAO;
import com.erp.dao.SaleMasterDAOFactory;
import com.erp.domain.SaleMaster;
import com.erp.domain.SaleQuotationMaster;
import com.erp.dto.SaleDTO;
import com.erp.dto.SaleQuotationDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;
import com.erp.errors.SaleRemovalProblemException;


public class SaleOperationsBusinessDelegate {

	public String addSaleEnquiry(String empName,String design,int custId,String custName,String addr,long contact,String custReq,
								String prodName,String prodType,String company,int quantity,float prodCost,
								String serName,String provider,float serCost)throws InsertOperationProblemException,InternalProblemException{
		SaleMasterDAO dao=null;
		SaleMaster sale=null;
		int sid=0;
		//use dAO
		dao=SaleMasterDAOFactory.getInstance();
		//prepare Sale obj
		sale=new SaleMaster();
		sale.setEmpName(empName);sale.setDesign(design);
		sale.setCustName(custName);sale.setAddr(addr);sale.setContact(contact);
		sale.setCustReq(custReq);
		 if(custReq.equalsIgnoreCase("Product Only")){
		sale.setProdName(prodName);sale.setProdType(prodType);sale.setCompany(company);sale.setQuantity(quantity);sale.setProdCost(prodCost);
		sale.setSerName("NULL");sale.setProvider("NULL");sale.setSerCost(00);
		 }
		 		else if(custReq.equalsIgnoreCase("Service Only")){
				sale.setProdName("NULL");sale.setProdType("NULL");sale.setCompany("NULL");sale.setQuantity(00);sale.setProdCost(00);
				sale.setSerName(serName);sale.setProvider(provider);sale.setSerCost(serCost);
				 }
		 		else
		 		{
				sale.setProdName(prodName);sale.setProdType(prodType);sale.setCompany(company);sale.setQuantity(quantity);sale.setProdCost(prodCost);
				sale.setSerName(serName);sale.setProvider(provider);sale.setSerCost(serCost);
				 }
		//invoke method
		try{
		 sid=dao.addSaleEnquiry(sale,custId);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Sale Added Succesfully with Id::"+sid;
	}//method
	
	
	public String addSaleQuotation(String empName,String design,int custId,String custName,String addr,long contact,String custReq,
			String prodName,String prodType,String company,int quantity,float prodCost,
			String serName,String provider,float sercost,
			float prodAmount,float prodTax,float prodGross,float prodDiscount,float prodGrand,
			float serAmount,float serTax,float serGross,float serDiscount,float serGrand)throws InsertOperationProblemException,InternalProblemException{

		SaleMasterDAO dao=null;
		SaleQuotationMaster sale=null;
			int sid=0;
				//use dAO
					dao=SaleMasterDAOFactory.getInstance();
					//prepare Sale obj
						sale=new SaleQuotationMaster();
						sale.setEmpName(empName);sale.setDesign(design);
						sale.setCustId(custId);sale.setCustName(custName);sale.setAddr(addr);sale.setContact(contact);
						sale.setCustReq(custReq);
							if(custReq.equalsIgnoreCase("Product Only")){
									sale.setProdName(prodName);sale.setProdType(prodType);sale.setCompany(company);sale.setQuantity(quantity);sale.setProdCost(prodCost);
									sale.setProdAmount(prodAmount);sale.setProdTax(prodTax);sale.setProdGross(prodGross);sale.setProdDiscount(prodDiscount);sale.setProdGrand(prodGrand);
									sale.setSerName("NULL");sale.setProvider("NULL");sale.setSercost(00);
									sale.setSerAmount(00);sale.setSerTax(00);sale.setSerGross(00);sale.setSerDiscount(00);sale.setSerGrand(00);
							}
							else if(custReq.equalsIgnoreCase("Service Only")){
								sale.setProdName("NULL");sale.setProdType("NULL");sale.setCompany("NULL");sale.setQuantity(00);sale.setProdCost(00);
								sale.setProdAmount(00);sale.setProdTax(00);sale.setProdGross(00);sale.setProdDiscount(00);sale.setProdGrand(00);
								sale.setSerName(serName);sale.setProvider(provider);sale.setSercost(sercost);
								sale.setSerAmount(serAmount);sale.setSerTax(serTax);sale.setSerGross(serGross);sale.setSerDiscount(serDiscount);sale.setSerGrand(serGrand);
							}
							else
							{
								sale.setProdName(prodName);sale.setProdType(prodType);sale.setCompany(company);sale.setQuantity(quantity);sale.setProdCost(prodCost);
								sale.setProdAmount(prodAmount);sale.setProdTax(prodTax);sale.setProdGross(prodGross);sale.setProdDiscount(prodDiscount);sale.setProdGrand(prodGrand);
								sale.setSerName(serName);sale.setProvider(provider);sale.setSercost(sercost);
								sale.setSerAmount(serAmount);sale.setSerTax(serTax);sale.setSerGross(serGross);sale.setSerDiscount(serDiscount);sale.setSerGrand(serGrand);
							}
							//invoke method
							try{
								sid=dao.addSaleQuotation(sale);
							}
							catch(HibernateException he){
								throw new InsertOperationProblemException(he.getMessage());
							}
							catch(Exception e){
								throw new InternalProblemException(e.getMessage());
							}
							return " Sale Quotation Added Succesfully with Id::"+sid;
	}//method
	
	public List<SaleDTO> getAllSales()throws InternalProblemException{
		SaleMasterDAO dao=null;
		List<SaleMaster> listsale=null;
		List<SaleDTO> listsaleDTOs=null;
		SaleDTO saleDTO=null;
		//get DAO
		dao=SaleMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listsale=dao.loadAllSales();	
		 //convert ListSale to ListSaleDTO 
		 listsaleDTOs=new ArrayList();
		 for(SaleMaster sale:listsale){
			 //get Each DTO class object
			 saleDTO=new SaleDTO();
			 saleDTO.setId(sale.getId());
			 saleDTO.setEmpName(sale.getEmpName());
			 saleDTO.setDesign(sale.getDesign());
			 saleDTO.setCustName(sale.getCustName());
			 saleDTO.setAddr(sale.getAddr());
			 saleDTO.setContact(sale.getContact());
			 saleDTO.setCustReq(sale.getCustReq());
			 saleDTO.setProdName(sale.getProdName());
			 saleDTO.setProdType(sale.getProdType());
			 saleDTO.setCompany(sale.getCompany());
			 saleDTO.setQuantity(sale.getQuantity());
			 saleDTO.setProdCost(sale.getProdCost());
			 saleDTO.setSerName(sale.getSerName());
			 saleDTO.setProvider(sale.getProvider());
			 saleDTO.setSerCost(sale.getSerCost());
			 listsaleDTOs.add(saleDTO);
		 }//for
		 return listsaleDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	public List<SaleDTO> getSale(String name)throws InternalProblemException{
		SaleMasterDAO dao=null;
		List<SaleMaster> listsale=null;
		List<SaleDTO> listsaleDTOs=null;
		SaleDTO saleDTO=null;
		//get DAO
		dao=SaleMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listsale=dao.getSale(name);	
		 //convert ListSale to ListSaleDTO 
		 listsaleDTOs=new ArrayList();
		 for(SaleMaster sale:listsale){
			 //get Each DTO class object
			 saleDTO=new SaleDTO();
			 saleDTO.setId(sale.getId());
			 saleDTO.setEmpName(sale.getEmpName());
			 saleDTO.setDesign(sale.getDesign());
			 saleDTO.setCustName(sale.getCustName());
			 saleDTO.setAddr(sale.getAddr());
			 saleDTO.setContact(sale.getContact());
			 saleDTO.setCustReq(sale.getCustReq());
			 saleDTO.setProdName(sale.getProdName());
			 saleDTO.setProdType(sale.getProdType());
			 saleDTO.setCompany(sale.getCompany());
			 saleDTO.setQuantity(sale.getQuantity());
			 saleDTO.setProdCost(sale.getProdCost());
			 saleDTO.setSerName(sale.getSerName());
			 saleDTO.setProvider(sale.getProvider());
			 saleDTO.setSerCost(sale.getSerCost());
			 listsaleDTOs.add(saleDTO);
		 }//for
		 return listsaleDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	public List<SaleQuotationDTO> editQUOTATION(int id)throws InternalProblemException{
		SaleMasterDAO dao=null;
		List<SaleQuotationMaster> listsale=null;
		List<SaleQuotationDTO> listsaleDTOs=null;
		SaleQuotationDTO saleDTO=null;
		//get DAO
		dao=SaleMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listsale=dao.editQuotation(id);	
		 //convert ListSale to ListSaleDTO 
		 listsaleDTOs=new ArrayList();
		 for(SaleQuotationMaster sale:listsale){
			 //get Each DTO class object
			 saleDTO=new SaleQuotationDTO();
			 saleDTO.setId(sale.getId());
			 saleDTO.setCustName(sale.getCustName());
			 saleDTO.setAddr(sale.getAddr());
			 saleDTO.setContact(sale.getContact());
			 saleDTO.setCustReq(sale.getCustReq());
			 saleDTO.setProdName(sale.getProdName());
			 saleDTO.setProdType(sale.getProdType());
			 saleDTO.setCompany(sale.getCompany());
			 saleDTO.setQuantity(sale.getQuantity());
			 saleDTO.setProdCost(sale.getProdCost());
			 saleDTO.setProdAmount(sale.getProdAmount());
			 saleDTO.setProdTax(sale.getProdTax());
			 saleDTO.setProdGross(sale.getProdGross());
			 saleDTO.setProdDiscount(sale.getProdDiscount());
			 saleDTO.setProdGrand(sale.getProdGrand());
			 saleDTO.setSerName(sale.getSerName());
			 saleDTO.setProvider(sale.getProvider());
			 saleDTO.setSercost(sale.getSercost());
			 saleDTO.setSerAmount(sale.getSerAmount());
			 saleDTO.setSerTax(sale.getSerTax());
			 saleDTO.setSerGross(sale.getSerGross());
			 saleDTO.setSerDiscount(sale.getSerDiscount());
			 saleDTO.setSerGrand(sale.getSerGrand());

			 listsaleDTOs.add(saleDTO);
		 }//for
		 return listsaleDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	public List<SaleQuotationDTO> loadAllSERVICEQUOTATION()throws InternalProblemException{
		SaleMasterDAO dao=null;
		List<SaleQuotationMaster> listsale=null;
		List<SaleQuotationDTO> listsaleDTOs=null;
		SaleQuotationDTO saleDTO=null;
		//get DAO
		dao=SaleMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listsale=dao.loadAllSERVICEQUOTATION();	
		 //convert ListSale to ListSaleDTO 
		 listsaleDTOs=new ArrayList();
		 for(SaleQuotationMaster sale:listsale){
			 //get Each DTO class object
			 saleDTO=new SaleQuotationDTO();
			 saleDTO.setId(sale.getId());
			 saleDTO.setEmpName(sale.getEmpName());
			 saleDTO.setCustName(sale.getCustName());
			 saleDTO.setSerName(sale.getSerName());
			 saleDTO.setProvider(sale.getProvider());
			 saleDTO.setSercost(sale.getSercost());
			 saleDTO.setSerAmount(sale.getSerAmount());
			 saleDTO.setSerTax(sale.getSerTax());
			 saleDTO.setSerGross(sale.getSerGross());
			 saleDTO.setSerDiscount(sale.getSerDiscount());
			 saleDTO.setSerGrand(sale.getSerGrand());

			 listsaleDTOs.add(saleDTO);
		 }//for
		 return listsaleDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	public List<SaleQuotationDTO> loadAllPRODUCTQUOTATION()throws InternalProblemException{
		SaleMasterDAO dao=null;
		List<SaleQuotationMaster> listsale=null;
		List<SaleQuotationDTO> listsaleDTOs=null;
		SaleQuotationDTO saleDTO=null;
		//get DAO
		dao=SaleMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listsale=dao.loadAllPRODUCTQUOTATION();	
		 //convert ListSale to ListSaleDTO 
		 listsaleDTOs=new ArrayList();
		 for(SaleQuotationMaster sale:listsale){
			 //get Each DTO class object
			 saleDTO=new SaleQuotationDTO();
			 saleDTO.setId(sale.getId());
			 saleDTO.setEmpName(sale.getEmpName());
			 saleDTO.setCustName(sale.getCustName());
			 saleDTO.setProdName(sale.getProdName());
			 saleDTO.setProdType(sale.getProdType());
			 saleDTO.setCompany(sale.getCompany());
			 saleDTO.setQuantity(sale.getQuantity());
			 saleDTO.setProdCost(sale.getProdCost());
			 saleDTO.setProdAmount(sale.getProdAmount());
			 saleDTO.setProdTax(sale.getProdTax());
			 saleDTO.setProdGross(sale.getProdGross());
			 saleDTO.setProdDiscount(sale.getProdDiscount());
			 saleDTO.setProdGrand(sale.getProdGrand());

			 listsaleDTOs.add(saleDTO);
		 }//for
		 return listsaleDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	public String deleteSale(int id)throws SaleRemovalProblemException{
		SaleMasterDAO dao=null;
		int count=0;
		String msg=null;
		//get DAO
		dao=SaleMasterDAOFactory.getInstance();
		try{
		  count=dao.deleteSale(id);
		  if(count==0)
			 
			  msg="Sale is Not Removed";
		  else
			  msg="Sale is  Removed";
		}
		catch(HibernateException he){
			throw new SaleRemovalProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new SaleRemovalProblemException(e.getMessage());
		}
		return msg;
	}//method
	
	public String deleteQuotation(int id)throws SaleRemovalProblemException{
		SaleMasterDAO dao=null;
		int count=0;
		String msg=null;
		//get DAO
		dao=SaleMasterDAOFactory.getInstance();
		try{
		  count=dao.deleteQuotation(id);
		  if(count==0)
			 
			  msg="Sale Quotation is Not Removed";
		  else
			  msg="Sale Quotation is  Removed";
		}
		catch(HibernateException he){
			throw new SaleRemovalProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new SaleRemovalProblemException(e.getMessage());
		}
		return msg;
	}//method
	
}//class
