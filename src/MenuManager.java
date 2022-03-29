import java.util.Scanner;    										// scanner Ŭ���� import

public class MenuManager {   										// 
	public static void main(String[] args) {  						// main �Լ� 
		Scanner input = new Scanner(System.in);						// ��ĳ�� ����
		MoneyManager moneyManager = new MoneyManager(input);		// �޸��Ҵ�
		
		int num = 0;        				  						// int num ���� �� 0 ����
		while(num != 5) {											// �Է¹��� num ���� 6�� �ƴ� �� �ݺ��� ����
			System.out.println("1. Add Income");					// 1-6������ �޴� ���
			System.out.println("2. Subtract Expense");
			System.out.println("3. Edit Content");
			System.out.println("4. Show Balance");
			System.out.println("5. Exit");							
			System.out.println("Select one number between 1-5: ");	// 1-6�� �߿��� �����϶�� �� ���
			num = input.nextInt();									// �Է¹��� ���ڸ� �����Ѵ� num�� �����Ѵ�
			if(num == 1) {			// �Է� ���� num�� 1�� ��
				moneyManager.addincome();		// addincome �޼���� �̵�
			}
			else if(num == 2) {		// 2�� ��
				moneyManager.substract();		// substract �޼���� �̵�
			}
			else if(num == 3) {		// 3�� ��
				moneyManager.edit();				// edit �޼���� �̵�
			}
			else if(num == 4) {		// 4�� ��
				moneyManager.balance();			// balance �޼���� �̵�
			}
		}
	}
	
	
}
