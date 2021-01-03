package main;

import java.util.Calendar;

public class MonthlyCalendar {
	
	private final Calendar cal;
	
	public MonthlyCalendar() {
		this(Calendar.getInstance());
	}
	
	public MonthlyCalendar(Calendar cal) {
		this.cal = cal;
	}

	public int getRemainingDays() {
		
		return cal.getActualMaximum(Calendar.DATE) - cal.get(Calendar.DATE);
	}
	

}
