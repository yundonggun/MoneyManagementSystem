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
}
