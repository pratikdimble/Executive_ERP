package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.erp.dao.ServiceMasterDAO;
import com.erp.dao.ServiceMasterDAOFactory;
import com.erp.domain.ServiceDataMaster;
import com.erp.domain.ServiceMaster;
import com.erp.dto.ServiceDTO;
import com.erp.dto.ServiceDataDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;
import com.erp.errors.ServiceRemovalProblemException;


public class ServiceOperationsBusinessDelegate {

	public String addService(String name)throws InsertOperationProblemException,InternalProblemException{
		ServiceMasterDAO dao=null;
		ServiceMaster service=null;
		int sid=0;
		//use dAO
		dao=ServiceMasterDAOFactory.getInstance();
		//prepare Service obj
		service=new ServiceMaster();
		service.setName(name);
		//service.setProvider(provider);service.setServiceCost(serviceCost);
		//invoke method
		try{
		 sid=dao.addService(service);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Service Added Succesfully with Id::"+sid;
	}//method
	
	public String addServiceData(int serid,String name,String provider,float serviceCost)throws InsertOperationProblemException,InternalProblemException{
		ServiceMasterDAO dao=null;
		ServiceDataMaster service=null;
		int sid=0;
		//use dAO
		dao=ServiceMasterDAOFactory.getInstance();
		//prepare Service obj
		service=new ServiceDataMaster();
		service.setName(name);
		service.setProvider(provider);service.setServiceCost(serviceCost);
		//invoke method
		try{
		 sid=dao.addServiceData(service,serid);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Service Added Succesfully with Id::"+sid;
	}//method
	
	
	public List<ServiceDataDTO> getAllServices()throws InternalProblemException{
		ServiceMasterDAO dao=null;
		List<ServiceDataMaster> listservice=null;
		List<ServiceDataDTO> listserviceDTOs=null;
		ServiceDataDTO serviceDTO=null;
		//get DAO
		dao=ServiceMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listservice=dao.loadAllServices();	
		 //convert ListService to ListServiceDTO 
		 listserviceDTOs=new ArrayList();
		 for(ServiceDataMaster service:listservice){
			 //get Each DTO class object
			 serviceDTO=new ServiceDataDTO();
			 serviceDTO.setSerid(service.getSerid());
			 serviceDTO.setName(service.getName());
			 serviceDTO.setProvider(service.getProvider());
			 serviceDTO.setServiceCost(service.getServiceCost());
			 listserviceDTOs.add(serviceDTO);
		 }//for
		 return listserviceDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	public List<ServiceDataDTO> getService(String name)throws InternalProblemException{
		ServiceMasterDAO dao=null;
		List<ServiceDataMaster> listservice=null;
		List<ServiceDataDTO> listserviceDTOs=null;
		ServiceDataDTO serviceDTO=null;
		//get DAO
		dao=ServiceMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listservice=dao.getService(name);	
		 //convert ListService to ListServiceDTO 
		 listserviceDTOs=new ArrayList();
		 for(ServiceDataMaster service:listservice){
			 //get Each DTO class object
			 serviceDTO=new ServiceDataDTO();
			 serviceDTO.setSerid(service.getSerid());
			 serviceDTO.setName(service.getName());
			 serviceDTO.setProvider(service.getProvider());
			 serviceDTO.setServiceCost(service.getServiceCost());
			 listserviceDTOs.add(serviceDTO);
		 }//for
		 return listserviceDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	public String deleteService(int id)throws ServiceRemovalProblemException{
		ServiceMasterDAO dao=null;
		int count=0;
		String msg=null;
		//get DAO
		dao=ServiceMasterDAOFactory.getInstance();
		try{
		  count=dao.deleteService(id);
		  if(count==0)
			 
			  msg="Service is Not Removed";
		  else
			  msg="Service is  Removed";
		}
		catch(HibernateException he){
			throw new ServiceRemovalProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new ServiceRemovalProblemException(e.getMessage());
		}
		return msg;
	}//method
	
	
}//class
