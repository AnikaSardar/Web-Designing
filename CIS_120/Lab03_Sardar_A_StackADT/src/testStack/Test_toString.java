package testStack;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import stackPackage.ArrayStack;
import stackPackage.LinkedStack;

public class Test_toString {

	/*
	 * Class to test the toString method added to the Stack ADT of Lab03
	 * 
	 *   test sizeIs on an empty stack
	 *     a stack with one element
	 *     a stack with many (but less than full) elements
	 *     and a "full" ArrayStack (not applicable to Linked Stack - comment it out)
	 */
	
	ArrayStack<Integer> stk1;
	@Before
	public void setUp() throws Exception {
		stk1 = new ArrayStack<Integer>(5);  
	}
	
//LinkedStack<Integer>stk1;
//	@Before
//	public void setUp() throws Exception {
//		stk1 = new LinkedStack<Integer>();  
//	}


	@Test  
	public void test_toString_on_an_emptyStack() {
		
		Assert.assertEquals("Empty Stack", stk1.toString());
		
	}
	
	@Test  
	public void test_toString_on_a_stack_with_1_element() {
		
		stk1.push(5);
		
		Assert.assertEquals("bottom|5|top", stk1.toString());
	}

	@Test  
	public void test_toString_on_a_stack_with_multiple_elements() {
		
		stk1.push(5); stk1.push(4); stk1.push(3);
		
		Assert.assertEquals("bottom|5|4|3|top", stk1.toString());
	}	
		
	// comment this test OUT when testing LinkedStack
	@Test  
	public void test_toString_on_a_full_stack() {
		
		stk1.push(1); stk1.push(2); stk1.push(3); stk1.push(4); stk1.push(5);

		Assert.assertEquals("bottom|1|2|3|4|5|top", stk1.toString());
	}	
	
	@After
	public void tearDown() throws Exception {
		
	}


}
