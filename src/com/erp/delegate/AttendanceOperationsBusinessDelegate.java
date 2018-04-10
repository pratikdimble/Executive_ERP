package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.erp.dao.AttendanceMasterDAO;
import com.erp.dao.AttendanceMasterDAOFactory;
import com.erp.domain.AttendanceMaster;
import com.erp.dto.AttendanceDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;

//import com.erp.errors.AttendanceRemovalProblemException;


public class AttendanceOperationsBusinessDelegate {
	public String addAttendance(String attendDate,int empId,String empName,String entryStatus,String inTime,String outTime)throws InsertOperationProblemException,InternalProblemException{
		AttendanceMasterDAO dao=null;
		AttendanceMaster attend=null;
		int attendId=0;
		//use dAO
		dao=AttendanceMasterDAOFactory.getInstance();
		//prepare Attendance object
		attend=new AttendanceMaster();
		attend.setAttendDate(attendDate);attend.setEmpId(empId);attend.setEmpName(empName);
		attend.setEntryStatus(entryStatus);attend.setInTime(inTime);attend.setOutTime(outTime);
		//invoke method
		try{
			attendId=dao.addAttendance(attend);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Attendance Added Succesfully with Id::"+attendId;
	}//method
	
	
	public List<AttendanceDTO> getAllAttendances()throws InternalProblemException{
		AttendanceMasterDAO dao=null;
		List<AttendanceMaster> listattend=null;
		List<AttendanceDTO> listattendDTOs=null;
		AttendanceDTO attendDTO=null;
		//get DAO
		dao=AttendanceMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listattend=dao.loadAllAttendances();	
		 //convert ListAttendance to ListAttendanceDTO 
		 listattendDTOs=new ArrayList();
		 for(AttendanceMaster attend:listattend){
			 //get Each DTO class object
			 attendDTO=new AttendanceDTO();
			 attendDTO.setAttendId(attend.getAttendId());
			 attendDTO.setAttendDate(attend.getAttendDate());
			 attendDTO.setEmpId(attend.getEmpId());
			 attendDTO.setEmpName(attend.getEmpName());
			 attendDTO.setEntryStatus(attend.getEntryStatus());
			 attendDTO.setInTime(attend.getInTime());
			 attendDTO.setOutTime(attend.getOutTime());

			 listattendDTOs.add(attendDTO);
		 }//for
		 return listattendDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	public List<AttendanceDTO> getAttendance(String name)throws InternalProblemException{
		AttendanceMasterDAO dao=null;
		List<AttendanceMaster> listattend=null;
		List<AttendanceDTO> listattendDTOs=null;
		AttendanceDTO attendDTO=null;
		//get DAO
		dao=AttendanceMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listattend=dao.getAttendance(name);	
		 //convert ListAttendance to ListAttendanceDTO 
		 listattendDTOs=new ArrayList();
		 for(AttendanceMaster attend:listattend){
			 //get Each DTO class object
			 attendDTO=new AttendanceDTO();
			 attendDTO.setAttendId(attend.getAttendId());
			 attendDTO.setAttendDate(attend.getAttendDate());
			 attendDTO.setEmpId(attend.getEmpId());
			 attendDTO.setEmpName(attend.getEmpName());
			 attendDTO.setEntryStatus(attend.getEntryStatus());
			 attendDTO.setInTime(attend.getInTime());
			 attendDTO.setOutTime(attend.getOutTime());

			 listattendDTOs.add(attendDTO);
		 }//for
		 return listattendDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
}//class
