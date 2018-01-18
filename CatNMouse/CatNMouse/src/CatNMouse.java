/*
 * Ziya Xu
 * Period 2
 * CatNMouse Program
 * 
 * This program recursively navigates an array maze.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CatNMouse {
	
	private ArrayList<ArrayList<Character>> maze = new ArrayList<ArrayList<Character>>();
	private boolean canNavigate = false;
	
	public CatNMouse() {
		
	}
	
	/**
	 * Getter
	 * @return whether the maze is solvable
	 */
	public boolean getCanNavigate() {
		return canNavigate;
	}

	/**
	 * Asks for user to input file
	 * Static because doesn't make sense to call inputFile method on CatNMouse object
	 * @return user input
	 * @throws IOException
	 */
	public static String inputFile() throws IOException{
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Enter the name of the file.");
		return input.readLine();
	}
	
	/**
	 * Reads the txt file containing the maze
	 * Stores maze as private data
	 * @throws IOException
	 */
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
	
	/**
	 * Method to find the position of the cat
	 * @return column index of cat
	 */
	public int findC() {
		ArrayList<Character> firstLine = new ArrayList<Character>();
		firstLine = maze.get(0);
		
		for (int i = 0; i < firstLine.size(); i++) {
			if (firstLine.get(i) == 'C') return i;
		}
		
		return -1;
	}
	
	/**
	 * Recursive maze navigating method
	 * Checks validity of current position, then tries to move down, right, up, or left
	 * Marks path with 'O'
	 * @param row
	 * @param col
	 * @return whether the current position is the path or not
	 * @throws IOException
	 */
	public boolean findM(int row, int col) throws IOException{

		if (col >= maze.get(0).size() || col < 0
				|| row >= maze.size() || row < 0
				|| maze.get(row).get(col) == 'O'
				|| maze.get(row).get(col) == '#')
			return false;
		else {
			
			if (maze.get(row).get(col) == 'M') {
				canNavigate = true;
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
	
	/**
	 * Method to change a character in the maze
	 * @param row
	 * @param col
	 * @param character to change position to
	 */
	public void changeChar(int row, int col, char x) {
		ArrayList<Character> line = new ArrayList<Character>(); //marking path with O
		line = maze.get(row);
		line.set(col, x);
		maze.set(row, line);
	}
	
	/**
	 * Prints maze array
	 */
	public void printArray() {
		for (ArrayList<Character> row: maze) {
			for (char x: row)
				System.out.print(x);
			System.out.println();
		}	
	}
	
	/**
	 * @return The dimension of the maze as a string
	 */
	public String dim() {
		return maze.size() + " x " + maze.get(0).size() + ".";
	}
	
	public static void main (String args[]) throws IOException {
		
		CatNMouse maze = new CatNMouse();
		
		maze.readFile();
		
		maze.printArray();
		int C = maze.findC();
		maze.findM(0, C);
	
		maze.changeChar(0, C, 'C');
		System.out.println();
		
		if (maze.getCanNavigate()) {
			System.out.println("Navigated maze:");
			maze.printArray();
			System.out.println("The dimensions of the maze are " + maze.dim());
		} else
			System.out.println("The mouse cannot navigate this maze that is " + maze.dim());
		
	}

}