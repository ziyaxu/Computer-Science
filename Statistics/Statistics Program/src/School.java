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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class School {
	
	//constants
	public static final int CLASS_LIM = 30;
	public static final int ID_SORT = 0;
	public static final int TEST_SORT = 1;
	public static final String STUDENT_HEADER = "ID" + '\t' + "Score" + '\t' + "Course Name";
	public static final String INPUT_FILE = "Enter the name of the file.";
	public static final String INPUT_ID = "Enter the id of the student you'd like to search for.";
	
	//private data
	private Student[] students = new Student[CLASS_LIM];
	private int numStudents = 0;
	private int numInvalidScoresFront = 0;
	private int numInvalidScoresBack = 0;
	private int highestScore = 0;
	private int lowestScore = 100;
	private int sumTestScores = 0;
	private int numA = 0, numB = 0, numC = 0, numD = 0, numF = 0;
	
	//empty constructor
	public School() {
		
	}
	
	//method to set the number of students
	//takes integer argument
	public void setNumStudents(int num) {
		numStudents = num;
	}
	
	//method to add another student to the students array
	//takes a Student argument of the student to be entered and an integer argument of the index to insert
	public void addStudent(int id, int grade, char course, int index) {
		Student student = new Student(id, grade, course);
		students[index] = student;
	}
	
	//asks for user to input file
	//returns user input
	//static because doesn't make sense to call inputfile method on school object
	public static String inputData(String inputMessage) throws IOException{
		//input reader
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println(inputMessage);
		return input.readLine();
	}
	
	//reads the file and adds students to the array
	public void readFile() throws IOException{
		FileReader readFile = new FileReader(inputData(INPUT_FILE));
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
			addStudent(id, grade, course, numStudents);
			numStudents++;
		}
	}
	
	public void countGrades(int grade) {
		if (grade >= 0 && grade <= 65)
			numF++;
		else if (grade <= 70)
			numD++;
		else if (grade <= 80)
			numC++;
		else if (grade <= 90)
			numB++;
		else if (grade <= 100) //else if because grade could be higher
			numA++;
	}
	
	//method to sort the student array
	//takes integer argument to determine what value to sort by
	//0 for ID sort, anything else for Test score sort
	public void sortStudents(int methodChoice) {
		//insertion sort
		for (int i = 1; i < numStudents; i++) {
			Student comparedStudent = students[i];
			int j = i-1;
           
            while (j >= 0 && students[j].getSortValue(methodChoice) > comparedStudent.getSortValue(methodChoice)) {
            	students[j+1] = students[j];
            	students[j] = comparedStudent;
                j--;
            }
            students[j+1] = comparedStudent;
		}
	}
	
	//method to print the array of students
	public void printStudentList() {
		System.out.println(STUDENT_HEADER);

		for (int i = 0; i < numStudents; i++) {
			System.out.println(students[i].studentToString());
		}
	}
	
	//method to check whether a score is the highest or lowest and reassigns those variables accordingly
	public void checkHighLow(int index) {
		if (students[index].getTestScore() > highestScore) {
			highestScore = students[index].getTestScore();
		}
		if (students[index].getTestScore() < lowestScore) {
			lowestScore = students[index].getTestScore();
		}
	}
	
	//method to find the mean
	//adds tally to number of scoures
	//returns the mean as a double rounded to two decimal places
	public double mean() {
		for (int i = 0; i < numStudents; i++) {
			if (students[i].getTestScore() < 0) {
				numInvalidScoresFront++;
			} else if (students[i].getTestScore() > 100) {
				numInvalidScoresBack++;
			} else {
				if (students[i].getTestScore() >= 0 && students[i].getTestScore() < 65)
					numF++;
				else if (students[i].getTestScore() < 70)
					numD++;
				else if (students[i].getTestScore() < 80)
					numC++;
				else if (students[i].getTestScore() < 90)
					numB++;
				else //else if because students[i].getTestScore() could be higher
					numA++;
				
				sumTestScores += students[i].getTestScore();
				checkHighLow(i);
			}
		}
		double mean = (double) (sumTestScores) / (numStudents - (numInvalidScoresFront + numInvalidScoresBack));
		
		return ((int) (mean * 100 + 0.5) / 100.0) ;
	}
	
	//method to calculate the median
	//returns the median as a double
	public double median() {
		int middle = (numInvalidScoresFront + (numStudents - numInvalidScoresBack) - 1) / 2;
		
		if (middle % 2 == 1) {
			return students[middle].getTestScore();
		} else {
			return (students[middle].getTestScore() + students[middle + 1].getTestScore()) / 2.0;
		}
		
	}
	
	//returns a string that describes the number of invalid scores
	public String toStringNumInvalid() {
		return "There are " + (numInvalidScoresFront + numInvalidScoresBack) + " invalid scores.";
	}
	
	//method to find the print the percentages of each letter grade
	public void printPercents() {
		
		int total = numStudents - numInvalidScoresFront - numInvalidScoresBack;
		
		double A = (double) numA / total;
		double B = (double) numB / total;
		double C = (double) numC / total;
		double D = (double) numD / total;
		double F = (double) numF / total;
		
		System.out.println("Letter" + '\t' + "Tally" + '\t' + "Percent");
		System.out.println("A" + '\t' + numA + " " + '\t' + (int) (A * 1000 + 0.5) / 10.0 + "%");
		System.out.println("B" + '\t' + numB + " " + '\t' + (int) (B * 1000 + 0.5) / 10.0 + "%");
		System.out.println("C" + '\t' + numC + " " + '\t' + (int) (C * 1000 + 0.5) / 10.0 + "%");
		System.out.println("D" + '\t' + numD + " " + '\t' + (int) (D * 1000 + 0.5) / 10.0 + "%");
		System.out.println("F" + '\t' + numF + " " + '\t' + (int) (F * 1000 + 0.5) / 10.0 + "%");
	}
	
	//method to print all of the statistics
	public void printStats() {
		System.out.println("Mean: " + mean());
		System.out.println("Median: " + median());
		System.out.println("Highest Score: " + highestScore);
		System.out.println("Lowest Score: " + lowestScore);
		System.out.println(toStringNumInvalid());
		printPercents();
	}
	
	
	 //find the index of value in students[] sorted in ascending order by ID
	 //returns index of user entered score
	public int searchID(int id) throws IOException {

		int front = 0;
		int back = numStudents - 1;
		
		while (front <= back) {
			
			int middle = (front + back) / 2;
			
			if (id < students[middle].getID()) {
				back = middle - 1;
			} else if (id > students[middle].getID()) {
				front = middle + 1;
			} else {
				return middle;
			}
		}
		
		return -1;
		
	}
	
	//method to print the data for the sought student
	public void printSoughtStudent(int index) throws IOException{
		System.out.println(STUDENT_HEADER);
		if (index < 0) 
			System.out.println("Sorry, that student is not in the list.");
		else
			System.out.println(students[index].studentToString());
	}
	
	
	public static void main (String args[]) throws IOException {
		School foxChapel = new School();
		
		foxChapel.readFile();
		
		/*main method for first statistics program
		foxChapel.printStudentList();
		foxChapel.sortStudents(TEST_SORT);
		foxChapel.printStats();*/
		
		//main method for second statistics program
		foxChapel.sortStudents(ID_SORT);
		foxChapel.printStudentList();
		
		int id = new Integer(inputData(INPUT_ID));
		int index = foxChapel.searchID(id);
		
		while (id != 999) {
			foxChapel.printSoughtStudent(index);
			System.out.println("Enter 999 as the ID when you are done.");
			id = new Integer(inputData(INPUT_ID));
			index = foxChapel.searchID(id);
		}
		
	}
}

/*
Output for modified
Enter the name of the file.
scores2.txt
ID	Score	Course Name
11 	70	Engineering
17 	85	Engineering
22 	500	Art
27 	90	Incorrect Course Code
32 	-10	Art
33 	90	Business
39 	400	Incorrect Course Code
43 	95	Computer Science
44 	300	Engineering
50 	8	Mathematics
53 	87	Business
55 	99	Education
63 	50	Engineering
65 	88	Mathematics
73 	89	Education
75 	80	Computer Science
83 	95	Mathematics
85 	60	Mathematics
87 	70	Business
93 	90	Engineering
Enter the id of the student you'd like to search for.
0
ID	Score	Course Name
Sorry, that student is not in the list.
Enter 999 as the ID when you are done.
Enter the id of the student you'd like to search for.
11
ID	Score	Course Name
11 	70	Engineering
Enter 999 as the ID when you are done.
Enter the id of the student you'd like to search for.
27
ID	Score	Course Name
27 	90	Incorrect Course Code
Enter 999 as the ID when you are done.
Enter the id of the student you'd like to search for.
50
ID	Score	Course Name
50 	8	Mathematics
Enter 999 as the ID when you are done.
Enter the id of the student you'd like to search for.
65
ID	Score	Course Name
65 	88	Mathematics
Enter 999 as the ID when you are done.
Enter the id of the student you'd like to search for.
93
ID	Score	Course Name
93 	90	Engineering
Enter 999 as the ID when you are done.
Enter the id of the student you'd like to search for.
100
ID	Score	Course Name
Sorry, that student is not in the list.
Enter 999 as the ID when you are done.
Enter the id of the student you'd like to search for.
25
ID	Score	Course Name
Sorry, that student is not in the list.
Enter 999 as the ID when you are done.
Enter the id of the student you'd like to search for.
999

 */
