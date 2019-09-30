package testngFeatures;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoAssertion1 {
  @Test
  public void test1() {
	  System.out.println("Test1 started");
	  Assert.assertEquals("Hello", "Hey");
	  System.out.println("Test1 completed");
  }
  @Test
  public void test2() {
	  System.out.println("Test2 started");
	  Assert.assertNotEquals("Hello", "Hey");
	  System.out.println("Test2 completed");
  }
  @Test
  public void test3() {
	  System.out.println("Test3 started");
	  Assert.assertTrue("Khyatee".contains("ate"), "Doesn't Contain");
	  System.out.println("Test3 completed");
  }
  @Test
  public void test4() {
	  System.out.println("Test4 started");
	  Assert.assertFalse(26>2, "26 is greater Genius :/");
	  System.out.println("Test4 completed");
  }
  @Test
  public void test5() {
	  Object test=null;
	  System.out.println("Test5 started");
	  Assert.assertNotNull(test,"Its not Null");
	  System.out.println("Test5 completed");
  }
  //@Test
  //public void test7() {
	  //Object test=null;
	 // System.out.println("Test7 started");
	 // Assert.assertNull(test,"Its Null");
	 // System.out.println("Test7 completed");
  //}
  @Test
  public void test6() {
	  System.out.println("Test6 started");
	  Assert.fail("Bye bye");
	  System.out.println("Test6 completed");
  }
}
