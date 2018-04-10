package com.erp.dao;

import java.util.List;

import com.erp.domain.EmployeeMaster;
import com.erp.domain.LoginMaster;
import com.erp.dto.LoginDTO;

public interface EmployeeMasterDAO {
	public List<EmployeeMaster> loadAllEmployee();
	public List<EmployeeMaster> getEmployee(String name);
	public  int addEmployee(EmployeeMaster emp);
	public  int addEmployeeInfo(LoginMaster log);
	public List<LoginMaster> getEmployeeLogin(String name);
	public  int updateEmployee(int loginId,int empId,String empName,String empAddr,String empCity,int pin,
			String designation,String qualification,String workExp,	String doj,long mobile,String empMail);
	public int changePassword(int id,String password);
	public int changeDepartment(int id,String dept);
}
