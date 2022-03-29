import java.util.Scanner;

public class MoneyManager {
	Money day;		// 클래스 레벨에서 day 생성
	Scanner input;		// 클래스 내용에 필드에 입력
	MoneyManager(Scanner input) {
		this.input = input;	
	}
	
	public void addincome() {
		day = new Money();				// 기본 생성자 
		System.out.print("Day: ");		// 날짜 입력
		day.days = input.nextInt();		// 입력한 내용 저장
		System.out.print("Income: ");		// 수입을 입력하라는 문장 출력
		day.income = input.nextInt();		// income에 입력받은 값 할당
		System.out.print("Content: ");		// 내용을 입력하라는 문장 출력
		day.content = input.next();			// content에 입력받은 값 할당
		System.out.print("Place: ");		// 장소를 입력하라는 문장 출력
		day.place = input.next();		// 문자열 place에 입력받은 값 할당
	}
	
	public void substract() {				
		System.out.print("Days: ");			// 날짜 입력
		int someday = input.nextInt();		// 날짜 저장
		if(day == null) {					
			System.out.println("No data");
			return;
		}
		if(day.days == someday) {			// 입력한 날짜와 처음 날짜가 같으면
			System.out.print("Expense: ");	// 소비 입력
			day.expense = input.nextInt();	// 소비 expense에 할당
			System.out.print("Content: ");	// 내용 입력	
			day.content = input.next();		// content에 할당
			System.out.print("Place: ");	// 장소 입력
			day.place = input.next();		// place에 할당
		}
	}
	
	public void edit() {
		System.out.print("Days: ");
		int someday = input.nextInt();
		if(day == null) {
			System.out.println("No data");
		}
		if(day.days == someday) {
			System.out.print("Content: ");		// 내용 입력하라는 문장 출력
			String edit1 = input.next();			// edit 문자열에 입력받은 값 할당
			day.content = edit1;				// content에 edit 할당
			System.out.print("Place: ");		// 장소 입력하라는 문장 출력
			String edit2 = input.next();		// edit2에 입력받은 값 할당
			day.place = edit2;				// place에 edit2 할당
		}	
	}
	
	public void balance() {
		System.out.print("Days: ");
		int someday = input.nextInt();
		if(day == null) {
			System.out.println("No data");
		}
		if(day.days == someday) {			// 입력한 내용이 날짜에 있을 때
			day.balance = day.income - day.expense;		// 잔액을 계산하는 식
			System.out.printf("Days: %d Content: %s Place: %s\n", day.days, day.content, day.place);  // 날짜와 내용과 장소 출력
			System.out.printf("Balance: %d\n", day.balance); 	// 잔액을 출력
		}
	}
}
