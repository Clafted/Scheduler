package main.backend;


public class Activity {
	
	String name = "";
	String location = "";
	String notes = "";
	int hour = 0;
	int minute = 0;
	
	public String getName() {
		return name;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public int getHour() {
		return hour;
	}
	
	public int getMinute() {
		return minute;
	}
	
	public String getFormattedTime() {
		return hour + ":" + minute;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setHour(int hour) {
		if (hour > 23) {
			this.hour = 23;
		} else if (hour < 0) {
			this.hour = 0;
		} else {
			this.hour = hour;
		}
	}
	
	public void setMinute(int minute) {
		if (minute > 59) {
			this.minute = 59;
		} else if (minute < 0) {
			this.minute = 0;
		} else {
			this.minute = minute;
		}
	}
}
