import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class School {
	
	public static final String FILE_NAME = "InheritanceSchool.txt";
	
	private ArrayList<HSStudent> school = new ArrayList<HSStudent>();
	
	public School() {
	}
	
	public void readFile() throws IOException{
		FileReader readFile = new FileReader(FILE_NAME);
		BufferedReader inFile = new BufferedReader(readFile);
		
		String inputString = inFile.readLine(); //reading one line of file
		
		while (inputString != null){
			appendStudents(inputString);
			inputString = inFile.readLine();
		}
		
		inFile.close();
	}
	
	//adds students to the Student array
	//takes String argument
	public void appendStudents(String inputString) {
		StringTokenizer inputLine = new StringTokenizer(inputString);
		
		while(inputLine.hasMoreTokens()) {
			String first = inputLine.nextToken();
			String last = inputLine.nextToken();
			int grade = new Integer(inputLine.nextToken());
			double qpa = new Double(inputLine.nextToken());
			
			if (grade == 9) {
				int referrals = new Integer(inputLine.nextToken());
				HSStudent student = new Freshman(first, last, grade, qpa, referrals);
				addStudent(student);
			} else if (grade == 10) {
				char mathGrade = inputLine.nextToken().charAt(0);
				HSStudent student = new Sophomore(first, last, grade, qpa, mathGrade);
				addStudent(student);
			} else if (grade == 11) {
				int keystone = new Integer (inputLine.nextToken());
				HSStudent student = new Junior(first, last, grade, qpa, keystone);
				addStudent(student);
			}
			else {
				boolean portfolio = new Boolean(inputLine.nextToken());
				double fines = new Double(inputLine.nextToken());
				HSStudent student = new Senior(first, last, grade, qpa, portfolio, fines);
				addStudent(student);
			}
		}
	}
	
	public void addStudent(HSStudent student) {
		school.add(student);
	}
	
	public void sortStudents() {
		for (int i = 1; i < school.size(); i++) {
			
			HSStudent comparedStudent = school.get(i);
			int j = i-1;
           
            while (j >= 0 && school.get(j).compareTo(comparedStudent) >= 0) {
            	school.set(j+1, school.get(j));
                j--;
            }
            school.set(j+1, comparedStudent);
		}
	}
	
	public void printStudents() {
		for (Student student: school) {
			System.out.println(student.toString());
			System.out.println();
		}
	}
	
	public static void main (String[] args) throws IOException {
		School foxChapel = new School();
		foxChapel.readFile();
		foxChapel.sortStudents();
		foxChapel.printStudents();
	}
}

//OUTPUT
//Freshman Amanda Apple is in grade 9 with a 4.0 qpa.
//Amanda Apple has 0 referrals.
//
//Freshman Sally Apple is in grade 9 with a 4.0 qpa.
//Sally Apple has 0 referrals.
//
//Sophomore Taylor Beans is in grade 10 with a 1.0 qpa.
//Taylor Beans's freshman year math grade is C.
//
//Sophomore Taylor Smith is in grade 10 with a 3.3 qpa.
//Taylor Smith's freshman year math grade is A.
//
//Junior Johnny Apple is in grade 11 with a 4.0 qpa.
//Johnny Apple's keystone level is Advanced.
//
//Senior Bob Smith is in grade 12 with a 2.0 qpa.
//Bob Smith owes $45.0 in fines to the school.
//Bob Smith has completed his or her portfolio.