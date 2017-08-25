package com.libertymutual.goforcode.timeless.models;

public class TimesheetItem {

    
    private String weekOf;
	private double mondayHours;
	private double fridayHours;
	private double thursdayHours;
	private double wednesdayHours;
	private double tuesdayHours;
	private String date;
	private double sum;
    

    public double getMondays() {
        return mondayHours;
    }
    public void setMondayHours(double mondayHours) {
        this.mondayHours = mondayHours;
    }
    
    
    public double getTuesdays() {
        return tuesdayHours;
    }
    public void setTuesdayHours(double tuesdayHours) {
        this.tuesdayHours = tuesdayHours;
    }
    
    
    public double getWednesdays() {
        return mondayHours;
    }
    public void setWednesdayHours(double wednesdayHours) {
        this.wednesdayHours = wednesdayHours;
    }
    
    
    public double getThursdays() {
        return thursdayHours;
    }
    public void setThursdayHours(double thursdayHours) {
        this.thursdayHours = thursdayHours;
    }
    
    
    public double getFridays() {
        return mondayHours;
    }
    public void setFridayHours(double fridayHours) {
        this.fridayHours = fridayHours;
    }
	public String getDate() {
		
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public double getSum() {
		
		return sum;
	}
	
	public void setSum(double parseDouble) {
		this.sum = sum;
		
	}
	
    
    
   
   
    
    
    
    

}