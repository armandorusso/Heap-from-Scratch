import java.*;

public class Driver {

	public static void main(String[] args) {

		Random random = new Random();
		HeapMethods[] aBunchOfHeaps = new HeapMethods[20];

		for(int i = 0; i < aBunchOfHeaps.length; i++) {
			int randomSort = random.nextInt(100);
			int randomNumber = random.nextInt(100);
			if(randomSort < 50)
				aBunchOfHeaps[i] = new HeapMethods(randomNumber, "Min");
			else
				aBunchOfHeaps[i] = new HeapMethods(randomNumber, "Max");
		}

		while(numberToInsert != 20302) {
			for (int i = 0; i < aBunchOfHeaps.length; i++)
				aBunchOfHeaps.insert(numberToInsert, numberToInsert += 26);
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
		System.out.println(aBunchOfHeaps[0].top());
			

		for(int i = 0; i < aBunchOfHeaps.length; i++) {
			aBunchOfHeaps[i].heapPrint();
			System.out.println("\n");
		}

		/*
		For fun: testing to see if we can obtain a sorted array by removing each element and putting it into a new array
		 */
		KeyValue[] sortedArray = new KeyValue[11];

		for(int i = 0; i < sortedArray.length; i++) {
			sortedArray[i] = heap.remove();
			System.out.println("This is in the sorted array: " + sortedArray[i].getKey());
		}
	}
}
