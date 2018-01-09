import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CatNMouseArray {

	private char[][] maze;
	private int countCol = 0;
	private int countRow;
	
	public CatNMouseArray() {
		
	}

	/**
	 * asks for user to input file
	 * static because doesn't make sense to call inputFile method on school object
	 * @return user input
	 * @throws IOException
	 */
	public static String inputFile() throws IOException{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Enter the name of the file.");
		return input.readLine();
	}
	
	public void readFile() throws IOException{
		FileReader readFile = new FileReader(inputFile());
		BufferedReader inFile = new BufferedReader(readFile);
		
		String inputString = inFile.readLine(); //reading one line of file
		
		countRow = inputString.length();
		while (inputString != null){
			char[] row = new char[countRow];
			
			for (int i = 0; i < countRow; i++)
				row[i] = inputString.charAt(i);
			
			countCol++;
			maze[countCol] = ;
			inputString = inFile.readLine();
		}
		
	
		inFile.close();
	}
	
	public int findC() {
		char[] firstLine = maze[0];
		
		for (int i = 0; i < firstLine.length; i++) {
			if (firstLine[i] == 'C') return i;
		}
		
		return -1;
	}
	
	public boolean valid(int x, int y) {
		if (x >= maze[0].length || x < 0)
			return false;
		else if (y >= maze.length || y < 0)
			return false;
		else return (maze[y][x] == ' ');
	}
	
	public boolean findM(int x, int y) {
		
		boolean found = false;
		
		if (valid(x, y)) {
			
			maze[y][x] = 'O';
			
			if (maze[y][x] == 'M') found = true;
			else {
				found = findM(x + 1, y);
				if (!found)
					found = findM(x - 1, y);
				if (!found)
					found = findM(x, y + 1);
				if (!found)
					found = findM(x, y - 1);
			}
		}
	
		return found;
	}
	
	public void printArray() {
		for (char[] row: maze) {
			for (char x: row)
				System.out.print(x);
			System.out.println();
		}	
	}
	
	public String dim() {
		return maze.length + " x " + maze[0].length;
	}
	
	public static void main (String args[]) throws IOException {
		
		CatNMouseArray maze = new CatNMouseArray();
		
		maze.readFile();
		
		maze.printArray();
		maze.findM(0, maze.findC());
	
		System.out.println();
		maze.printArray();
		
	}

}