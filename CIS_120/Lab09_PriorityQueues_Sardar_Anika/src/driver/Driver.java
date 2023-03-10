package driver;

import java.util.Random;

import ch09.priorityQueues.PQ_MinHeap;
import ch09.priorityQueues.PQ_RefSortedList;
import ch09.priorityQueues.PQ_RefSortedList; 

public class Driver {

	public static void main(String[] args) {
	
		Random rand = new Random (); //generate random numbers
		int [] randArray = new int[50]; 
		
//		for (int i = 0; i<50; i++) {
//			randArray[i] = rand.nextInt(1000); 
//			System.out.println(randArray[i] + " ");
//		}
//		
//		PQ_MinHeap<Integer> pQ_heap = new PQ_MinHeap<Integer>(50);
//		
//		//adding the random numbers into the priority queue heap
//		for (int i = 0; i<50; i++) {
//			pQ_heap.enqueue(randArray[i]);
//		}	
//		
//		//deleting the random numbers from the priority queue heap
//		for (int i = 0; i<50; i++) {
//		pQ_heap.dequeue();
//		} 
//		
//		PQ_RefSortedList<Integer> pQ_list =  new PQ_RefSortedList<Integer>();
//		
//		//adding the random numbers into the priority queue list
//		for (int i = 0; i<50; i++) {
//			pQ_list.enqueue(randArray[i]);
//		}
//		
//		//deleting the random numbers from the priority queue list
//		for (int i = 0; i<50; i++) {
//		pQ_list.dequeue();
//		}
		
		
		
		//Extra-Credit 
		
		int sumHeapSwaps = 0;
		int sumHeapCompares = 0;
		float averageHeapSwaps;
		float averageHeapCompares;

		int sumpQ_listSwaps = 0;
		int sumpQ_listCompares = 0;
		float averagepQ_listSwaps;
		float averagepQ_listCompares;

		int rows = 10; //number of trials
		int cols = 50; //number of random integers

		PQ_MinHeap<Integer> pQ_heap;
		PQ_RefSortedList<Integer> pQ_list; 

		for (int i = 0; i < rows; i++) {
			System.out.print("Trial " + (i + 1) + " :  ");

			pQ_heap = new PQ_MinHeap<Integer>(cols); // size is 50
			 pQ_list = new PQ_RefSortedList<Integer>(); // unbounded sorted list
			 
			for (int j = 0; j < cols; j++) {

				randArray[j] = rand.nextInt(1000);
				pQ_heap.enqueue(randArray[j]);
				pQ_list.enqueue(randArray[j]);
				System.out.print(randArray[j] + "   ");
				
			}

			for (int k = 0; k < cols; k++) {
				pQ_heap.dequeue();
				pQ_list.dequeue();
			}

			System.out.println(" ");

			sumHeapSwaps += PQ_MinHeap.countSwaps;
			sumHeapCompares += PQ_MinHeap.countCompares;
			sumpQ_listSwaps += PQ_RefSortedList.countSwaps;
			sumpQ_listCompares += PQ_RefSortedList.countCompares;
			System.out.println("----------------------------------------------------------------------------"
					+ "----------------------------------------------------------------------------"
					+ "----------------------------------------------------------------------------"
					+ "----------------------------------------------------------------------------");

		}

		averageHeapSwaps = sumHeapSwaps / rows;
		averageHeapCompares = sumHeapCompares / rows;
		averagepQ_listSwaps = sumpQ_listSwaps / rows;
		averagepQ_listCompares = sumpQ_listCompares / rows;

		float averageHeap;
		float averageList;
		
		averageHeap = (averageHeapCompares + averageHeapSwaps) / 2;
		averageList = (averagepQ_listCompares + averagepQ_listSwaps) / 2; 
		

		
		System.out.println("-----------------------------------------------------------------");
		System.out.println("minHead - countSwaps in heap in the last trial: " + PQ_MinHeap.countSwaps);
		System.out.println("minHead - countCompares in heap in the last trial: " + PQ_MinHeap.countCompares);

		System.out.println("minHead - countSwaps in list in the last trial: " + PQ_RefSortedList.countSwaps);
		System.out.println("minHead - countCompares in list in the last trial: " + PQ_RefSortedList.countCompares);

		System.out.println("-----------------------------------------------------------------");
		System.out.println("Average swaps for the heap for a total trials of " + 
		rows + " is: " + averageHeapSwaps);
		System.out.println("Average compares for the heap for a total trials of " +
		rows + " is: " + averageHeapCompares);
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Average swaps for the sorted list for a total trials of " +
		rows + " is: " + averagepQ_listSwaps);
		System.out.println("Average compares for the sorted list for a total trials of " + 
		rows + " is: " +averagepQ_listCompares);
		
		System.out.println("-----------------------------------------------------------------");
		if (averageHeap < averageList) {
			System.out.println("Heap is better, because it has a lower average of"
					+ " swaps and compares than\na reference sorted list. " 
					+ "In this case of " + rows +  " trials, heap has an average of\n" 
					+ averageHeap + " swaps and compares, whereas the list has on "
							+ "average " + averageList + " swaps and compares");
		}
		else {
			System.out.println("Reference sorted list is better, because it has a lower average of"
					+ " swaps and compares than\nthe heap. " 
					+ "In this case of " + rows +  " trials, reference sorted list has an average of " 
					+ averageList + " swaps and compares whereas the list has on " +
					"average " + averageHeap + " swaps and compares");
		}
	}

}
