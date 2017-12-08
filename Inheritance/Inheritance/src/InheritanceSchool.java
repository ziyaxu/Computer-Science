import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InheritanceSchool {
	
	public static final String FILE_NAME = "InheritanceSchool.txt";
	
	private HSStudent[] school = new HSStudent[10];
	private int numStudents = 0;
	
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
			int id = new Integer(inputLine.nextToken());
			int grade = new Integer(inputLine.nextToken());
			char course = inputLine.nextToken().charAt(0);
			
			//addStudent(id, grade, course, numStudents);
			numStudents++;
		}
	}
	
	/*public void addStudent(int id, int grade, char course, int index) {
		HSStudent student = new Student(id, grade, course);
		school[index] = student;
	}*/
	
	public InheritanceSchool() {
		
	}

}
