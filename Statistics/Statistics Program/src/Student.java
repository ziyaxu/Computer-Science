/*
 * Ziya Xu
 * Statistics Program
 * 10/27/17
 * 
 * This program reads a file that contains the ID number, a test score, 
 * and a class code for each student.  It then prints out the information
 * for every student and calculates the mean, median, highest score, and
 * lowest score for all valid scores.
 */

public class Student {
	
	//private data
	private int idNum;
	private int testScore;
	private char courseCode;
	
	//student constructor
	//has int id, int score, and char code parameters
	public Student(int id, int score, char code) {
		idNum = id;
		testScore = score;
		courseCode = code;
	}
	
	//getters
	public int getID() {
		return idNum;
	}
	
	public int getTestScore() {
		return testScore;
	}
	
	public char getCourseCode() {
		return courseCode;
	}
	
	//method for getting the full course name
	//takes a character argument
	//returns the full course name
	public String getFullCourse() {
		if (courseCode == 'c' || courseCode == 'C') {
			return "Computer Science";
		} else if (courseCode == 'e' || courseCode == 'E') {
			return "Education";
		} else if (courseCode == 'm' || courseCode == 'M') {
			return "Mathematics";
		} else if (courseCode == 'b' || courseCode == 'B') {
			return "Business";
		} else if (courseCode == 'n' || courseCode == 'N') {
			return "Engineering";
		} else if (courseCode == 'a' || courseCode == 'A') {
			return "Art";
		} else {
			return "Incorrect Course Code";
		}
	}
	
	//setters
	public void setID(int id) {
		idNum = id;
	}
	
	public void setTestScore(int score) {
		testScore = score;
	}
	
	public void setCourseCode(char code) {
		courseCode = code;
	}
	
	/**
	 * Chooses which value of the student to sort by
	 * @param methodChoice
	 * @return the selected value of the student
	 */
	public int getSortValue(int methodChoice) {
		//choose which value to compare
	    if (methodChoice == School.ID_SORT) {
	    	return getID();
	    } else {
	    	return getTestScore();
	    }
	}
	
	/**
	 * @return Student data as a string
	 */
	public String studentToString() {
		return getID() + " " + '\t' //space needed in this line otherwise id and test score are added
				+ getTestScore() + '\t' 
				+ getFullCourse();
	}
}
