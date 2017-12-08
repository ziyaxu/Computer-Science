/*
 * Ziya Xu
 * Period 2
 * 9/8/17
 */

public class NewChangeProgram {
	
	public static void main(String args[]) {
		
		//variables and arrays needed to perform calculations
		double cost = 40.67;
		int amountPaid = 100;
		double change = amountPaid - cost;
		
		int newChange = (int) (change * 100);
		
		int[] moneyValues = {5000, 2000, 1000, 500, 100, 25, 10, 5, 1};
		int[] moneyNum = {0, 0, 0, 0, 0, 0, 0, 0, 0};
		String[] printValues = {"Number of $50 bills: ", "Number of $20 bills: ", "Number of $10 bills: ", "Number of $5 bills: ", "Number of $1 bills: ",
				"Number of quarters: ", "Number of dimes: ", "Number of nickels: ", "Number of pennies: "};
	
		//for loop to calculate change
		for (int i = 0; i < moneyValues.length; i++) {
			if (newChange >= moneyValues[i]) {
				moneyNum[i] = newChange / moneyValues[i];
				newChange %= moneyValues[i];
			}
		}

		//output
		System.out.println("Cost of items: $" + cost);
		System.out.println("Amount paid: $" + amountPaid);
		System.out.println("Amount of change: $" + change);
		System.out.println();
		
		for (int j = 0; j < moneyNum.length; j++) {
			System.out.println(printValues[j] + moneyNum[j]);
		}
	
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
