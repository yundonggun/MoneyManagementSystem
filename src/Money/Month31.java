package Money;

import java.util.Scanner;

import exception.Month1FormatException;

public class Month31 extends Date implements DateInput {
	public Month31() {
		
	}
	
	public Month31(Month month31) {
		
	}

	public void getUserInput(Scanner input) {
		String month1 = "1";
		while(month1.contains("1") || month1.contains("2") || month1.contains("3") || month1.contains("4") ||
				month1.contains("5") || month1.contains("6") || month1.contains("7") || month1.contains("8") ||
				month1.contains("9") || month1.contains("10") || month1.contains("11") || month1.contains("12")) {
			System.out.print("Month(ex: January): ");
			month1 = input.next();
			try {
				this.setMonth1(month1);
			} catch (Month1FormatException e) {
				System.out.println("Please input like January, not 1");
			}
		}
		
		int day1 = 0;
		while(day1 <= 0 || day1 >= 32) {
			System.out.print("Day: ");			
			day1 = input.nextInt();
			if(day1 > 0 && day1 < 32) {
				int day = day1;
				this.setDay(day);
				break;
			}
			else {
				System.out.println(month1 + " is until the 31st.");
			}		// �Է� ���� ��¥�� 0���� ũ�ų� 29���� ���� �� day�� �Է¹��� ���� �����ϰ� setDay�� �����Ѵ�. 
		}	// �ƴϸ� ������ ����ϰ� �ٽ� ���� �Է� �޴´�.
		
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
	
	public void printInfo() {
		System.out.println("Month: " + month1 + " Day: " + day + " Income: " + income + " Expense: " + expense + 
				" Content: " + content + " Place: " + place + " Balance: " + (income - expense));
	}
}
