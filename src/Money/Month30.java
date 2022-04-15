package Money;

import java.util.Scanner;

public class Month30 extends Date {
	public void getUserInput(Scanner input) {
		System.out.print("Month: ");
		String month1 = input.next();
		this.setMonth1(month1);
		
		int day1 = 0;
		while(day1 <= 0 || day1 >= 31) {
			System.out.print("Day: ");			
			day1 = input.nextInt();
			if(day1 > 0 && day1 < 31) {
				int day = day1;
				this.setDay(day);
				break;
			}
			else {
				System.out.println(month1 + " is until the 30th.");
			}		// 입력 받은 날짜가 0보다 크거나 29보다 작을 때 day에 입력받은 값을 저장하고 setDay로 저장한다. 
		}	// 아니면 문장을 출력하고 다시 값을 입력 받는다.
		
		System.out.print("Income: ");	
		int income = input.nextInt();	
		this.setIncome(income);
			
		System.out.print("Expense: ");
		int expense = input.nextInt();
		this.setExpense(expense);
			
		System.out.print("Content: ");	
		String content = input.next();
		this.setContent(content);
			
		System.out.print("Place: ");
		String place = input.next();
		this.setPlace(place);
	}
}
