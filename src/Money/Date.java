package Money;

import java.util.Scanner;
import exception.Month1FormatException;

public abstract class Date implements DateInput {
	protected Month month = Month.Month30;		// default �� ����
	protected int income;
	protected int expense;
	protected String content;
	protected String place;
	protected String month1;
	protected int day;		// �ʵ� 
	
	public Date() {
	}		// �⺻ ������
	
	public Date(String month1, int day, int income, int expense, String content, String place) {
		this.month1 = month1;
		this.day = day;
		this.income = income;
		this.expense = expense;
		this.content = content;
		this.place = place;
	}		// ������
	
	public Date(Month month30) {
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getExpense() {
		return expense;
	}

	public void setExpense(int expense) {
		this.expense = expense;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getMonth1() {
		return month1;
	}

	public void setMonth1(String month1) throws Month1FormatException {	// ���ܰ� ����� Month1FormatException����
		if(month1.contains("1") || month1.contains("2") || month1.contains("3") || month1.contains("4") ||
				month1.contains("5") || month1.contains("6") || month1.contains("7") || month1.contains("8") ||
				month1.contains("9") || month1.contains("10") || month1.contains("11") || month1.contains("12")) {	
				// month1�� 1���� 12������ ������ �� �ݺ� �߻�
			throw new Month1FormatException();	// ���ܸ� �߻����Ŵ
		}
		this.month1 = month1;
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public void setUserIncome(Scanner input) {
		System.out.print("Income: ");
		int income = input.nextInt();
		this.setIncome(income);	
	}
			
	public void setUserExpense(Scanner input) {
		System.out.print("Expense: ");
		int expense = input.nextInt();
		this.setExpense(expense);	
	}
			
	public void setUserContent(Scanner input) {
		System.out.print("Content: ");
		String content = input.next();
		this.setContent(content);	
	}
			
	public void setUserPlace(Scanner input) {
		System.out.print("Place: ");
		String place = input.next();
		this.setPlace(place);	
	}
	
	public abstract void printInfo();
	
}