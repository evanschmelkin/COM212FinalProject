/**
 * a timeline class storing all the posts that the user creates
 * we have the functionality to display all the posts in the list
 * 
 * 
 */


public class Timeline {
    public SinglyLinkedList<String> posts = new SinglyLinkedList<String>();

    /**
     *
     * @param content is a String of the content of the timeline post
     */
    public void add(String content){ //don't need date. most recent post at head of list
        posts.addFirst(content); //validation so have to enter text
    }


        /**
         * @param post_id how we can find the post given its postiion in the SLL
         * @return string the posts text
         * 
         */
    public String remove(int post_id){ //posts are labeled most recently as starting at 1
        String temp = posts.getNodeByPosition(post_id-1).getElement();
        posts.deleteEmail(posts.getNodeByPosition(post_id-1).getElement());
        return temp;
    }


        /**
         * 
         * @param num_posts the number of posts that we print in the console
         */
    public void display(int num_posts){
        if (num_posts<=posts.size){
            num_posts = posts.size;
            //System.out.println("you don't have that many posts");
        }

        
            int i = 0;
            while (i < num_posts && i < posts.size){
                System.out.println((i+1) + ". " + posts.getNodeByPosition(i).getElement());
                i++;
            }
        


    }


        /**
         * 
         * 
         * @return boolean whether we have any posts or not
         */
    public boolean isEmpty(){
        return posts.isEmpty();
    }


}


//Timeline of posts - SLL
//display
//Add (text of post)
//Remove
