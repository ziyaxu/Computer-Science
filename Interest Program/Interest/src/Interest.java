
/*
 * Ziya Xu
 * Period 2
 * Interest Program
 * 
 * This program uses nested for loops to calculate the the amount of money
 * in a bank over over the course of 10 years with various interest levels.
 */

public class Interest {
	
	public static void main (String args[]) {
		
		double amount = 1000;
		
		System.out.println("You have invested $1000.");
		System.out.println();
		
		for (int i = 6; i <= 12; i += 1) {
			
			System.out.println("Interest rate of " + i + "%");
			System.out.println("Investment at year 0 is $" + amount + ".");
			
			for (int y = 1; y <= 10; y++) {
				amount *= (1 + (i/100.0));
				
				//rounding (sometimes the interest rate is very long)
				amount = (int) (amount * 100 + 0.5) / 100.0;
				
				System.out.println("Investment at year " + y + " is $" + amount + ".");
			}
			
			System.out.println();
			amount = 1000;
		}
	}
}

/*
 * Output:
You have invested $1000.

Interest rate of 6%
Investment at year 0 is $1000.0.
Investment at year 1 is $1060.0.
Investment at year 2 is $1123.6.
Investment at year 3 is $1191.02.
Investment at year 4 is $1262.48.
Investment at year 5 is $1338.23.
Investment at year 6 is $1418.52.
Investment at year 7 is $1503.63.
Investment at year 8 is $1593.85.
Investment at year 9 is $1689.48.
Investment at year 10 is $1790.85.

Interest rate of 7%
Investment at year 0 is $1000.0.
Investment at year 1 is $1070.0.
Investment at year 2 is $1144.9.
Investment at year 3 is $1225.04.
Investment at year 4 is $1310.79.
Investment at year 5 is $1402.55.
Investment at year 6 is $1500.73.
Investment at year 7 is $1605.78.
Investment at year 8 is $1718.18.
Investment at year 9 is $1838.45.
Investment at year 10 is $1967.14.

Interest rate of 8%
Investment at year 0 is $1000.0.
Investment at year 1 is $1080.0.
Investment at year 2 is $1166.4.
Investment at year 3 is $1259.71.
Investment at year 4 is $1360.49.
Investment at year 5 is $1469.33.
Investment at year 6 is $1586.88.
Investment at year 7 is $1713.83.
Investment at year 8 is $1850.94.
Investment at year 9 is $1999.02.
Investment at year 10 is $2158.94.

Interest rate of 9%
Investment at year 0 is $1000.0.
Investment at year 1 is $1090.0.
Investment at year 2 is $1188.1.
Investment at year 3 is $1295.03.
Investment at year 4 is $1411.58.
Investment at year 5 is $1538.62.
Investment at year 6 is $1677.1.
Investment at year 7 is $1828.04.
Investment at year 8 is $1992.56.
Investment at year 9 is $2171.89.
Investment at year 10 is $2367.36.

Interest rate of 10%
Investment at year 0 is $1000.0.
Investment at year 1 is $1100.0.
Investment at year 2 is $1210.0.
Investment at year 3 is $1331.0.
Investment at year 4 is $1464.1.
Investment at year 5 is $1610.51.
Investment at year 6 is $1771.56.
Investment at year 7 is $1948.72.
Investment at year 8 is $2143.59.
Investment at year 9 is $2357.95.
Investment at year 10 is $2593.75.

Interest rate of 11%
Investment at year 0 is $1000.0.
Investment at year 1 is $1110.0.
Investment at year 2 is $1232.1.
Investment at year 3 is $1367.63.
Investment at year 4 is $1518.07.
Investment at year 5 is $1685.06.
Investment at year 6 is $1870.42.
Investment at year 7 is $2076.17.
Investment at year 8 is $2304.55.
Investment at year 9 is $2558.05.
Investment at year 10 is $2839.44.

Interest rate of 12%
Investment at year 0 is $1000.0.
Investment at year 1 is $1120.0.
Investment at year 2 is $1254.4.
Investment at year 3 is $1404.93.
Investment at year 4 is $1573.52.
Investment at year 5 is $1762.34.
Investment at year 6 is $1973.82.
Investment at year 7 is $2210.68.
Investment at year 8 is $2475.96.
Investment at year 9 is $2773.08.
Investment at year 10 is $3105.85.
 */
