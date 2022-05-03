import java.util.Scanner;
import Money.Date;
import Money.DateInput;
import Money.February;
import Money.Month;
import Money.Month30;
import Money.Month31;

import java.util.ArrayList;

public class MoneyManager {
	ArrayList<DateInput> dates = new ArrayList<DateInput>();		// Ŭ���� �������� arraylist date ����
	Scanner input;		// Ŭ���� ���뿡 �ʵ忡 �Է�
	MoneyManager(Scanner input) {
		this.input = input;	
	}
	
	public void addContent() {
		int num = 0;
		DateInput dateInput;	// ������
		while (num != 1 && num != 2 && num != 3) {	// �Է¹��� num�� 1, 2, 3 ��� �ƴҶ����� �ݺ�
			System.out.print("1 for Months with 30 days, ");
			System.out.print("2 for Months with 31 days, ");
			System.out.println("3 for February");
			System.out.print("Select num between 1 - 3: ");
			num = input.nextInt();
			if(num == 1) {
				dateInput = new Month30(Month.Month30);	// dynamic binding
				dateInput.getUserInput(input);	// getUserInput �޼���� �Է� ����
				dates.add(dateInput);	// arraylist�� date �߰�
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
			}	// 1, 2, 3�� �ƴ� �ٸ� ���� �Է����� ��
		}
		
	}
	
	public void deleteContent() {				
		System.out.print("Month: ");
		String somemonth = input.next();	// �� ����
		System.out.print("Day: ");			// ��¥ �Է�
		int someday = input.nextInt();		// ��¥ ����
		int index = -1;
		for(int i = 0; i < dates.size(); i++) {
			if(dates.get(i).getMonth1().equals(somemonth)) {			// �迭�� ����� ���� �Է¹��� ���� ������
				if(dates.get(i).getDay() == someday) {
					index = i;		// index�� i�� ����
				break;
				}
			}
		}
		if (index >= 0) {		
			dates.remove(index);
			System.out.println("The data of " + somemonth + " " + someday + " is deleted.");
		}			// ����� index ���� 0�̻��̸� �迭�� index��° �� ����
		else {
			System.out.println("The day has not been registered.");
			return;		// index ���� ������ ������ ��ϵ� ���� ���ٰ� ���.
		}
	}
	
	public void editContent() {
		System.out.print("Month: ");	
		String somemonth = input.next();	// �Է¹��� �� ����
		System.out.print("Days: ");
		int someday = input.nextInt();		// �Է¹��� �� ����
		for(int i = 0; i < dates.size(); i++) {
			DateInput dateInput = dates.get(i);	// date�� arraylist �� ����
			if(dateInput.getMonth1().equals(somemonth)) {	// getMonth1���� �Է¹��� ���� ���� ��
				if(dateInput.getDay() == someday) {	// getDay�� �Է¹��� ���� ���� ��
					int num = -1;	// num = -1�� �ʱ�ȭ
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
							dateInput.setIncome(income);	// income�� �缳��
						}
						else if (num == 2) {
							System.out.print("Expense: ");
							int expense = input.nextInt();
							dateInput.setExpense(expense);	// expense �缳��
						}
						else if (num == 3) {
							System.out.print("Content: ");
							String content = input.next();
							dateInput.setContent(content);	// content �缳��
						}
						else if (num == 4) {
							System.out.print("Place: ");
							String place = input.next();
							dateInput.setPlace(place);	// place �缳��
						}
						else {
							continue;
						}
					} // while
				} // if
				else {
					System.out.println("The day has not been registered.");	// �Է��� ���� ���� �ʴٸ� ���
				} // else
			} // if
		} // for
	}
	
	public void showContent() {
		for(int i = 0; i < dates.size(); i++) {
			dates.get(i).printInfo();	// printInfo �޼���� arraylist�� ���� ���
		}
	}
}