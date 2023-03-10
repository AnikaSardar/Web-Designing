package testQueue;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	Test_AppLevel_copyQueue.class,
	Test_AppLevel_count.class,
	Test_AppLevel_showQueue.class})

public class All_Tests {
  // dummy class used to call the suite of tests
}
