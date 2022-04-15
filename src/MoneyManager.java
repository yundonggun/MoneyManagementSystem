import java.util.Scanner;
import Money.Date;
import Money.February;
import Money.Month30;
import Money.Month31;

import java.util.ArrayList;

public class MoneyManager {
	ArrayList<Date> dates = new ArrayList<Date>();		// 클래스 레벨에서 배열 day 생성
	Scanner input;		// 클래스 내용에 필드에 입력
	MoneyManager(Scanner input) {
		this.input = input;	
	}
	
	public void addContent() {
		int month = 0;
		Date date;
		while (month != 1 && month != 2 && month != 3) {
			System.out.print("1 for Months with 30 days, ");
			System.out.print("2 for Months with 31 days, ");
			System.out.println("3 for February");
			System.out.print("Select num for Quater between 1 - 3: ");
			month = input.nextInt();
			if(month == 1) {
				date = new Month30();
				date.getUserInput(input);
				dates.add(date);
				break;
			}
			else if(month == 2) {
				date = new Month31();
				date.getUserInput(input);
				dates.add(date);
				break;
			}
			else if(month == 3) {
				date = new February();
				date.getUserInput(input);
				dates.add(date);
				break;
			}
			else {
				System.out.println("Select num for Quater between 1 - 3");
			}
		}
		
	}
	
	public void deleteContent() {				
		System.out.print("Month: ");
		String somemonth = input.next();
		System.out.print("Day: ");			// 날짜 입력
		int someday = input.nextInt();		// 날짜 저장
		int index = -1;
		for(int i = 0; i < dates.size(); i++) {
			if(dates.get(i).getMonth1().equals(somemonth)) {			// 입력한 날짜와 처음 날짜가 같으면
				if(dates.get(i).getDay() == someday) {
					index = i;
				break;
				}
			}
		}
		if (index >= 0) {
			dates.remove(index);
			System.out.println("The data of " + somemonth + " " + someday + " is deleted");
		}
		else {
			System.out.println("The day has not been register");
			return;
		}
	}
	
	public void editContent() {
		System.out.print("Month: ");
		String somemonth = input.next();
		System.out.print("Days: ");
		int someday = input.nextInt();
		for(int i = 0; i < dates.size(); i++) {
			Date date = dates.get(i);
			if(date.getMonth1().equals(somemonth)) {
				if(date.getDay() == someday) {
					int num = -1;
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
							date.setIncome(income);
						}
						else if (num == 2) {
							System.out.print("Expense: ");
							int expense = input.nextInt();
							date.setExpense(expense);
						}
						else if (num == 3) {
							System.out.print("Content: ");
							String content = input.next();
							date.setContent(content);
						}
						else if (num == 4) {
							System.out.print("Place: ");
							String place = input.next();
							date.setPlace(place);
						}
						else {
							continue;
						}
					} // while
				} // if
			} // if
			else {
				System.out.println("No Data");
			} // else
		} // for
	}
	
	public void showContent() {
		for(int i = 0; i < dates.size(); i++) {
			dates.get(i).printInfo();
		}
	}
}