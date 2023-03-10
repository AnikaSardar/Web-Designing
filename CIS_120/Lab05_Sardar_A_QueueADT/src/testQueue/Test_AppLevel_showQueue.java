package testQueue;

import static org.junit.Assert.*;
//import junit.framework.Assert;
//import org.junit.After;
//import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import ApplicationLevelMethods.Methods;

import queuePackage.LinkedUnbndQueue;

public class Test_AppLevel_showQueue {

	/* Tests of static method: showQueue
	 *   test for a null reference
	 *   test an empty queue
	 *   test queue with one element
	 *   test queue with many elements
	 */

	LinkedUnbndQueue<String> myQ;

	@Before
	public void setUp() throws Exception {
		myQ = new LinkedUnbndQueue<String>();
	}
	
	@Test
	public void test_null_reference() {
		
		//setting myQ (empty object) to null
		
		myQ = null;
		
		assertEquals("Queue is null", Methods.showQueue(myQ));

	}
	
	@Test
	public void test_empty_Queue() {
		 
		//myQ has already been instantiated to be an empty object

		assertEquals("Empty Queue", Methods.showQueue(myQ));
				
	}

	@Test
	public void test_queue_with_one_element() {
		
		myQ.enqueue("A");
		
		assertEquals("front|A|rear", Methods.showQueue(myQ));
		
	}

	@Test
	public void test_queue_with_many_elements() {
		
		myQ.enqueue("A");
		myQ.enqueue("B");
		myQ.enqueue("C");
		
		assertEquals("front|A|B|C|rear", Methods.showQueue(myQ));
	}
}
