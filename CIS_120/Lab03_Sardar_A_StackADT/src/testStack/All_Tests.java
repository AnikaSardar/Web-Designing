package testStack;

//import static org.junit.Assert.*;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Test_clear.class, Test_sizeIs.class, Test_toString.class })
//@SuiteClasses({ Test_toString.class })

public class All_Tests {
  // dummy class used to call the suite of tests
}
