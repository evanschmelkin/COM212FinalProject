/*
Evan, Max, and Abdullah
4/22/2025
Data Structures
Final Project
Professor Tarimo
Friends.java
 */
public class Friends {
    SinglyLinkedList<String> friends = new SinglyLinkedList<>();

    public String add(String email){
        friends.addFirst(email);
        return email;
    }

    public boolean remove(String email) {
        if (friends.contains(email)) {
            friends.deleteEmail(email);
            return true;
        }
        return false;
    }


}
