import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CatNMouse {
	
	private ArrayList<ArrayList<Character>> maze = new ArrayList<ArrayList<Character>>();
	
	public CatNMouse() {
		
	}

	/**
	 * asks for user to input file
	 * static because doesn't make sense to call inputFile method on CatNMouse object
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
		
		while (inputString != null){
			ArrayList<Character> row = new ArrayList<Character>();
			
			for (int i = 0; i < inputString.length(); i++)
				row.add(inputString.charAt(i));
			
			maze.add(row);
			inputString = inFile.readLine();
		}
		
		inFile.close();
	}
	
	public int findC() {
		ArrayList<Character> firstLine = new ArrayList<Character>();
		firstLine = maze.get(0);
		
		for (int i = 0; i < firstLine.size(); i++) {
			if (firstLine.get(i) == 'C') return i;
		}
		
		return -1;
	}
	
	public boolean findM(int row, int col) throws IOException{
//		InputStreamReader reader = new InputStreamReader(System.in);
//		BufferedReader input = new BufferedReader(reader);
//		input.readLine();
		System.out.println();
		printArray();
		System.out.println("Row:" + (row+1) + " Col:" + (col+1));

		if (col >= maze.get(0).size() || col < 0
				|| row >= maze.size() || row < 0
				|| maze.get(row).get(col) == 'O'
				|| maze.get(row).get(col) == '#')
			return false;
		else {
			
			if (maze.get(row).get(col) == 'M') {
				return true;
			}
			changeChar(row, col, 'O'); //marking path with O
				
			if (findM(row + 1, col)) //down
				return true;
			if (findM(row, col + 1)) //right
				return true;
			if (findM(row - 1, col)) //up
				return true;
			if (findM(row, col - 1)) //left
				return true;
			
			changeChar(row, col, ' '); //marking path with O
			return false;	
		}

	}
	
	public void changeChar(int row, int col, char x) {
		ArrayList<Character> line = new ArrayList<Character>(); //marking path with O
		line = maze.get(row);
		line.set(col, x);
		maze.set(row, line);
	}
	
	public void printArray() {
		for (ArrayList<Character> row: maze) {
			for (char x: row)
				System.out.print(x);
			System.out.println();
		}	
	}
	
	public String dim() {
		return maze.size() + " x " + maze.get(0).size();
	}
	
	public static void main (String args[]) throws IOException {
		
		CatNMouse maze = new CatNMouse();
		
		maze.readFile();
		
		maze.printArray();
		int C = maze.findC();
		maze.findM(0, C);
	
		maze.changeChar(0, C, 'C');
		System.out.println();
		maze.printArray();
		
	}

}