package testngFeatures;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoSoftAssert {
  @Test
  public void f() {
	  
	  SoftAssert sa =new SoftAssert();
	  System.out.println("Test 1 - Check 1st Test");
	  sa.assertEquals(12, 10);
	  
	  System.out.println("Test 2- Check 2nd Test");
	  sa.assertTrue("Selenium".contains("basic"), "Error msg:");
	  
	  sa.assertAll();
	  
  }
 
}
