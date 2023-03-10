package testPackage;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import stringLog.ArrayStringLog;
import stringLog.LinkedStringLog;

public class Test_isEmpty {

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
	public void test_NoElements() {
		assertTrue(strLog.isEmpty());
	}

	@Test
	public void test_1Element() {	
		strLog.insert("first string");
		assertFalse(strLog.isEmpty());
	}
	
	@Test
	public void test_ManyElements_but_not_full() {
		strLog.insert("string 1"); strLog.insert("string 2");
		strLog.insert("string 3"); strLog.insert("string 4");
		
		// System.out.println(strLog);
		assertFalse(strLog.isEmpty());
	}

	@Test
	public void test_when_full() {
		strLog.insert("string 1"); strLog.insert("string 2");
		strLog.insert("string 3"); strLog.insert("string 4");
		strLog.insert("string 5");
		
		// System.out.println(strLog);
		assertFalse(strLog.isEmpty());
	}
	
	@After
	public void tearDown() throws Exception {
	}
}
