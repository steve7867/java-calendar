package honux.calendar;

import java.util.Scanner;

public class Calendar {
	private static final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month];
	}

	public void printCalendar(int year, int month) {
		System.out.printf("     <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU  MO  TU  WE  TH  FR  SA");
		System.out.println("---------------------------");
		
		int maxDays = getMaxDaysOfMonth(month);
		for (int i = 1; i <= maxDays; i++) {
			System.out.printf("%3d ", i);
			if (i % 7 == 0 || i == maxDays)
				System.out.println();
		}
		System.out.println();
	}
}
