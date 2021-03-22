package honux.calendar;

import java.util.Scanner;

public class Prompt {
	
	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+----------------------+");
	}
	
	public void runPrompt() {
		printMenu();
		
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		boolean isLoop = true;
		while (isLoop) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = scanner.nextLine().trim();
			switch (cmd) {
			case "1":
				cmdRegister(scanner, cal);
				break;
			case "2":
				cmdSearch(scanner, cal);
				break;
			case "3":
				cmdCal(scanner, cal);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				isLoop = false;
				break;
			}
		}
		
		System.out.println("Thank you. Bye~");
		scanner.close();
	}

	private void cmdCal(Scanner scanner, Calendar cal) {
		System.out.println("년을 입력하세요(exit: -1)");
		System.out.print("YEAR> ");
		int year = scanner.nextInt();
		if (year == -1)
			return;
		
		System.out.println("월을 입력하세요.");
		System.out.print("MONTH> ");
		int month = scanner.nextInt();
		// 버퍼 비우기
		scanner.nextLine();
		if (month < 1 || month > 12) {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		
		cal.printCalendar(year, month);
	}

	private void cmdSearch(Scanner scanner, Calendar cal) {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해 주세요. (yyyy-mm-dd)");
		String strDate = scanner.nextLine().trim();
		
		PlanItem plan = cal.searchPlan(strDate);
		System.out.println(plan == null ? "일정이 없습니다." : plan.detail);
	}

	private void cmdRegister(Scanner scanner, Calendar cal) {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해주세요 (yyyy-mm-dd).");
		String strDate = scanner.nextLine().trim();
		
		System.out.println("일정을 입력해주세요.");
		String plan = scanner.nextLine().trim();
		
		cal.registerPlan(strDate, plan);
	}

	public static void main(String[] args) {
		// 쉘 실행
		Prompt p = new Prompt();
		p.runPrompt();
	}
}