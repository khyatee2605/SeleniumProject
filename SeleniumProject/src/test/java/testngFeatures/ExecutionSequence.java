package testngFeatures;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ExecutionSequence {
  @Test
  public void f() {
	  System.out.println("I'm in @Test annotation");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("I'm in @beforeMethod annotation");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("I'm in @afterMethod annotation");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("I'm in @beforeClass annotation");
  }
 

  @AfterClass
  public void afterClass() {
	  System.out.println("I'm in @afterClass annotation");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("I'm in @beforeTest annotation");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("I'm in @afterTest annotation");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("I'm in @beforeSuite annotation");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("I'm in @afterSuite annotation");
  }

}
