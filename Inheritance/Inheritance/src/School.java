import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class School {
	
	public static final String FILE_NAME = "InheritanceSchool.txt"; //TODO: user input file name?
	
	private HSStudent[] school = new HSStudent[10];
	private int numStudents = 0;
	
	public School() {
	}
	
	public void readFile() throws IOException{
		FileReader readFile = new FileReader(FILE_NAME);
		BufferedReader inFile = new BufferedReader(readFile);
		
		String inputString = inFile.readLine(); //reading one line of file
		
		//TODO: ask if this is okay in one method
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
		//HSStudent student = new Student(id, grade, course);
		school[numStudents] = student;
		numStudents++;
	}
	
	public void sortStudents() {
		for (int i = 1; i < numStudents; i++) {
			
			HSStudent comparedStudent = school[i];
			int j = i-1;
           
            while (j >= 0 && school[j].compareTo(comparedStudent) >= 0) { 
            	school[j+1] = school[j];
                j--;
            }
            school[j+1] = comparedStudent;
		}
	}
	
	public void printStudents() {
		for (int i = 0; i < numStudents; i++) {
			System.out.println(school[i].toString());
		}
		
		/*for (Student student: school) {
			System.out.println(student.toString());
		}*/ //TODO: Why does this throw null pointer exception?
	}
	
	public static void main (String[] args) throws IOException {
		School foxChapel = new School();
		foxChapel.readFile();
		foxChapel.sortStudents();
		foxChapel.printStudents();
	}
}