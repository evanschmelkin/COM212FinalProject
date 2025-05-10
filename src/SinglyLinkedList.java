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
	public int size() {
		return size;
	}

	//Returns true of the list is empty, false otherwise
	public boolean isEmpty() {
		return size == 0;
	}

	//Returns the first element in the list, null if empty
	public E first() {
		if (isEmpty()) return null;
		return head.getElement();
	}

	//Returns the last element in the list, null if empty
	public E last() {
		if (isEmpty()) return null;
		return tail.getElement();
	}

	//Adds a new element to the front of the list
	public void addFirst(E e) {
		SNode<E> newNode = new SNode<>(e, head);
		head = newNode;
		if (isEmpty()) {
			tail = head;
		}    //Special case
		size++;
	}

	//Add a new element to the end of the list
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
	public void display() {
		SNode current = head;
		while (current != null) {                // for each SNode,
			System.out.print(current + " ");    // display it		}
			current = current.getNext();
		}
		System.out.println("");
	}

	//Returns a string representation of the list
	public String toString() {
		SNode current = head;
		String list = "";
		while (current != null) {                // for each SNode,
			list += current + " ";
			current = current.getNext();
		}
		return list;
	}

	public boolean contains (String email){
		if (size() == 0) return false;
		SNode current = head;
		while (current.getNext().getElement() != null){
			//if (current.getNext().getElement() )
		}

	}


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

	class Friends {
		SinglyLinkedList<String> friends = new SinglyLinkedList<>();

		public String add(String email) {
			friends.addFirst(email);
			return email;
		}
		/*
		public boolean remove(String email) {
			if (contains(email)) {
				deleteEmail(email);
				return true;
			}
			return false;
		}
		*/

		//this is the evan deletion thing to remove the friends emails
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

		public SNode<E> getNodeByPosition(int pos) { //pos is like index
			if (pos > size) return null;
			SNode<E> current = head;
			for (int i = 0; i <= pos; i++) {
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

		}
	}
}