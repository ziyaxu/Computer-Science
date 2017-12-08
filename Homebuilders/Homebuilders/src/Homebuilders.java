/*
 * Ziya Xu
 * Period 2
 * 9/27/17
 * 
 * Homebuilders Program
 * This program asks the user for their budget, the length, width, and number of stories of a house
 * they want to build, and a pricing style.  Then, program will tell the user if they have enough
 * money to build their dream house.  It will then ask the user if they would like to change any
 * of the inputs to recalculate the price.  The program will keep looping until the user is satisfied.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Homebuilders {
	
	public final static int MIN_COST = 100;
	public final static int STAN_COST = 125;
	public final static int ENERGY_COST = 150;
	public final static int CUSTOM_COST = 200;
	public final static String BUDGET_INPUT = " your budget without the dollar sign";
	public final static String LENGTH_INPUT = " the length of your house";
	public final static String WIDTH_INPUT = " the width of your house";
	public final static String STORIES_INPUT = " the number of stories of your house";
	public final static String STYLE_INPUT = " the pricing option for your house";
	
	private int budget, length, width, stories, rate;
	char style;
	
	//empty constructor
	public Homebuilders() {
	}
	
	//setters from user input
	public void setBudget() throws IOException {
		budget = inputInt(BUDGET_INPUT);
		System.out.println("Your budget is $" + budget + ".");
	}
	
	public void setLength() throws IOException {
		length = inputInt(LENGTH_INPUT);
		System.out.println("The length of your house is " + length + ".");
	}
	
	public void setWidth() throws IOException {
		width = inputInt(WIDTH_INPUT);
		System.out.println("The width of your house is " + width + ".");
	}
	
	public void setStories() throws IOException {
		stories = inputInt(STORIES_INPUT);
		System.out.println("Your house will be " + stories + " stories tall");
	}
	
	public void setStyle() throws IOException {
		inputStyle();
	}
	
	//method to check if a string is an integer
	public boolean isInt(String input) {
		
		try {
	        int num = new Integer(input);
	        if (num <= 0)
	        	return false;
	        else
	        	return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	//method to ask user for the integer input
	public int inputInt(String printed) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Please enter" + printed + " as a positive integer value.");
		String in = input.readLine();
		while (!isInt(in)) {
			System.out.println("Please enter a valid value.");
			in = input.readLine();
		}
		
		return new Integer(in);
	}
	
	//method to check if entered style is valid, assigns 
	public boolean isStyle(char in) {
		
		if (in == 'M' || in == 'm') {
			style = 'm';
			return true;
		} else if (in == 'S' || in == 's') {
			style = 's';
			return true;
		} else if (in == 'E' || in == 'e') {
			style = 'e';
			return true;
		} else if (in == 'C' || in == 'c') {
			style = 'c';
			return true;
		} else
			return false;
	}
	
	//method to ask for style input
	public void inputStyle() throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("There are several pricing options: minimum cost for $100 per square foot, "
				+ "\n" + "standard for $125 per square foot, energy-efficient for $150 per square foot, "
				+ "\n" + "and custom for $200 per square foot.  Enter 'm' for minimum cost, "
				+ "\n" + "'s' for standard, 'e' for energy-efficient, and 'c' for custom."); 
	
		char in = input.readLine().charAt(0);
		while (!isStyle(in)) {
			System.out.println("Please enter a valid code.");
			in = input.readLine().charAt(0);
			
		}
		
		if (style == 'm') {
			rate = MIN_COST;
			System.out.println("You chose the minimum cost option.");
		} else if (style == 's') {
			rate = STAN_COST;
			System.out.println("You chose the standard option.");
		} else if (style == 'e') {
			rate = ENERGY_COST;
			System.out.println("You chose the energy-efficient option.");
		} else if (style == 'c') {
			rate = CUSTOM_COST;
			System.out.println("You chose the custom cost option.");
		}
	}
	
	//method for all of the user input
	public void input() throws IOException {
		setBudget();
		setLength();
		setWidth();
		setStories();
		setStyle();
	}
	
	//method to calculate the cost
	public int calcCost() {
		return length*width*stories*rate;
	}
	
	//method to print cost
	public void printCost() {
		if (calcCost() > budget) {
			System.out.println("Sorry, but you do not have enough money to build your house which would cost $" + calcCost() + ".");
		} else{
			System.out.println("Congratulations, you can build your house which will cost $" + calcCost() + ".");
		}
	}
	
	//method to ask if user wants to change any value
	public boolean valueChange(String printed) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Would you like to change" + printed + "?");
		char in = input.readLine().charAt(0);
		return (in == 'Y' || in == 'y');
	}
	
	//ask user if they want to change any input values
	public boolean askUser() throws IOException{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		char in;
		
		System.out.println("Please answer the following question(s) with a 'Y' for yes and anything else for no.");
		
		System.out.println("Would you like to change any values to recalculate the budget?");
		in = input.readLine().charAt(0);
		if (in == 'Y' || in == 'y') {
			/*This cannot be a nested if statement, right? 
			 * The program needs to check for every single condition,
			 * not just if one of them is true.
			 */
			if (valueChange(BUDGET_INPUT))
				setBudget();
			if (valueChange(LENGTH_INPUT))
				setLength();
			if (valueChange(WIDTH_INPUT))
				setWidth();
			if (valueChange(STORIES_INPUT)) 
				setStories();
			if (valueChange(STYLE_INPUT))
				setStyle();
			return true;
		} else
			return false;
	}
	
	//main method
	public static void main (String args[]) throws IOException {
		
		Homebuilders house = new Homebuilders();
		
		//welcome message
		System.out.println("Welcome to Homebuilders - the program for calculating the cost of your dream house!");
		
		house.input();
		house.printCost();
		
		//asks user to change values until satisfied
		while (house.askUser()) {
			house.printCost();
		}
		
		//end message
		System.out.println("Thank you for using Homebuilders!");
		
	}
}

/* Output
Welcome to Homebuilders - the program for calculating the cost of your dream house!
Please enter your budget without the dollar sign as a positive integer value.
-300
Please enter a valid value.
300
Your budget is $300.
Please enter the length of your house as a positive integer value.
10
The length of your house is 10.
Please enter the width of your house as a positive integer value.
20
The width of your house is 20.
Please enter the number of stories of your house as a positive integer value.
1
Your house will be 1 stories tall
There are several pricing options: minimum cost for $100 per square foot, 
standard for $125 per square foot, energy-efficient for $150 per square foot, 
and custom for $200 per square foot.  Enter 'm' for minimum cost, 
's' for standard, 'e' for energy-efficient, and 'c' for custom.
m
You chose the minimum cost option.
Sorry, but you do not have enough money to build your house which would cost $20000.
Please answer the following question(s) with a 'Y' for yes and anything else for no.
Would you like to change any values to recalculate the budget?
Y
Would you like to change your budget without the dollar sign?
30000
Would you like to change the length of your house?
N
Would you like to change the width of your house?
N
Would you like to change the number of stories of your house?
N
Would you like to change the pricing option for your house?
Y
There are several pricing options: minimum cost for $100 per square foot, 
standard for $125 per square foot, energy-efficient for $150 per square foot, 
and custom for $200 per square foot.  Enter 'm' for minimum cost, 
's' for standard, 'e' for energy-efficient, and 'c' for custom.
s
You chose the standard option.
Sorry, but you do not have enough money to build your house which would cost $25000.
Please answer the following question(s) with a 'Y' for yes and anything else for no.
Would you like to change any values to recalculate the budget?
Y
Would you like to change your budget without the dollar sign?
Y
Please enter your budget without the dollar sign as a positive integer value.
500000
Your budget is $500000.
Would you like to change the length of your house?
Y
Please enter the length of your house as a positive integer value.
50
The length of your house is 50.
Would you like to change the width of your house?
Y
Please enter the width of your house as a positive integer value.
-40
Please enter a valid value.
40
The width of your house is 40.
Would you like to change the number of stories of your house?
Y
Please enter the number of stories of your house as a positive integer value.
5
Your house will be 5 stories tall
Would you like to change the pricing option for your house?
Y
There are several pricing options: minimum cost for $100 per square foot, 
standard for $125 per square foot, energy-efficient for $150 per square foot, 
and custom for $200 per square foot.  Enter 'm' for minimum cost, 
's' for standard, 'e' for energy-efficient, and 'c' for custom.
t
Please enter a valid code.
e
You chose the energy-efficient option.
Sorry, but you do not have enough money to build your house which would cost $1500000.
Please answer the following question(s) with a 'Y' for yes and anything else for no.
Would you like to change any values to recalculate the budget?
Y
Would you like to change your budget without the dollar sign?
Y
Please enter your budget without the dollar sign as a positive integer value.
1000000000
Your budget is $1000000000.
Would you like to change the length of your house?
N
Would you like to change the width of your house?
N
Would you like to change the number of stories of your house?
Y
Please enter the number of stories of your house as a positive integer value.
-1
Please enter a valid value.
5
Your house will be 5 stories tall
Would you like to change the pricing option for your house?
Y
There are several pricing options: minimum cost for $100 per square foot, 
standard for $125 per square foot, energy-efficient for $150 per square foot, 
and custom for $200 per square foot.  Enter 'm' for minimum cost, 
's' for standard, 'e' for energy-efficient, and 'c' for custom.
c
You chose the custom cost option.
Congratulations, you can build your house which will cost $2000000.
Please answer the following question(s) with a 'Y' for yes and anything else for no.
Would you like to change any values to recalculate the budget?
Y
Would you like to change your budget without the dollar sign?
N
Would you like to change the length of your house?
N
Would you like to change the width of your house?
N
Would you like to change the number of stories of your house?
Y
Please enter the number of stories of your house as a positive integer value.
2
Your house will be 2 stories tall
Would you like to change the pricing option for your house?
N
Congratulations, you can build your house which will cost $800000.
Please answer the following question(s) with a 'Y' for yes and anything else for no.
Would you like to change any values to recalculate the budget?
N
Thank you for using Homebuilders!
 */
