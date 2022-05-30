package money;

import java.util.Scanner;
import exception.Month1FormatException;

public class Month30 extends Date {
	private static final long serialVersionUID = 3538913508247546253L;
	public Month30(Month month30) {
		
	}

	public void getUserInput(Scanner input) {
		String month1 = "1";		// �ݺ����� �����ϱ� ���� month1�� 1 ����
		while(month1.contains("1") || month1.contains("2") || month1.contains("3") || month1.contains("4") ||
				month1.contains("5") || month1.contains("6") || month1.contains("7") || month1.contains("8") ||
				month1.contains("9") || month1.contains("10") || month1.contains("11") || month1.contains("12")) {
			System.out.print("Month(ex: April): ");
			month1 = input.next();
			try {
				this.setMonth1(month1);		// setMonth1�� ���� ��
			} catch (Month1FormatException e) {	// ���ܰ� �����
				System.out.println("Please input like April, not 4");	// �ٽ� �Է��϶�� �޽���
			}
		}
		
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
