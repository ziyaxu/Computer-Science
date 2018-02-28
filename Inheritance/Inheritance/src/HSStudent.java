
public abstract class HSStudent implements Student, Comparable<HSStudent>{
	
	private String first, last;
	private int grade;
	private double qpa;
	
	public HSStudent() {}
	
	public HSStudent(String first, String last, int grade, double qpa) {
		this.first = first;
		this.last = last;
		this.grade = grade;
		this.qpa = qpa;
	}
	
	public abstract String getGradeString();
	
	public int getGrade() {
		return grade;
	}
	
	public String getFirstName() {
		return first;
	}

	public String getLastName() {
		return last;
	}
	
	public double getQPA() {
		return qpa;
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
	
	public void setQPA(double qpa) {
		this.qpa = qpa;
	}
	
	public String toString() {
		return getGradeString() + " " + first + " " + last + " is in grade " + grade + " with a " + qpa + " qpa.";
	}
	
	public int compareTo(HSStudent student) {
		int compareLast = getLastName().compareToIgnoreCase(student.getLastName());
		int compareFirst = getFirstName().compareToIgnoreCase(student.getFirstName());
		
		if (grade != student.getGrade()) return grade - student.getGrade();
		else
			if (compareLast == 0) return compareFirst;
			else return compareLast;
	}

}
