package honux.calendar;

import java.util.Scanner;

public class Calendar {
	private static final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month];
	}

	public void printSampleCalendar() {
		System.out.println("일 월 화 수 목 금 토");
		System.out.println("--------------------");
		int day = 1;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.printf("%2d ", day++);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {

		// 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		String PROMPT = "cal> ";
		
		String res = "";
		System.out.println("월을 입력하세요.");
		while (true) {
			System.out.print(PROMPT);
			int month = scanner.nextInt();
			if (month <= 0)	break;
			if (month > 12)	continue;
			res += String.format("%d월은 %d일까지 있습니다.\n", month, cal.getMaxDaysOfMonth(month));
		}
		System.out.println(res);

		cal.printSampleCalendar();

		scanner.close();
	}
}
