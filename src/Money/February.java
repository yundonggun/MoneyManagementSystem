package Money;

import java.util.Scanner;

public class February extends Date {
	public void getUserInput(Scanner input) {
		this.setMonth1("February");
		
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
