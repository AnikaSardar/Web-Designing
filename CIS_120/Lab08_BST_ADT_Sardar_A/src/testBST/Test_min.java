package testBST;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import applicationLevelMethods.Methods;
import bst_Package.BinarySearchTree;

public class Test_min {

BinarySearchTree<Integer> bst; 
	
	@Before
	public void setUp() throws Exception {
		
		 bst = new BinarySearchTree<Integer>();
	}

	@Test
	public void testNullTree() {
		
		assertEquals(null, Methods.min(null));
	}
	
	@Test
	public void testEmptyTree() {
		
		assertEquals(null, Methods.min(bst)); 
	}
	
	@Test
	public void testOneElementTree() {
		bst.add(15);
		
		assertEquals(15, Methods.min(bst));
	}
	@Test
	public void testTwoRepeatedElementsTree() {
		bst.add(15);
		bst.add(15);
		
		assertEquals(15, Methods.min(bst));
	}
	
	@Test
	public void test_Three_Elements_smallest_at_beginning() {
		
		bst.add(11);
		bst.add(15);
		bst.add(12);
		
		assertEquals(11, Methods.min(bst));
	}
	
	@Test
	public void test_Three_Elements_smallest_in_middle() {
		
		bst.add(15);
		bst.add(11);
		bst.add(12);
		
		assertEquals(11, Methods.min(bst));
	}
	
	@Test
	public void test_Three_Elements_smallest_at_end() {
		
		bst.add(15);
		bst.add(12);
		bst.add(11);
		
		assertEquals(11, Methods.min(bst));
	}
	
	@Test
	public void testFiveElements() { //zigzag structure 
		bst.add(15);
		bst.add(11);
		bst.add(13);
		bst.add(12);
		bst.add(13);
		
		assertEquals(11, Methods.min(bst));
	//	bst.showStructure();
	}
	
	@Test
	public void testElementsWithOneNegativeValue() { //zigzag structure 
		bst.add(15);
		bst.add(-11);
		bst.add(13);
		bst.add(0);
		bst.add(13);
		
		assertEquals(-11, Methods.min(bst));
	//	bst.showStructure();
	}
	@Test
	public void testElementsWithManyNegativeValues() { //zigzag structure 
		bst.add(-15);
		bst.add(-11);
		bst.add(-13);
		bst.add(-12);
		bst.add(-13);
		
		assertEquals(-15, Methods.min(bst));
	//	bst.showStructure();
	}
	
	
	@After
	public void tearDown() throws Exception {
	}
}
