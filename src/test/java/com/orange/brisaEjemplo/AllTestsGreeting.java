package com.orange.brisaEjemplo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.orange.brisaEjemplo.greeting.GreetingHTTPNoServiceNoTest;
import com.orange.brisaEjemplo.greeting.GreetingHTTPNoTest;
import com.orange.brisaEjemplo.greeting.GreetingHTTPYesTests;

@RunWith(Suite.class)
@SuiteClasses({ 
	GreetingHTTPYesTests.class, 
	GreetingHTTPNoServiceNoTest.class, 
	GreetingHTTPNoTest.class 
})

public class AllTestsGreeting {

}
