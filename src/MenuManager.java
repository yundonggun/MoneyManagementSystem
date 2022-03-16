import java.util.Scanner;    										// scanner 클래스 import

public class MenuManager {   										// 
	
	public static void main(String[] args) {  						// main 함수 
		int num = 0;        				  						// int num 선언 및 0 저장
		Scanner input = new Scanner(System.in);						// 스캐너 생성
		
		while(num != 6) {											// 입력받은 num 값이 6이 아닐 때 반복문 수행
			System.out.println("1. Add Income");					// 1-6번까지 메뉴 출력
			System.out.println("2. Subtract Expense");
			System.out.println("3. Edit Content");
			System.out.println("4. Show Balance");
			System.out.println("5. Show a Menu");
			System.out.println("6. Exit");							
			System.out.println("Select one number between 1-6: ");	// 1-6번 중에서 선택하라는 말 출력
			num = input.nextInt();									// 입력받은 숫자를 저장한다 num에 저장한다
			int income = 0; 										// 정수 income expense balance 선언 후 0저장
			int expense = 0; 
			int balance = 0;
			switch(num) {											// switch case 문 시작
			case 1:													// num이 1일때
				System.out.println("Income: ");						// income에 대한 입력을 알리는 문장 출력
				income = input.nextInt();							// income 선언 후 입력받은 값 저장
				System.out.println("Content: ");					// content에 대한 입력을 알리는 문장 출력
				String content = input.next();						// content 선언 후 입력받은 내용 저장
				break;												// 1번 내용일 때 행동 끝
			case 2:													// num이 2일때
				System.out.println("Expense: ");					// expense에 대한 입력을 알리는 문장 출력
				expense = input.nextInt();							// expense 선언 후 입력받은 값 저장
				System.out.println("Content: ");					// content2에 대한 입력을 알리는 문장 출력
				String content2 = input.next();						// content2 선언 후 내용 저장
				break;												// 2번 일 때 내용 끝
			case 3:													// num이 3 일 때
				System.out.println("Content: ");					// 편집할 content에 대한 입력을 알리는 문장 출력
				String edit = input.next();							// edit 선언 후 입력 받은 내용 저장
				break;												// 3번일때 끝
			case 4:													// num이 4일때
				balance = income - expense;							//
				System.out.printf("Balance: %d\n", balance);		// balance 출력
				break;												// 4일 때 끝
			}														// switch case 문 종료
		}															// 반복문 끝
	}																// main 함수 종료
}																	// class 종료
