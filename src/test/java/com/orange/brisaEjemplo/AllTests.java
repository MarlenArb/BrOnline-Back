package com.orange.brisaEjemplo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	AllTestsClient.class, 
	AllTestsGreeting.class 
})

public class AllTests {

}
