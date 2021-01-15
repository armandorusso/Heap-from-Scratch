import java.util.Random;

public class Driver {

	public static void main(String[] args) {

		Random random = new Random();
		HeapMethods[] aBunchOfHeaps = new HeapMethods[20];

		for(int i = 0; i < aBunchOfHeaps.length; i++) {
			int randomSort = random.nextInt(100);
			int randomNumber = random.nextInt(100);

			if(randomSort < 50)
				aBunchOfHeaps[i] = new HeapMethods(randomNumber + 10, "Min");
			else
				aBunchOfHeaps[i] = new HeapMethods(randomNumber + 10, "Max");
		}

		int numberToInsert = 0;
		while(numberToInsert < 20302) {
			for (int i = 0; i < aBunchOfHeaps.length; i++)
				aBunchOfHeaps[i].insert(numberToInsert, numberToInsert += 26);
			numberToInsert += 26;
		}

		System.out.println("The removed element from heap 1: " + aBunchOfHeaps[0].remove());
		System.out.println("The removed element from heap 3: " + aBunchOfHeaps[2].remove());
		System.out.println("The removed element from heap 4: " + aBunchOfHeaps[3].remove());
		System.out.println("The removed element from heap 4: " + aBunchOfHeaps[3].remove());
		System.out.println("The removed element from heap 4: " + aBunchOfHeaps[3].remove());
		System.out.println("The removed element from heap 15: " + aBunchOfHeaps[14].remove());

		aBunchOfHeaps[14].sortMax(0);
		aBunchOfHeaps[15].sortMin(0);
		aBunchOfHeaps[11].toggle();
		System.out.println("Top of the first heap: " + aBunchOfHeaps[0].top() + "\n");

		System.out.println("Printing a bunch of heaps!");
		for(int i = 0; i < aBunchOfHeaps.length; i++) {
			System.out.println("Heap number: " + (i + 1));
			aBunchOfHeaps[i].heapPrint();
			System.out.println("\n");
		}

		/*
		For fun: testing to see if we can obtain a sorted array by removing each element and putting it into a new array
		 */
		KeyValue[] sortedArray = new KeyValue[aBunchOfHeaps[8].size()];
		HeapMethods heap = aBunchOfHeaps[8];

		for(int i = 0; i < sortedArray.length; i++) {
			sortedArray[i] = heap.remove();
			System.out.println("This is in the sorted array: " + sortedArray[i].getKey());
		}
	}
}
