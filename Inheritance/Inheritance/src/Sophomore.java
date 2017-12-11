
public class Sophomore extends HSStudent{
	
	private char ninthMathGrade;
	
	public Sophomore(String first, String last, int grade, double qpa, char mathGrade) {
		setFirstName(first);
		setLastName(last);
		setGrade(grade);
		setQPA(qpa);
		ninthMathGrade = mathGrade;
	}
	
	public String getGradeString() {
		return "Sophomore";
	}
	
	public char getNinthMathGrade() {
		return ninthMathGrade;
	}
	
	public void setNinthMathGrade(char grade) {
		ninthMathGrade = grade;
	}
	
	public String toString() {
		return super.toString() + '\n' + getFirstName() + " " + getLastName() + "'s freshman year math grade is " + ninthMathGrade + ".";
	}
}
