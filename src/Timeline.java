public class Timeline {
    public SinglyLinkedList<String> posts = new SinglyLinkedList<String>();

    /**
     *
     * @param content is a String
     */
    public void add(String content){ //don't need date. most recent post at head of list
        posts.addFirst(content); //validation so have to enter text
    }

    public String remove(int post_id){ //posts are labeled most recently as starting at 1
        String temp = posts.getNodeByPosition(post_id-1).getElement();
        posts.deleteEmail(posts.getNodeByPosition(post_id-1).getElement());
        return temp;
    }

    public void display(int num_posts){
        if (num_posts<=posts.size){
            int i = 0;
            while (i < num_posts && i < posts.size){
                System.out.println((i+1) + ". " + posts.getNodeByPosition(i).getElement());
                i++;
            }
        }
        else{
            System.out.println("Out of bounds");
        }


    }


}


//Timeline of posts - SLL
//display
//Add (text of post)
//Remove
