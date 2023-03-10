package testPackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import stringLog.ArrayStringLog;
import stringLog.LinkedStringLog;

public class Test_smallest {

	
//	ArrayStringLog strLog;
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
	public void test_1Element() {
		strLog.insert("string 1");
		assertEquals(strLog.smallest(), "string 1");
	}
	
	@Test
	public void test_3Elements_smallest_at_beginning() {
		strLog.insert("string 1"); 
		strLog.insert("string 2");
		strLog.insert("string 3"); 
		
		assertEquals(strLog.smallest(), "string 1");
	}
	
	@Test
	public void test_3Elements_smallest_in_middle() {
		strLog.insert("string 2"); strLog.insert("string 1");
		strLog.insert("string 3"); 
		
		assertEquals(strLog.smallest(), "string 1");
	}
	
	@Test
	public void test_3Elements_smallest_at_end() {
		strLog.insert("string 3"); strLog.insert("string 2");
		strLog.insert("string 1"); 
		
		assertEquals(strLog.smallest(), "string 1");
	}	
	
	@After
	public void tearDown() throws Exception {
	}

}
