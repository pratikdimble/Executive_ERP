package com.erp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="ERP_DEPARTMENT")
public class DepartmentMaster {
	private int deptId;
	private String deptName;

	
	public DepartmentMaster() {
		System.out.println("DesignationMaster:0-param constructor");
	}
	 @Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")
	 public int getDeptId() {
			return deptId;
		}
		public void setDeptId(int deptId) {
			this.deptId = deptId;
		}
		
	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}
