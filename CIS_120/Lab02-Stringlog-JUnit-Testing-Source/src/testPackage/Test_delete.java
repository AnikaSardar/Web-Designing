package testPackage;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import stringLog.ArrayStringLog;
import stringLog.LinkedStringLog;

public class Test_delete {
	
	ArrayStringLog strLog;
	
	@Before
	public void setUp() throws Exception {		
		strLog = new ArrayStringLog("My StringLog",5);
	}
	
//	LinkedStringLog strLog;
//	
//	@Before
//	public void setUp() throws Exception {
//		strLog = new LinkedStringLog("My StringLog");
//	}
	

	@Test 
	public void test_NoElement() {
		assertFalse(strLog.delete("string 1"));
	}
	
	@Test
	public void test_NoOccurrence() {
		strLog.insert("string 1"); 
		strLog.insert("string 2");
		strLog.insert("string 3"); 
		strLog.insert("string 4");
		strLog.insert("string 5");
		
		assertFalse(strLog.delete("string 6")); 
	}
	
	@Test 
	public void test_1Element_Occurrence_At_the_Front() {
		strLog.insert("string 1"); 
		strLog.insert("string 2");
		strLog.insert("string 3"); 
		strLog.insert("string 4");
		strLog.insert("string 5");
		
		assertTrue(strLog.delete("string 5"));
	}
	
	@Test 
	public void test_1Element_Occurrence_At_the_Middle() {
		strLog.insert("string 1"); 
		strLog.insert("string 2");
		strLog.insert("string 3"); 
		strLog.insert("string 4");
		strLog.insert("string 5");
		
		assertTrue(strLog.delete("string 3"));
	}
	
	@Test 
	public void test_1Element_Occurrence_At_the_End() {
		strLog.insert("string 1"); 
		strLog.insert("string 2");
		strLog.insert("string 3"); 
		strLog.insert("string 4");
		strLog.insert("string 5");
		
		assertTrue(strLog.delete("string 1"));
	}
	
	@Test 
	public void test_3Elements_Occurrence() {
		strLog.insert("string 1"); 
		strLog.insert("string 1");
		strLog.insert("string 1"); 
		strLog.insert("string 4");
		strLog.insert("string 5");
		
	assertTrue(strLog.delete("string 1"));
	
	}
	
	@After
	public void tearDown() throws Exception {
	}
}

