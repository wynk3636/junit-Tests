package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Calendar;

import org.junit.Test;

import main.MonthlyCalendar;

/**
 * 
 * @author hikaru
 * システム時間に依存するテスト
 */
public class MonthlyCalendarTest {
	
	static Calendar newCalendar(int yyyy, int MM, int dd) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, yyyy);
		cal.set(Calendar.MONTH, MM -1);
		cal.set(Calendar.DATE, dd);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		return cal;
	}
	
	@Test
	public void 時刻が20120131の場合() {
		MonthlyCalendar sut = new MonthlyCalendar(newCalendar(2012,1,31));
		assertThat(sut.getRemainingDays(), is(0));
	}
	
	@Test
	public void 時刻が20120130の場合() {
		MonthlyCalendar sut = new MonthlyCalendar(newCalendar(2012,1,30));
		assertThat(sut.getRemainingDays(), is(1));
	}
	
	@Test
	public void 時刻が20120201の場合() {
		MonthlyCalendar sut = new MonthlyCalendar(newCalendar(2012,2,1));
		assertThat(sut.getRemainingDays(), is(28));
	}

}
