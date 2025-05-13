/*
this class is what we use to store events and make sure that we are able to acess the next event in constant time

*/

public class ArrayPriorityQueue {
	Event[] A;
	int n;
	/**
	 * @param capacity how many events we can create
	 */
	public ArrayPriorityQueue(int capacity) {
		A = new Event[capacity];
		n = 0;
	}

	/**
	 * @return int the current amount of events
	 */
	public int size() {
		return n;
	}

	/**
	 * @return boolean whether there are any events present
	 */
	public boolean isEmpty() {
		return n == 0;
	}


	/**
	 * 
	 * @return Event returns the event that is closest
	 */
	public Event getMin() {
		return A[1];
	}


	/**
	 * @param k the event that we want to add
	 * adds an event to our list
	 */
	public void insert(Event k) {
		A[n+1] = k;
		n++;
		int cIndex = n;
		int pIndex = parentIndex(n);
		//while child is not root and child is smaller than parent
		while (pIndex >= 1 && A[cIndex].dateComparison < A[pIndex].dateComparison) {
			swap(cIndex,pIndex);
			cIndex = pIndex;
			pIndex = parentIndex(cIndex);
		}
	}

	/**
	 * @return Event the nearest event that we just removed
	 * 
	 */
	public Event extractMin() {
		swap(1,n);
		n--;
		int pIndex = 1;
		int lCIndex;
		int rCIndex;
		while (hasSmallerChild(pIndex)) {
			rCIndex = rightChildIndex(pIndex);
			lCIndex = leftChildIndex(pIndex);
			//No right child, then swap parent with left child
			if (rCIndex > n) {
				swap(pIndex, lCIndex);
				pIndex = lCIndex;
			}
			else { //Two children, swap with the smaller child
				if (A[lCIndex].dateComparison < A[rCIndex].dateComparison) {
					swap(pIndex,lCIndex);
					pIndex = lCIndex;
				}
				else {
					swap(pIndex,rCIndex);
					pIndex = rCIndex;
				}
			}
		}
		return A[n+1];
	}

	/**
	 * @param cIndex the index of the child we need to parent of
	 * @return int getting the index of the parent by integer division
	 * 
	 */
	private int parentIndex(int cIndex) {
		return cIndex/2;
	}

	/**
	 * 
	 * @param pIndex the index of the parent we need left child of
	 * @return int the index of the left child
	 */
	private int leftChildIndex(int pIndex) {
		return pIndex * 2;
	}


	/**
	 * @param pIndex the index of the parent we need right child of
	 * @return int index of the right child
	 * 
	 */
	private int rightChildIndex(int pIndex) {
		return (pIndex * 2) + 1;
	}

	/**
	 * @param pIndex the parent index
	 * @param cIndex the child index
	 * swaping a parent and a child nodes
	 */
	private void swap(int pIndex, int cIndex) {
		Event temp = A[cIndex];
		A[cIndex] = A[pIndex];
		A[pIndex] = temp;
	}


	/**
	 * 
	 * @param pIndex the parent we need to figure out if has smaller child
	 * @return boolean whether the parent has a smaller child or not
	 * 
	 */
	private boolean hasSmallerChild(int pIndex) {
		int rCIndex = rightChildIndex(pIndex);
		int lCIndex = leftChildIndex(pIndex);
		if (rCIndex <= n && A[rCIndex].dateComparison < A[pIndex].dateComparison)
			return true;
		else if (lCIndex <= n && A[lCIndex].dateComparison < A[pIndex].dateComparison)
			return true;
		else
			return false;
	}


	/**
	 * prints out the events sorted from nearest to last
	 * 
	 */
	public void printSortedEvents() {
		Event[] copy = new Event[n + 1];
		for (int i = 1; i <= n; i++) {
			copy[i] = A[i];
		}
		int copySize = n;

		while (copySize > 0) {
			Event min = copy[1];
			System.out.println(min.formatedDateTime); //min.description + ": " + 
			copy[1] = copy[copySize];
			copySize--;

			int p = 1;
			while (true) {
				int l = 2 * p;
				int r = 2 * p + 1;
				int smallest = p;


				if (l <= copySize && copy[l].dateComparison < copy[smallest].dateComparison) {
					smallest = l;
				}

				if (r <= copySize && copy[r].dateComparison < copy[smallest].dateComparison) {
					smallest = r;
				}



				if (smallest != p) {
					Event temp = copy[p];
					copy[p] = copy[smallest];
					copy[smallest] = temp;
					p = smallest;
				} else {
					break;
				}
			}
		}
	}



	public static void main(String[] args){
		ArrayPriorityQueue myQueue = new ArrayPriorityQueue(10);

		Event thisEvent = new Event(7,5,2025, 23, 30, "Time for JA");
		Event thisEvent2 = new Event(7,5,2025, 13, 15, "Time for Cal C");
		Event thisEvent3 = new Event(7,5,2025, 19, 30, "Com 212 meeting");
		Event thisEvent4 = new Event(10,5,2025, 14, 00, "Com 212 meeting again");
		Event thisEvent5 = new Event(5,5,2025, 1, 30, "Sleep");


		myQueue.insert(thisEvent3);
		myQueue.insert(thisEvent);
		myQueue.insert(thisEvent5);
		myQueue.insert(thisEvent4);
		myQueue.insert(thisEvent2);
		myQueue.printSortedEvents();

		myQueue.printSortedEvents();


	}


}