package testPackage;

import lists.ArrayUnsortedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test_removeAll {

	ArrayUnsortedList<String> list;

	@Before
	public void setUp() throws Exception {

		list = new ArrayUnsortedList<String>(5);

	}

	@Test
	public void test_NoElements() {

		assertEquals(0, list.removeAll("string 1"));
	}

	@Test
	public void test_NoOccurrence() {
		list.add("string 1");
		list.add("string 2");
		list.add("string 3");
		list.add("string 4");
		list.add("string 5");

		assertEquals(0, list.removeAll("string 6"));
	}

	@Test
	public void test_One_Element_Occurrence_At_the_Front() {
		
		list.add("string 1");
		list.add("string 2");
		list.add("string 3");
		list.add("string 4");
		list.add("string 5");

		assertEquals(1, list.removeAll("string 1"));
	}

	@Test
	public void test_One_Element_Occurrence_At_the_Middle() {
		
		list.add("string 1");
		list.add("string 2");
		list.add("string 3");
		list.add("string 4");
		list.add("string 5");

		assertEquals(1, list.removeAll("string 3"));
	}

	@Test
	public void test_One_Element_Occurrence_At_the_End() {
		
		list.add("string 1");
		list.add("string 2");
		list.add("string 3");
		list.add("string 4");
		list.add("string 5");

		assertEquals(1, list.removeAll("string 5"));
	}

	@Test
	public void test_Three_Elements_Occurrence_At_the_Front() {
		
		list.add("string 1");
		list.add("string 1");
		list.add("string 1");
		list.add("string 4");
		list.add("string 5");

		assertEquals(3, list.removeAll("string 1"));

	}

	@Test
	public void test_Three_Elements_Occurrence_At_the_Middle() {
		
		list.add("string 1");
		list.add("string 2");
		list.add("string 2");
		list.add("string 2");
		list.add("string 5");

		assertEquals(3, list.removeAll("string 2"));
	}

	@Test
	public void test_Three_Elements_Occurrence_At_the_End() {

		list.add("string 1");
		list.add("string 2");
		list.add("string 3");
		list.add("string 3");
		list.add("string 3");

		assertEquals(3, list.removeAll("string 3"));
	}

	@Test
	public void test_Occurrence_At_Odd_Places() { 
		//"places" here meaning positive integers and not indices
		//,i.e., "place" starts at 1 and not 0 
		
		list.add("string 1");
		list.add("string 2");
		list.add("string 1");
		list.add("string 3");
		list.add("string 1");

		assertEquals(3, list.removeAll("string 1"));
	}

	@Test
	public void test_Occurrence_At_Even_Places() {
		//"places" here meaning positive integers and not indices
		//,i.e., "place" starts at 1 and not 0 
		
		list.add("string 1");
		list.add("string 2");
		list.add("string 1");
		list.add("string 2");
		list.add("string 1");

		assertEquals(2, list.removeAll("string 2"));
	}


	@Test
	public void test_Element_Occurrence_When_Reached_OrigCap() {
		
		list.add("string 1");
		list.add("string 1");
		list.add("string 1");
		list.add("string 1");
		list.add("string 1");

		assertEquals(5, list.removeAll("string 1"));
	}
	
	@Test
	public void test_Occurrence_When_Enlarged() {
		
		list.add("string 1");
		list.add("string 1");
		list.add("string 1");
		list.add("string 1");
		list.add("string 1");
		list.add("string 1");
		list.add("string 1");


		assertEquals(7, list.removeAll("string 1"));
	}

	@After
	public void tearDown() throws Exception {
	}

}
