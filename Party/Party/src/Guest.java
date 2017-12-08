public class Guest {
	
	//TODO: comments
	
	private String firstName, lastName, company, attendance;
	
	public Guest (String firstName, String lastName, String company, String attendance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.attendance = attendance;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getCompany() {
		return company;
	}
	
	public String getAttendance() {
		if (attendance.equals("?"))
			return "maybe";
		else
			return attendance;
	}
	
	public void setFirstName(String newFirst) {
		firstName = newFirst;
	}
	
	public void setLastName(String newLast) {
		lastName = newLast;
	}
	
	public void setCompany(String co) {
		company = co;
	}
	
	public void setAttendance(String atten) {
		attendance = atten;
	}
	
	public String toTableString() {
		return lastName + ", " + firstName + '\t' + company + '\t' + getAttendance();
	}
	
	public String toStatementString() {
		return firstName + ", " + lastName + " works for " + getCompany() 
		+ " and his or her attendance is " + getAttendance();
	}
	
	public int compareGuests(Guest guest) {
		
		int compareLast = getLastName().compareToIgnoreCase(guest.getLastName());
		int compareFirst = getFirstName().compareToIgnoreCase(guest.getFirstName());
		
		if (compareLast == 0)
			return compareFirst;
		else
			return compareLast;
	}
}
