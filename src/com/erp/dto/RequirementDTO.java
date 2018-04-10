package com.erp.dto;

import java.util.Set;

import com.erp.domain.CustomerMaster;
import com.erp.domain.EmployeeMaster;

public class RequirementDTO {
	private int reqId;
	private String empName;
	private String dsgn;
	private String custName;
	
	private String prodName;
	private String prodType;
	private String prodCompany;
	private int quantity;
	
	private  EmployeeMaster empMaster;
	private  CustomerMaster custMaster;
	private String status;
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDsgn() {
		return dsgn;
	}
	public void setDsgn(String dsgn) {
		this.dsgn = dsgn;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public String getProdCompany() {
		return prodCompany;
	}
	public void setProdCompany(String prodCompany) {
		this.prodCompany = prodCompany;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public EmployeeMaster getEmpMaster() {
		return empMaster;
	}
	public void setEmpMaster(EmployeeMaster empMaster) {
		this.empMaster = empMaster;
	}
	public CustomerMaster getCustMaster() {
		return custMaster;
	}
	public void setCustMaster(CustomerMaster custMaster) {
		this.custMaster = custMaster;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}