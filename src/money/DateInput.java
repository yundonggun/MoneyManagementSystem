package money;

import java.util.Scanner;

import exception.Month1FormatException;

public interface DateInput {
	public void getUserInput(Scanner input);
	
	public String getMonth1();
	
	public int getDay();
	
	public int getIncome();
	
	public int getExpense();
	
	public String getContent();
	
	public String getPlace();
	
	public void setMonth1(String month1) throws Month1FormatException;
	
	public void setDay(int day);
	
	public void setIncome(int income);
	
	public void setExpense(int expense);
	
	public void setContent(String content);
	
	public void setPlace(String place);
	
	public void printInfo();
	
	public void setUserIncome(Scanner input);
	
	public void setUserExpense(Scanner input);
	
	public void setUserContent(Scanner input);
	
	public void setUserPlace(Scanner input);
	
}
