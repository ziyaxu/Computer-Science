/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card ace = new Card("Ace", "Spades", 5);
		Card ace1 = new Card("Ace", "Spades", 5);
		
		System.out.println(ace.matches(ace1));
	}
}
