/*
 * Ziya Xu
 * Merge Program
 * 10/24/17
 * 
 * This program asks the user to enter two separate lists of integers on one line each,
 * with the integers separated by a space.  Then it sorts the lists so each is ordered
 * in ascending order.  Finally, it merges the two lists into one sorted list.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Merge {
	
	//private data
	private int[] intList;
	private int count;
	
	//empty constructor
	public Merge() {
	}
	
	//getters
	public int getCount() {
		return count;
	}
	
	public int[] getIntList() {
		return intList;
	}
	
	//setters
	public void setLength(int len) {
		intList = new int[len];
	}
	
	//method to ask for user input of the integer lists
	//adds user entries to the list and gets the count value
	public void userInput() throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		//TODO: error trap input? //handle empty list
		System.out.println("Please enter your list.");
		StringTokenizer list = new StringTokenizer(input.readLine());
		
		intList = new int[list.countTokens()];
		int index = 0;
		
		while (list.hasMoreTokens()) {
			intList[index] = new Integer(list.nextToken()); 
			index++;
		}
		
		count = index;
	}
	
	//method to sort lists (insertion sort) in ascending numerical order
	public void sort() {
		
		for (int i = 1; i < count; i++) {
			int comparedValue = intList[i];
            int j = i-1;
            
            while (j >= 0 && intList[j] > comparedValue) {
            	intList[j+1] = intList[j];
                j--;
            }
            
            intList[j+1] = comparedValue;
		}
            
    }
	
	//method to merge two lists into one list in ascending order
	//takes two Merge object arguments
	public void merge(Merge list1, Merge list2) {
		
		int[] one = list1.getIntList();
		int[] two = list2.getIntList();
		int oneCount = list1.getCount();
		int twoCount = list2.getCount();
		count = intList.length;
		int indexOne = 0;
		int indexTwo = 0;
		int indexThree = 0;
		
		while (indexOne < oneCount && indexTwo < twoCount) {
			
			if (indexOne < oneCount - 1 && one[indexOne] == one[indexOne + 1]) { //skips over duplicates
				indexOne++;
				count--;
			} else if (indexTwo < twoCount - 1 && two[indexTwo] == two[indexTwo + 1]) { //skips over duplicates
				indexTwo++;
				count--;
			} else if (one[indexOne] < two[indexTwo]) { //merging by value
				intList[indexThree] = one[indexOne];
				indexOne++;
				indexThree++;
			} else if (one[indexOne] > two[indexTwo]) {
				intList[indexThree] = two[indexTwo];
				indexTwo++;
				indexThree++;
			} else {
				intList[indexThree] = one[indexOne];
				indexOne++;
				indexTwo++;
				indexThree++;
				count--;
			}
		
		}
		
		//adds remaining numbers at end of lists to final list
		while (indexOne < oneCount) {
			intList[indexThree] = one[indexOne];
			indexOne++;
			indexThree++;
		}
		
		while (indexTwo < twoCount) {
			intList[indexThree] = two[indexTwo];
			indexTwo++;
			indexThree++;
		}
	}
	
	//method to print out lists
	public void print() {
		System.out.print("--> ");
		for (int i = 0; i < count; i++) {
			System.out.print(intList[i] + " ");
		}
		System.out.println();
	}
	
	//main method
	public static void main (String args[]) throws IOException{
		int i = 1;
		
		while (i <= 15) {
			System.out.println("Example format: 21 18 12 8 3 2");
			
			//first list
			System.out.println("List 1 of unordered integers");
			Merge list1 = new Merge();
			list1.userInput();
			list1.sort();
			System.out.print("List 1 ");
			list1.print();
			
			//second list
			System.out.println("List 2 of unordered integers");
			Merge list2 = new Merge();
			list2.userInput();
			list2.sort();
			System.out.print("List 2 ");
			list2.print();
			
			//final list
			Merge list3 = new Merge();
			list3.setLength(list1.getCount() + list2.getCount());
			System.out.print("List 3 ");
			list3.merge(list1, list2);
			list3.print();
			
			System.out.println();
			
			i++;
		}
	}
}

/* Output
 Example format: 21 18 12 8 3 2
List 1 of unordered integers
Please enter your list.
1
List 1 --> 1 
List 2 of unordered integers
Please enter your list.
4 2 3
List 2 --> 2 3 4 
List 3 --> 1 2 3 4 

Example format: 21 18 12 8 3 2
List 1 of unordered integers
Please enter your list.
8
List 1 --> 8 
List 2 of unordered integers
Please enter your list.
7 6
List 2 --> 6 7 
List 3 --> 6 7 8 

Example format: 21 18 12 8 3 2
List 1 of unordered integers
Please enter your list.
7 11
List 1 --> 7 11 
List 2 of unordered integers
Please enter your list.
8 13 2 9
List 2 --> 2 8 9 13 
List 3 --> 2 7 8 9 11 13 

Example format: 21 18 12 8 3 2
List 1 of unordered integers
Please enter your list.
6 4 2
List 1 --> 2 4 6 
List 2 of unordered integers
Please enter your list.
5 3 1
List 2 --> 1 3 5 
List 3 --> 1 2 3 4 5 6 

Example format: 21 18 12 8 3 2
List 1 of unordered integers
Please enter your list.
5 2 7 8
List 1 --> 2 5 7 8 
List 2 of unordered integers
Please enter your list.
3 5 4
List 2 --> 3 4 5 
List 3 --> 2 3 4 5 7 8 

Example format: 21 18 12 8 3 2
List 1 of unordered integers
Please enter your list.
2
List 1 --> 2 
List 2 of unordered integers
Please enter your list.
2
List 2 --> 2 
List 3 --> 2 

Example format: 21 18 12 8 3 2
List 1 of unordered integers
Please enter your list.
7 9 8
List 1 --> 7 8 9 
List 2 of unordered integers
Please enter your list.
2 1
List 2 --> 1 2 
List 3 --> 1 2 7 8 9 

Example format: 21 18 12 8 3 2
List 1 of unordered integers
Please enter your list.
7 9 8 1
List 1 --> 1 7 8 9 
List 2 of unordered integers
Please enter your list.
9 1 7 2 3
List 2 --> 1 2 3 7 9 
List 3 --> 1 2 3 7 8 9 

Example format: 21 18 12 8 3 2
List 1 of unordered integers
Please enter your list.
5 6 
List 1 --> 5 6 
List 2 of unordered integers
Please enter your list.
3 6 4
List 2 --> 3 4 6 
List 3 --> 3 4 5 6 

Example format: 21 18 12 8 3 2
List 1 of unordered integers
Please enter your list.
9 8 7 4
List 1 --> 4 7 8 9 
List 2 of unordered integers
Please enter your list.
4 3 2 1
List 2 --> 1 2 3 4 
List 3 --> 1 2 3 4 7 8 9 

Example format: 21 18 12 8 3 2
List 1 of unordered integers
Please enter your list.
4 3 2 1 9 
List 1 --> 1 2 3 4 9 
List 2 of unordered integers
Please enter your list.
4 9 1 3 2
List 2 --> 1 2 3 4 9 
List 3 --> 1 2 3 4 9 

Example format: 21 18 12 8 3 2
List 1 of unordered integers
Please enter your list.
4 8 7 6 2 5
List 1 --> 2 4 5 6 7 8 
List 2 of unordered integers
Please enter your list.
5 6 1 9 3 4
List 2 --> 1 3 4 5 6 9 
List 3 --> 1 2 3 4 5 6 7 8 9 

Example format: 21 18 12 8 3 2
List 1 of unordered integers
Please enter your list.
9 1
List 1 --> 1 9 
List 2 of unordered integers
Please enter your list.
7 1 6 3 5 2
List 2 --> 1 2 3 5 6 7 
List 3 --> 1 2 3 5 6 7 9 

Example format: 21 18 12 8 3 2
List 1 of unordered integers
Please enter your list.
15 14 13 12 1 2 3 4 5 6 11 10 9 8 7
List 1 --> 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 
List 2 of unordered integers
Please enter your list.
21 20 22
List 2 --> 20 21 22 
List 3 --> 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 20 21 22 

Example format: 21 18 12 8 3 2
List 1 of unordered integers
Please enter your list.
10 20 30 40 50 60 70 80 90 21 31 41 51 61 71 
List 1 --> 10 20 21 30 31 40 41 50 51 60 61 70 71 80 90 
List 2 of unordered integers
Please enter your list.
22 32 42 52 62 72 82 92 10 20 30 40 50 31 41
List 2 --> 10 20 22 30 31 32 40 41 42 50 52 62 72 82 92 
List 3 --> 10 20 21 22 30 31 32 40 41 42 50 51 52 60 61 62 70 71 72 80 82 90 92
 */