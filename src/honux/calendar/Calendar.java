package honux.calendar;

import java.util.Scanner;

public class Calendar {
	public static void main(String[] args) {
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
		
		//숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		int[] maxDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("달을 입력하세요.");
		int month = scanner.nextInt();
		System.out.printf("%d월은 %d일까지 있습니다.", month, maxDays[month]);
		scanner.close();
	}
}
