/**
* A Singly Linked Class
* Storing a list of SNode nodes with integer elements
*/

public class SinglyLinkedList<E> {
	private SNode<E> head;        //The head node of the list
	private SNode<E> tail;        //The tail node of the list
	int size;                //The number of nodes in the list

	//Constructor method
	public SinglyLinkedList() {
		head = null;        //head and tail are null in an empty list
		tail = null;
		size = 0;
	}

	//ACCESS METHODS
	//Returns the number of nodes in the list
	/**
	 * 
	 * @return int the number of nodes we have
	 */
	public int size() {
		return size;
	}

	//Returns true of the list is empty, false otherwise
	/**
	 * 
	 * @return boolean whether we have any nodes or not
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	//Returns the first element in the list, null if empty

	/**
	 * 
	 * @return E the first node's element, whatever type it may be
	 */
	public E first() {
		if (isEmpty()) return null;
		return head.getElement();
	}

	//Returns the last element in the list, null if empty
	/**
	 * 
	 * @return E the last node's elemn whatever type it may be
	 */
	public E last() {
		if (isEmpty()) return null;
		return tail.getElement();
	}

	//Adds a new element to the front of the list
	/**
	 * 
	 * @param e the element of the new first node
	 */
	public void addFirst(E e) {
		SNode<E> newNode = new SNode<>(e, head);
		head = newNode;
		if (isEmpty()) {
			tail = head;
		}    //Special case
		size++;
	}

	//Add a new element to the end of the list
	/**
	 * 
	 * @param e the elemt of the new last node
	 */
	public void addLast(E e) {
		SNode<E> newNode = new SNode<>(e, null);
		if (isEmpty()) {
			head = newNode;
		}    //Special case
		else {
			tail.setNext(newNode);
		}
		tail = newNode;
		size++;
	}

	//Removes and returns the first element of the list
	//Returns null if list is empty
	/**
	 * @return E the old first node's eleemnt that we removed 
	 * 
	 */
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}
		SNode<E> temp = head;
		head = head.getNext();
		size--;
		if (isEmpty()) {
			tail = null;
		}
		temp.setNext(null);        //Optional
		return temp.getElement();
	}

	//Prints the elements of the list
	/**
	 * 
	 * prints out the entire list
	 */
	public void display() {
		SNode current = head;
		while (current != null) {                // for each SNode,
			System.out.print(current + " ");    // display it		}
			current = current.getNext();
		}
		System.out.println("");
	}

	//Returns a string representation of the list
	/**
	 * 
	 * @return string string represntation of the node
	 */
	public String toString() {
		SNode current = head;
		String list = "";
		while (current != null) {                // for each SNode,
			list += current + " ";
			current = current.getNext();
		}
		return list;
	}


		/**
		 * @param email the element we are looking for in a node in the list
		 * @return boolean whether the list contains a node with a specific elemnt
		 */
	public boolean contains (String email){
		System.out.println("contains command recognized");
		display();
		if (size() == 0) return false;
		SNode current = head;
		while (current!= null){
			
			if (current.getElement() ==email){
				return true;
			}
			current = current.getNext();
		}
		
        return false;
    }

    	/**
    	 * @return boolean whether two singularly linked lists are equal to each other
    	 * @param other the other SLL
    	 */
	public boolean equals(SinglyLinkedList other) {
		if (other == null) return false;            // Other SSL is not null
		if (size != other.size()) return false;        //Other SSL's size is the same
		SNode current = head;
		SNode otherCurrent = other.head;
		while (current != null) {
			if (current.getElement() != otherCurrent.getElement())
				return false;
			//If elements were objects then we would use the equals method instead of !=
			//if (!current.getElement().equals(otherCurrent.getElement()))
			current = current.getNext();
			otherCurrent = otherCurrent.getNext();
		}
		return true;
	}

	//Removes and returns the last element in the list
	/**
	 * @return E the element of the former last node whateve type it may be
	 */
	public E removeLast() {
		if (isEmpty()) return null;
		if (size == 1) return removeFirst();

		SNode<E> current = head;
		SNode<E> ahead = head.getNext();
		while (ahead.getNext() != null) {
			current = current.getNext();
			ahead = ahead.getNext();
		}
		current.setNext(null);
		tail = current;
		size--;
		return ahead.getElement();
	}



	//this is the evan deletion thing to remove the friends emails
	/**
	 * @return E the email of the element we wanted to delete
	 * @param email the email is the identifier of the node we're going to delete
	 * 
	 */
	public E deleteEmail(String email) {
		if (isEmpty()) return null;

		SNode<E> current = head;
		SNode<E> prev = null;

		while (current != null) {
			if (current.getElement().equals(email)) {
				if (prev == null) {
					return removeFirst();
				} else {
					prev.setNext(current.getNext());
					if (current == tail) {
						tail = prev;
					}
					size--;
					return current.getElement();
				}
			}
			prev = current;
			current = current.getNext();
		}

		return null;
	}


		/**
		 * 
		 * @param pos starts at 1 kind of like index in an array. describes the position of a node in an SLL
		 * @return SnodeE the node at that position whateve rthe element type might be
		 */
	public SNode<E> getNodeByPosition(int pos) { //pos is like index
		if (pos > size) return null;
		SNode<E> current = head;
		for (int i = 0; i < pos; i++) {
			current = current.getNext();
		}
		return current;

	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> newList = new SinglyLinkedList<>();
		newList.addFirst(89);
		newList.addLast(50);
		newList.addFirst(78);
		newList.addLast(-65);
		newList.display();


		SinglyLinkedList<Integer> other = new SinglyLinkedList<>();
		other.addLast(89);
		System.out.println(newList.equals(other));

		SinglyLinkedList<String> coolList = new SinglyLinkedList<>();
		coolList.addFirst("poop");
		coolList.addFirst("miami");
		coolList.addFirst("dade");
		coolList.addFirst("skibidi");
		coolList.addFirst("chungus");

		coolList.display();
		coolList.deleteEmail("skibidi");
		coolList.display();
		//System.out.println("test123423452");
		System.out.println(coolList.contains("chungus"));

	}

}