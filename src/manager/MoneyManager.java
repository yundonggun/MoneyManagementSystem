package manager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import money.Date;
import money.DateInput;
import money.February;
import money.Month;
import money.Month30;
import money.Month31;

public class MoneyManager implements Serializable {
	private static final long serialVersionUID = 1145197048678055359L;	// serializable
	ArrayList<DateInput> dates = new ArrayList<DateInput>();		// 클래스 레벨에서 arraylist date 생성
	transient Scanner input;		// 클래스 내용에 필드에 입력
	MoneyManager(Scanner input) {
		this.input = input;	
	}
	
	public void addContent() {
		int num = 0;
		DateInput dateInput;	// 생성자
		while (num != 1 && num != 2 && num != 3) {	// 입력받은 num이 1, 2, 3 모두 아닐때까지 반복
			try {
				System.out.println("1 for Months with 30 days, 2 for Months with 31 days, 3 for February");
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
					System.out.println("Please input an integer between 1 - 3");
				}	// 1, 2, 3이 아닌 다른 수를 입력했을 때
			} catch(InputMismatchException e) {
				System.out.println("Error. Please input an integer between 1 - 3");
				if(input.hasNext()) {
					input.next();
				}
				num = 0;
			} 
		}
	}
	
	public void deleteContent() {				
		System.out.print("Month: ");
		String somemonth = input.next();	// 월 저장
		System.out.print("Day: ");			// 날짜 입력
		int someday = input.nextInt();		// 날짜 저장
		int index = findIndex(somemonth, someday);
		removefromDates(index, somemonth, someday);
	}
	
	public void editContent() {
		System.out.print("Month: ");	
		String somemonth = input.next();	// 입력받은 월 저장
		try {
			System.out.print("Days: ");
			int someday = input.nextInt();		// 입력받은 일 저장
			for(int i = 0; i < dates.size(); i++) {
				DateInput dateInput = dates.get(i);	// date에 arraylist 값 저장
				if(dateInput.getMonth1().equals(somemonth)) {	// getMonth1값과 입력받은 값이 같을 때
					if(dateInput.getDay() == someday) {	// getDay와 입력받은 값이 같을 때
						int num = -1;	// num = -1로 초기화
						while(num!= 5) {
							try {
								showEditMenu();
								num = input.nextInt();
								switch(num) {
								case 1:
									dateInput.setUserIncome(input);
									break;
								case 2:
									dateInput.setUserExpense(input);
									break;
								case 3:
									dateInput.setUserContent(input);
									break;
								case 4:
									dateInput.setUserPlace(input);
									break;
								default:
									continue;
								}
							} 
							catch(InputMismatchException e) {
								System.out.println("Error. Please input an integer between 1 - 5");
								if(input.hasNext()) {
									input.next();
								}
								num = -1;
							}
						} // while
					} // if
					else {
						System.out.println("The day has not been registered.");	// 입력한 날이 같지 않다면 출력
					} // else
				} // if
			} // for
		} 
		catch(InputMismatchException e) {
			System.out.println("Error. Please input an integer between 1 - 5");
			if(input.hasNext()) {
				input.next();
			}
		}
	}
	
	public void showContent() {
		for(int i = 0; i < dates.size(); i++) {
			dates.get(i).printInfo();	// printInfo 메서드로 arraylist의 내용 출력
		}
	}
	
	public int size() {
		return dates.size();
	}
	
	public DateInput get(int index) {
		return (Date) dates.get(index);
	}
	
	public int findIndex(String somemonth, int someday) {
		int index = -1;
		for(int i = 0; i < dates.size(); i++) {
			if(dates.get(i).getMonth1().equals(somemonth)) {			// 배열에 저장된 값과 입력받은 값이 같으면
				if(dates.get(i).getDay() == someday) {
					index = i;		// index에 i로 저장
				break;
				}
			}
		}
		return index;
	}
	
	public int removefromDates(int index, String somemonth, int someday) {
		if (index >= 0) {		
			dates.remove(index);
			System.out.println("The data of " + somemonth + " " + someday + " is deleted.");
			return 1;
		}			// 저장된 index 값이 0이상이면 배열의 index번째 값 삭제
		else {
			System.out.println("The day has not been registered.");
			return -1;	// index 값이 변하지 않으면 등록된 날이 없다고 출력.
		}
	}
	
	public void showEditMenu() {
		System.out.println("*** Money Manager ***");
		System.out.println("1. Edit Income");	
		System.out.println("2. Edit Expense");
		System.out.println("3. Edit Content");
		System.out.println("4. Edit Place");
		System.out.println("5. Exit");		
		System.out.print("Select one number between 1 - 5: ");
	}
}
