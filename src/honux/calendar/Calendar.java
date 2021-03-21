package honux.calendar;

public class Calendar {
	private static final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	public boolean isLeapYear(int year) {
		if (year % 400 == 0) return true;
		if (year % 100 == 0) return false;
		if (year % 4 == 0) return true;
		return false;
	}
	
	public int getMaxDaysOfMonth(int year, int month) {
		return isLeapYear(year) ? LEAP_MAX_DAYS[month] : MAX_DAYS[month];
	}

	public void printCalendar(int year, int month, int weekday) {
		System.out.printf("   <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		
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
