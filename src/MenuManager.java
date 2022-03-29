import java.util.Scanner;    										// scanner 클래스 import

public class MenuManager {   										// 
	public static void main(String[] args) {  						// main 함수 
		Scanner input = new Scanner(System.in);						// 스캐너 생성
		MoneyManager moneyManager = new MoneyManager(input);		// 메모리할당
		
		int num = 0;        				  						// int num 선언 및 0 저장
		while(num != 5) {											// 입력받은 num 값이 6이 아닐 때 반복문 수행
			System.out.println("1. Add Income");					// 1-6번까지 메뉴 출력
			System.out.println("2. Subtract Expense");
			System.out.println("3. Edit Content");
			System.out.println("4. Show Balance");
			System.out.println("5. Exit");							
			System.out.println("Select one number between 1-5: ");	// 1-6번 중에서 선택하라는 말 출력
			num = input.nextInt();									// 입력받은 숫자를 저장한다 num에 저장한다
			if(num == 1) {			// 입력 받은 num이 1일 때
				moneyManager.addincome();		// addincome 메서드로 이동
			}
			else if(num == 2) {		// 2일 때
				moneyManager.substract();		// substract 메서드로 이동
			}
			else if(num == 3) {		// 3일 때
				moneyManager.edit();				// edit 메서드로 이동
			}
			else if(num == 4) {		// 4일 때
				moneyManager.balance();			// balance 메서드로 이동
			}
		}
	}
	
	
}
