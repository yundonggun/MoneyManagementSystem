package money;

import java.util.Scanner;
import exception.Month1FormatException;

public class February extends Date {
	private static final long serialVersionUID = 8897983662350138611L;

	public February(Month february) {
		
	}

	public void getUserInput(Scanner input) {
		try {
			this.setMonth1("February");
		} catch (Month1FormatException e) {
			e.printStackTrace();
		}
		
		int day1 = 0;
		while(day1 <= 0 || day1 >= 29) {
			System.out.print("Day: ");			
			day1 = input.nextInt();
			if(day1 > 0 && day1 < 29) {
				int day = day1;
				this.setDay(day);
				break;
			}
			else {
				System.out.println("February is until the 28th.");
			}		// 입력 받은 날짜가 0보다 크거나 29보다 작을 때 day에 입력받은 값을 저장하고 setDay로 저장한다. 
		}	// 아니면 문장을 출력하고 다시 값을 입력 받는다.
		
		setUserIncome(input);
		setUserExpense(input);
		setUserContent(input);
		setUserPlace(input);
	}
	
	public void printInfo() {
		System.out.println("Month: " + month1 + " Day: " + day + " Income: " + income + " Expense: " + expense + 
				" Content: " + content + " Place: " + place + " Balance: " + (income - expense));
	}
}
