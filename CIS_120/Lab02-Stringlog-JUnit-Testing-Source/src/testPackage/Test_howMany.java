package testPackage;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import stringLog.ArrayStringLog;
import stringLog.LinkedStringLog;
import stringLog.StringLogInterface;

public class Test_howMany {

//   ArrayStringLog strLog;
//	
//	@Before
//	public void setUp() throws Exception {		
//		strLog = new ArrayStringLog("My StringLog",5);
//	}
	
	LinkedStringLog strLog;
		
	@Before
	public void setUp() throws Exception {
		strLog = new LinkedStringLog("My StringLog");
	}

	@Test
	public void test_NoElements() {	
		assertEquals(0, strLog.howMany("someString"));	
	}

	@Test
	public void test_noMatch_1Element() {	
		strLog.insert("first string");
		assertEquals(0, strLog.howMany("some string"));		
	}
	
	@Test
	public void test_noMatch_5Elements() {	
		strLog.insert("string 1"); strLog.insert("string 2");
		strLog.insert("string 3"); strLog.insert("string 4");
		strLog.insert("string 5"); 
		
		assertEquals(0, strLog.howMany("some string"));		
	}
	
	@Test
	public void test_1_match_at_beginning() {	
		strLog.insert("string 1"); strLog.insert("string 2");
		strLog.insert("string 3"); strLog.insert("string 4");
		strLog.insert("string 5"); 
		
		assertEquals(1, strLog.howMany("string 1"));		
	}
	
	@Test
	public void test_1_match_in_middle() {	
		strLog.insert("string 1"); strLog.insert("string 2");
		strLog.insert("string 3"); strLog.insert("string 4");
		strLog.insert("string 5"); 
		
		assertEquals(1, strLog.howMany("string 3"));		
	}
	
	@Test
	public void test_1_match_at_End() {	
		strLog.insert("string 1"); strLog.insert("string 2");
		strLog.insert("string 3"); strLog.insert("string 4");
		strLog.insert("string 5"); 
		
		assertEquals(1, strLog.howMany("string 5"));		
	}
	
	@Test
	public void test_3_matches_scattered_throughout() {
		strLog.insert("string 1"); strLog.insert("string 2");
		strLog.insert("string 1"); strLog.insert("string 4");
		strLog.insert("string 1"); 
		
		//System.out.println(strLog);
		assertEquals(3, strLog.howMany("string 1"));		
	}
	
	@Test
	public void test_all_matching_1_Element() {
		strLog.insert("string 1");
		
		//System.out.println(strLog);
		assertEquals(1, strLog.howMany("string 1"));		
	}	

	@Test
	public void test_test_all_matching_2_Elements() {
		strLog.insert("string 1"); strLog.insert("string 1");
		
		//System.out.println(strLog);
		assertEquals(2, strLog.howMany("string 1"));		
	}
		
	@Test
	public void test_test_all_matching_5_Elements() {
		strLog.insert("string 1"); strLog.insert("string 1");
		strLog.insert("string 1"); strLog.insert("string 1");
		strLog.insert("string 1"); 
		
		//System.out.println(strLog);
		assertEquals(5, strLog.howMany("string 1"));		
	}
		
	@After
	public void tearDown() throws Exception {
	}
}
