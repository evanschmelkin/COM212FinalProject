public class Timeline {
    public SinglyLinkedList<String> posts = new SinglyLinkedList<String>();

    public void add(String content){ //don't need date. most recent post at head of list
        posts.addFirst(content); //validation so have to enter text
    }

    public void remove(int post_id){ //posts are labeled most recently as starting at 1
        posts.deleteEmail(posts.getNodeByPosition(post_id-1).getElement());
    }

    public void display(int num_posts){
        int i = 0;
        while (i < num_posts && i < posts.size){
            System.out.println("Post " + (i+1) + ": " + posts.getNodeByPosition(i).getElement());
        }

    }


}


//Timeline of posts - SLL
//display
//Add (text of post)
//Remove
