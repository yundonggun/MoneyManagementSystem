package Money;

import java.util.Scanner;

public class Date {
	protected Month month = Month.Month30;
	protected int income;
	protected int expense;
	protected String content;
	protected String place;
	protected String month1;
	protected int day;		// �ʵ� 
	
	public Date() {
	}		// �⺻ ������
	
	public Date(int day, int income, int expense, String content, String place) {
		this.day = day;
		this.income = income;
		this.expense = expense;
		this.content = content;
		this.place = place;
	}		// ������
	
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

	public void setMonth1(String month1) {
		this.month1 = month1;
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public void printInfo() {
		System.out.println("Month: " + month1 + " Day: " + day + " Income: " + income + " Expense: " + expense + " Content: " + content 
				+ " Place: " + place + " Balance: " + (income - expense));
	}
	
	public void getUserInput(Scanner input) {
		System.out.print("Month: ");
		String month1 = input.next();
		this.setMonth1(month1);
		System.out.print("Day: ");		// ��¥ �Է�
		int day = input.nextInt();		// �Է��� ���� ����
		this.setDay(day);
		System.out.print("Income: ");		// ������ �Է��϶�� ���� ���
		int income = input.nextInt();		// income�� �Է¹��� �� �Ҵ�
		this.setIncome(income);
		System.out.print("Expense: ");
		int expense = input.nextInt();
		this.setExpense(expense);
		System.out.print("Content: ");		// ������ �Է��϶�� ���� ���
		String content = input.next();			// content�� �Է¹��� �� �Ҵ�
		this.setContent(content);
		System.out.print("Place: ");		// ��Ҹ� �Է��϶�� ���� ���
		String place = input.next();
		this.setPlace(place);
	}
}