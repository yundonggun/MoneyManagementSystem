import java.util.Scanner;    										// scanner Ŭ���� import

public class MenuManager {   										// 
	
	public static void main(String[] args) {  						// main �Լ� 
		int num = 0;        				  						// int num ���� �� 0 ����
		Scanner input = new Scanner(System.in);						// ��ĳ�� ����
		
		while(num != 6) {											// �Է¹��� num ���� 6�� �ƴ� �� �ݺ��� ����
			System.out.println("1. Add Income");					// 1-6������ �޴� ���
			System.out.println("2. Subtract Expense");
			System.out.println("3. Edit Content");
			System.out.println("4. Show Balance");
			System.out.println("5. Show a Menu");
			System.out.println("6. Exit");							
			System.out.println("Select one number between 1-6: ");	// 1-6�� �߿��� �����϶�� �� ���
			num = input.nextInt();									// �Է¹��� ���ڸ� �����Ѵ� num�� �����Ѵ�
			int income = 0; 										// ���� income expense balance ���� �� 0����
			int expense = 0; 
			int balance = 0;
			switch(num) {											// switch case �� ����
			case 1:													// num�� 1�϶�
				System.out.println("Income: ");						// income�� ���� �Է��� �˸��� ���� ���
				income = input.nextInt();							// income ���� �� �Է¹��� �� ����
				System.out.println("Content: ");					// content�� ���� �Է��� �˸��� ���� ���
				String content = input.next();						// content ���� �� �Է¹��� ���� ����
				break;												// 1�� ������ �� �ൿ ��
			case 2:													// num�� 2�϶�
				System.out.println("Expense: ");					// expense�� ���� �Է��� �˸��� ���� ���
				expense = input.nextInt();							// expense ���� �� �Է¹��� �� ����
				System.out.println("Content: ");					// content2�� ���� �Է��� �˸��� ���� ���
				String content2 = input.next();						// content2 ���� �� ���� ����
				break;												// 2�� �� �� ���� ��
			case 3:													// num�� 3 �� ��
				System.out.println("Content: ");					// ������ content�� ���� �Է��� �˸��� ���� ���
				String edit = input.next();							// edit ���� �� �Է� ���� ���� ����
				break;												// 3���϶� ��
			case 4:													// num�� 4�϶�
				balance = income - expense;							//
				System.out.printf("Balance: %d\n", balance);		// balance ���
				break;												// 4�� �� ��
			}														// switch case �� ����
		}															// �ݺ��� ��
	}																// main �Լ� ����
}																	// class ����
