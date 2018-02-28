
public class Senior extends HSStudent{
	
	private boolean portfolioComplete;
	private double finesOwed;
	
	public Senior() {}
	
	public Senior(String first, String last, int grade, double qpa, boolean portfolio, double fines) {
		super(first, last, grade, qpa);
		portfolioComplete = portfolio;
		finesOwed = fines;
	}
	
	public String getGradeString() {
		return "Senior";
	}
	
	public boolean getPortfolioComplete() {
		return portfolioComplete;
	}
	
	public void setPortfolio(boolean portfolio) {
		portfolioComplete = portfolio;
	}
	
	public double getFinesOwed() {
		return finesOwed;
	}
	
	public void setFinesOwed(double fines) {
		finesOwed = fines;
	}
	
	public String portfolioCompleteToString() {
		if (portfolioComplete) return getFirstName() + " " + getLastName() + " has completed his or her portfolio.";
		else return getFirstName() + " " + getLastName() + " has not completed his or her portfolio.";
	}
	
	public String toString() {
		return super.toString() + '\n' + getFirstName() + " " + getLastName() + " owes $" + finesOwed + " in fines to the school."
				+ '\n' + portfolioCompleteToString();
	}

}
