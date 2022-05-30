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
	ArrayList<DateInput> dates = new ArrayList<DateInput>();		// Ŭ���� �������� arraylist date ����
	transient Scanner input;		// Ŭ���� ���뿡 �ʵ忡 �Է�
	MoneyManager(Scanner input) {
		this.input = input;	
	}
	
	public void addContent() {
		int num = 0;
		DateInput dateInput;	// ������
		while (num != 1 && num != 2 && num != 3) {	// �Է¹��� num�� 1, 2, 3 ��� �ƴҶ����� �ݺ�
			try {
				System.out.println("1 for Months with 30 days, 2 for Months with 31 days, 3 for February");
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
					System.out.println("Please input an integer between 1 - 3");
				}	// 1, 2, 3�� �ƴ� �ٸ� ���� �Է����� ��
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
		String somemonth = input.next();	// �� ����
		System.out.print("Day: ");			// ��¥ �Է�
		int someday = input.nextInt();		// ��¥ ����
		int index = findIndex(somemonth, someday);
		removefromDates(index, somemonth, someday);
	}
	
	public void editContent() {
		System.out.print("Month: ");	
		String somemonth = input.next();	// �Է¹��� �� ����
		try {
			System.out.print("Days: ");
			int someday = input.nextInt();		// �Է¹��� �� ����
			for(int i = 0; i < dates.size(); i++) {
				DateInput dateInput = dates.get(i);	// date�� arraylist �� ����
				if(dateInput.getMonth1().equals(somemonth)) {	// getMonth1���� �Է¹��� ���� ���� ��
					if(dateInput.getDay() == someday) {	// getDay�� �Է¹��� ���� ���� ��
						int num = -1;	// num = -1�� �ʱ�ȭ
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
						System.out.println("The day has not been registered.");	// �Է��� ���� ���� �ʴٸ� ���
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
			dates.get(i).printInfo();	// printInfo �޼���� arraylist�� ���� ���
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
			if(dates.get(i).getMonth1().equals(somemonth)) {			// �迭�� ����� ���� �Է¹��� ���� ������
				if(dates.get(i).getDay() == someday) {
					index = i;		// index�� i�� ����
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
		}			// ����� index ���� 0�̻��̸� �迭�� index��° �� ����
		else {
			System.out.println("The day has not been registered.");
			return -1;	// index ���� ������ ������ ��ϵ� ���� ���ٰ� ���.
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
