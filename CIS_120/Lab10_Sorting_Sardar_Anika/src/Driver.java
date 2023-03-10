import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;

public class Driver {

	public static void main(String[] args) {

		//*************************************latest
		
		ArrayList<ArrayList<Long>> selections = new ArrayList<ArrayList<Long>>();
		ArrayList<Long> selection_row; //Selection: [Comp,Copies,Time| Comp,Copies...]
		
		ArrayList<ArrayList<Long>> bubble = new ArrayList<ArrayList<Long>>();
		ArrayList<Long> bubble_row; 
		
		ArrayList<ArrayList<Long>> shortBubble = new ArrayList<ArrayList<Long>>();
		ArrayList<Long> shortBubble_row; 
		
		ArrayList<ArrayList<Long>> insertion = new ArrayList<ArrayList<Long>>();
		ArrayList<Long> insertion_row; 
		
		int arrayCount = 1;
		
		for (int iteration = 1;  iteration <= 3; iteration++ ) {
			
			selection_row = new ArrayList<Long>();
			bubble_row = new ArrayList<Long>();
			shortBubble_row = new ArrayList<Long>();
			insertion_row = new ArrayList<Long>();
			
			arrayCount *= 10;
			
			//******************************** RANDOM ************************************************
			
			// selection
			new Sorts(arrayCount);
			
			Sorts.initRandomOrderValues();
			long startTime = System.nanoTime();
			Sorts.selectionSort();
			long estimatedTime = System.nanoTime() - startTime;
			
			long comparesValue = Sorts.compares;
			long copiesValue = Sorts.copies;
			
			//Random: Comp, Copies, Time
			selection_row.add(comparesValue);
			selection_row.add(copiesValue);
			selection_row.add(estimatedTime);
			
			//bubble
			new Sorts(arrayCount);
			
			Sorts.initRandomOrderValues();
			startTime = System.nanoTime();
			Sorts.bubbleSort();
			estimatedTime = System.nanoTime() - startTime;
			
			comparesValue = Sorts.compares;
			copiesValue = Sorts.copies;
			
			bubble_row.add(comparesValue);
			bubble_row.add(copiesValue);
			bubble_row.add(estimatedTime);
			
			//shortBubble
			new Sorts(arrayCount);
			
			Sorts.initRandomOrderValues();
			startTime = System.nanoTime();
			Sorts.shortBubble();
			estimatedTime = System.nanoTime() - startTime;
			
			comparesValue = Sorts.compares;
			copiesValue = Sorts.copies;
			
			shortBubble_row.add(comparesValue);
			shortBubble_row.add(copiesValue);
			shortBubble_row.add(estimatedTime);
			
			//insertion
			new Sorts(arrayCount);
			
			Sorts.initRandomOrderValues();
			startTime = System.nanoTime();
			Sorts.insertionSort();
			estimatedTime = System.nanoTime() - startTime;
			
			comparesValue = Sorts.compares;
			copiesValue = Sorts.copies;
			
			insertion_row.add(comparesValue);
			insertion_row.add(copiesValue);
			insertion_row.add(estimatedTime);
			
			//******************************** IN ORDER ************************************************
			//selection
			new Sorts(arrayCount);
			Sorts.initInOrderValues();
			startTime = System.nanoTime();
			Sorts.selectionSort();
			estimatedTime = System.nanoTime() - startTime;
			
			comparesValue = Sorts.compares;
			copiesValue = Sorts.copies;
			
			//In-Order: Comp, Copies, Time
			selection_row.add(comparesValue);
			selection_row.add(copiesValue);
			selection_row.add(estimatedTime);
			
			
			// bubble
			new Sorts(arrayCount);
			
			Sorts.initInOrderValues();
			startTime = System.nanoTime();
			Sorts.bubbleSort();
			estimatedTime = System.nanoTime() - startTime;
			
			comparesValue = Sorts.compares;
			copiesValue = Sorts.copies;
			
			bubble_row.add(comparesValue);
			bubble_row.add(copiesValue);
			bubble_row.add(estimatedTime);
			
			//shortBubble
			new Sorts(arrayCount);
			
			Sorts.initInOrderValues();
			startTime = System.nanoTime();
			Sorts.shortBubble();
			estimatedTime = System.nanoTime() - startTime;
			
			comparesValue = Sorts.compares;
			copiesValue = Sorts.copies;
			
			shortBubble_row.add(comparesValue);
			shortBubble_row.add(copiesValue);
			shortBubble_row.add(estimatedTime);
			
			//insertion
			new Sorts(arrayCount);
			
			Sorts.initInOrderValues();
			startTime = System.nanoTime();
			Sorts.insertionSort();
			estimatedTime = System.nanoTime() - startTime;
			
			comparesValue = Sorts.compares;
			copiesValue = Sorts.copies;
			
			insertion_row.add(comparesValue);
			insertion_row.add(copiesValue);
			insertion_row.add(estimatedTime);
		
			//******************************** Out-of ORDER ************************************************
			//selection
			new Sorts(arrayCount);
			Sorts.initOutOfOrderValues();
			startTime = System.nanoTime();
			Sorts.selectionSort();
			estimatedTime = System.nanoTime() - startTime;
			
			comparesValue = Sorts.compares;
			copiesValue = Sorts.copies;
			
			//In-Order: Comp, Copies, Time
			selection_row.add(comparesValue);
			selection_row.add(copiesValue);
			selection_row.add(estimatedTime);
			

			// bubble
			new Sorts(arrayCount);
	
			Sorts.initOutOfOrderValues();
			startTime = System.nanoTime();
			Sorts.bubbleSort();
			estimatedTime = System.nanoTime() - startTime;
			
			comparesValue = Sorts.compares;
			copiesValue = Sorts.copies;
			
			bubble_row.add(comparesValue);
			bubble_row.add(copiesValue);
			bubble_row.add(estimatedTime);
			
			//shortBubble
			new Sorts(arrayCount);
			
			Sorts.initOutOfOrderValues();
			startTime = System.nanoTime();
			Sorts.shortBubble();
			estimatedTime = System.nanoTime() - startTime;
			
			comparesValue = Sorts.compares;
			copiesValue = Sorts.copies;
			
			shortBubble_row.add(comparesValue);
			shortBubble_row.add(copiesValue);
			shortBubble_row.add(estimatedTime);
			
			//insertion
			new Sorts(arrayCount);
			
			Sorts.initOutOfOrderValues();
			startTime = System.nanoTime();
			Sorts.insertionSort();
			estimatedTime = System.nanoTime() - startTime;
			
			comparesValue = Sorts.compares;
			copiesValue = Sorts.copies;
			
			insertion_row.add(comparesValue);
			insertion_row.add(copiesValue);
			insertion_row.add(estimatedTime);
			
			selections.add(selection_row);
			bubble.add(bubble_row);
			shortBubble.add(shortBubble_row);
			insertion.add(insertion_row);
		}
		
		// Now that data collection is done, printing the table
		Formatter fmt = new Formatter();  
		fmt.format("%1s\n", "Simple Sorts");
		int n_val = 1;
		for (int i= 0 ; i < 3; i++)   
		{  
			n_val *= 10;
			ArrayList<Long> row_selection = selections.get(i);
			ArrayList<Long> row_bubble = bubble.get(i);
			ArrayList<Long> row_shortBubble = shortBubble.get(i);
			ArrayList<Long> row_insertion = insertion.get(i);
			
			fmt.format("%42s %48s %48s\n", "Random", "In Order", "Out Order"); 
			
			fmt.format("%1s %1s %18s %15s %15s %15s %15s %15s %15s %15s %15s\n ", "N = ", n_val, "Comp", "Copies", "Time |", 
					"Comp", "Copies", "Time |", "Comp", "Copies", "Time |\n");
			
			fmt.format("%1s %15s %15s %16s %15s %15s %15s %15s %15s %15s\n\n", "\nSelection", 
					row_selection.get(0),
					row_selection.get(1),
					row_selection.get(2),
					row_selection.get(3),
					row_selection.get(4),
					row_selection.get(5),
					row_selection.get(6),
					row_selection.get(7),
					row_selection.get(8));  
			
			fmt.format("Bubble %18s %15s %16s %15s %15s %15s %15s %15s %15s\n\n", 
					row_bubble.get(0),
					row_bubble.get(1),
					row_bubble.get(2),
					row_bubble.get(3),
					row_bubble.get(4),
					row_bubble.get(5),
					row_bubble.get(6),
					row_bubble.get(7),
					row_bubble.get(8));  
			
			fmt.format("Short Bubble %12s %15s %16s %15s %15s %15s %15s %15s %15s\n\n", 
					row_shortBubble.get(0),
					row_shortBubble.get(1),
					row_shortBubble.get(2),
					row_shortBubble.get(3),
					row_shortBubble.get(4),
					row_shortBubble.get(5),
					row_shortBubble.get(6),
					row_shortBubble.get(7),
					row_shortBubble.get(8));  
			
			fmt.format("Insertion %15s %15s %16s %15s %15s %15s %15s %15s %15s\n\n\n\n", 
					row_insertion.get(0),
					row_insertion.get(1),
					row_insertion.get(2),
					row_insertion.get(3),
					row_insertion.get(4),
					row_insertion.get(5),
					row_insertion.get(6),
					row_insertion.get(7),
					row_insertion.get(8));  
		}  
		System.out.println(fmt);
		
		// SECTION 2
		//************************************** EFFICIENT TABLE **********************************************************
		ArrayList<ArrayList<Long>> quick = new ArrayList<ArrayList<Long>>();
		ArrayList<Long> quick_row; //Selection: [Comp,Copies,Time| Comp,Copies...]
		
		ArrayList<ArrayList<Long>> merge = new ArrayList<ArrayList<Long>>();
		ArrayList<Long> merge_row; 
		
		ArrayList<ArrayList<Long>> heap = new ArrayList<ArrayList<Long>>();
		ArrayList<Long> heap_row; 
		
		int count = 1;
		
		for (int iteration = 1;  iteration <= 3; iteration++ ) {
			
			quick_row = new ArrayList<Long>();
			merge_row = new ArrayList<Long>();
			heap_row = new ArrayList<Long>();
	
			
			count *= 10;
			
			//******************************** RANDOM ************************************************
			
			// quick
			new Sorts(count);
			
			Sorts.initRandomOrderValues();
			long startTime = System.nanoTime();
			Sorts.quickSort(0, count -1);
			long estimatedTime = System.nanoTime() - startTime;
			
			long comparesValue = Sorts.compares;
			long copiesValue = Sorts.copies;
			
			//Random: Comp, Copies, Time
			quick_row.add(comparesValue);
			quick_row.add(copiesValue);
			quick_row.add(estimatedTime);
			
			//merge
			new Sorts(count);
			
			Sorts.initRandomOrderValues();
			startTime = System.nanoTime();
			Sorts.mergeSort(0, count -1);
			estimatedTime = System.nanoTime() - startTime;
			
			comparesValue = Sorts.compares;
			copiesValue = Sorts.copies;
			
			merge_row.add(comparesValue);
			merge_row.add(copiesValue);
			merge_row.add(estimatedTime);
			
			//heap
			new Sorts(count);
			
			Sorts.initRandomOrderValues();
			startTime = System.nanoTime();
			Sorts.heapSort();
			estimatedTime = System.nanoTime() - startTime;
			
			comparesValue = Sorts.compares;
			copiesValue = Sorts.copies;
			
			heap_row.add(comparesValue);
			heap_row.add(copiesValue);
			heap_row.add(estimatedTime);
			
			//******************************** IN ORDER ************************************************
			//quick
			new Sorts(count);
			Sorts.initInOrderValues();
			startTime = System.nanoTime();
			Sorts.quickSort(0, count -1);
			estimatedTime = System.nanoTime() - startTime;
			
			comparesValue = Sorts.compares;
			copiesValue = Sorts.copies;
			
			//In-Order: Comp, Copies, Time
			quick_row.add(comparesValue);
			quick_row.add(copiesValue);
			quick_row.add(estimatedTime);
			
			
			// merge
			new Sorts(count);
			
			Sorts.initInOrderValues();
			startTime = System.nanoTime();
			Sorts.mergeSort(0, count -1);
			estimatedTime = System.nanoTime() - startTime;
			
			comparesValue = Sorts.compares;
			copiesValue = Sorts.copies;
			
			merge_row.add(comparesValue);
			merge_row.add(copiesValue);
			merge_row.add(estimatedTime);
			
			//heap
			new Sorts(count);
			
			Sorts.initInOrderValues();
			startTime = System.nanoTime();
			Sorts.heapSort();
			estimatedTime = System.nanoTime() - startTime;
			
			comparesValue = Sorts.compares;
			copiesValue = Sorts.copies;
			
			heap_row.add(comparesValue);
			heap_row.add(copiesValue);
			heap_row.add(estimatedTime);
		
			//******************************** Out-of ORDER ************************************************
			//quick
			new Sorts(count);
			Sorts.initOutOfOrderValues();
			startTime = System.nanoTime();
			Sorts.quickSort(0, count -1);
			estimatedTime = System.nanoTime() - startTime;
			
			comparesValue = Sorts.compares;
			copiesValue = Sorts.copies;
			
			//In-Order: Comp, Copies, Time
			quick_row.add(comparesValue);
			quick_row.add(copiesValue);
			quick_row.add(estimatedTime);
			

			// merge
			new Sorts(count);
	
			Sorts.initOutOfOrderValues();
			startTime = System.nanoTime();
			Sorts.mergeSort(0, count -1);;
			estimatedTime = System.nanoTime() - startTime;
			
			comparesValue = Sorts.compares;
			copiesValue = Sorts.copies;
			
			merge_row.add(comparesValue);
			merge_row.add(copiesValue);
			merge_row.add(estimatedTime);
			
			//heap
			new Sorts(count);
			
			Sorts.initOutOfOrderValues();
			startTime = System.nanoTime();
			Sorts.heapSort();
			estimatedTime = System.nanoTime() - startTime;
			
			comparesValue = Sorts.compares;
			copiesValue = Sorts.copies;
			
			heap_row.add(comparesValue);
			heap_row.add(copiesValue);
			heap_row.add(estimatedTime);
			
			quick.add(quick_row);
			merge.add(merge_row);
			heap.add(heap_row);
		}
		
		// Now that data collection is done, printing the table
		fmt = new Formatter();  
		fmt.format("%1s\n", "Efficient Sorts");
		n_val = 1;
		for (int i= 0 ; i < 3; i++)   
		{  
			n_val *= 10;
			ArrayList<Long> row_quick = quick.get(i);
			ArrayList<Long> row_merge = merge.get(i);
			ArrayList<Long> row_heap = heap.get(i);
			
			fmt.format("%42s %48s %48s\n", "Random", "In Order", "Out Order"); 
			
			fmt.format("%1s %1s %18s %15s %15s %15s %15s %15s %15s %15s %15s\n ", "N = ", n_val, "Comp", "Copies", "Time |", 
					"Comp", "Copies", "Time |", "Comp", "Copies", "Time |\n");
			
			fmt.format("%1s %15s %15s %16s %14s %15s %15s %15s %15s %15s\n\n", "\nQuick Sort", 
					row_quick.get(0),
					row_quick.get(1),
					row_quick.get(2),
					row_quick.get(3),
					row_quick.get(4),
					row_quick.get(5),
					row_quick.get(6),
					row_quick.get(7),
					row_quick.get(8));  
			
			fmt.format("Merge Sort %15s %15s %16s %15s %15s %15s %15s %15s %15s\n\n", 
					row_merge.get(0),
					row_merge.get(1),
					row_merge.get(2),
					row_merge.get(3),
					row_merge.get(4),
					row_merge.get(5),
					row_merge.get(6),
					row_merge.get(7),
					row_merge.get(8));  
			
			fmt.format("Heap Sort %16s %15s %16s %15s %15s %15s %15s %15s %15s\n\n\n\n", 
					row_heap.get(0),
					row_heap.get(1),
					row_heap.get(2),
					row_heap.get(3),
					row_heap.get(4),
					row_heap.get(5),
					row_heap.get(6),
					row_heap.get(7),
					row_heap.get(8));  
		}  
		System.out.println(fmt);
	}
}

