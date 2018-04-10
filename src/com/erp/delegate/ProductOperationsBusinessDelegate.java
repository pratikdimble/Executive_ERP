package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.erp.dao.ProductMasterDAO;
import com.erp.dao.ProductMasterDAOFactory;
import com.erp.domain.ProductDataMaster;
import com.erp.domain.ProductMaster;
import com.erp.dto.ProductDTO;
import com.erp.dto.ProductDataDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;
import com.erp.errors.ProductRemovalProblemException;


public class ProductOperationsBusinessDelegate {

	public String addProduct(String name,String type)throws InsertOperationProblemException,InternalProblemException{
		ProductMasterDAO dao=null;
		ProductMaster prod=null;
		int pid=0;
		//use dAO
		dao=ProductMasterDAOFactory.getInstance();
		//prepare Product object
		prod=new ProductMaster();
		prod.setName(name);prod.setType(type);
		//invoke method
		try{
		 pid=dao.addProduct(prod);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Product Added Succesfully with Id::"+pid;
	}//method
	public String addProductData(int prodid,String name,String type,String company,float cost,int quantity,float warranty)throws InsertOperationProblemException,InternalProblemException{
		ProductMasterDAO dao=null;
		ProductDataMaster prod=null;
		int pid=0;
		//use dAO
		dao=ProductMasterDAOFactory.getInstance();
		//prepare Product object
		prod=new ProductDataMaster();
		prod.setName(name);prod.setType(type);prod.setCompany(company);
		prod.setCost(cost);prod.setQuantity(quantity);prod.setWarranty(warranty);
		//invoke method
		try{
		 pid=dao.addProductData(prod,prodid);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Product Data Added Succesfully with Id::"+pid;
	}//method
	public String updateProduct(int pid,String name,String type,String company,float cost,int quantity,float warranty)throws InsertOperationProblemException,InternalProblemException{
		ProductMasterDAO dao=null;
		ProductMaster prod=null;
	//	int pid=0;
		//use dAO
		dao=ProductMasterDAOFactory.getInstance();
		/*//prepare Product object
		prod=new ProductMaster();
		prod.setName(name);prod.setType(type);prod.setCompany(company);
		prod.setCost(cost);prod.setQuantity(quantity);prod.setWarranty(warranty);*/
		//invoke method
		try{
		 pid=dao.updateProduct(pid,name, type, company, cost, quantity, warranty);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Product Updated Succesfully with Id::"+pid;
	}//method
	
	public List<ProductDataDTO> getAllProducts()throws InternalProblemException{
		ProductMasterDAO dao=null;
		List<ProductDataMaster> listprod=null;
		List<ProductDataDTO> listprodDTOs=null;
		ProductDataDTO prodDTO=null;
		//get DAO
		dao=ProductMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listprod=dao.loadAllProducts();	
		 //convert ListProduct to ListProductDTO 
		 listprodDTOs=new ArrayList();
		 for(ProductDataMaster prod:listprod){
			 //get Each DTO class object
			 prodDTO=new ProductDataDTO();
			 prodDTO.setPid(prod.getPid());
			 prodDTO.setName(prod.getName());
			 prodDTO.setType(prod.getType());
			 prodDTO.setCompany(prod.getCompany());
			 prodDTO.setCost(prod.getCost());
			 prodDTO.setQuantity(prod.getQuantity());
			 prodDTO.setWarranty(prod.getWarranty());

			 listprodDTOs.add(prodDTO);
		 }//for
		 return listprodDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	public List<ProductDataDTO> getProduct(String name,String thisRole)throws InternalProblemException{
		ProductMasterDAO dao=null;
		List<ProductDataMaster> listprod=null;
		List<ProductDataDTO> listprodDTOs=null;
		ProductDataDTO prodDTO=null;
		//get DAO
		dao=ProductMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listprod=dao.getProduct(name);	
	       if(thisRole.equalsIgnoreCase("Admin"))
	      	{
	    	 //convert ListProduct to ListProductDTO 
	  		 listprodDTOs=new ArrayList();
	  		 for(ProductDataMaster prod:listprod){
	  			 //get Each DTO class object
	  			 prodDTO=new ProductDataDTO();
	  			 prodDTO.setPid(prod.getPid());
	  			 prodDTO.setName(prod.getName());
	  			 prodDTO.setCompany(prod.getCompany());
	  			 prodDTO.setType(prod.getType());
	  			 prodDTO.setCost(prod.getCost());
	  			 prodDTO.setWarranty(prod.getWarranty());
	  			 prodDTO.setQuantity(prod.getQuantity());
	  			 listprodDTOs.add(prodDTO);
	  		 }//for
	      	}
	      	else if(thisRole.equalsIgnoreCase("Product Executive"))
	      	{
	      	//convert ListProduct to ListProductDTO 
	   		 listprodDTOs=new ArrayList();
	   		 for(ProductDataMaster prod:listprod){
	   			 //get Each DTO class object
	   			 prodDTO=new ProductDataDTO();
	   			 prodDTO.setPid(prod.getPid());
	   			 prodDTO.setName(prod.getName());
	   			 prodDTO.setCompany(prod.getCompany());
	   			 prodDTO.setType(prod.getType());
	   			 prodDTO.setCost(prod.getCost());
	   			 prodDTO.setWarranty(prod.getWarranty());
	   			 listprodDTOs.add(prodDTO);
	   		 }//for
	      	}
		 
		 return listprodDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
/*	public List<ProductDTO> getProduct(String name)throws InternalProblemException{
		ProductMasterDAO dao=null;
		List<ProductMaster> listprod=null;
		List<ProductDTO> listprodDTOs=null;
		ProductDTO prodDTO=null;
		//get DAO
		dao=ProductMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listprod=dao.getProduct(name);	
		 //convert ListProduct to ListProductDTO 
		 listprodDTOs=new ArrayList();
		 for(ProductMaster prod:listprod){
			 //get Each DTO class object
			 prodDTO=new ProductDTO();
			 prodDTO.setPid(prod.getPid());
			 prodDTO.setName(prod.getName());
			 prodDTO.setType(prod.getType());
			 prodDTO.setCompany(prod.getCompany());
			 prodDTO.setCost(prod.getCost());
			 prodDTO.setQuantity(prod.getQuantity());
			 prodDTO.setWarranty(prod.getWarranty());

			 listprodDTOs.add(prodDTO);
		 }//for
		 return listprodDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
*/	public String deleteProduct(String name)throws ProductRemovalProblemException{
		ProductMasterDAO dao=null;
		int count=0;
		//get DAO
		dao=ProductMasterDAOFactory.getInstance();
		try{
		  count=dao.deleteProduct(name);
		  if(count==0)
			  return "Product is Not Deleted";
		  else
			  return "Product Is Deleted";
		}
		catch(HibernateException he){
			throw new ProductRemovalProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new ProductRemovalProblemException(e.getMessage());
		}
	}//method
	
}//class
