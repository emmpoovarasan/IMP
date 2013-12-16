package test;

import org.junit.Test;

import junit.framework.TestSuite;
import keyworddriven.Scripts.Dashboard;
import keyworddriven.Scripts.Login;

public class RunTestSuite {

	public static TestSuite suite(){
		
		TestSuite ts = new TestSuite();
		ts.addTestSuite(Login.class);
		ts.addTestSuite(Dashboard.class);
		
		return ts;
	}
	
	@Test
	public void testRunTestSuite(){
		System.out.println("Total no of test cases are "+suite().countTestCases());
		suite();
	}
	
}
