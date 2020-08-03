package com.orange.brisaEjemplo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.orange.brisaEjemplo.client.ClientHTTPYesTest;
import com.orange.brisaEjemplo.client.ClientRepositoryYesTest;
import com.orange.brisaEjemplo.client.ClientRepositoryNoTest;



@RunWith(Suite.class)
@SuiteClasses({ 
	ClientHTTPYesTest.class, 
	ClientRepositoryNoTest.class,
	ClientRepositoryYesTest.class 
})

public class AllTestsClient {

}
