/*
Evan, Max, and Abdullah
4/22/2025
Data Structures
Final Project
Professor Tarimo
MySocialProfile.java
 */

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class MySocialProfile {
    public String fullName;
    public String email;
    public String password;
    public int classYear;
    //public SinglyLinkedQueue<Event> upcomingEvents;
    public int[] timeLine;
    public int[] friendsList;
    //public SinglyLinkedL //i dont know wo was working here but it wast finished so i commented it out


    public Scanner readFile() {
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            return myReader; //MAKE SURE TO CLOSE IN THE METHOD
            //myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }



    public boolean authenticate(String email, String password) {
        Scanner myReader = readFile();
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();

            if (data == email && myReader.nextLine() == password){
                myReader.close();
                return true;
            }
        }
        myReader.close();
        return false;
    }

    public void extract(String email) {
        //traverse through the lines of the mysocialprofile.tx
        Scanner myReader = readFile();
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
                //nested if: if email = line

    }

    public static void main(String[] args) {

    }


}


