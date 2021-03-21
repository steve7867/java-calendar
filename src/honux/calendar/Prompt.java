package honux.calendar;

import java.util.Scanner;

public class Prompt {
	
	public int parseDay(String str_weekday) {
		str_weekday = str_weekday.toUpperCase();
		return " SU MO TU WE TH FR SA".indexOf(str_weekday) / 3;
	}
	
	public void runPrompt() {

		// 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
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
			
			//버퍼 비우기
			scanner.nextLine();
			System.out.println("첫째 날의 요일을 입력하세요.");
			System.out.print("WEEK_DAY> ");
			String str_weekday = scanner.nextLine();
			int weekday = parseDay(str_weekday);
			
			cal.printCalendar(year, month, weekday);
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
