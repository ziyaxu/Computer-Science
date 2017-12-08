import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Ziya Xu
 * Period 2
 * 9/18/17
 * 
 * Javaland Program
 * This program calculates the amount a citizen of Javaland will have to pay
 * based on their income. 1% is owed on the first $10000 of income, 5% is 
 * owed on the next $20000 of income, and 10% is owed on any income over $30000.
 * Additionally, anyone whose income is over $1000 will have to pay an additional
 * $500 in taxes.
 * 
 */

public class Javaland {
	
	//constants
	public static final int TAX_BRACKET_ONE = 10000;
	public static final int TAX_BRACKET_TWO = 30000;
	public static final double PERCENT_ONE = 0.01;
	public static final double PERCENT_TWO = 0.05;
	public static final double PERCENT_THREE = 0.1;
	
	private int income;

	//constructor for a person
	public Javaland(int salary) {
		income = salary;
	}
	
	//getter for income
	public int getIncome() {
		return income;
	}
	
	//setter for salary
	public void setIncome(int salary) {
		income = salary;
	}
	
	//method to calculate taxes
	public double calcTaxes() {
		double taxes = 0;
		
		if (getIncome() >= 1000){
			taxes += 500;
		}
		
		if (getIncome() <= TAX_BRACKET_ONE) {
			taxes += getIncome() * PERCENT_ONE;
		} else if (getIncome() <= TAX_BRACKET_TWO) {
			taxes += (getIncome() - TAX_BRACKET_ONE) * PERCENT_TWO 
				+ TAX_BRACKET_ONE * PERCENT_ONE;
		} else {
			taxes += (getIncome() - TAX_BRACKET_TWO) * PERCENT_THREE 
				+ TAX_BRACKET_ONE * PERCENT_ONE + TAX_BRACKET_TWO * PERCENT_TWO;
		}
			
		return taxes;
	}
	
	//method to display the income and taxes for each person
	public void print() {
		System.out.println("This person's income is $" + income 
				+ " and will pay $" + calcTaxes() + " in taxes.");
	}
	
	public static void main (String args[]) throws IOException {
		double totalTax = 0;
		
		//prompting user to enter their salary
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Enter your salary as a numeric value.  " 
				+ "Enter -999 as the salary when you are done.");
		
		int salary = new Integer(input.readLine());
		Javaland person = new Javaland(salary);
		
		//continuously asks user for salary entries until -999
		while (salary != -999) {
			
			person.setIncome(salary);
			person.print();
			totalTax += person.calcTaxes();
			
			System.out.println("Enter the next salary.  " 
					+ "Enter -999 as the salary when you are done.");
			
			salary = new Integer(input.readLine());
		}
		
		//rounding and printing total taxes
		totalTax = (int) (totalTax * 100) / 100.0;
		System.out.println("The total amount of taxes paid to the Queen of JavaLand is: $" 
				+ totalTax);
	}
}

/* Output
Enter your salary as a numeric value.  Enter -999 as the salary when you are done.
0
This person's income is $0 and will pay $0.0 in taxes.
Enter the next salary.  Enter -999 as the salary when you are done.
500
This person's income is $500 and will pay $5.0 in taxes.
Enter the next salary.  Enter -999 as the salary when you are done.
5432
This person's income is $5432 and will pay $554.32 in taxes.
Enter the next salary.  Enter -999 as the salary when you are done.
15006
This person's income is $15006 and will pay $850.3 in taxes.
Enter the next salary.  Enter -999 as the salary when you are done.
32999
This person's income is $32999 and will pay $1899.9 in taxes.
Enter the next salary.  Enter -999 as the salary when you are done.
100555
This person's income is $100555 and will pay $8655.5 in taxes.
Enter the next salary.  Enter -999 as the salary when you are done.
-999
The total amount of taxes paid to the Queen of JavaLand is: $11965.02
 */
