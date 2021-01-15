public class HeapMethods extends KeyValue  {

	protected KeyValue[] heap;
	protected int heapSize;
	protected KeyValue keyValue;
	protected int index;
	private String state;

	public HeapMethods() {
		heap = new KeyValue[10];
		heapSize = 0;
		index = -1;
		state = "Min";
	}

	public HeapMethods(int size, String state) {
		heap = new KeyValue[size];
		heapSize = 0;
		index = -1;
		this.state = state;
	}

	public int size() {
		return heapSize;
	}
	
	public int heapLength() {
		return heap.length;
	}

	public boolean isEmpty() { return (heapSize == 0); }

	public KeyValue top() { return heap[0]; }

	public String state() { return state; }

	public void increaseSize() {
		KeyValue[] newHeap = new KeyValue[(heap.length * 2)];
		keyValue = new KeyValue();
		for (int i = 0; i < heap.length; i++) {
			newHeap[i] = keyValue.clone(heap[i]);
		}

		heap = newHeap; // Point the heap to the increased heap
		newHeap = null; // Since its being pointed to the variable we want, point this initial pointer to null since we don't want to have 2 pointers.
	}

	/*
	Used when we remove a node, we must resort the heap (in terms of max)
	*/
	public void maxDownHeap(int index) {
		if(((2* index) + 1 > heap.length - 1 || (2 * index) + 2 > heap.length - 1))
			return;
		
		int leftChild = (2 * index) + 1;
		int rightChild = (2 * index) + 2;
		
		if(heap[leftChild] == null || heap[rightChild] == null)
			return;

		if(heap[leftChild].getKey() > heap[rightChild].getKey()) {
			if(heap[index].getKey() < heap[leftChild].getKey()) {
				KeyValue temp = heap[index];
				heap[index] = heap[leftChild];
				heap[leftChild] = temp;
				temp = null;
				
				maxDownHeap(leftChild);
			}

			maxDownHeap(leftChild);
		}
		
		else {
			if(heap[index].getKey() < heap[rightChild].getKey()) {
				KeyValue temp = heap[index];
				heap[index] = heap[rightChild];
				heap[rightChild] = temp;
				temp = null;
				maxDownHeap(rightChild);
			}
			maxDownHeap(rightChild);
		}
	}

	/*
	Used for when we remove a node. We sort using downheaping since when we remove a node,
	we have to set the last element as the root and therefore we must downheap to make it sorted
	 */
	public void minDownHeap(int index) {
		if(((2* index) + 1 > heap.length - 1 || (2 * index) + 2 > heap.length - 1))
			return;

		int leftChild = (2 * index) + 1;
		int rightChild = (2 * index) + 2;

		if(heap[leftChild] == null || heap[rightChild] == null)
			return;
		
		if(heap[leftChild].getKey() < heap[rightChild].getKey()) {
			if(heap[index].getKey() > heap[leftChild].getKey()) {
				KeyValue temp = heap[index];
				heap[index] = heap[leftChild];
				heap[leftChild] = temp;
				temp = null;
				minDownHeap(leftChild);
			}

			minDownHeap(leftChild);
		}
		
		else {
			if(heap[index].getKey() > heap[rightChild].getKey()) {
				KeyValue temp = heap[index];
				heap[index] = heap[rightChild];
				heap[rightChild] = temp;
				temp = null;
				minDownHeap(rightChild);
			}

			minDownHeap(rightChild);
		}
	}

	/*
	Up Heap Min Method
	*/
	public void min(int index) {
		int parentIndex = index / 2;

		if(index == 0 || heap[parentIndex] == null || heap[index] == null) {
			KeyValue temp = heap[index];
			heap[index] = heap[0];
			heap[0] = temp;
			temp = null;
			return;
		}

		if(heap[parentIndex].getKey() > heap[index].getKey()) {
			KeyValue temp = heap[parentIndex];
			heap[parentIndex] = heap[index];
			heap[index] = temp;
			temp = null;
			min(parentIndex);
		}

		min(parentIndex);
	}

	/*
	Up Heap Max Method
	*/
	public void max(int index) {
		int parentIndex = index / 2;

		if(index == 0) {
			KeyValue temp = heap[index];
			heap[index] = heap[0];
			heap[0] = temp;
			temp = null;
			return;
		}

		if(heap[parentIndex].getKey() < heap[index].getKey()) {
			KeyValue temp = heap[parentIndex];
			heap[parentIndex] = heap[index];
			heap[index] = temp;
			temp = null;
			max(parentIndex);
		}

		max(parentIndex);
	}

	/*
	Done using an inorder traversal sort. This method is used when we are converting from max to min
	*/
	public void sortMin(int index) {
		if(isEmpty() || size() == 1) {
			return;
		}

		HeapMethods newMinHeap = new HeapMethods(heap.length, state);
		
		for(int i = 0; i < heap.length; i++) {
			if(heap[i] == null)
				break;

			newMinHeap.insert(heap[i].getKey(), heap[i].getValue());
		}

		heap = newMinHeap.heap;
		
		newMinHeap = null;
		return;
	}

	/*
	Done using an inorder traversal sort. This method is used when we are converting from max to min
	 */
	public void sortMax(int index) {
		if(isEmpty() || size() == 1) {
			return;
		}
		
		HeapMethods newMaxHeap = new HeapMethods(heap.length, state);
		
		for(int i = 0; i < heap.length; i++) {
			if(heap[i] == null)
				break;
			newMaxHeap.insert(heap[i].getKey(), heap[i].getValue());
		}

		heap = newMaxHeap.heap;
		newMaxHeap = null;

		return;
	}

	public void insert(int key, Object value) {
		KeyValue element = new KeyValue(key, value);

		/* If the heap is empty, just simply add it to the first entry of the array */
		if (isEmpty()) {
			heap[0] = element;
			heapSize++;
			index++;
			return;
		}

	    /* If the heap is full, double its size and then insert */
		if (size() == heap.length)
			increaseSize();

		index++;
		heap[index] = element;
		heapSize++;
		
		if (state.equals("Min"))
			min(index);
		else
			max(index);

		return;
	}

	public KeyValue remove() {
		if(isEmpty() || size() == 0 || index == -1)
			return null;

		if(size() == 1) {
			KeyValue keyvalue = top();
			heap[0] = null;
			heapSize--;
			return keyvalue;
		}

		/*
		Storing the object from the top of the heap into a temporary variable which
		we will return later
		*/
		KeyValue keyValue = top();

		/*
		Setting the top of the tree equal to the last node (which should be the right)
		most node on the very last level of the heap)
		 */
		heap[0] = heap[index];

		heap[index] = null;
		index--;
		heapSize--;

		if (state.equals("Min"))
			minDownHeap(0);

		else
			maxDownHeap(0);

		return keyValue;
	}

	/*
	The tight big o of this would be O(n) where n is the number of nodes.
	This is because we are doing an inorder traversal which goes through every node.
	We can't do better than this since we have to swap every node (assuming worst case)
	 */
	public void toggle() {
		if (isEmpty() || size() == 1)
			return;

		if (state().equals("Min")) {
			state = "Max";
			sortMax(0);
		}

		/*
		No need to state and else if, but leaving it here for more readability
		*/
		else if (state().equals("Max")) {
			state = "Min";
			sortMin(0);
		}
	}

	public void switchToMin() {
		if (isEmpty() || state().equals("Min"))
			return;

		state = "Min";
		sortMin(0);
		
	}
	
	public void switchToMax() {
		if (isEmpty() || state().equals("Max"))
			return;

		state = "Max";
		sortMax(0);
		
	}

	public boolean isLeftChild(int index) { return (heap[(2 * index) + 1] != null); }

	public boolean isRightChild(int index) { return (heap[(2 * index) + 2] != null); }

	public boolean isInternal(int index) {
		if(index >= heap.length)
			return false;

		return (isLeftChild(index) || isRightChild(index));
	}
	
	public boolean isExternal(int index) {
		if(index >= heap.length)
			return false;

		return (!(isLeftChild(index) && isRightChild(index)));
	}
	
	public void heapPrint() {
		for(int i = 0; i < heap.length; i++) {
			if(heap[i] == null)
				continue;

			System.out.println("Index of the heap array: " + i + " and this is the key: " + heap[i].getKey());
		}
	}

}
