
public class Money {
	int income;
	int expense;
	String content;
	int balance;
	String place;
	int days;		// �ʵ� 
	
	public Money() {
	}		// �⺻ ������
	
	public Money(int days, int income, int expense, String content, int balance, String place) {
		this.days = days;
		this.income = income;
		this.expense = expense;
		this.content = content;
		this.balance = balance;
		this.place = place;
	}
	
	public void printInfo() {
		System.out.println("Days: " + days + "Income: " + income + "Expense: " + expense + "Content: " + content 
				+ "Balance: " + balance + "Content: " + content + "Place: " + place);
	}
} 
