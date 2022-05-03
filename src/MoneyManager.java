import java.util.Scanner;
import Money.Date;
import Money.DateInput;
import Money.February;
import Money.Month;
import Money.Month30;
import Money.Month31;

import java.util.ArrayList;

public class MoneyManager {
	ArrayList<DateInput> dates = new ArrayList<DateInput>();		// 클래스 레벨에서 arraylist date 생성
	Scanner input;		// 클래스 내용에 필드에 입력
	MoneyManager(Scanner input) {
		this.input = input;	
	}
	
	public void addContent() {
		int num = 0;
		DateInput dateInput;	// 생성자
		while (num != 1 && num != 2 && num != 3) {	// 입력받은 num이 1, 2, 3 모두 아닐때까지 반복
			System.out.print("1 for Months with 30 days, ");
			System.out.print("2 for Months with 31 days, ");
			System.out.println("3 for February");
			System.out.print("Select num between 1 - 3: ");
			num = input.nextInt();
			if(num == 1) {
				dateInput = new Month30(Month.Month30);	// dynamic binding
				dateInput.getUserInput(input);	// getUserInput 메서드로 입력 받음
				dates.add(dateInput);	// arraylist에 date 추가
				break;
			}
			else if(num == 2) {
				dateInput = new Month31(Month.Month31);
				dateInput.getUserInput(input);
				dates.add(dateInput);
				break;
			}
			else if(num == 3) {
				dateInput = new February(Month.February);
				dateInput.getUserInput(input);
				dates.add(dateInput);
				break;
			}
			else {
				System.out.println("Select num between 1 - 3");
			}	// 1, 2, 3이 아닌 다른 수를 입력했을 때
		}
		
	}
	
	public void deleteContent() {				
		System.out.print("Month: ");
		String somemonth = input.next();	// 월 저장
		System.out.print("Day: ");			// 날짜 입력
		int someday = input.nextInt();		// 날짜 저장
		int index = -1;
		for(int i = 0; i < dates.size(); i++) {
			if(dates.get(i).getMonth1().equals(somemonth)) {			// 배열에 저장된 값과 입력받은 값이 같으면
				if(dates.get(i).getDay() == someday) {
					index = i;		// index에 i로 저장
				break;
				}
			}
		}
		if (index >= 0) {		
			dates.remove(index);
			System.out.println("The data of " + somemonth + " " + someday + " is deleted.");
		}			// 저장된 index 값이 0이상이면 배열의 index번째 값 삭제
		else {
			System.out.println("The day has not been registered.");
			return;		// index 값이 변하지 않으면 등록된 날이 없다고 출력.
		}
	}
	
	public void editContent() {
		System.out.print("Month: ");	
		String somemonth = input.next();	// 입력받은 월 저장
		System.out.print("Days: ");
		int someday = input.nextInt();		// 입력받은 일 저장
		for(int i = 0; i < dates.size(); i++) {
			DateInput dateInput = dates.get(i);	// date에 arraylist 값 저장
			if(dateInput.getMonth1().equals(somemonth)) {	// getMonth1값과 입력받은 값이 같을 때
				if(dateInput.getDay() == someday) {	// getDay와 입력받은 값이 같을 때
					int num = -1;	// num = -1로 초기화
					while(num!= 5) {
						System.out.println("*** Money Manager ***");
						System.out.println("1. Edit Income");	
						System.out.println("2. Edit Expense");
						System.out.println("3. Edit Content");
						System.out.println("4. Edit Place");
						System.out.println("5. Exit");		
						System.out.println("Select oen number between 1 - 5");
						num = input.nextInt();
						if (num == 1) {
							System.out.print("Income: ");
							int income = input.nextInt();
							dateInput.setIncome(income);	// income을 재설정
						}
						else if (num == 2) {
							System.out.print("Expense: ");
							int expense = input.nextInt();
							dateInput.setExpense(expense);	// expense 재설정
						}
						else if (num == 3) {
							System.out.print("Content: ");
							String content = input.next();
							dateInput.setContent(content);	// content 재설정
						}
						else if (num == 4) {
							System.out.print("Place: ");
							String place = input.next();
							dateInput.setPlace(place);	// place 재설정
						}
						else {
							continue;
						}
					} // while
				} // if
				else {
					System.out.println("The day has not been registered.");	// 입력한 날이 같지 않다면 출력
				} // else
			} // if
		} // for
	}
	
	public void showContent() {
		for(int i = 0; i < dates.size(); i++) {
			dates.get(i).printInfo();	// printInfo 메서드로 arraylist의 내용 출력
		}
	}
}