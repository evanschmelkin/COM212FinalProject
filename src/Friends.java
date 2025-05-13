/*
Evan, Max, and Abdullah
Data Structures
Final Project
Professor Tarimo
Friends.java


this class is for our list of friends. adding viewing and displaying functionality happens here
 */
public class Friends {
    SinglyLinkedList<String> friends = new SinglyLinkedList<>();


    /**
     * @param email when we add a friend we are actually adding an email to a SLL
     * @return string returns the email that we just added
     * 
     */
    public String add(String email){
        friends.addFirst(email);
        return email;
    }
    /**
     * @param email when we add a friend we are actually removing an email to a SLL
     * @return boolean returns true
     * 
     */
    public boolean remove(String email) {
        System.out.println("remove command registered");
        //if (friends.contains(email)) {
            friends.deleteEmail(email);
            return true;
        //}
        //return false;
    }


    /**
     * 
     * @return string the friends email we removed from the SLL
     * @param friend_id the 'index' of the friend in the SLL starting at 1 so we know where to find them
     */
    public String extract(int friend_id){//friend ids start at 1
        String temp = friends.getNodeByPosition(friend_id-1).getElement();
        friends.deleteEmail(friends.getNodeByPosition(friend_id-1).getElement());
        return temp;
    }


    /**
     * @return boolean whether its empty or not
     */
    public boolean isEmpty(){
        return friends.isEmpty();
    }

    /**
     * @param num_friends the number of friends we need to print out
     * 
     */
    public void display(int num_friends){
        if (!(num_friends<=friends.size)){
            num_friends = friends.size;
            //System.out.println("you don't have that many friends");
        }


        //if (num_friends<=friends.size){
            int i = 0;
            while (i < num_friends && i < friends.size){
                System.out.println((i+1) + ". " + friends.getNodeByPosition(i).getElement());
                i++;
            }
        //}
        //else{
            //System.out.println("Out of bounds");
        //}

    }


}
