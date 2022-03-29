import java.util.Scanner;

public class MoneyManager {
	Money day;		// Ŭ���� �������� day ����
	Scanner input;		// Ŭ���� ���뿡 �ʵ忡 �Է�
	MoneyManager(Scanner input) {
		this.input = input;	
	}
	
	public void addincome() {
		day = new Money();				// �⺻ ������ 
		System.out.print("Day: ");		// ��¥ �Է�
		day.days = input.nextInt();		// �Է��� ���� ����
		System.out.print("Income: ");		// ������ �Է��϶�� ���� ���
		day.income = input.nextInt();		// income�� �Է¹��� �� �Ҵ�
		System.out.print("Content: ");		// ������ �Է��϶�� ���� ���
		day.content = input.next();			// content�� �Է¹��� �� �Ҵ�
		System.out.print("Place: ");		// ��Ҹ� �Է��϶�� ���� ���
		day.place = input.next();		// ���ڿ� place�� �Է¹��� �� �Ҵ�
	}
	
	public void substract() {				
		System.out.print("Days: ");			// ��¥ �Է�
		int someday = input.nextInt();		// ��¥ ����
		if(day == null) {					
			System.out.println("No data");
			return;
		}
		if(day.days == someday) {			// �Է��� ��¥�� ó�� ��¥�� ������
			System.out.print("Expense: ");	// �Һ� �Է�
			day.expense = input.nextInt();	// �Һ� expense�� �Ҵ�
			System.out.print("Content: ");	// ���� �Է�	
			day.content = input.next();		// content�� �Ҵ�
			System.out.print("Place: ");	// ��� �Է�
			day.place = input.next();		// place�� �Ҵ�
		}
	}
	
	public void edit() {
		System.out.print("Days: ");
		int someday = input.nextInt();
		if(day == null) {
			System.out.println("No data");
		}
		if(day.days == someday) {
			System.out.print("Content: ");		// ���� �Է��϶�� ���� ���
			String edit1 = input.next();			// edit ���ڿ��� �Է¹��� �� �Ҵ�
			day.content = edit1;				// content�� edit �Ҵ�
			System.out.print("Place: ");		// ��� �Է��϶�� ���� ���
			String edit2 = input.next();		// edit2�� �Է¹��� �� �Ҵ�
			day.place = edit2;				// place�� edit2 �Ҵ�
		}	
	}
	
	public void balance() {
		System.out.print("Days: ");
		int someday = input.nextInt();
		if(day == null) {
			System.out.println("No data");
		}
		if(day.days == someday) {			// �Է��� ������ ��¥�� ���� ��
			day.balance = day.income - day.expense;		// �ܾ��� ����ϴ� ��
			System.out.printf("Days: %d Content: %s Place: %s\n", day.days, day.content, day.place);  // ��¥�� ����� ��� ���
			System.out.printf("Balance: %d\n", day.balance); 	// �ܾ��� ���
		}
	}
}
