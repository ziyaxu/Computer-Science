import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CatNMouse {
	
	public static final String INPUT_FILE = "Enter the name of the file.";
	
	private ArrayList<ArrayList<Character>> maze;

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
	
	public void readFile(String fileName) throws IOException{
		FileReader readFile = new FileReader(fileName);
		BufferedReader inFile = new BufferedReader(readFile);
		
		String inputString = inFile.readLine(); //reading one line of file
		
		StringTokenizer inputLine = new StringTokenizer(inputString);
		ArrayList<Character> row = new ArrayList<Character>();
		
		while (inputString != null){
			while(inputLine.hasMoreTokens()) {
				row.add(inputLine.nextToken().charAt(0));
			}
			maze.add(row);
			inputString = inFile.readLine();
		}
		
		inFile.close();
	}
	
	public void printArray() {
		for (ArrayList<Character> row: maze) {
			for (char x: row) {
				System.out.print(x);
			}
			System.out.println();
		}	
	}
	
	public String dim() {
		return maze.size() + " x " + maze.get(0).size();
	}

}
