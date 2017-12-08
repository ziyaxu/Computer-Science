
/**
 * Palindrome Program
 * @author Ziya Xu
 * @version October 20 2017
 *
 * This program asks the user for a phrase and checks if it is a palindrome,
 * only taking alpha-numeric characters into consideration.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {
	
	public Palindrome() {
	}
	
	/**
	 * Asks the user for the phrase to check
	 * @return entered phrase
	 * @throws IOException
	 */
	public String askUser() throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Enter a phrase if you want to check whether it is a palindrome.");
		return input.readLine();
	}
	
	/**
	 * Checks whether a phrase is a palindrome
	 * @param phrase
	 * 			string to check
	 * @return boolean 
	 * 			whether phrase is a palindrome or not
	 */
	public boolean isPalin(String phrase) {
		
		if (phrase.equals(" ")) //returns false if the string is one space long
			return false;
		
		Character front, end;
		
		int frontCount = 0, endCount = phrase.length() - 1;

		for (frontCount = 0; endCount - frontCount >= 0; frontCount++) {
			
			front = phrase.charAt(frontCount);
			end = phrase.charAt(endCount);
		
			  
			while (!Character.isLetterOrDigit(front)) {
				frontCount++;  
				if (frontCount >= phrase.length()) { //returns false if the string is empty
					return false;
				}
				front = phrase.charAt(frontCount);
			}
			
			while (!Character.isLetterOrDigit(end)) {
				endCount--;
				end = phrase.charAt(endCount);
			}
					
			front = Character.toLowerCase(front);
			end = Character.toLowerCase(end);
			
			if (!(front == end))
				return false;
			else
				endCount--;
			
		}
		
		return true;
	}
	
	/**
	 * Prints whether phrase is a palindrome or not
	 * @param boolean
	 * 			whether phrase is palindrome or not
	 */
	public void print(boolean phraseType) {
		if (phraseType) 
			System.out.println("Your phrase is a palindrome.");
		else
			System.out.println("Your phrase is not a palindrome.");
	}
	
	
	/**
	 * Creates new Palindrome object
	 * Asks user to enter statements until 'Done' entered
	 * @param args
	 * @throws IOException
	 */
	public static void main (String args[]) throws IOException {
		//asking the user for palindromes
		System.out.println("Hello and welcome to the Palindrome Checker! " 
						+ "Enter 'Done' as your palindrome when you are done using the program.");
						
		Palindrome palin = new Palindrome();
		String input = palin.askUser();
		
		while (!input.equals("Done")) {
			palin.print(palin.isPalin(input));
			input = palin.askUser();
		}
		
		System.out.println("Thank you for using the Palindrome Checker!");
	}

}

/*
 * Hello and welcome to the Palindrome Checker! Enter 'Done' as your palindrome when you are done using the program.
Enter a phrase if you want to check whether it is a palindrome.
man o nam
Your phrase is a palindrome.
Enter a phrase if you want to check whether it is a palindrome.
I palindrome I
Your phrase is not a palindrome.
Enter a phrase if you want to check whether it is a palindrome.
Egad, a base tone denotes a bad age.
Your phrase is a palindrome.
Enter a phrase if you want to check whether it is a palindrome.
#$%^&*)+=-!@#$%BUB@#$%^&*
Your phrase is a palindrome.
Enter a phrase if you want to check whether it is a palindrome.
z
Your phrase is a palindrome.
Enter a phrase if you want to check whether it is a palindrome.
!@#$%^&*()!@#$%^&*()!@#$%^b o !@#$% b
Your phrase is a palindrome.
Enter a phrase if you want to check whether it is a palindrome.
1 2 3 4 5 4 3 2 1
Your phrase is a palindrome.
Enter a phrase if you want to check whether it is a palindrome.
!@#$%^&*+{
Your phrase is not a palindrome.
Enter a phrase if you want to check whether it is a palindrome.
!*!
Your phrase is not a palindrome.
Enter a phrase if you want to check whether it is a palindrome.
#
Your phrase is not a palindrome.
Enter a phrase if you want to check whether it is a palindrome.
)(*&^%$#@!)(*&^%$#@!h%#aNnAh
Your phrase is a palindrome.
Enter a phrase if you want to check whether it is a palindrome.
<!@#$%^&*())(*&^h%#anxah
Your phrase is not a palindrome.
Enter a phrase if you want to check whether it is a palindrome.
***!!!Z
Your phrase is a palindrome.
Enter a phrase if you want to check whether it is a palindrome.
)(*&^Z!@#$%^&*()!@#$%
Your phrase is a palindrome. 
Enter a phrase if you want to check whether it is a palindrome.
Ma 7 dam, I'm, Ad 7 am.
Your phrase is a palindrome.
Enter a phrase if you want to check whether it is a palindrome.
Done
Thank you for using the Palindrome Checker!
*/
