/*
 * Ziya Xu
 * Period 2
 * ISBN Program 9/15/17
 * 
 * This program calculates the check digit from ISBN numbers.
 */

public class ISBN {
	
	public static void main (String args[]) {
		
		//declaring and initializing necessary variables
		String isbn = "957-621-541-2";
		int total = 0, value, count = 0;
		
		//loops through values (except last check digit) to calculate the total
		for (int i = 0; i < isbn.length() - 2; i++) {

			if (isbn.charAt(i) == '-') {
				i++;
			}
			
			value = new Integer(isbn.substring(i, i+1));
			
			total += value * (10 - count);
			
			count++;
		}
		
		int checkDigit = 10 - ((total - 1) % 11);
		
		//for when check digits is 10
		String digits = "0123456789X";
		
		//Output
		System.out.println("ISBN Number: " + isbn);
		System.out.println("Check digit from number: " + isbn.charAt(isbn.length() - 1));
		System.out.println("Check digit from calculations: " + digits.charAt(checkDigit));
		
	}
}

/*
 * Output
 * 
ISBN Number: 0-7645-0417-7
Check digit from number: 7
Check digit from calculations: 7

ISBN Number: 0-7654-0417-6
Check digit from number: 6
Check digit from calculations: 6

ISBN Number: 0-912517-31-X
Check digit from number: X
Check digit from calculations: X

ISBN Number: 3-314-21145-7
Check digit from number: 7
Check digit from calculations: 7

ISBN Number: 91-29-65497-1
Check digit from number: 1
Check digit from calculations: 1

ISBN Number: 957-621-541-2
Check digit from number: 2
Check digit from calculations: 2

 */
