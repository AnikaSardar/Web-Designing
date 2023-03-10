package testStack;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import stackPackage.ArrayStack;
import stackPackage.LinkedStack;

public class Test_sizeIs {
	
//	ArrayStack<Integer> stk1;
//	@Before
//	public void setUp() throws Exception {
//		stk1 = new ArrayStack<Integer>(5);  
//	}
	
LinkedStack<Integer>stk1;
	@Before
	public void setUp() throws Exception {
		stk1 = new LinkedStack<Integer>();  
	}
	
	@Test  
	public void test_sizeIs_on_an_emptyStack() {
		assertEquals(0,stk1.sizeIs()); 
	}
	
	@Test  
	public void test_sizeIs_on_a_stack_with_1_element() {
		
		stk1.push(5);
		
		assertEquals(1,stk1.sizeIs());
	}
	
	@Test  
	public void test_sizeIs_on_a_stack_with_multiple_elements() {
		
		stk1.push(5); stk1.push(4); stk1.push(3);
		
		assertEquals(3,stk1.sizeIs());
	}	

	// comment this test OUT when testing LinkedStack
//	@Test  
//	public void test_sizeIs_on_a_full_stack() {
//		
//		stk1.push(1); stk1.push(2); stk1.push(3); stk1.push(4); stk1.push(5);
//
//		assertEquals(5,stk1.sizeIs());
//	}	
	
	@After
	public void tearDown() throws Exception {
		
	}
}
