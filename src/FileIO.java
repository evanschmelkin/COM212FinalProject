import java.io.*;
import java.util.Scanner;



//we didn't use this class. perhaps accidently added by an import???
//Evan, Max, and Abdullah


class FileIO{
	public static void main(String args[]){
		//this try-catch statement is needed around this file input code
		//because the FileInputStream may throw a FileNotFoundException
		try {
			Scanner lineScanner = new Scanner(new FileInputStream("userdata.txt"));
			
			while (lineScanner.hasNext()) { //while more of the input file is still available for reading
											
				System.out.println("+++++++++++++++++++++++++++");
				String name = lineScanner.nextLine();  //reads an entire line of input
				System.out.println("Name is: " + name);
				
				System.out.println("+++++++++++++++++++++++++++");
				String email = lineScanner.nextLine();
				System.out.println("Email is: " + email);
				
				System.out.println("+++++++++++++++++++++++++++");
				String pass = lineScanner.nextLine();
				System.out.println("Password is: " + pass);
				
				System.out.println("+++++++++++++++++++++++++++");
				String year = lineScanner.nextLine();
				System.out.println("Year is: " + year);
				
				System.out.println("+++++++++++++++++++++++++++");
				String events = lineScanner.nextLine(); //read the entire line of event data
				//now create a secondary scanner to actually scan through this list of events
				// to break them up into individual events
				Scanner eventsScanner = new Scanner(events);
				String[] eventsArray = new String[10]; //will store the individual events for now
				int i = 0; //array index counter
				//on this line of data, events are in quotes and delimited by commas, 
				// so we tell the scanner to look for a quotation mark followed by a comma (",)
				// to delimit each event
				eventsScanner.useDelimiter("\","); //need the backslash in front of special characters like "
				String e; //will hold each individual event
				System.out.println("Events are: ");
				while (eventsScanner.hasNext()){
					System.out.println("--------------------------");
					e = eventsScanner.next();
					e = e.substring(1, e.length()); //cut off the leading quotation mark of each event
					System.out.println(e);
					eventsArray[i] = e;
					i++;
					//here's some extra code to demonstrate how to further break down each event string
					System.out.println("(Now illustrating how to extract each piece of event info.)");
					Scanner eScanner = new Scanner(e); //yet another scanner just for this particular event
					System.out.println("Month: " + eScanner.nextInt());
					System.out.println("Day: " + eScanner.nextInt());
					System.out.println("Year: " + eScanner.nextInt());
					System.out.println("Hour: " + eScanner.nextInt());
					System.out.println("Minutes: " + eScanner.nextInt());
					String desc = ""; //to hold the description of the event
					while (eScanner.hasNext()){ //while there are words left...
						desc = desc + " " + eScanner.next(); //reads the description one word at a time
					}
					System.out.println("Description: " + desc);
				}				
				
				System.out.println("+++++++++++++++++++++++++++");				
				/* reads in next line and then breaks it into separate timeline posts/messages
				 * code is analogous to events, so refer to above comments for explanation. */
				String wallMsgs = lineScanner.nextLine();
				Scanner wallMsgScanner = new Scanner(wallMsgs);
				String[] wallMsgArray = new String[5];
				i = 0;
				wallMsgScanner.useDelimiter("\",");
				String message; 
				System.out.print("Wall messages are: ");
				while (wallMsgScanner.hasNext()) {
					message = wallMsgScanner.next();
					System.out.print(message + "\",");
					message = message.substring(1, message.length());
					wallMsgArray[i] = message; //stores message into array of messages
					//i don't do anything with this array, but it is here just to demonstrate
					//(you may or may not be using an array to store the list of timeline messages.)
					i++;
				}
				System.out.println();
				/*	test code for printing contents of array
				for (int j = 0; j < wallMsgArray.length; j++){
					System.out.println(wallMsgArray[j]);
				}*/
				
				System.out.println("+++++++++++++++++++++++++++");
				/* reads in next line and then breaks it into separate friends
				 * now the delimiter is just a comma because there are no quotes around
				 * each email address.  so this is a bit simpler than above procedure.*/
				String friends = lineScanner.nextLine();
				Scanner friendScanner = new Scanner(friends);
				String[] friendArray = new String[20]; 
				i = 0;
				friendScanner.useDelimiter(",");  
				String friend;
				System.out.print("Friends are: ");
				while (friendScanner.hasNext()) {
					friend = friendScanner.next();
					System.out.print(friend + ",");
					friendArray[i] = friend; //stores friend into array of friends
					//i don't do anything with this array, but it is here just to demonstrate
					//(you may or may not be using an array to store the list of friends.)
					i++;
				}
				System.out.println();
				System.out.println("+++++++++++++++++++++++++++");
				
			}
	
		} catch(FileNotFoundException ex) {
			System.out.println("File not Found");
			System.exit(0);
		}
		
	
	}
}
