package testQueue;

import static org.junit.Assert.*;
//import junit.framework.Assert;
//import org.junit.After;
//import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import ApplicationLevelMethods.Methods;

import queuePackage.LinkedUnbndQueue;

/* Tests of static method: copyQueue
 *   test for a null reference; the copy should also be a null reference
 *   test an empty queue
 *   test queue with one element
 *   test queue with many elements
 */

public class Test_AppLevel_copyQueue {

	LinkedUnbndQueue<String> q1, q2;

	// toggle to true to turn on console output in this test class
	boolean consoleOut = true;

	@Before
	public void setUp() throws Exception {

		q1 = new LinkedUnbndQueue<String>();
		// q2 is set in each test below

	}

	@Test
	public void test_null_reference() {

		q1 = null; 	//setting q1 (empty object) to null
		q2 = Methods.copyQueue(q1); //address of a null copyQueue is assigned to q2

		if (consoleOut) {
			System.out.println("Original Queue: " + Methods.showQueue(q1) + "\nCopied Queue  : " + Methods.showQueue(q2));
		} 

		//Assert original queue is equal to the copied queue
		assertEquals(Methods.showQueue(q1), Methods.showQueue(q2));

	}

	@Test
	public void test_empty_Queue() {

		//q1 has already been instantiated to be an empty object
		

		q2 = Methods.copyQueue(q1); //address of an empty copyQueue is assigned to q2

		if (consoleOut) {
			System.out.println("Original Queue: " + Methods.showQueue(q1) + "\nCopied Queue  : " + Methods.showQueue(q2));
		} 
		assertEquals(Methods.showQueue(q1), Methods.showQueue(q2));

	}

	@Test
	public void test_queue_with_one_element() {

		q1.enqueue("A");
		q2 = Methods.copyQueue(q1);  //address of one-element-copyQueue is assigned to q2

		
		if (consoleOut) {
			System.out.println("Original Queue: " + Methods.showQueue(q1) + "\nCopied Queue  : " + Methods.showQueue(q2));
		} 

		assertEquals(Methods.showQueue(q1), Methods.showQueue(q2));

	}

	@Test
	public void test_queue_with_many_elements() {

		q1.enqueue("A");
		q1.enqueue("B");
		q1.enqueue("C");

		q2 = Methods.copyQueue(q1); //address of multiple-elements-copyQueue is assigned to q2

		if (consoleOut) {
			System.out.println("Original Queue: " + Methods.showQueue(q1) + "\nCopied Queue  : " + Methods.showQueue(q2));
		} 

		assertEquals(Methods.showQueue(q1), Methods.showQueue(q2));

	}

}
