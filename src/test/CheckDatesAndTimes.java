package test;

import java.time.*;
import java.time.format.DateTimeFormatter;
/***
 * 
 * @author Christian
 *
 *
 *	New from Java8 java.time.*
 */
public class CheckDatesAndTimes {
	
	public static void main(String...strings) {
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		
		LocalDate married = LocalDate.of(2011, Month.OCTOBER, 15);
		
		DayOfWeek weekDay = married.getDayOfWeek();
		
		System.out.println(weekDay);
		LocalDateTime timeMarried = married.atTime(15, 00);
		System.out.println(timeMarried.format(DateTimeFormatter.ISO_WEEK_DATE));
		
	}

}
