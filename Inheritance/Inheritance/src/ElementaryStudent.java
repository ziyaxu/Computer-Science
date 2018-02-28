
public class ElementaryStudent implements Student {

	private String first, last;
	private int grade;
	
	public ElementaryStudent() {
		
	}
	
	public ElementaryStudent(String first, String last, int grade) {
		this.first = first;
		this.last = last;
		this.grade = grade;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public String getFirstName() {
		return first;
	}

	public String getLastName() {
		return last;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void setFirstName(String first) {
		this.first = first;
	}

	public void setLastName(String last) {
		this.last = last;
	}
	
	public String toString() {
		String stringGrade;
		if (getGrade() == 0) stringGrade = "K";
		else stringGrade = "" + getGrade();
		
		return first + " " + last + " is in grade " + stringGrade;
	}
	
}
