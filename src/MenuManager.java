import java.util.Scanner;    										// scanner 클래스 import

public class MenuManager {   										// 
	
	static int income;			// 인스턴스 변수 income 선언
	static int expense;			// 인스턴스 변수 expense 선언
	static String content;		// 인스턴스 변수 content 선언
	
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
			if(num == 1) {			// 입력 받은 num이 1일 때
				addincome();		// addincome 메서드로 이동
			}
			else if(num == 2) {		// 2일 때
				substract();		// substract 메서드로 이동
			}
			else if(num == 3) {		// 3일 때
				edit();				// edit 메서드로 이동
			}
			else if(num == 4) {		// 4일 때
				balance();			// balance 메서드로 이동
			}
		}
	}
	
	public static void addincome() {
		Scanner input = new Scanner(System.in);	// scanner 객체 생성
		System.out.print("Income: ");		// 수입을 입력하라는 문장 출력
		income = input.nextInt();			// 인스턴스 변수 income에 입력받은 값 할당
		System.out.print("Content: ");		// 내용을 입력하라는 문장 출력
		content = input.next();				// 인스턴스 변수 content에 입력받은 값 할당
		System.out.print("Place: ");		// 장소를 입력하라는 문장 출력
		String place = input.next();		// 문자열 place에 입력받은 값 할당
	}
	
	public static void substract() {
		Scanner input = new Scanner(System.in);	//scanner 객체 생성
		System.out.print("Expense: ");		// 소비를 입력하라는 문장 출력
		expense = input.nextInt();			// 인스턴스 변수 expense에 입력받은 값 할당
		System.out.print("Content: ");		// 내용을 입력하라는 문장 출력
		String content2 = input.next();		// 문자열 content2에 내용 할당
		System.out.print("Place: ");		// 장소를 입력하라는 문장 출력
		String place2 = input.next();		// 문자열 place2에 입력받은 값 할당
	}
	
	public static void edit() {
		Scanner input = new Scanner(System.in);	// scanner 객체 생성
		System.out.print("Content: ");		// 내용 입력하라는 문장 출력
		String edit = input.next();			// edit 문자열에 입력받은 값 할당
		content = edit;						// 인스턴스 변수 content에 edit 할당
	}
	
	public static void balance() {
		int balance = income - expense;		// 잔액을 계산하는 식
		System.out.printf("Balance: %d\n", balance); 	// 잔액을 출력
	}
}
