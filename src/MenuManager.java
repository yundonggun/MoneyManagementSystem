import java.util.Scanner;    										// scanner Ŭ���� import

public class MenuManager {   										// 
	
	static int income;			// �ν��Ͻ� ���� income ����
	static int expense;			// �ν��Ͻ� ���� expense ����
	static String content;		// �ν��Ͻ� ���� content ����
	
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
			if(num == 1) {			// �Է� ���� num�� 1�� ��
				addincome();		// addincome �޼���� �̵�
			}
			else if(num == 2) {		// 2�� ��
				substract();		// substract �޼���� �̵�
			}
			else if(num == 3) {		// 3�� ��
				edit();				// edit �޼���� �̵�
			}
			else if(num == 4) {		// 4�� ��
				balance();			// balance �޼���� �̵�
			}
		}
	}
	
	public static void addincome() {
		Scanner input = new Scanner(System.in);	// scanner ��ü ����
		System.out.print("Income: ");		// ������ �Է��϶�� ���� ���
		income = input.nextInt();			// �ν��Ͻ� ���� income�� �Է¹��� �� �Ҵ�
		System.out.print("Content: ");		// ������ �Է��϶�� ���� ���
		content = input.next();				// �ν��Ͻ� ���� content�� �Է¹��� �� �Ҵ�
		System.out.print("Place: ");		// ��Ҹ� �Է��϶�� ���� ���
		String place = input.next();		// ���ڿ� place�� �Է¹��� �� �Ҵ�
	}
	
	public static void substract() {
		Scanner input = new Scanner(System.in);	//scanner ��ü ����
		System.out.print("Expense: ");		// �Һ� �Է��϶�� ���� ���
		expense = input.nextInt();			// �ν��Ͻ� ���� expense�� �Է¹��� �� �Ҵ�
		System.out.print("Content: ");		// ������ �Է��϶�� ���� ���
		String content2 = input.next();		// ���ڿ� content2�� ���� �Ҵ�
		System.out.print("Place: ");		// ��Ҹ� �Է��϶�� ���� ���
		String place2 = input.next();		// ���ڿ� place2�� �Է¹��� �� �Ҵ�
	}
	
	public static void edit() {
		Scanner input = new Scanner(System.in);	// scanner ��ü ����
		System.out.print("Content: ");		// ���� �Է��϶�� ���� ���
		String edit = input.next();			// edit ���ڿ��� �Է¹��� �� �Ҵ�
		content = edit;						// �ν��Ͻ� ���� content�� edit �Ҵ�
	}
	
	public static void balance() {
		int balance = income - expense;		// �ܾ��� ����ϴ� ��
		System.out.printf("Balance: %d\n", balance); 	// �ܾ��� ���
	}
}
