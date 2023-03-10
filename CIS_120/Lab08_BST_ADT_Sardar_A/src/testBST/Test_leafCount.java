package testBST;
import bst_Package.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test_leafCount {

	BinarySearchTree<String> bst; 
	
	@Before
	public void setUp() throws Exception {
		
		 bst = new BinarySearchTree<String>();
	}


//	@Test
//	public void testEmptyTree() {
//		
//		assertEquals(0, bst.leafCount());
//	}
//	
//	@Test
//	public void testOneElementTree() {  //here the element is both a root and a leaf
//		
//		bst.add(15);
//		
//		assertEquals(1, bst.leafCount());
//	}
//	
//	@Test
//	public void testThreeElementsAllLeft_OneLeaf() {    //linear structure
//		
//		bst.add(15);
//		bst.add(12);
//		bst.add(11);
//		
//		assertEquals(1, bst.leafCount());
//	//	bst.showStructure();
//	}
//	
//	@Test
//	public void testThreeElementsAllRight_OneLeaf_() { //linear structure
//		bst.add(15);
//		bst.add(17);
//		bst.add(19);
//		
//		assertEquals(1, bst.leafCount());
//	//	bst.showStructure();
//	}
//	
//	@Test
//	public void testFiveElementsWithOneRepeatedElement_OneLeaf() { //zigzag structure 
//		bst.add(15);
//		bst.add(11);
//		bst.add(13);
//		bst.add(12);
//		bst.add(13);
//		
//		assertEquals(1, bst.leafCount());
//	//	bst.showStructure();
//	}
//	
//	@Test
//	public void testFiveElementsWithTwoRepeatedElements_OneLeaf() { 
//		bst.add(15);
//		bst.add(15);
//		bst.add(10);
//		bst.add(11);
//		bst.add(11);
//		
//		assertEquals(1, bst.leafCount());
//	//	bst.showStructure();
//	}
//	
//	@Test
//	public void testThreeElementsTwoLeaf() { //Full and Complete Binary Tree 
//		bst.add(15);
//		bst.add(9);
//		bst.add(17);
//		
//		assertEquals(2, bst.leafCount());
//	//	bst.showStructure();
//
//	}
//	
//	@Test
//	public void testFiveElementsWithOneRepeatedElement_TwoLeaf() { 
//		bst.add(15);
//		bst.add(12);
//		bst.add(12);
//		bst.add(17);
//		bst.add(16);
//		
//		assertEquals(2, bst.leafCount());
//	//	bst.showStructure();
//	}
//	
//	@Test
//	public void testSixElementsWithThreeRepeatedElements_TwoLeaf() {  
//		bst.add(15);
//		bst.add(11);
//		bst.add(15);
//		bst.add(11);
//		bst.add(13);
//		bst.add(13);
//		
//		assertEquals(2, bst.leafCount());
//	//	bst.showStructure();
//	}
//	
//	@Test
//	public void testManyElementsandLeaf() { //Complete Binary Tree
//		bst.add(15);
//		bst.add(9);
//		bst.add(17);
//		bst.add(5);
//		bst.add(11);
//		bst.add(16);
//		bst.add(22);
//		bst.add(3);
//		bst.add(7);
//		bst.add(10);
//		
//		assertEquals(5, bst.leafCount());
//	//	bst.showStructure();
//
//	}
//	
	@Test
	public void test() { //Complete Binary Tree
		bst.add("Q");
		bst.add("K");
		bst.add("T");
		bst.add("D");
		bst.add("M");
		bst.add("R");
		bst.add("Y");
		bst.add("B");
		bst.add("J");
		bst.add("P");
		bst.add("W");
		bst.add("N");
		
bst.add("Q");
		bst.showStructure();

	}
	

	@After
	public void tearDown() throws Exception {
	}
}
