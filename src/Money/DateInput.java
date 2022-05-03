package Money;

import java.util.Scanner;

public interface DateInput {
	public void getUserInput(Scanner input);
	public String getMonth1();
	public int getDay();
	public void setIncome(int income);
	public void setExpense(int expense);
	public void setContent(String content);
	public void setPlace(String place);
	public void printInfo();
}
