/*
Evan, Max, and Abdullah
4/22/2025
Data Structures
Final Project
Professor Tarimo
MySocialProfile.java
 */

import java.io.*; // Import Java.io
import java.util.Scanner; // Import the Scanner class to read text files

public class MySocialProfile {
    public String fullName;
    public String email;
    public String password;
    public int classYear;
    //public SinglyLinkedQueue<Event> upcomingEvents;
    public Timeline timeline;

    public Friends[] friendsList;
    //public SinglyLinkedL //i dont know wo was working here but it wast finished so i commented it out


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


    public static MySocialProfile login(){ //some of user input code form w3 schools
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter email");
        String email = myObj.nextLine();  // Read user input

        System.out.println("Enter password");
        String password = myObj.nextLine();

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

    public static boolean authenticate(String email, String password) {
        Scanner myReader = readFile();
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();


            if (data.equals(email) && myReader.nextLine().equals(password)){
                myReader.close();
                return true;
            }
        }
        myReader.close();
        return false;
    }

    public void extract(String email) { //finds the account and saves all info to right variables
        //traverse through the lines of the mysocialprofile.txt

        //linenumber var
        int lineNumber = 0;

        Scanner myReader = readFile();
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();

            System.out.println("line " + lineNumber);
            System.out.println(data);
            lineNumber++;

            //this next line in theory will only run once
            //at the specific line whence it finds the email
            if (data.equals(email)) {
                System.out.println("data equals data! " + data);

                System.out.println("nextline is " + myReader.nextLine());

                //save some of them variables
                data = email;
                fullName = myReader.nextLine();


            }
        }
        myReader.close();


    }

    public static void signUp(String email, String password){




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

    public static void main(String[] args) {

        System.out.println("Hello! Welcome to a basic social profile");
        MySocialProfile social = new MySocialProfile();
        social.extract("gnorbert@conncoll.edu");


    }


}


