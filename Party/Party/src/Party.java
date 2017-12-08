import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Party {

	public final static String FILE_NAME = "GuestList.txt";
	public final static String PROMPT = "Please enter the guest's ";
	public final static String FIRST = "first name.";
	public final static String LAST = "last name.";
	public final static String COMPANY = "company.";
	
	private ArrayList<Guest> guestList = new ArrayList<Guest>();
	
	public Party() {
	}
	
	/**
	 * Reads the file and adds guests to ArrayList
	 * @throws IOException
	 */
	public void readGuestList() throws IOException {
		FileReader readFile = new FileReader(FILE_NAME);
		BufferedReader inFile = new BufferedReader(readFile);
		
		String inputString = inFile.readLine();
		
		while (inputString != null){
			appendGuests(inputString);
			inputString = inFile.readLine();
		}
		inFile.close();
	}
	
	/**
	 * Creates new guests from one line of the file
	 * @param inputString
	 */
	public void appendGuests(String inputString) {
		StringTokenizer inputLine = new StringTokenizer(inputString);
		
		while(inputLine.hasMoreTokens()) {
			String first = inputLine.nextToken();
			String last = inputLine.nextToken();
			String company = inputLine.nextToken();
			String attendance = inputLine.nextToken();
			
			Guest guest = new Guest(first, last, company, attendance);
			guestList.add(guest);
		}
	}
	
	/**
	 * Lists what the commands are and asks the user to enter a command
	 * Error checks for a valid command
	 * 
	 * @return char that represents the command
	 * @throws IOException
	 */
	public char askCommand() throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("Enter one of the following commands:"
				+ "\n" + "'G' for guest information of a specified guest"
				+ "\n" + "'L' to list guests"
				+ "\n" + "'N' for the number of guests attending, declining, or unknown"
				+ "\n" + "'A' to add a new guest"
				+ "\n" + "'R' to change guest response"
				+ "\n" + "'C' to find the colleagues of an entered guest"
				+ "\n" + "'Q' to quit the program");
		
		String in = input.readLine();
		
		while (!isCommand(in)) {
			System.out.println("Please enter a valid code.");
			in = input.readLine();
		}
		
		return in.charAt(0);
	}
	
	/**
	 * Checks whether input is a valid command or not
	 * 
	 * @param input of command
	 * @return whether the input is a command or not
	 */
	public boolean isCommand(String input) {
		if (input.length() == 1) {
			char command = input.charAt(0);
			return command == 'G' ||  command == 'L' || command == 'N' || command == 'A' 
					|| command == 'R' || command == 'C' || command == 'Q'
					|| command == 'g' || command == 'l' || command == 'n' || command == 'a'
					|| command == 'r' || command == 'c' || command == 'q';
		} else
			return false;
		
 	}
	
	/**
	 * Executes the command entered
	 * 
	 * @param command
	 * @throws IOException
	 */
	public void doCommand(char command) throws IOException {
		if (command == 'G' || command == 'g')
			G();
		else if (command == 'L' || command == 'l')
			L();
		else if (command == 'N' || command == 'n')
			N();
		else if (command == 'A' || command == 'a')
			A();
		else if (command == 'R' || command == 'r')
			R();
		else if (command == 'C' || command == 'c') //must be else if because command 'q' quits the program
			C();
	}
	
	/**
	 * Asks user to enter a value
	 * @param type of input
	 * @return value enteres
	 * @throws IOException
	 */
	public String ask(String type) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println(PROMPT + type);
		return input.readLine();
	}
	
	/**
	 * Asks user for their attendance
	 * Checks to make sure valid response is entered
	 * @return attendance entered
	 * @throws IOException
	 */
	public String askAttendance() throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println(PROMPT + "attendance as 'yes', 'no', or '?'.");
		String response = input.readLine();
		while (!(response.equals("yes") || response.equals("no") || response.equals("?"))) {
			System.out.println("Please enter a valid response.");
			response = input.readLine();
		}
		return response;
	}
	
	/**
	 * Insertion sort of guests by their last name, then first name
	 */
	public void sortGuests() {
		for (int i = 1; i < guestList.size(); i++) {
			
			Guest comparedGuest = guestList.get(i);
			int j = i-1;
           
            while (j >= 0 && guestList.get(j).compareGuests(comparedGuest) >= 0) {            	
            	guestList.set(j+1, guestList.get(j));
                j--;
            }
            
            guestList.set(j+1, comparedGuest);
		}
	}
	
	/**
	 * Binary search of guests
	 * @param first name of guest
	 * @param last name of guest
	 * @return index of guest, -1 if not in list
	 */
	public int searchGuests(String first, String last) {
		
		int pos = 0, end = guestList.size() - 1;
		Guest compare = new Guest(first, last, "", "");
		
		while (pos <= end) {
			int mid = (pos + end)/2;
		
			if (guestList.get(mid).compareGuests(compare) == 0)
				return mid;
			else if (guestList.get(mid).compareGuests(compare) < 0)
				pos = mid + 1;
			else
				end = mid - 1;
			
		}
		
		return -1;
	}
	
	/**
	 * Command G - guest information of a specified guest
	 * prompts for a guest's first and last names
	 * prints the name (last, first), employer, and response ("yes", "no", "maybe" (not "?")) of that guest
	 * indicates if the guest is not on the list
	 */
	public void G() throws IOException {
		Guest entered = new Guest(ask(FIRST), ask(LAST), "", "");
		
		int pos = searchGuests(entered.getFirstName(), entered.getLastName());
		if (pos < 0)
			System.out.println("Sorry, that guest is not on the list.");
		else
			System.out.println(guestList.get(pos).toStatementString());
		
	}
	
	/**
	 * Command L - list guests
	 * sorts guest list in alphabetical order
	 * prints out the guests
	 */
	public void L() {
		sortGuests();
		
		System.out.println("Last, First" + "\t" + "Company" + "\t" + "Attendance");
		for (Guest guest : guestList) {
			System.out.println(guest.toTableString());
		}
	}
	
	/**
	 * N - the number of guests attending, declining, or unknown
	 * 
	 * displays the number of guests responding that they are attending the party,
	 * the number of guests responding they are not attending the party,
	 * and the number of guests who have not yet responded (maybe)
	 */
	public void N() {
		int yesCount = 0, noCount = 0, maybeCount = 0;
		for (Guest guest : guestList) {
			if (guest.getAttendance().equals("yes"))
				yesCount++;
			else if (guest.getAttendance().equals("no"))
				noCount++;
			else
				maybeCount++;
		}
		
		System.out.println(yesCount + " people are attending, " 
				+ noCount + " people are not attending, and " 
				+ maybeCount + " have not responded.");
	}
	
	/**
	 * A - add new guest
	 * 
	 * prompts the user for the name, corporation, and response of a new guest
	 * inform the user if the guest is already on the list, and show their name, corporation, and response
	 * otherwise add the name to the list and inform the user of a successful addition
	 * @throws IOException
	 */
	public void A() throws IOException {
		
		Guest entered = new Guest (ask(FIRST), ask(LAST), ask(COMPANY), askAttendance());
		
		int pos = searchGuests(entered.getFirstName(), entered.getLastName());
		if (pos >= 0)
			System.out.println("They are already on the list. " + guestList.get(pos).toStatementString());
		else {
			System.out.println("We are adding a new guest to list: " + entered.toStatementString());
			guestList.add(entered);
		}
	}
	
	/**
	 * R - change guest response
	 * 
	 * prompts user for first name, last name, and new attendance of guest
	 * informs user if guest is not on the list
	 * if response is different, changes response on list and informs user of change
	 * if response is the same, inform user
	 * @throws IOException
	 */
	public void R() throws IOException {
		Guest entered = new Guest (ask(FIRST), ask(LAST), askAttendance(), "");
		
		int pos = searchGuests(entered.getFirstName(), entered.getLastName());
		if (pos < 0)
			System.out.println("Sorry, that guest is not on the list.");
		else if (guestList.get(pos).getAttendance() == entered.getAttendance()) {
			System.out.println("The response is " + entered.getAttendance() + " and it has not changed.");
		} else {
			guestList.get(pos).setAttendance(entered.getAttendance());
			System.out.println("The response has been changed to " + entered.getAttendance());
		}
		
	}
	
	/**
	 * C - find the colleagues of an entered guest
	 * 
	 * prompts user for first and last name of a guest
	 * if guest not on the list, inform user
	 * if guest is, inform user of all other guests who
	 * work at the same company
	 * @throws IOException
	 */
	public void C() throws IOException{
		Guest entered = new Guest (ask(FIRST), ask(LAST), "", "");
		
		int total = 0;
		
		int pos = searchGuests(entered.getFirstName(), entered.getLastName());
		if (pos < 0)
			System.out.println("Sorry, that guest is not on the list.");
		else {
			String company = guestList.get(pos).getCompany();
			System.out.println("Colleagues are:");
			
			for (Guest guest : guestList) {
				if (entered.compareGuests(guest) == 0) {//the person is not printed as his or her own colleague
				} else if (guest.getCompany().equals(company)) {
					System.out.println(guest.toStatementString());
					total++;
				}
			}
			if (total == 0)
				System.out.println("They have no colleagues.");
		}
	}
	
	public static void main (String args[]) throws IOException{
		
		Party compSciParty = new Party();
		compSciParty.readGuestList();
		
		//loops until user enters "Q" to quit the program
		char command = compSciParty.askCommand();
		while (!(command == 'Q' || command == 'q')) {
			compSciParty.doCommand(command);
			command = compSciParty.askCommand();
		}
		
		System.out.println("You have quit. Thanks for using this program!");
	}

}
