package com.erp.dao;

import java.util.List;

import com.erp.domain.AttendanceMaster;


public interface AttendanceMasterDAO {
	public List<AttendanceMaster> loadAllAttendances();
	public List<AttendanceMaster> getAttendance(String name);
	public  int addAttendance(AttendanceMaster attend);
}
