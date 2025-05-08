import java.io.*;

public class ArrayPriorityQueue {
	Event[] A;
	int n;

	public ArrayPriorityQueue(int capacity) {
		A = new Event[capacity];
		n = 0;
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public Event getMin() {
		return A[1];
	}

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

	private int parentIndex(int cIndex) {
		return cIndex/2;
	}

	private int leftChildIndex(int pIndex) {
		return pIndex * 2;
	}

	private int rightChildIndex(int pIndex) {
		return (pIndex * 2) + 1;
	}

	private void swap(int pIndex, int cIndex) {
		Event temp = A[cIndex];
		A[cIndex] = A[pIndex];
		A[pIndex] = temp;
	}

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
	public void printSortedEvents() {
		while (!isEmpty()) {
			Event e = extractMin();
			System.out.println(e.description + ": " + e.formatedDateTime);
		}
	}


	public static void main(String[] args){
		ArrayPriorityQueue myQueue = new ArrayPriorityQueue(10);
		Event thisEvent = new Event(7,5,2025, 23, 30, "Time for JA");
		Event thisEvent2 = new Event(7,5,2025, 13, 15, "Time for Cal C");
		Event thisEvent3 = new Event(7,5,2025, 19, 30, "Com 212 meeting");


		myQueue.insert(thisEvent3);
		myQueue.insert(thisEvent);
		myQueue.insert(thisEvent2);

		myQueue.printSortedEvents();

	}


}