package com.erp.dao;

import java.util.List;

import com.erp.domain.HolidayMaster;
import com.erp.domain.ProductMaster;

public interface HolidayMasterDAO {
	public List<HolidayMaster> loadAllHolidays();
	public  int addHoliday(HolidayMaster holiday);
	public List<HolidayMaster> getHoliday(String holidayDate);
}
