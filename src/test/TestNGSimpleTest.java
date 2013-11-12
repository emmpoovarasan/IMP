package test;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class TestNGSimpleTest {
  @Test
  public void testAdd() {
	  String str = "TestNG is working fine";
	  try {
		  assertEquals("TestNG is working fine1", str);
	} catch (AssertionError e) {
		// TODO: handle exception
		System.out.println("Failed: "+e.getMessage());
	}
	  
  }
}
