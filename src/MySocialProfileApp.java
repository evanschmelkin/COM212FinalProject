import java.util.Scanner;

public class MySocialProfileApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MySocialProfile currentUser = null;

        while (true) {
            System.out.println("=== Welcome to MySocialProfile ===");
            System.out.println("1. Log In");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            String choice = input.nextLine();

            if (choice.equals("1")) {
                currentUser = MySocialProfile.login();
            } else if (choice.equals("2")) {
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

    private static void userDashboard(Scanner input, MySocialProfile user) {
        while (true) {
            System.out.println("\n=== Home Screen ===");
            System.out.println("Name: " + user.fullName);
            System.out.println("Class Year: " + user.classYear);

            System.out.println("\nOptions:");
            System.out.println("1. Post to Timeline");
            System.out.println("2. View Timeline");
            System.out.println("3. View Friends");
            System.out.println("4. Add Friend");
            System.out.println("5. Remove Friend");
            System.out.println("6. Log Out");
            System.out.print("Choose an option: ");
            String option = input.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Write your post: ");
                    String post = input.nextLine();
                    user.timeline.add(post);
                    System.out.println("Post added.");
                    break;

                case "2":
                    System.out.print("How many recent posts to display? ");
                    int num = Integer.parseInt(input.nextLine());
                    user.timeline.display(num);
                    break;

                case "3":
                    System.out.println("Friends:");
                    user.friends.display();
                    break;

                case "4":
                    System.out.print("Enter email to add: ");
                    String newFriend = input.nextLine();
                    user.friends.add(newFriend);
                    System.out.println("Friend added.");
                    break;

                case "5":
                    System.out.print("Enter email to remove: ");
                    String oldFriend = input.nextLine();
                    boolean removed = user.friends.remove(oldFriend);
                    if (removed) {
                        System.out.println("Friend removed.");
                    } else {
                        System.out.println("Friend not found.");
                    }
                    break;

                case "6":
                    System.out.println("Logging out...");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}