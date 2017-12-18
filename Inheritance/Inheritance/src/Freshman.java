
public class Freshman extends HSStudent{

	private int numReferrals;
	
	public Freshman(String first, String last, int grade, double qpa, int referrals) {
		setFirstName(first);
		setLastName(last);
		setGrade(grade);
		setQPA(qpa);
		numReferrals = referrals;
	}
	
	public String getGradeString() {
		return "Freshman";
	}
	
	public int getReferrals() {
		return numReferrals;
	}
	
	public void setReferrals(int referrals) {
		numReferrals = referrals;
	}
	
	public String toString() {
		return super.toString() + '\n' + getFirstName() + " " + getLastName() + " has " + numReferrals + " referrals.";
	}
}
