
public class Junior extends HSStudent{
	
	private int keystoneGrade;
	
	public Junior() {}
	
	public Junior(String first, String last, int grade, double qpa, int keystone) {
		setFirstName(first);
		setLastName(last);
		setGrade(grade);
		setQPA(qpa);
		keystoneGrade = keystone;
	}
	
	public String getGradeString() {
		return "Junior";
	}
	
	public String getKeystoneGrade() {
		if (keystoneGrade == 4) return "Advanced";
		else if (keystoneGrade == 3) return "Proficient";
		else if (keystoneGrade == 2) return "Basic";
		else return "Below Basic";
	}
	
	public void setKeystoneGrade(int grade) {
		keystoneGrade = grade;
	}
	
	public String toString() {
		return super.toString() + '\n' + getFirstName() + " " + getLastName() + "'s keystone level is " + getKeystoneGrade() + ".";
	}

}
