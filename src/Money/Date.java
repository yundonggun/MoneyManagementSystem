package Money;

import java.util.Scanner;

public abstract class Date {
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

	public void setMonth1(String month1) {
		this.month1 = month1;
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public abstract void printInfo();
}