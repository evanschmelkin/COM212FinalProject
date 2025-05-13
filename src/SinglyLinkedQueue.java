/**
  * Implementation of a generic queue ADT using a SinglyLinkedList.
  * Realization of a FIFO queue as an adaptation of a SinglyLinkedList
 * Evan, Max, and Abdullah
*/




//we don't use this class

public class SinglyLinkedQueue<E> {
	
	private SinglyLinkedList<E> list;		//The SinglyLinkedList for storage

	public SinglyLinkedQueue() {
		list = new SinglyLinkedList<>();	//new queue starts with an empty list
	}

	/** Tests whether the queue is empty */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/** Returns the number of elements in the queue. */
	public int size() {
		return list.size();
	}

	/** Inserts an element at the rear of the queue */
	public void enqueue(E e) {
		list.addLast(e);
	}

	/** Returns, but does not remove, the first element of the queue 
	Returns null if the queue is empty */
	public E first() {
		return list.first();
	}

	/** Removes and returns the first element of the queue
	Returns null if the queue is empty */
	public E dequeue() {
		return list.removeFirst();
	}
}