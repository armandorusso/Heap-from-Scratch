import java.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HeapMethods heap = new HeapMethods(10, "Min");
		HeapMethods heap2 = new HeapMethods(10, "Max");
		HeapMethods heap3 = new HeapMethods(10, "Min");
		HeapMethods heap4 = new HeapMethods(10, "Max");
		HeapMethods heap5 = new HeapMethods(10, "Min");
		HeapMethods heap6 = new HeapMethods(10, "Max");
		HeapMethods heap7 = new HeapMethods(21, "Min");
		HeapMethods heap8 = new HeapMethods(10, "Max");
		HeapMethods heap9 = new HeapMethods(23, "Min");
		HeapMethods heap10 = new HeapMethods(10, "Max");
		HeapMethods heap11 = new HeapMethods(10, "Min");
		HeapMethods heap12 = new HeapMethods(10, "Max");
		HeapMethods heap13 = new HeapMethods(20, "Min");
		HeapMethods heap14 = new HeapMethods(10, "Max");
		HeapMethods heap15 = new HeapMethods(20, "Min");
		HeapMethods heap16 = new HeapMethods(10, "Max");
		HeapMethods heap17 = new HeapMethods(10, "Min");
		HeapMethods heap18 = new HeapMethods(10, "Max");
		HeapMethods heap19 = new HeapMethods(30, "Min");
		HeapMethods heap20 = new HeapMethods(50, "Max");
		
		for(int i = 0; i < 20302; i+=14) {
			heap.insert(i, i+=26);
			heap2.insert(i, i+=26);
			heap3.insert(i, i+=26);
			heap4.insert(i, i+=26);
			heap5.insert(i, i+=26);
			heap6.insert(i, i+=26);
			heap7.insert(i, i+=26);
			heap8.insert(i, i+=26);
			heap9.insert(i, i+=26);
			heap10.insert(i, i+=26);
			heap11.insert(i, i+=26);
			heap12.insert(i, i+=26);
			heap13.insert(i, i+=26);
			heap14.insert(i, i+=26);
			heap15.insert(i, i+=26);
			heap16.insert(i, i+=26);
			heap17.insert(i, i+=26);
			heap18.insert(i, i+=26);
			heap19.insert(i, i+=26);	
			heap20.insert(i, i+=26);
		}
		
			System.out.println("The removed element from heap 1: " + heap.remove());
			System.out.println("The removed element from heap 3: " + heap3.remove());
			System.out.println("The removed element from heap 4: " + heap4.remove());
			System.out.println("The removed element from heap 4: " + heap4.remove());
			System.out.println("The removed element from heap 4: " + heap4.remove());
		
			System.out.println("The removed element from heap 15: " + heap15.remove());
			heap15.sortMax(0);
			heap16.sortMin(0);
			heap12.toggle();
			System.out.println(heap.top());
			
			
			heap.heapPrint();
			System.out.println("\n");
			heap2.heapPrint();
			System.out.println("\n");
			heap3.heapPrint();
			System.out.println("\n");
			heap4.heapPrint();
			System.out.println("\n");
			heap5.heapPrint();
			System.out.println("\n");
			heap6.heapPrint();
			System.out.println("\n");
			heap7.heapPrint();
			System.out.println("\n");
			heap8.heapPrint();
			System.out.println("\n");
			heap9.heapPrint();
			System.out.println("\n");
			heap10.heapPrint();
			System.out.println("\n");
			heap11.heapPrint();
			System.out.println("\n");
			heap12.heapPrint();
			System.out.println("\n");
			heap13.heapPrint();
			System.out.println("\n");
			heap14.heapPrint();
			System.out.println("\n");
			heap15.heapPrint();
			System.out.println("\n");
			heap16.heapPrint();
			System.out.println("\n");
			heap17.heapPrint();
			System.out.println("\n");
			heap18.heapPrint();
			System.out.println("\n");
			heap19.heapPrint();
			System.out.println("\n");
			heap20.heapPrint();
		//heap.heapPrint();
		KeyValue[] sortedArray = new KeyValue[11];
//		for fun: testing to see if we can obtain a sorted array by removing each element and putting it into a new array
	for(int i = 0; i < sortedArray.length; i++) {
		
				sortedArray[i] = heap.remove();
			System.out.println("This is in the sorted array: " + sortedArray[i].getKey());
	}

	}
}
