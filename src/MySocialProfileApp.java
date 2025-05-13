/*
Evan, Max, and Abdullah
5/12/2025
Data Structures
Final Project
Professor Tarimo
 */



import java.util.Scanner;

public class MySocialProfileApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MySocialProfile currentUser = null;

        while (true) {
            System.out.println("=== Welcome to MySocialProfile ===");
            System.out.println("1. Log In");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String choice = input.nextLine();

            if (choice.equals("1")) {
                currentUser = MySocialProfile.login();
            }
            else if (choice.equals("2")){
                MySocialProfile.signUp();
            }
            else if (choice.equals("3")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid input.");
            }

            if (currentUser != null) {
                userDashboard(input, currentUser);
                currentUser = null; // logout
            }
        }

        input.close();
    }


        /**
         * @param input the scanner object we use to see what the user wrote
         * @param user the user objects account
         * 
         */
    private static void userDashboard(Scanner input, MySocialProfile user) {
        //System.out.println("test: " + user.email);
        while (true) {
            System.out.println("\n=== Home Screen ===");
            System.out.println("Name: " + user.fullName);
            System.out.println("Class Year: " + user.classYear);

            //next event
            System.out.println(user.getFirstEvent());
            //3 most recent timeline entries
            user.timeline.display(3);
            //list of all events they plan to attend
            user.upcomingEvents.printSortedEvents();

            System.out.println("\nOptions:");
            System.out.println("1. Post to Timeline");
            System.out.println("2. View Timeline");
            System.out.println("3. View Friends");
            System.out.println("4. Add Friend");
            System.out.println("5. Remove Friend");
            System.out.println("6. Add Event");
            System.out.println("7. View All Events"); //don't have this
            System.out.println("8. Log Out"); //don't have this
            System.out.print("Choose an option: ");
            String option = input.nextLine();

            switch (option) { 
                case "1": //post to timeline
                    System.out.print("Write your post: ");
                    String post = input.nextLine();
                    user.timeline.add(post);
                    System.out.println("Post added.");
                    break;

                case "2": //view timeline
                    System.out.print("How many recent posts to display? ");
                    int num = Integer.parseInt(input.nextLine());
                    user.timeline.display(num);
                    break;

                case "3": //view friends
                    System.out.print("How many recent posts to display? ");
                    num = Integer.parseInt(input.nextLine());
                    System.out.println("Friends:");
                    user.myFriends.display(num);
                    break;

                case "4": //add friend
                    System.out.print("Enter email of friend: ");
                    String newFriend = input.nextLine();
                    user.myFriends.add(newFriend);
                    System.out.println("Friend added.");
                    break;

                case "5": //remove friend
                    System.out.print("Enter email to remove: ");
                    String oldFriend = input.nextLine();
                    boolean removed = user.myFriends.remove(oldFriend);
                    System.out.println("test");
                    if (removed) {
                        System.out.println("Friend removed.");
                    } else {
                        System.out.println("Friend not found.");
                    }
                    break;

                case "6": //add event
                    System.out.print("Enter event description:");
                    String description = input.nextLine();

                    System.out.print("Enter event day:");
                    int day = Integer.parseInt(input.nextLine());

                    System.out.print("Enter event month:");
                    int month = Integer.parseInt(input.nextLine());

                    System.out.print("Enter event year:");
                    int year = Integer.parseInt(input.nextLine());

                    System.out.print("Enter event hour:");
                    int hour= Integer.parseInt(input.nextLine());

                    System.out.print("Enter event minute:");
                    int minute = Integer.parseInt(input.nextLine());

                    Event newEvent = new Event(day,month,year,hour,minute,description); //day month year hour minute description
                    user.upcomingEvents.insert(newEvent);
                    break; //will set current user to null in for loop above

                case "7":

                    System.out.println("Your events:");
                    user.upcomingEvents.printSortedEvents();
                    break;

                case "8": //add event

                    System.out.println("Logging out..." + user.email);
                    user.close();
                    return; //will set current user to null in for loop above

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}