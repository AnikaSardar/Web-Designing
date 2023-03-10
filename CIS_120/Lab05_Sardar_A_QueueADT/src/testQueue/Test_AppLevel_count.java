package testQueue;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ApplicationLevelMethods.Methods;

import queuePackage.LinkedUnbndQueue;

public class Test_AppLevel_count {

	/* Tests of static method: count
	 *   test for a queue with a null reference (value = 0)
	 *   test an empty queue (value = 0)
	 *   test queue with one element (value = 1)
	 *   test queue with many elements (value = many)
	 */
	
	// only the test with many elements is provided; 
	// ASSIGN: provide the rest of the tests described above
	
	LinkedUnbndQueue<String> myQ;
	
	@Before
	public void setUp() throws Exception {
		myQ = new LinkedUnbndQueue<String>();
	}

	@Test
	public void test_null_reference() {
		
		//setting myQ (empty object) to null
		myQ = null; 
		
		assertEquals(0, Methods.count(myQ));
		
	}
	
	@Test
	public void test_no_elements() {
		
		//myQ has already been instantiated to be an empty object
		
		assertEquals(0, Methods.count(myQ));

	}


	@Test
	public void test_one_element() {
		
		myQ.enqueue("A"); 

		assertEquals(1, Methods.count(myQ));
	}
	
	@Test
	public void test_many_elements() {
		
		myQ.enqueue("A"); 
		myQ.enqueue("B"); 
		myQ.enqueue("C");

		assertEquals(3, Methods.count(myQ));
	
	}	
	
}
