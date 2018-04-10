package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.erp.dao.CustomerMasterDAO;
import com.erp.dao.CustomerMasterDAOFactory;
import com.erp.domain.CustomerMaster;
import com.erp.dto.CustomerDTO;

import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;


public class CustomerOperationsBusinessDelegate {

	public String addCustomer(String custName,String shopName,String shopAddr,int pin,
								String delivery,long mobile,String shopMail,String contactPerson,
								long personMobile)throws InsertOperationProblemException,InternalProblemException{
		CustomerMasterDAO dao=null;
		CustomerMaster cust=null;
		int custId=0;
		//use dAO
		dao=CustomerMasterDAOFactory.getInstance();
		//prepare Customer obj
		cust=new CustomerMaster();
		cust.setCustName(custName);cust.setShopName(shopName);cust.setShopAddr(shopAddr);
		cust.setPin(pin);cust.setDelivery(delivery);cust.setMobile(mobile);
		cust.setShopMail(shopMail);cust.setContactPerson(contactPerson);
		cust.setPersonMobile(personMobile);
				//invoke method
		try{
		 custId=dao.addCustomer(cust);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Customer Added Succesfully with Id::"+custId;
	}//method
	
	
	public List<CustomerDTO> getAllCustomer()throws InternalProblemException{
		CustomerMasterDAO dao=null;
		List<CustomerMaster> listCustomer=null;
		List<CustomerDTO> listCustomerDTOs=null;
		CustomerDTO custDTO=null;
		//get DAO
		dao=CustomerMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listCustomer=dao.loadAllCustomer();	
		 //convert ListCustomer to ListCustomerDTO 
		 listCustomerDTOs=new ArrayList();
		 for(CustomerMaster cust:listCustomer){
			 //get Each DTO class object
			 custDTO=new CustomerDTO();
			 custDTO.setCustId(cust.getCustId());
			 custDTO.setCustName(cust.getCustName());
			 custDTO.setShopName(cust.getShopName());
			 custDTO.setShopAddr( cust.getShopAddr());
			 custDTO.setPin( cust.getPin());
			 custDTO.setDelivery(cust.getDelivery());
			 custDTO.setMobile( cust.getMobile());
			 custDTO.setShopMail( cust.getShopMail());
			 custDTO.setContactPerson(cust.getContactPerson());
			 custDTO.setPersonMobile(cust.getPersonMobile());
		
			 listCustomerDTOs.add(custDTO);
		 }//for
		 return listCustomerDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	
	
	
	/*public List<CustomerDTO> findCustomer(int sid)throws InternalProblemException{
		CustomerMasterDAO dao=null;
		List<CustomerMaster> listCustomer=null;
		List<CustomerDTO> findCustomerDTOs=null;
		CustomerDTO CustomerDTO=null;
		//get DAO
		dao=CustomerMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listCustomer=dao.findCustomer(sid);
		 //convert ListCustomer to ListCustomerDTO 
		 findCustomerDTOs=new ArrayList();
		 for(CustomerMaster Customer:listCustomer){
			 //get Each DTO class object
			 CustomerDTO=new CustomerDTO();
			 CustomerDTO.setSid(Customer.getSid());
			 CustomerDTO.setName(Customer.getName());
			 CustomerDTO.setProvider(Customer.getProvider());

			 findCustomerDTOs.add(CustomerDTO);
		 }//for
		 return findCustomerDTOs;
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
