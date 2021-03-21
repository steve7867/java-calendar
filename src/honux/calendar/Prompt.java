package honux.calendar;

import java.util.Scanner;

public class Prompt {

	public void runPrompt() {

		// 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {
			System.out.println("년을 입력하세요.");
			System.out.print("YEAR> ");
			int year = scanner.nextInt();
			
			System.out.println("월을 입력하세요.");
			System.out.print("MONTH> ");
			int month = scanner.nextInt();
			if (month < 0)
				break;
			else if (month == 0 || month > 12)
				continue;
			
			cal.printCalendar(year, month);
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
