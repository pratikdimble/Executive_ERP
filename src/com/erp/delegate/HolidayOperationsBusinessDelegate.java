package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.erp.dao.HolidayMasterDAO;
import com.erp.dao.HolidayMasterDAOFactory;
import com.erp.domain.HolidayMaster;
import com.erp.dto.HolidayDTO;

import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;


public class HolidayOperationsBusinessDelegate {

	public String addHoliday(String holidayName, String holidayDate)throws InsertOperationProblemException,InternalProblemException{
		HolidayMasterDAO dao=null;
		HolidayMaster holiday=null;
		int holidayId=0;
		//use dAO
		dao=HolidayMasterDAOFactory.getInstance();
		//prepare Holiday obj
		holiday=new HolidayMaster();
		holiday.setHolidayName(holidayName);
		holiday.setHolidayDate(holidayDate);
		//invoke method
		try{
		 holidayId=dao.addHoliday(holiday);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Holiday Added Succesfully with Id::"+holidayId;
	}//method
	
	
	public List<HolidayDTO> getAllHolidays()throws InternalProblemException{
		HolidayMasterDAO dao=null;
		List<HolidayMaster> listHoliday=null;
		List<HolidayDTO> listHolidayDTOs=null;
		HolidayDTO holidayDTO=null;
		//get DAO
		dao=HolidayMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listHoliday=dao.loadAllHolidays();	
		 //convert ListHoliday to ListHolidayDTO 
		 listHolidayDTOs=new ArrayList();
		 for(HolidayMaster holiday:listHoliday){
			 //get Each DTO class object
			 holidayDTO=new HolidayDTO();
			 holidayDTO.setHolidayId(holiday.getHolidayId());
			 holidayDTO.setHolidayName(holiday.getHolidayName());
			 holidayDTO.setHolidayDate(holiday.getHolidayDate());

			 listHolidayDTOs.add(holidayDTO);
		 }//for
		 return listHolidayDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	public List<HolidayDTO> getHoliday(String holidayDate)throws InternalProblemException{
		HolidayMasterDAO dao=null;
		List<HolidayMaster> listHoliday=null;
		List<HolidayDTO> listHolidayDTOs=null;
		HolidayDTO holidayDTO=null;
		//get DAO
		dao=HolidayMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listHoliday=dao.getHoliday(holidayDate);	
		 //convert ListHoliday to ListHolidayDTO 
		 listHolidayDTOs=new ArrayList();
		 for(HolidayMaster holiday:listHoliday){
			 //get Each DTO class object
			 holidayDTO=new HolidayDTO();
			 holidayDTO.setHolidayId(holiday.getHolidayId());
			 holidayDTO.setHolidayName(holiday.getHolidayName());
			 holidayDTO.setHolidayDate(holiday.getHolidayDate());

			 listHolidayDTOs.add(holidayDTO);
		 }//for
		 return listHolidayDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
}//class
