package honux.calendar;

public class Calendar {
	public static void main(String[] args) {
		System.out.println("�� �� ȭ �� �� �� ��");
		System.out.println("--------------------");
		int day = 1;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.printf("%2d ", day++);
			}
			System.out.println();
		}
	}
}
