import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MagicSquare {
	
	//TODO: always use .length or make new array
	private int[][] square;
	
	public MagicSquare() {
		
	}
	
	public int askUser() throws IOException {
		//input reader
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Please enter the dimension of your magic square as an odd integer.");
		String inputValue = input.readLine();
		while (!isOddInt(inputValue)) {
			System.out.println("Please enter a valid dimension.");
			inputValue = input.readLine();
		}
		
		return new Integer(inputValue);
	}
	
	public void setSquareDim(int dim) {
		square = new int[dim][dim];
	}
	
	//method to check if a string is an integer
	public boolean isOddInt(String input) {
		try {
	        int num = new Integer(input);
	        if (num < 3 || num >= 20)
	        	return false;
	        else if (num % 2 == 0)
	        	return false;
	        else
	        	return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	public void buildSquare() {
		int rowIndex = 0;
		int colIndex = square.length / 2;
		int numToAdd = 1;
		
		while (numToAdd <= Math.pow(square.length, 2)) {
			
			square[rowIndex][colIndex] = numToAdd;
			
			rowIndex--;
			colIndex++;
			
			int oriRowIndex = rowIndex;
			int oriColIndex = colIndex;
			
			if (rowIndex < 0) {
				rowIndex = square.length - 1;
			}
			
			if (colIndex >= square.length) {
				colIndex = 0;
			}
			
			if (square[rowIndex][colIndex] != 0) {
				colIndex = oriColIndex - 1;
				rowIndex = oriRowIndex + 2;
			}
			
			numToAdd++;
		}
		
	}
	
	public void printSquare() {
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square.length; j++) {
				System.out.print(square[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static void main (String args[]) throws IOException {
		MagicSquare square = new MagicSquare();
		
		int dim = square.askUser();
		square.setSquareDim(dim);
		square.buildSquare();
		square.printSquare();
	
	}

}
