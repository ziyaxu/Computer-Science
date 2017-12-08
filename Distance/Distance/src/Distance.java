
/*
 * Ziya Xu
 * Period 2
 * Distance Program 9/15/17
 * 
 * This program calculates the distance, rounded to the nearest hundredths place,
 * between two points on the Cartesian plane by using the distance formula.
 */

public class Distance {
	
	public static void main (String args[]) {
		
		//declare and initial coordinates
		double x1 = -2.15, y1 = 8.0, x2 = 3.0, y2 = -5.93;
		
		//calculating distance and rounding
		double distance = (double) Math.round(Math.sqrt(Math.pow(x2-x1,  2) + Math.pow(y2-y1, 2)) * 100) / 100;
		
		//output
		System.out.println("The distance between (" + x1 + ", " + y1 + ") and (" 
				+ x2 + ", " + y2 + ") is " + distance + ".");
		
	}
}

/*
 * Output
 * The distance between (-2.15, 8.0) and (3.0, -5.93) is 14.85.
 */
