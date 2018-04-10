package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.erp.dao.AreaMasterDAO;
import com.erp.dao.AreaMasterDAOFactory;
import com.erp.dao.RegionMasterDAO;
import com.erp.dao.RegionMasterDAOFactory;
import com.erp.domain.AreaMaster;
import com.erp.dto.AreaDTO;
import com.erp.errors.AreaRemovalProblemException;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;


public class AreaOperationsBusinessDelegate {

/*	public String addArea(String regName,String areaName, String description)throws InsertOperationProblemException,InternalProblemException{
		AreaMasterDAO dao=null;
		AreaMaster area=null;
		int areaId=0;
		//use dAO
		dao=AreaMasterDAOFactory.getInstance();
		//prepare Area obj
		area=new AreaMaster();
		area.setRegName(regName);
		area.setAreaName(areaName);
		area.setDescription(description);
		//invoke method
		try{
		 areaId=dao.addArea(area);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Area Added Succesfully with Id::"+areaId;
	}//method
*/	
	public String addAreaToExistingRegion(String regName,String areaName, String description)throws InsertOperationProblemException,InternalProblemException{
		RegionMasterDAO dao=null;
		AreaMaster area=null;
		String msg=null;
		//use dAO
		dao=RegionMasterDAOFactory.getInstance();
		//prepare Area obj
		area=new AreaMaster();
		area.setRegName(regName);
		area.setAreaName(areaName);
		area.setDescription(description);
		//invoke method
		try{
		 msg=dao.addNewAreaToExistingRegion(regName, area);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return msg;
	}//method
	
	public List<AreaDTO> getAllArea()throws InternalProblemException{
		AreaMasterDAO dao=null;
		List<AreaMaster> listArea=null;
		List<AreaDTO> listAreaDTOs=null;
		AreaDTO areaDTO=null;
		//get DAO
		dao=AreaMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listArea=dao.loadAllArea();	
		 //convert ListArea to ListAreaDTO 
		 listAreaDTOs=new ArrayList();
		 for(AreaMaster area:listArea){
			 //get Each DTO class object
			 areaDTO=new AreaDTO();
			 areaDTO.setAreaId(area.getAreaId());
			 areaDTO.setRegName(area.getRegName());
			 areaDTO.setAreaName(area.getAreaName());
			 areaDTO.setDescription(area.getDescription());
			 

			 listAreaDTOs.add(areaDTO);
		 }//for
		 return listAreaDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method

	public String deleteArea(int id)throws AreaRemovalProblemException{
		AreaMasterDAO dao=null;
		int count=0;
		String msg=null;
		//get DAO
		dao=AreaMasterDAOFactory.getInstance();
		try{
		  count=dao.deleteArea(id);
		  if(count==0)
			 
			  msg="Area is Not Removed";
		  else
			  msg="Area is  Removed";
		}
		catch(HibernateException he){
			throw new AreaRemovalProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new AreaRemovalProblemException(e.getMessage());
		}
		return msg;
	}//method
	
	
	
	
	/*public List<AreaDTO> findArea(int sid)throws InternalProblemException{
		AreaMasterDAO dao=null;
		List<AreaMaster> listArea=null;
		List<AreaDTO> findAreaDTOs=null;
		AreaDTO AreaDTO=null;
		//get DAO
		dao=AreaMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listArea=dao.findArea(sid);
		 //convert ListArea to ListAreaDTO 
		 findAreaDTOs=new ArrayList();
		 for(AreaMaster Area:listArea){
			 //get Each DTO class object
			 AreaDTO=new AreaDTO();
			 AreaDTO.setSid(Area.getSid());
			 AreaDTO.setName(Area.getName());
			 AreaDTO.setProvider(Area.getProvider());

			 findAreaDTOs.add(AreaDTO);
		 }//for
		 return findAreaDTOs;
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
