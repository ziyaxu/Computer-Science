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

/* Output
Enter the name of the file.
maze1.txt
##C#####################################
##         ######## ############       #
##          ####### #            ##### #
## ################ ################## #
## #######                       ##### #
## ####### ############### ######   ## #
## #######         M###### ###    #  # #
## #####  ########## ##### ### ## # ## #
## ##### # ######    #####     ## # ## #
## ##### #######  ## ##############  # #
## ##### ####    ### #########    ## # #
##       #### ###### ######### ##### # #
###        ## ###### ######### ##    # #
### ######### ######     ##### ## #### #
### ######### ######## ## #### ##      #
###             ###### ## #### ####### #
###################### ## #   ##       #
###################### ######### ##### #
######################           #     #
########################################

Navigated maze:
##C#####################################
##O        ######## ############       #
##O         ####### #            ##### #
##O################ ################## #
##O#######OOOOOOOOOOOOOOOOO      ##### #
##O#######O###############O######OOO## #
##O#######OOOOOOOOOM######O###OOOO#O # #
##O#####  ########## #####O###O## #O## #
##O##### # ######OOOO#####OOOOO## #O## #
##O##### #######OO##O##############OO# #
##O##### ####OOOO###O#########    ##O# #
##OO     ####O######O######### #####O# #
###O       ##O######O######### ##OOOO# #
###O#########O######OOO  ##### ##O#### #
###O#########O########O## #### ##OOOOOO#
###OOOOOOOOOOO  ######O## #### #######O#
######################O## #   ##OOOOOOO#
######################O#########O##### #
######################OOOOOOOOOOO#     #
########################################
The dimensions of the maze are 20 x 40. 

Enter the name of the file.
maze2.txt
####C  
#### ##
###M   
       
       
       
#######

Navigated maze:
####C  
####O##
###MO  
   OO  
   OO  
   OO  
#######
The dimensions of the maze are 7 x 7.

Enter the name of the file.
maze3.txt
########C#
#     #  #
 #####   #
#       ##
#    #####
#       ##
######    
#       M#
        ##
###       

Navigated maze:
########C#
#     # O#
 ##### OO#
#   OOOO##
#   O#####
#   OOO ##
######O   
#     OOM#
      OO##
###   OO  
The dimensions of the maze are 10 x 10.

Enter the name of the file.
maze4.txt
#####C#####
#          
#          
# #### ####
  #  #    #
# # M#    #
# #  #    #
# ######## 

The mouse cannot navigate this maze that is 8 x 11.

Enter the name of the file.
maze5.txt
M      C
        
        
######  
        
        
        
######  

Navigated maze:
MOOOOOOC
OOOOOOOO
OOOOOOOO
######OO
      OO
      OO
      OO
######OO
The dimensions of the maze are 8 x 8.

Enter the name of the file.
maze6.txt
M     C
       
       
#######
       
       
       
#######

Navigated maze:
MOOOOOC
 OOOOOO
 OOOOOO
#######
       
       
       
#######
The dimensions of the maze are 8 x 7.

Enter the name of the file.
maze7.txt
    C     
          
          
          
          
       M  
          
          

Navigated maze:
    C   OO
    O   OO
    O   OO
    O   OO
    O   OO
    O  MOO
    O  OOO
    OOOOOO
The dimensions of the maze are 8 x 10.

Enter the name of the file.
maze8.txt
#####C    
######### 
######### 
######    
       ###
M#########

Navigated maze:
#####COOOO
#########O
#########O
######OOOO
OOOOOOO###
M#########
The dimensions of the maze are 6 x 10.

Enter the name of the file.
maze9.txt
####C    M## 
             
############ 

Navigated maze:
####C    M## 
    OOOOOO   
############ 
The dimensions of the maze are 3 x 13.

Enter the name of the file.
maze10.txt
 C  
    
    
    
  M 
    
    
    
    
    

Navigated maze:
 COO
 OOO
 OOO
 OOO
 OMO
 O O
 O O
 O O
 O O
 OOO
The dimensions of the maze are 10 x 4.

Enter the name of the file.
maze11.txt
###C######
          
          
  #####   
  #   #   
  # M #   
  #   #   
  #####   

The mouse cannot navigate this maze that is 8 x 10.

Enter the name of the file.
maze12.txt
##C#####################################
##         ######## ############       #
##          ####### #            ##### #
## ################ ################## #
## #######                       ##### #
## ####### ############### ######   ## #
## #######         M###### ###    #  # #
## ################# ##### ### ## # ## #
## ##### # ######    #####     ## # ## #
## ##### #######  ## ##############  # #
## ##### ####    ### #########    ## # #
##       #### ###### ######### ##### # #
###        ## ###### ######### ##    # #
### ######### ######     ##### ## #### #
### ######### ######## ## #### ##      #
###             ###### ## #### ####### #
###################### ## #   ##       #
###################### ######### ##### #
######################           #     #
########################################

Navigated maze:
##C#####################################
##O        ######## ############       #
##O         ####### #            ##### #
##O################ ################## #
##O#######OOOOOOOOOOOOOOOOO      ##### #
##O#######O###############O######OOO## #
##O#######OOOOOOOOOM######O###OOOO#O # #
##O################# #####O###O## #O## #
##O##### # ######OOOO#####OOOOO## #O## #
##O##### #######OO##O##############OO# #
##O##### ####OOOO###O#########    ##O# #
##OO     ####O######O######### #####O# #
###O       ##O######O######### ##OOOO# #
###O#########O######OOO  ##### ##O#### #
###O#########O########O## #### ##OOOOOO#
###OOOOOOOOOOO  ######O## #### #######O#
######################O## #   ##OOOOOOO#
######################O#########O##### #
######################OOOOOOOOOOO#     #
########################################
The dimensions of the maze are 20 x 40.
*/