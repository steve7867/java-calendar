package honux.calendar;

import java.util.Scanner;

public class Prompt {
	private static final String PROMPT = "cal> ";

	public void runPrompt() {

		// 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		String res = "";
		System.out.println("월을 입력하세요.");
		while (true) {
			System.out.print(PROMPT);
			int month = scanner.nextInt();
			if (month < 0)
				break;
			else if (month == 0 || month > 12)
				continue;
			res += String.format("%d월은 %d일까지 있습니다.\n", month, cal.getMaxDaysOfMonth(month));
		}
		System.out.println(res);

		while (true) {
			System.out.println("몇 월 달력을 출력할까요?");
			System.out.print(PROMPT);
			int month = scanner.nextInt();
			if (month < 0)
				break;
			else if (month == 0 || month > 12)
				continue;
			cal.printCalendar(2021, month);
		}
		System.out.println("Bye~");
		scanner.close();
	}

	public static void main(String[] args) {
		// 쉘 실행
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
