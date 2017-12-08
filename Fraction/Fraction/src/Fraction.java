
/*
 * Ziya Xu
 * Period 2
 * 9/18/17
 * 
 * Fraction Class Program
 * This program creates a Fraction class and its methods allow you
 * to add, subtract, multiply, and divide two fractions.  It will
 * then print the result to the console.
 */

public class Fraction {
	
	private int numerator;
	private int denominator;
	
	//Fraction constructor
	public Fraction(int num, int den) {
		numerator = num;
		denominator = den;
	}
	
	//getters
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	//setters
	public void setNumerator(int num) {
		numerator = num;
	}
	
	public void setDenominator(int den) {
		denominator = den;
	}
	
	public String toString() {
		return getNumerator() + "/" + getDenominator();
	}
	
	//operation methods to add, subtract, multiply, and divide
	public Fraction add(Fraction otherFrac) {
		
		//calculates numerator and denominator for addition
		int sumNumerator = getNumerator() * otherFrac.getDenominator()
				+ otherFrac.getNumerator() * getDenominator();
		int sumDenominator = getDenominator() * otherFrac.getDenominator();
		
		//creates new Fraction object result
		Fraction result = new Fraction(sumNumerator, sumDenominator);
		
		return result;
	}
	
	public Fraction subtract(Fraction otherFrac) {
		
		//calculates numerator and denominator for subtraction
		int diffNumerator = getNumerator() * otherFrac.getDenominator()
				- otherFrac.getNumerator() * getDenominator();
		int diffDenominator = getDenominator() * otherFrac.getDenominator();
		
		//creates new Fraction object result
		Fraction result = new Fraction(diffNumerator, diffDenominator);
		
		return result;
	}
	
	public Fraction multiply(Fraction otherFrac) {
		
		//calculates numerator and denominator for multiplication
		int multNumerator = getNumerator() * otherFrac.getNumerator();
		int multDenominator = getDenominator() * otherFrac.getDenominator();
		
		//creates new Fraction object result
		Fraction result = new Fraction(multNumerator, multDenominator);
		
		return result;
	}
	
	public Fraction divide(Fraction otherFrac) {
		
		//calculates numerator and denominator for division
		int divNumerator = getNumerator() * otherFrac.getDenominator();
		int divDenominator = getDenominator() * otherFrac.getNumerator();
		
		//creates new Fraction object result
		Fraction result = new Fraction(divNumerator, divDenominator);
		
		return result;
		
	}
	
	
	public static void main (String args[]) {
		
		//creating new fraction objects
		Fraction f1 = new Fraction(1, 2);
		Fraction f2 = new Fraction(3, 5);
		Fraction sum, difference, product, quotient;
		
		//calling operation methods on fractions and printing
		sum = f1.add(f2);
		System.out.println(f1.toString() + " + " + f2.toString()
			+ " = " + sum.toString());
		
		difference = f1.subtract(f2);
		System.out.println(f1.toString() + " - " + f2.toString()
		+ " = " + difference.toString());
		
		product = f1.multiply(f2);
		System.out.println(f1.toString() + " * " + f2.toString()
		+ " = " + product.toString());
		
		quotient = f1.divide(f2);
		System.out.println(f1.toString() + " / " + f2.toString()
		+ " = " + quotient.toString());
		
	}
}

/* Output:
1/2 + 3/5 = 11/10
1/2 - 3/5 = -1/10
1/2 * 3/5 = 3/10
1/2 / 3/5 = 5/6
 */
