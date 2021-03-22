package honux.calendar;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

public class Calendar {
	private static final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private HashMap<Date, PlanItem> planMap = new HashMap<>();

	public Calendar() {
		this.planMap = new HashMap<Date, PlanItem>();
	}

	/**
	 * 
	 * @param strDate ex: 2017-06-17
	 * @param plan
	 * @throws ParseException
	 */
	public void registerPlan(String strDate, String plan) {
		PlanItem p = new PlanItem(strDate, plan);
		planMap.put(p.getPlanDate(), p);
	}
	
	public PlanItem searchPlan(String strDate) {
		Date date = PlanItem.getDateFromString(strDate);
		return planMap.get(date);
	}

	private boolean isLeapYear(int year) {
		return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
	}

	private int getMaxDaysOfMonth(int year, int month) {
		return isLeapYear(year) ? LEAP_MAX_DAYS[month] : MAX_DAYS[month];
	}

	private int getWeekDay(int year, int month) {
		// 1년 1월 1일은 월요일
		int countDays = 1;
		for (int i = 1; i < year; i++) {
			countDays += isLeapYear(i) ? 366 : 365;
		}

		for (int i = 1; i < month; i++) {
			countDays += isLeapYear(year) ? LEAP_MAX_DAYS[i] : MAX_DAYS[i];
		}

		return countDays % 7;
	}

	public void printCalendar(int year, int month) {
		System.out.printf("   <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");

		int weekday = getWeekDay(year, month);

		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}

		int maxDays = getMaxDaysOfMonth(year, month);
		for (int i = 1; i <= maxDays; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == (7 - weekday) % 7 || i == maxDays)
				System.out.println();
		}
		System.out.println();
	}
}