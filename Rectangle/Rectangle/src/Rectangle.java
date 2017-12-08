/*
 * Ziya Xu
 * Period 2
 * 9/22/17
 * 
 * Rectangle Program
 * This program prints out a rectangle with the dimensions the user specifies
 * using asterisks. It will prompt the user for another entry if the first was
 * not an integer value.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rectangle {
	
	//constants for limit of rectangle size
	public static final int WIDTH_SIZE = 80;
	public static final int LENGTH_SIZE = 25;
	
	private int width, length;
	
	//empty constructor
	public Rectangle() {
	}
	
	//getters
	public int getWidth() {
		return width;
	}
	
	public int getLength() {
		return length;
	}
	
	//setters
	public void setWidth(int wid) {
		width = wid;
	}
	
	public void setLength(int len) {
		length = len;
	}
	
	//method to check if the input is an integer
	public boolean isInt(String input, int lim) {
		try {
	        int in = new Integer(input);
	        if (in < 0 || in > lim) { //0 must be able to be entered, it is the sentinel value
	        	return false;
	        } else
	        	return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	public void askUser() throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		String in;
		
		//asking for width of rectangle
		System.out.println("Please enter the width of a rectangle as an integer value.");
		System.out.println("Enter 0 as the width and length when you are done.");
		in = input.readLine();
		while (!isInt(in, WIDTH_SIZE)) {
			System.out.println("Sorry, please enter a valid integer value for the width.");
			in = input.readLine();
		}
		width = new Integer(in);
		
		//asking for length of rectangle
		System.out.println("Please enter the length of a rectangle as an integer value.");
		System.out.println("Enter 0 as the width and length when you are done.");
		in = input.readLine();
		while (!isInt(in, LENGTH_SIZE)) {
			System.out.println("Sorry, please enter a valid integer value for the length.");
			in = input.readLine();
		}
		length = new Integer(in);
	}
	
	//method to print the rectangle, width, length, and area
	public void printRec() throws IOException {
		
		System.out.println("Width: " + width + '\t' + " Length: " + length + '\t' + "Area: " + width*length);

		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= width; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main (String args[]) throws IOException {
		
		//new rectangle object and printing it
		Rectangle rec = new Rectangle();
		rec.askUser();
		while (rec.getLength() != 0 && rec.getWidth() != 0) {
			rec.printRec();
			rec.askUser();
		}
		
	}
}

/*
 Please enter the width of a rectangle as an integer value.
Enter 0 as the width and length when you are done.
-8
Sorry, please enter a valid integer value for the width.
100
Sorry, please enter a valid integer value for the width.
81
Sorry, please enter a valid integer value for the width.
1
Please enter the length of a rectangle as an integer value.
Enter 0 as the width and length when you are done.
-5
Sorry, please enter a valid integer value for the length.
30
Sorry, please enter a valid integer value for the length.
25
Width: 1	 Length: 25	Area: 25
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
Please enter the width of a rectangle as an integer value.
Enter 0 as the width and length when you are done.
10
Please enter the length of a rectangle as an integer value.
Enter 0 as the width and length when you are done.
2
Width: 10	 Length: 2	Area: 20
**********
**********
Please enter the width of a rectangle as an integer value.
Enter 0 as the width and length when you are done.
5
Please enter the length of a rectangle as an integer value.
Enter 0 as the width and length when you are done.
8
Width: 5	 Length: 8	Area: 40
*****
*****
*****
*****
*****
*****
*****
*****
Please enter the width of a rectangle as an integer value.
Enter 0 as the width and length when you are done.
0
Please enter the length of a rectangle as an integer value.
Enter 0 as the width and length when you are done.
0


 */
