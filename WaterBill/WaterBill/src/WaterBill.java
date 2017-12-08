/*
 * Ziya Xu
 * Period 2
 * Water Bill Program
 * 9/19/17
 * 
 * This program asks the user to input their ID number, billing code, and
 * the number of gallons of water they used.  Then, the program will calculate
 * their water bill and display the information to the user.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaterBill {
	
	//constants
	public static final char H_LOWER = 'h';
	public static final char H_UPPER = 'H';
	public static final char C_LOWER = 'c';
	public static final char C_UPPER = 'C';
	public static final char I_LOWER = 'i';
	public static final char I_UPPER = 'I';
	public static final int GAL_LIM_ONE = 4000000;
	public static final int GAL_LIM_TWO = 10000000;
	public static final int COST_ONE = 1000;
	public static final int COST_TWO = 2000;
	public static final int COST_THREE = 3000;
	public static final int INIT_H  = 5;
	public static final double RATE_H = 0.0005;
	public static final double RATE_C = 0.00025;
	
	private int id, gallons;
	private char code;
	
	//constructor
	public WaterBill(int id, char code, int gallons) {
		this.id = id;
		this.code = code;
		this.gallons = gallons;
	}
	
	//getters
	public int getID() {
		return id;
	}
	
	public char getCode() {
		return code;
	}
	
	public int getGallons() {
		return gallons;
	}
	
	//method to calculate the cost of the bill
	public double calcBill() {
		double bill;
		
		//home use
		if (getCode() == H_LOWER || getCode() == H_UPPER)
			bill = INIT_H + RATE_H * getGallons();
		
		//commercial use
		else if (getCode() == C_LOWER || getCode() == C_UPPER) {
			if (getGallons() >= GAL_LIM_ONE) 
				bill = COST_ONE + (getGallons() - GAL_LIM_ONE) * RATE_C;
			else
				bill = COST_ONE;
		}
		
		//industrial use
		else if (getCode() == I_LOWER || getCode() == I_UPPER)
			if (getGallons() > GAL_LIM_TWO)
				bill = COST_THREE;
			else if (getGallons() > GAL_LIM_ONE)
				bill = COST_TWO;
			else
				bill = COST_ONE;
		
		//error with code
		else {
			System.out.println("Sorry, there was an error with the code you entered.");
			bill = 0;
		}
		
		//rounding to hundreds
		bill = (int) (bill * 100 + 0.5) / 100.0;
		
		return bill;
	}
	
	//method to display information
	public void print() {
		System.out.println("ID number: " + getID());
		
		if (getCode() == H_LOWER || getCode() == H_UPPER)
			System.out.println("Code: home use");
		else if (getCode() == C_LOWER || getCode() == C_UPPER)
			System.out.println("Code: commercial use");
		else
			System.out.println("Code: industrial use");
		
		System.out.println("Gallons Used: " + getGallons());
		
		System.out.println("Bill: $" + calcBill());
	}
	
	public static void main (String args[]) throws IOException {
		
		//input from user
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Enter your ID number. Enter 0 to stop entering.");
		int id = new Integer(input.readLine());
		
		while (id != 0) {
			System.out.println("Enter your billing code as one character: ");
			char code = input.readLine().charAt(0);
			
			System.out.println("Enter the number of gallons of water used as a numeric value: ");
			int gallons = new Integer(input.readLine());
			
			//new WaterBill object
			WaterBill bill = new WaterBill(id, code, gallons);
			bill.print();
			
			System.out.println("Enter your ID number. Enter 0 to stop entering.");
			id = new Integer(input.readLine());
		}
		
	}
}

/*Output
Enter your ID number. Enter 0 to stop entering.
10
Enter your billing code as one character: 
c
Enter the number of gallons of water used as a numeric value: 
5000022
ID number: 10
Code: commercial use
Gallons Used: 5000022
Bill: $1250.01
Enter your ID number. Enter 0 to stop entering.
11
Enter your billing code as one character: 
i
Enter the number of gallons of water used as a numeric value: 
1234567
ID number: 11
Code: industrial use
Gallons Used: 1234567
Bill: $1000.0
Enter your ID number. Enter 0 to stop entering.
12
Enter your billing code as one character: 
h
Enter the number of gallons of water used as a numeric value: 
8765
ID number: 12
Code: home use
Gallons Used: 8765
Bill: $9.38
Enter your ID number. Enter 0 to stop entering.
13
Enter your billing code as one character: 
c
Enter the number of gallons of water used as a numeric value: 
444444
ID number: 13
Code: commercial use
Gallons Used: 444444
Bill: $1000.0
Enter your ID number. Enter 0 to stop entering.
14
Enter your billing code as one character: 
i
Enter the number of gallons of water used as a numeric value: 
5555555
ID number: 14
Code: industrial use
Gallons Used: 5555555
Bill: $2000.0
Enter your ID number. Enter 0 to stop entering.
15
Enter your billing code as one character: 
i
Enter the number of gallons of water used as a numeric value: 
20000000
ID number: 15
Code: industrial use
Gallons Used: 20000000
Bill: $3000.0
Enter your ID number. Enter 0 to stop entering.
0


 */
