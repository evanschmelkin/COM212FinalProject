/*
Evan, Max, and Abdullah
5/12/25
Data Structures
Final Project
Professor Tarimo
MySocialProfile.java
 */

import java.io.*; // Import Java.io
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors


public class MySocialProfile {
    public String fullName;
    public String email;
    public String password;
    public int classYear;
    public ArrayPriorityQueue upcomingEvents = new ArrayPriorityQueue(100);
    public Timeline timeline = new Timeline();

    //lists used for indexing
    public String[] tokens;
    public String[] individualposts;
    public String[] individualfriends;

    public Friends myFriends = new Friends();



        /**
         * preps the fiels for reading. returns null if error
         * @return Scanner which is a very of the file that we can read
         */
    public static Scanner readFile() {
        try {
            File myObj = new File("mysocialprofile.txt");
            Scanner myReader = new Scanner(myObj);
            return myReader; //MAKE SURE TO CLOSE IN THE METHOD
            //myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 
     * @return String the nearest event
     */
    public String getFirstEvent(){
        return upcomingEvents.getMin().getDescription();
    }

    public static MySocialProfile login(){ //some of user input code form w3 schools
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter email");
        String email = myObj.nextLine();  // Read user input
        //myObj.nextLine();
        System.out.println("Enter password");

        String password = myObj.nextLine();
        //System.out.println("test1");

        if (authenticate(email, password)){
            //extract(email);
            MySocialProfile user = new MySocialProfile();
            user.extract(email);
            return user;
        }
        else{
            System.out.println("Incorrect email or password, please try again...");
        }

        return null;
    }


    /**
     * 
     * component of login. finding these to confirm its a valid user
     * @param email the email the user entered for authentication
     * @param password the password the user entered to confirm the email
     * @return boolean this is whether the user is valid or not
     */
    public static boolean authenticate(String email, String password) {
        Scanner myReader = readFile();
        while (myReader.hasNextLine()) {

            String data = myReader.nextLine();


            if (data.equals(email) ){ //&&
                myReader.nextLine();

                if (myReader.nextLine().equals(password)) {
                    myReader.close();
                    return true;
                }
            }
        }
        myReader.close();
        return false;
    }

    /**
     * this method saves all the data about the user and any changes back to the txt file
     */
    public void close(){ 
        try {
          FileWriter myWriter = new FileWriter("mysocialprofile.txt"); //from the import statemnts. we're getting this file so we can overwrite its info
          myWriter.write(email + "\n");
            myWriter.write(fullName + "\n");//need the double slash to go down a row
            myWriter.write(password + "\n");
            myWriter.write(classYear + "\n");

            while (!upcomingEvents.isEmpty()){ //writing down all the upcoming events
                //will be placed backward from how they were initially but shouldn't effect them being placed in order when viewing
                myWriter.write("'" + upcomingEvents.extractMin().getDescription() + "',");
            }
            myWriter.write("\n");

            while (!timeline.isEmpty()){
                myWriter.write("'" + timeline.remove(1)+ "',");
            }
            myWriter.write("\n");

            while (!myFriends.isEmpty()){
                myWriter.write("'" + myFriends.extract(1)+ "',"); //note: in the txt file. there should be no spaces between the "Events" otherwise the formatting will be unhappy
            }


          myWriter.close();
          //System.out.println("Successfully wrote to the file.");
        } catch (IOException e) { //if there is any errors
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        
        
    }


    /**
     * saving the data from the text file to the local variables and datatypes
     * @param email the email we're saving the data for
     */
    public void extract(String email) { //finds the account and saves all info to right variables
        //traverse through the lines of the mysocialprofile.txt

        //linenumber var
        int lineNumber = 0;

        Scanner myReader = readFile();
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();

            //System.out.println("line " + lineNumber);
            //System.out.println(data);
            lineNumber++;

            //this next line in theory will only run once
            //at the specific line whence it finds the email
            if (data.equals(email)) {
                //do everything within this if statement!
                //System.out.println("data equals data! " + data);

                //save some of them variables
                //saving email through classyear
                this.email = data;
                fullName = myReader.nextLine();
                //System.out.println("fullname is " + fullName);
                password = myReader.nextLine();
                classYear = Integer.parseInt(myReader.nextLine());


                tokens = myReader.nextLine().split(",");

                int j = 0;
                String[] parts = null;
                for (j = 0; j < tokens.length; j++) {
                    parts = tokens[j].split(" ");
                    int charlength = tokens[j].length();
                    //System.out.println(charlength);


                    //day is done this way to clean the quotation mark at the beginning
                    int day = Integer.valueOf(parts[0].substring(1, 2));
                    //beautiful, simple interior code
                    int month = Integer.parseInt(parts[1]);
                    int year = Integer.parseInt(parts[2]);
                    int hour = Integer.parseInt(parts[3]);
                    int minute = Integer.parseInt(parts[4]);

                    //this is probably the worst way i could've written it, but it probably works
                    //it is charlength -1 in order to clean up the quotation mark at the end
                    String description = tokens[j].substring(18, charlength -1);


                    //System.out.println("skibidi " + description);

                    //make the event
                    Event thisEvent = new Event(day, month, year, hour, minute, description);
                    upcomingEvents.insert(thisEvent);
                }

                //timeline posts
                //first get them individual timeline posts
                individualposts = myReader.nextLine().split(",");

                //now use a for loop to add them posts to
                int k = 0;
                String[] words = null;
                for (k = 0; k < individualposts.length; k++) {
                    //System.out.println(individualposts[k].substring(1, individualposts[k].length() -1));
                    timeline.add(individualposts[k].substring(1, individualposts[k].length() -1));
                }


                //friends part of the project
                //first get them individual friends
                //by splitting them up with commas
                individualfriends = myReader.nextLine().split(",");
                int l = 0;
                for (l = 0; l < individualfriends.length; l++) {
                    //System.out.println(individualfriends[l].substring(1, individualfriends[l].length() -1));
                    myFriends.add(individualfriends[l].substring(1, individualfriends[l].length() -1));
                }


            }
        }

        myReader.close();

    }


    /**
     * confirms if a user has been created or not
     * @param email the email we are checking exists in the txt file
     * @return boolean whether the user exists or not
     * 
     * 
     */
    public static boolean findUser(String email){
        Scanner myReader = readFile();
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            if (data.equals(email)){
                myReader.close();
                return true;
            }
        }
        myReader.close();
        return false;
    }

    /**
     * the process of signing up. asking for user information
     * since there is only one user allowed, this will not be relevent
     * 
     */
    public static void signUp(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter email");
        String email = myObj.nextLine();  // Read user input



        if (findUser(email)){ System.out.println("This email is already taken...");}


        else{

            System.out.println("Enter password");
            String password = myObj.nextLine();

            try {
                FileWriter myWriter = new FileWriter("MySocialProfile.txt");
                myWriter.write(email + "\n");
                myWriter.write(password);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

    }


    /**
     * local testing
     * 
     */
    public static void main(String[] args) {

        System.out.println("Hello! Welcome to a basic social profile");
        MySocialProfile social = new MySocialProfile();
        social.extract("gnorbert@conncoll.edu");

        //social.timeline.display(3);
        social.myFriends.display(4);


    }


}


