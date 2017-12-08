/*
 * Ziya Xu
 * Period 2
 * 9/25/17
 * 
 * Art Registration Program
 * This program asks for the user to enter ID numbers of students and the course code
 * for an art class until 0 is entered for an ID.  After each valid ID, the ID number
 * and entire course name will be printed.  Then, the program will calculate
 * the number of sections a class will have based on class size limits.  Lastly,
 * the full name of each course, the number of students enrolled, and the number of
 * sessions will be printed.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArtRegistration {
	
	//constants
	public final static int B_LIM = 6;
	public final static int C_LIM = 4;
	public final static int P_LIM = 7;
	public final static int S_LIM = 4;
	public final static int W_LIM = 5;
	
	private int b = 0, c = 0, p = 0, s = 0, w = 0;
	
	//empty constructor
	public ArtRegistration() {
	}
	
	//getter for number of people in a course
	public int getNum(char course) {
		if (course == 'b' || course == 'B')
			return b;
		else if (course == 'c' || course == 'C')
			return c;
		else if (course == 'p' || course == 'P')
			return p;
		else if (course == 's' || course == 'S')
			return s;
		else if (course == 'w' || course == 'W')
			return w;
		else
			return 0;
	}
	
	//method to check if integer is a string for error trapping user input
	public boolean isInt(String input) {
		try {
	        new Integer(input);
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	//method to check if course is a valid course for error trapping user input
	public boolean isCourse(char course) {
		if (course == 'b' || course == 'B') {
			b++;
			return true;
		} else if (course == 'c' || course == 'C') {
			c++;
			return true;
		} else if (course == 'p' || course == 'P') {
			p++;
			return true;
		} else if (course == 's' || course == 'S') {
			s++;
			return true;
		} else if (course == 'w' || course == 'W') {
			w++;
			return true;
		} else
			return false;
	}
	
	//method to print the course and add people to classes
	public String printCourse(char course) {
		if (course == 'b' || course == 'B') {
			return "Batik";
		} else if (course == 'c' || course == 'C') {
			return "Calligraphy";
		} else if (course == 'p' || course == 'P') {
			return "Painting";
		} else if (course == 's' || course == 'S') {
			return "Sculpture";
		} else if (course == 'w' || course == 'W') {
			return "Weaving";
		} else
			return null;
	}
	
	//method to check the number of sessions
	public int getSessions(int size, int limit) {
		if (size <= 2) {
			return 0;
		} else if (size % limit > 0) {
			return (size / limit) + 1;
		} else
			return size / limit;
	}
	
	//method to print at the end
	public void printFinal(char course, int limit) {
		System.out.println("Course name: " + printCourse(course)
				+ "\t" + "Number of students: " + getNum(course)
				+ "\t" + "Number of sessions: " + getSessions(getNum(course), limit));
	}
	
	//method to ask for user input of id number
	public String idInput() throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Please enter your id number." 
				+ "  Enter 0 as the id when you're done entering students.");
		String in = input.readLine();
		while (!isInt(in)) {
			System.out.println("Please enter a valid id number.");
			in = input.readLine();
		}
		
		return in;
	}
	
	//method to ask for user input of course code
	public char courseInput() throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Please enter the first letter of your desired course.");
		String in = input.readLine();
		while (!isCourse(in.charAt(0))) {
			System.out.println("Please enter a valid course letter.");
			in = input.readLine();
		}
		
		return in.charAt(0);
	}
	
	public static void main (String args[]) throws IOException {
		
		ArtRegistration artCourses = new ArtRegistration();
		
		//asking user for input, printing out id and course of student until 0 is entered as id
		int id;
		char course = ' ';
	
		id = new Integer(artCourses.idInput());
		
		while (id != 0) {
			course = artCourses.courseInput();
			
			System.out.println("Your id number is: " + id + " and your course is: " + artCourses.printCourse(course));
		
			id = new Integer(artCourses.idInput());
		}
		
		//printing courses, number of students, and number of sessions
		artCourses.printFinal('b', B_LIM);
		artCourses.printFinal('c', C_LIM);
		artCourses.printFinal('p', P_LIM);
		artCourses.printFinal('s', S_LIM);
		artCourses.printFinal('w', W_LIM);
	}
}

/*
Output
Please enter your id number.  Enter 0 as the id when you're done entering students.
18
Please enter the first letter of your desired course.
S
Your id number is: 18 and your course is: Sculpture
Please enter your id number.  Enter 0 as the id when you're done entering students.
24
Please enter the first letter of your desired course.
S
Your id number is: 24 and your course is: Sculpture
Please enter your id number.  Enter 0 as the id when you're done entering students.
21
Please enter the first letter of your desired course.
C
Your id number is: 21 and your course is: Calligraphy
Please enter your id number.  Enter 0 as the id when you're done entering students.
19
Please enter the first letter of your desired course.
W
Your id number is: 19 and your course is: Weaving
Please enter your id number.  Enter 0 as the id when you're done entering students.
32
Please enter the first letter of your desired course.
B
Your id number is: 32 and your course is: Batik
Please enter your id number.  Enter 0 as the id when you're done entering students.
20
Please enter the first letter of your desired course.
S
Your id number is: 20 and your course is: Sculpture
Please enter your id number.  Enter 0 as the id when you're done entering students.
10
Please enter the first letter of your desired course.
S
Your id number is: 10 and your course is: Sculpture
Please enter your id number.  Enter 0 as the id when you're done entering students.
11
Please enter the first letter of your desired course.
C
Your id number is: 11 and your course is: Calligraphy
Please enter your id number.  Enter 0 as the id when you're done entering students.
12
Please enter the first letter of your desired course.
C
Your id number is: 12 and your course is: Calligraphy
Please enter your id number.  Enter 0 as the id when you're done entering students.
35
Please enter the first letter of your desired course.
R
Please enter a valid course letter.
Y
Please enter a valid course letter.
M
Please enter a valid course letter.
W
Your id number is: 35 and your course is: Weaving
Please enter your id number.  Enter 0 as the id when you're done entering students.
38
Please enter the first letter of your desired course.
W
Your id number is: 38 and your course is: Weaving
Please enter your id number.  Enter 0 as the id when you're done entering students.
40
Please enter the first letter of your desired course.
B
Your id number is: 40 and your course is: Batik
Please enter your id number.  Enter 0 as the id when you're done entering students.
19
Please enter the first letter of your desired course.
S
Your id number is: 19 and your course is: Sculpture
Please enter your id number.  Enter 0 as the id when you're done entering students.
98
Please enter the first letter of your desired course.
S
Your id number is: 98 and your course is: Sculpture
Please enter your id number.  Enter 0 as the id when you're done entering students.
87
Please enter the first letter of your desired course.
C
Your id number is: 87 and your course is: Calligraphy
Please enter your id number.  Enter 0 as the id when you're done entering students.
18
Please enter the first letter of your desired course.
W
Your id number is: 18 and your course is: Weaving
Please enter your id number.  Enter 0 as the id when you're done entering students.
51
Please enter the first letter of your desired course.
S
Your id number is: 51 and your course is: Sculpture
Please enter your id number.  Enter 0 as the id when you're done entering students.
52
Please enter the first letter of your desired course.
W
Your id number is: 52 and your course is: Weaving
Please enter your id number.  Enter 0 as the id when you're done entering students.
67
Please enter the first letter of your desired course.
S
Your id number is: 67 and your course is: Sculpture
Please enter your id number.  Enter 0 as the id when you're done entering students.
15
Please enter the first letter of your desired course.
C
Your id number is: 15 and your course is: Calligraphy
Please enter your id number.  Enter 0 as the id when you're done entering students.
44
Please enter the first letter of your desired course.
R
Please enter a valid course letter.
C
Your id number is: 44 and your course is: Calligraphy
Please enter your id number.  Enter 0 as the id when you're done entering students.
48
Please enter the first letter of your desired course.
S
Your id number is: 48 and your course is: Sculpture
Please enter your id number.  Enter 0 as the id when you're done entering students.
0
Course name: Batik	Number of students: 2	Number of sessions: 0
Course name: Calligraphy	Number of students: 6	Number of sessions: 2
Course name: Painting	Number of students: 0	Number of sessions: 0
Course name: Sculpture	Number of students: 9	Number of sessions: 3
Course name: Weaving	Number of students: 5	Number of sessions: 1
 */
