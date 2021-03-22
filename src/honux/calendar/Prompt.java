package honux.calendar;

import java.util.Scanner;

public class Prompt {
	
	public void runPrompt() {

		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {
			System.out.println("년을 입력하세요(exit: -1)");
			System.out.print("YEAR> ");
			int year = scanner.nextInt();
			if (year == -1)
				break;
			
			System.out.println("월을 입력하세요.");
			System.out.print("MONTH> ");
			int month = scanner.nextInt();
			if (month <= 0 || month > 12) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			
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
