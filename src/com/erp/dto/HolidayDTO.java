package com.erp.dto;



public class HolidayDTO {
	private int holidayId;
	private String holidayName;
	private String holidayDate;

	
	public HolidayDTO() {
		System.out.println("HolidayDTO:0-param constructor");
	}


	public int getHolidayId() {
		return holidayId;
	}


	public void setHolidayId(int holidayId) {
		this.holidayId = holidayId;
	}


	public String getHolidayName() {
		return holidayName;
	}


	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}


	public String getHolidayDate() {
		return holidayDate;
	}


	public void setHolidayDate(String holidayDate) {
		this.holidayDate = holidayDate;
	}


}