import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;    										// scanner Ŭ���� import
import log.EventLogger;

public class MenuManager {   										// 
	static EventLogger logger = new EventLogger("log.txt");
	
	public static void main(String[] args) {  						// main �Լ� 
		
		Scanner input = new Scanner(System.in);						// ��ĳ�� ����
		MoneyManager moneyManager = getObject("moneymanager.ser");
		if(moneyManager == null) {
			moneyManager = new MoneyManager(input);
		}
		else {				// �α� ������ ���� ��, input�� �Ҵ�
			moneyManager.input = input;
		}

		showMenu();
		selectMenu(input, moneyManager);
		putObject(moneyManager, "moneymanager.ser");
	} 	
	
	public static void showMenu() {
		System.out.println("*** Money Manager ***");
		System.out.println("1. Add Content");					// 1-5������ �޴� ���
		System.out.println("2. Delete Content");
		System.out.println("3. Edit Content");
		System.out.println("4. Show Content");
		System.out.println("5. Exit");							
		System.out.print("Select one number between 1 - 5: ");	// 1-5�� �߿��� �����϶�� �� ���
	}
	
	public static void selectMenu(Scanner input, MoneyManager moneyManager) {
		int num = 0;        				  						// int num ���� �� 0 ����
		while(num != 5) {											// �Է¹��� num ���� 5�� �ƴ� �� �ݺ��� ����
			try {
				num = input.nextInt();									// �Է¹��� ���ڸ� �����Ѵ� num�� �����Ѵ�
				switch(num) {
				case 1:		// �Է� ���� num�� 1�� ��
					moneyManager.addContent();		// addContent �޼���� �̵�
					logger.log("add a content");
					break;
				case 2:		// 2�� ��
					moneyManager.deleteContent();	// deleteContent �޼���� �̵�
					logger.log("delete a content");
					break;
				case 3:		// 3�� ��
					moneyManager.editContent();		// editContent �޼���� �̵�
					logger.log("edit a content");
					break;
				case 4:		// 4�� ��
					moneyManager.showContent();		// showContent �޼���� �̵�
					logger.log("show a content");
					break;
				default: 
					continue;
				}
				showMenu();
			}
			catch(InputMismatchException e) {
				System.out.println("Error. Please input an integer between 1 - 5");
				if(input.hasNext()) {	// �Է� ���� ���� ������ ���ְ� 
					input.next();		// �ٽ� ����ڿ��� �� �Է� ����
				}
				num = 0;
				showMenu();
			}
		}	
	}
	
	public static MoneyManager getObject(String filename) {
		MoneyManager moneyManager = null;
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			
			moneyManager = (MoneyManager)in.readObject();
			
			in.close();
			file.close();
		} catch (FileNotFoundException e) {	
			return moneyManager;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return moneyManager; 
	}

	public static void putObject(MoneyManager moneyManager, String filename) {
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(moneyManager);
			
			out.close();
			file.close();
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
/* Ŭ���� ����
1. ���
MenuManager ���α׷��� ���ڸ� �Է¹޾Ƽ� �׿� ���� ����� �ؼ� �ܾ��� �����ִ� ���α׷��̴�.
2. �ҽ��ڵ� �帧 �� ����
MenuManager ���α׷����� ó�� �޴��� ����ϰ� ���ڸ� �Է� �޴´�. MoneyManager Ŭ���������� MenuManager Ŭ�������� �Է� ���� ���ڿ� �ش��ϴ� �Լ��� 
�����Ѵ�. 
ArrayList�� ����Ͽ� ����ڿ��� �Է� ���� ���� ��� �����Ѵ�. �̶� ���� ���� �Է� �޾Ƽ� �׿� �´� ���� �����Ѵ�.
1�� �Է� �޾��� �� addContent �޼���� �̵��Ѵ�. addContent������ 1���� 3���� ���� �Է¹޾� ���� �ش��ϴ� Ŭ������ ������ �����Ѵ�. 
2�� �Է� �޾��� �� deleteContent �޼���� �̵��Ѵ�. deleteContent������ ����ڰ� �Է��� ���� ���� ����� ���� ���� �� �׿� �ִ� ������ �����ϴ� ����� �Ѵ�.
3�� �Է� �޾��� �� editContent �޼���� �̵��Ѵ�. editContent������ ����ڰ� �Է��� ���� ���� ����� ���� ���� �� �ű⼭ 1���� 5���� ���ڸ� �Է��ؼ� ���ϴ� �κ��� 
�����ϰų� editContent�� ���� �� �ִ�. 4�� �Է� �޾��� �� printInfo�� ȣ���Ͽ� �̶����� ������ ���� ��� ����ϰ� �ȴ�. 
Date Ŭ���������� MoneyManager�� ���Ǵ� �ʵ带 �����Ѵ�. printInfo �޼���� �Է� ���� ���� ����ϰ� getUserInput �޼���� ����ڿ��� ���� �Է� �޴´�.
February Ŭ������ Date Ŭ������ ��� �޴´�. �̶� ����ڰ� �Է��ϴ� day ���� �������� ��� ��� �ٽ� �Է��϶�� ������ ����ϰ� ����� �ԷµǾ��� �� �ٸ� ���� �Է¹ް�
�����Ѵ�. Month30�� Month31 Ŭ������ ������ ���� 30�� �̰ų� 31���� �޿� ����Ѵ�. Ŭ���������� ���� ���� �Է� �ް� �������� February Ŭ������ ������ ����� �Ѵ�. 
3. input, output
input�� int���̰� output�� String�� month1, content, place�̰� int�� day, income, expense�̴�. 
*/