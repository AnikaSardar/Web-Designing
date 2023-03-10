package testPackage;
import lists.ArrayUnsortedList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Test_isEmpty {

	ArrayUnsortedList<String> list; 
	
	@Before 
	public void setUp() throws Exception {

         list = new ArrayUnsortedList<String>(5);

    }
	
	@Test
	public void test_NoElements() {
		
		assertTrue(list.isEmpty());
	}

	@Test
	public void test_One_Element() {	
		
		list.add("string 1");
		
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void test_ManyElements() {
		
		list.add("string 1"); 
		list.add("string 2");
		list.add("string 3"); 
		list.add("string 4");
		
	
		assertFalse(list.isEmpty());
	}

	@Test
	public void test_when_reached_OrigCap() {
		list.add("string 1"); 
		list.add("string 2");
		list.add("string 3"); 
		list.add("string 4");
		list.add("string 5");
		
	
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void test_when_Enlarged() {
		list.add("string 1"); 
		list.add("string 2");
		list.add("string 3"); 
		list.add("string 4");
		list.add("string 5");
		list.add("string 6");
		list.add("string 7");
	
		assertFalse(list.isEmpty());
	}
	
	@After
	public void tearDown() throws Exception {
	
	}

	
	
}
