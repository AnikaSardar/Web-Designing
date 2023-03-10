package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ch09.priorityQueues.PQ_MinHeap;
import ch09.priorityQueues.PQ_RefSortedList;

public class Test2 {

	PQ_RefSortedList<String> elt; 
	
	@Before 
	public void  setUp() throws Exception {
		elt = new PQ_RefSortedList<String>(); 
	}
	
	@Test 
	public void test_Empty(){
		
		assertEquals(true, elt.isEmpty());
		
		}
	
	@Test 
	public void test_Enqueue(){
		
		elt.enqueue("D");
		elt.enqueue("G");
		elt.enqueue("B");
		elt.enqueue("E");
//		elt.enqueue("C");
//		elt.enqueue("F");
//		elt.enqueue("A");
//		elt.enqueue("I");
//		elt.enqueue("H");
//		elt.enqueue("J");
		
		elt.dequeue();
		//assertEquals ("A",elt.dequeue());
		
		System.out.print (elt.toString());
		
		System.out.println("minHead - countSwaps in LL: " + PQ_RefSortedList.countSwaps);
		System.out.println("minHead - countCompares in LL: " + PQ_RefSortedList.countCompares);
		}
	
}

