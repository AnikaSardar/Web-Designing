package testBST;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bst_Package.BinarySearchTree;

public class Test_singleParentCount {

	BinarySearchTree<Integer> bst;
	@Before
	public void setUp() throws Exception {
		bst = new BinarySearchTree<Integer>();
	}

	@Test
	public void testEmptyTree() {
		
		assertEquals(0, bst.singleParentCount());
	}
	
	@Test
	public void testOneElementTree() {
		
		bst.add(15);
		
		assertEquals(0, bst.singleParentCount());
	}
	
	@Test
	public void testTwoElementTree() {
		
		bst.add(15);
		bst.add(17);
		
		assertEquals(1, bst.singleParentCount());
	}
	@Test
	public void testTwoChildOneParentTree() { //Full and Complete Binary Tree
		
		bst.add(15);
		bst.add(17);
		bst.add(12);
		
		assertEquals(0, bst.singleParentCount());
	}
	@Test
	public void testTwoChildForEachOfTheThreeParent() { //Full and Complete Binary Tree
		
		bst.add(15);
		bst.add(17);
		bst.add(12);
		bst.add(12);
		bst.add(13);
		bst.add(16);
		bst.add(18);
		
	//	bst.showStructure();
		assertEquals(0, bst.singleParentCount());
	}
	@Test
	public void testSingleLineElementsOfThreeToLeft() {    //linear structure
		
		bst.add(15);
		bst.add(12);
		bst.add(11);
		
		assertEquals(2, bst.singleParentCount());
	//	bst.showStructure();
	}
	
	@Test
	public void testSingleLineElementsofFiveToRight() { //linear structure
		bst.add(15);
		bst.add(17);
		bst.add(19);
		bst.add(20);
		bst.add(21);
		assertEquals(4, bst.singleParentCount());
	//	bst.showStructure();
	}
	@Test
	public void testSixElementsTree() { //zigzag structure 
		bst.add(15);
		bst.add(10);
		bst.add(13);
		bst.add(11);
		bst.add(13);
		bst.add(12);
		assertEquals(5, bst.singleParentCount());
	//	bst.showStructure();
	}
	
	@Test
	public void testLargeTree() { 
		bst.add(15);
		bst.add(9);
		bst.add(17);
		bst.add(5);
		bst.add(11);
		bst.add(16);
		bst.add(22);
		bst.add(3);
		bst.add(7);
		bst.add(10);
		bst.add(18);
		bst.add(23);
		bst.add(2);
		bst.add(8);
		bst.add(11);
		bst.add(17);
		bst.add(17);
		bst.add(19);
		bst.add(23);
		
	    assertEquals(8, bst.singleParentCount());
	//	bst.showStructure();

	}

	@After
	public void tearDown() throws Exception {
	}
}
