/**
* A generic node class for a SinglyLinkedList class
* This stores an arbitrary element object type
*/

public class SNode<E> {
	private E element;				//Reference to the element stored at this node
	private SNode<E> next;				//Reference to the successor node in the list

	//The Constructor method
	/**
	 * @param e the element stroign in the node
	 * @param n the next node in the lineup
	 */
	public SNode(E e, SNode<E> n) {
		element = e;
		next = n;
	}

	//ACCESS METHODS

	//Returns the GameScore element stored at the node
	/**
	 * 
	 * @return E the content of the node
	 */
	public E getElement() {
		return element;
	}

	//Returns the next node
	/**
	 * @return SNodeE the next node whatever type it may contain
	 */
	public SNode<E> getNext() {
		return next;
	}

	//UPDATE METHODS

	//Updates/sets the element field
	/**
	 * 
	 * @param e the new content of the element
	 */
	public void setElement(E e) {
		element = e;
	}

	//Sets the next node field
	/**
	 * 
	 * @param n setting which node we're set to go to next in the lineup
	 * 
	 */
	public void setNext(SNode<E> n) {
		next = n;
	}


		/**
		 * @return string the element of a node as a string represetnatiuon
		 * 
		 */
	//Returns a string representation of the node
	public String toString() {
		return element.toString();		//Using the toString() method of the E class
	}

	//Testing the class in the main method


}