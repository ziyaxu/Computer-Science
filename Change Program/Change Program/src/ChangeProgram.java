/*
 * Ziya Xu
 * Period 2
 * 9/7/17
 */

public class ChangeProgram {
	
	public static void main (String args[]) {
		
		double cost = 40.67;
		int amountPaid = 100;
		double change = amountPaid - cost;
		
		//declare and initialize (must initialize to put into array)
		int num50, num20, num10, num5, num1, 
			numQuarters, numDimes, numNickels, numPennies;
		
		//new change value to work with decimals
		int newChange = (int) (change * 100);
		
		//if loops to calculate the number of bills and pennies
		if (newChange >= 5000) {
			num50 = newChange / 5000;
			newChange %= 5000;
		} else
			num50 = 0;
		
		if (newChange > 2000) {
			num20 = newChange / 2000;
			newChange %= 2000;
		} else
			num20 = 0;
		
		if (newChange > 1000) {
			num10 = newChange / 1000;
			newChange %= 1000;
		} else 
			num10 = 0;
		
		if (newChange > 500) {
			num5 = newChange / 500;
			newChange %= 500;
		} else
			num5 = 0;
		
		if (newChange > 100) {
			num1 = newChange / 100;
			newChange %= 100;
		} else
			num1 = 0;
		
		if (newChange > 25) {
			numQuarters = newChange / 25;
			newChange %= 25;
		} else
			numQuarters = 0;
		
		if (newChange > 10) {
			numDimes = newChange / 10;
			newChange %= 10;
		} else
			numDimes = 0;
		
		if (newChange > 5) {
			numNickels = newChange / 5;
			newChange %= 5;
		} else
			numNickels = 0;
		
		if (newChange > 1) {
			numPennies = newChange / 1;
			newChange %= 1;
		} else
			numPennies = 0;

		
		//output
		System.out.println("Cost of items: $" + cost);
		System.out.println("Amount paid: $" + amountPaid);
		System.out.println("Amount of change: $" + change);
		System.out.println();
		System.out.println("Number of $50 bills: " + num50);
		System.out.println("Number of $20 bills: " + num20);
		System.out.println("Number of $10 bills: " + num10);
		System.out.println("Number of $5 bills: " + num5);
		System.out.println("Number of $1 bills: " + num1);
		System.out.println("Number of quarters: " + numQuarters);
		System.out.println("Number of dimes: " + numDimes);
		System.out.println("Number of nickels: " + numNickels);
		System.out.println("Number of pennies: " + numPennies);
	}
}

/*
 * output
Cost of items: $40.67
Amount paid: $100
Amount of change: $59.33

Number of $50 bills: 1
Number of $20 bills: 0
Number of $10 bills: 0
Number of $5 bills: 1
Number of $1 bills: 4
Number of quarters: 1
Number of dimes: 0
Number of nickels: 1
Number of pennies: 3
*/
