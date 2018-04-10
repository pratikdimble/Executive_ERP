package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.erp.dao.EmployeeMasterDAO;
import com.erp.dao.EmployeeMasterDAOFactory;
import com.erp.domain.EmployeeMaster;
import com.erp.domain.LoginMaster;
import com.erp.dto.EmployeeDTO;
import com.erp.dto.LoginDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;


public class EmployeeOperationsBusinessDelegate {

	public String addEmployee(String empName,String empAddr,String empCity,int pin,
								String designation,String department,String qualification,String workExp,
								String doj,long mobile,String empMail,String empUsername,String empPassword)throws InsertOperationProblemException,InternalProblemException{
		EmployeeMasterDAO dao=null;
		EmployeeMaster employee=null;
		LoginMaster log=null;
		int empId=0,loginId=0;
		//use dAO
		dao=EmployeeMasterDAOFactory.getInstance();
		//prepare Employee obj
		employee=new EmployeeMaster();
		employee.setEmpName(empName);employee.setEmpAddr(empAddr);employee.setEmpCity(empCity);
		employee.setPin(pin);employee.setDesignation(designation);employee.setDepartment(department); employee.setQualification(qualification);
		employee.setWorkExp(workExp);employee.setDoj(doj);employee.setEmpMail(empMail);
		employee.setMobile(mobile);employee.setUserName(empUsername);
		
		//prepare login objec
		log=new LoginMaster();
		log.setName(empUsername);log.setPassword(empPassword);log.setRole(designation);
		
		//invoke method
		try{
		 empId=dao.addEmployee(employee);
		 loginId=dao.addEmployeeInfo(log);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Employee Added Succesfully with Id::"+empId+" And Login ID:: "+loginId;
	}//method
	
	public String changePassword(int id,String password)throws InsertOperationProblemException,InternalProblemException{

				EmployeeMasterDAO dao=null;
				EmployeeMaster employee=null;
					LoginMaster log=null;
					//use dAO
						dao=EmployeeMasterDAOFactory.getInstance();

						//invoke method
							try{
								id=dao.changePassword(id, password);
							}
							catch(HibernateException he){
								throw new InsertOperationProblemException(he.getMessage());
							}
							catch(Exception e){
								throw new InternalProblemException(e.getMessage());
							}
							return " Password Changed Successfully::";
	}//method
	
	public String changeDepartment(int id,String dept)throws InsertOperationProblemException,InternalProblemException{

		EmployeeMasterDAO dao=null;
		EmployeeMaster employee=null;
			//use dAO
				dao=EmployeeMasterDAOFactory.getInstance();

				//invoke method
					try{
						id=dao.changeDepartment(id, dept);
					}
					catch(HibernateException he){
						throw new InsertOperationProblemException(he.getMessage());
					}
					catch(Exception e){
						throw new InternalProblemException(e.getMessage());
					}
					return " Department Changed Successfully::";
}//method
	
	public String updateEmployee(int loginId,int empId,String empName,String empAddr,String empCity,int pin,
			String designation,String qualification,String workExp,
			String doj,long mobile,String empMail)throws InsertOperationProblemException,InternalProblemException{

				EmployeeMasterDAO dao=null;
				EmployeeMaster employee=null;
					LoginMaster log=null;
//int empId=0,loginId=0;
					//use dAO
						dao=EmployeeMasterDAOFactory.getInstance();

						//invoke method
							try{
									empId=dao.updateEmployee(loginId, empId, empName, empAddr, empCity, pin, designation, qualification, workExp, doj, mobile, empMail);
							}
							catch(HibernateException he){
								throw new InsertOperationProblemException(he.getMessage());
							}
							catch(Exception e){
								throw new InternalProblemException(e.getMessage());
							}
							return " Employee Details Successfully Updated::"+empId;
	}//method
	

	public List<EmployeeDTO> getAllEmployee()throws InternalProblemException{
		EmployeeMasterDAO dao=null;
		List<EmployeeMaster> listEmployee=null;
		List<EmployeeDTO> listEmployeeDTOs=null;
		EmployeeDTO employeeDTO=null;
		//get DAO
		dao=EmployeeMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listEmployee=dao.loadAllEmployee();	
		 //convert ListEmployee to ListEmployeeDTO 
		 listEmployeeDTOs=new ArrayList();
		 for(EmployeeMaster employee:listEmployee){
			 //get Each DTO class object
			 employeeDTO=new EmployeeDTO();
			 employeeDTO.setEmpId(employee.getEmpId());
			 employeeDTO.setEmpName(employee.getEmpName());
			 employeeDTO.setEmpAddr( employee.getEmpAddr());
			 employeeDTO.setEmpCity(employee.getEmpCity());
			 employeeDTO.setDepartment(employee.getDepartment());
			 employeeDTO.setPin( employee.getPin());
			 employeeDTO.setDesignation(employee.getDesignation());
			 employeeDTO.setQualification(employee.getQualification());
			 employeeDTO.setWorkExp(employee.getWorkExp());
			 employeeDTO.setDoj(employee.getDoj());
			 employeeDTO.setMobile( employee.getMobile());
			 employeeDTO.setEmpMail( employee.getEmpMail());


			 listEmployeeDTOs.add(employeeDTO);
		 }//for
		 return listEmployeeDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	public List<EmployeeDTO> getEmployee(String name)throws InternalProblemException{
		EmployeeMasterDAO dao=null;
		List<EmployeeMaster> listEmployee=null;
		List<EmployeeDTO> listEmployeeDTOs=null;
		EmployeeDTO employeeDTO=null;
		//get DAO
		dao=EmployeeMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listEmployee=dao.getEmployee(name);	
		 //convert ListEmployee to ListEmployeeDTO 
		 listEmployeeDTOs=new ArrayList();
		 for(EmployeeMaster employee:listEmployee){
			 //get Each DTO class object
			 employeeDTO=new EmployeeDTO();
			 employeeDTO.setEmpId(employee.getEmpId());
			 employeeDTO.setEmpName(employee.getEmpName());
			 employeeDTO.setEmpAddr( employee.getEmpAddr());
			 employeeDTO.setEmpCity(employee.getEmpCity());
			 employeeDTO.setDepartment(employee.getDepartment());
			 employeeDTO.setPin( employee.getPin());
			 employeeDTO.setDesignation(employee.getDesignation());
			 employeeDTO.setQualification(employee.getQualification());
			 employeeDTO.setWorkExp(employee.getWorkExp());
			 employeeDTO.setDoj(employee.getDoj());
			 employeeDTO.setMobile( employee.getMobile());
			 employeeDTO.setEmpMail( employee.getEmpMail());
	

			 listEmployeeDTOs.add(employeeDTO);
		 }//for
		 return listEmployeeDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	public List<LoginDTO> getEmployeeLogin(String name)throws InternalProblemException{
		EmployeeMasterDAO dao=null;
		List<LoginMaster> listLogin=null;
		List<LoginDTO> listLoginDTOs=null;
		LoginDTO loginDTO=null;
		//get DAO
		dao=EmployeeMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listLogin=dao.getEmployeeLogin(name);	
		 //convert ListEmployee to ListEmployeeDTO 
		 listLoginDTOs=new ArrayList();
		 for(LoginMaster login:listLogin){
			 //get Each DTO class object
			 loginDTO=new LoginDTO();
			 loginDTO.setId(login.getId());
			 loginDTO.setName(login.getName());
			 loginDTO.setPassword(login.getPassword());
			 loginDTO.setRole(login.getRole());

			 listLoginDTOs.add(loginDTO);
		 }//for
		 return listLoginDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	
	
	/*public List<EmployeeDTO> findEmployee(int sid)throws InternalProblemException{
		EmployeeMasterDAO dao=null;
		List<EmployeeMaster> listEmployee=null;
		List<EmployeeDTO> findEmployeeDTOs=null;
		EmployeeDTO EmployeeDTO=null;
		//get DAO
		dao=EmployeeMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listEmployee=dao.findEmployee(sid);
		 //convert ListEmployee to ListEmployeeDTO 
		 findEmployeeDTOs=new ArrayList();
		 for(EmployeeMaster Employee:listEmployee){
			 //get Each DTO class object
			 EmployeeDTO=new EmployeeDTO();
			 EmployeeDTO.setSid(Employee.getSid());
			 EmployeeDTO.setName(Employee.getName());
			 EmployeeDTO.setProvider(Employee.getProvider());

			 findEmployeeDTOs.add(EmployeeDTO);
		 }//for
		 return findEmployeeDTOs;
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
