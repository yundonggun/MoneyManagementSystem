import java.util.InputMismatchException;
import java.util.Scanner;    										// scanner 클래스 import

public class MenuManager {   										// 
	public static void main(String[] args) {  						// main 함수 
		Scanner input = new Scanner(System.in);						// 스캐너 생성
		MoneyManager moneyManager = new MoneyManager(input);		// 메모리할당
		showMenu();
		int num = 0;        				  						// int num 선언 및 0 저장
		while(num != 5) {											// 입력받은 num 값이 5이 아닐 때 반복문 수행
			try {
				num = input.nextInt();									// 입력받은 숫자를 저장한다 num에 저장한다
				if(num == 1) {			// 입력 받은 num이 1일 때
					moneyManager.addContent();		// addContent 메서드로 이동
				}
				else if(num == 2) {		// 2일 때
					moneyManager.deleteContent();		// deleteContent 메서드로 이동
				}
				else if(num == 3) {		// 3일 때
					moneyManager.editContent();				// editContent 메서드로 이동
				}
				else if(num == 4) {		// 4일 때
					moneyManager.showContent();		// showContent 메서드로 이동
				}
				else if(num == 5) {
					break;
				}
				showMenu();
			}
			catch(InputMismatchException e) {
				System.out.println("Error. Please input an integer between 1 - 5");
				if(input.hasNext()) {	// 입력 받은 값이 있으면 없애고 
					input.next();		// 다시 사용자에게 값 입력 받음
				}
				num = 0;
				showMenu();
			}
		}	
	} 	
	
	public static void showMenu() {
		System.out.println("*** Money Manager ***");
		System.out.println("1. Add Content");					// 1-5번까지 메뉴 출력
		System.out.println("2. Delete Content");
		System.out.println("3. Edit Content");
		System.out.println("4. Show Content");
		System.out.println("5. Exit");							
		System.out.print("Select one number between 1 - 5: ");	// 1-5번 중에서 선택하라는 말 출력
	}
}
/* 클래스 설명
1. 기능
MenuManager 프로그램은 숫자를 입력받아서 그에 따른 계산을 해서 잔액을 보여주는 프로그램이다.
2. 소스코드 흐름 및 실행
MenuManager 프로그램에서 처음 메뉴를 출력하고 숫자를 입력 받는다. MoneyManager 클래스에서는 MenuManager 클래스에서 입력 받은 숫자에 해당하는 함수를 
실행한다. 
ArrayList를 사용하여 사용자에게 입력 받은 값을 모두 저장한다. 이때 월과 일을 입력 받아서 그에 맞는 곳에 저장한다.
1을 입력 받았을 때 addContent 메서드로 이동한다. addContent에서는 1부터 3까지 값을 입력받아 값에 해당하는 클래스의 동작을 수행한다. 
2를 입력 받았을 때 deleteContent 메서드로 이동한다. deleteContent에서는 사용자가 입력한 월과 일이 저장된 값에 있을 때 그에 있는 내용을 삭제하는 기능을 한다.
3을 입력 받았을 때 editContent 메서드로 이동한다. editContent에서는 사용자가 입력한 월과 일이 저장된 값에 있을 때 거기서 1부터 5까지 숫자를 입력해서 원하는 부분을 
수정하거나 editContent를 끝낼 수 있다. 4를 입력 받았을 때 printInfo를 호출하여 이때까지 저장한 값을 모두 출력하게 된다. 
Date 클래스에서는 MoneyManager에 사용되는 필드를 저장한다. printInfo 메서드로 입력 받은 값을 출력하고 getUserInput 메서드로 사용자에게 값을 입력 받는다.
February 클래슨는 Date 클래스를 상속 받는다. 이때 사용자가 입력하는 day 값이 범위에서 벗어날 경우 다시 입력하라는 문장을 출력하고 제대로 입력되었을 때 다른 값을 입력받고
저장한다. Month30과 Month31 클래스는 마지막 날이 30일 이거나 31일인 달에 사용한다. 클래스에서는 먼저 달을 입력 받고 나머지는 February 클래스와 동일한 기능을 한다. 
3. input, output
input은 int형이고 output은 String형 month1, content, place이고 int형 day, income, expense이다. 
*/