import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CatNMouse {
	
	private ArrayList<ArrayList<Character>> maze = new ArrayList<ArrayList<Character>>();
	
	public CatNMouse() {
		
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
	
	public boolean valid(int x, int y) {
		if (x >= maze.get(0).size() || x < 0)
			return false;
		else if (y >= maze.size() || y < 0)
			return false;
		else return (maze.get(y).get(x) == ' ');
	}
	
	public boolean findM(int x, int y) {
		
		boolean found = false;
		
		if (valid(x, y)) {
			
			ArrayList<Character> line = new ArrayList<Character>(); //marking path with O
			line = maze.get(y);
			line.set(x, 'O');
			maze.set(y, line);
			
			if (maze.get(y).get(x) == 'M') found = true;
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
		maze.findM(0, maze.findC());
	
		System.out.println();
		maze.printArray();
		
	}

}
