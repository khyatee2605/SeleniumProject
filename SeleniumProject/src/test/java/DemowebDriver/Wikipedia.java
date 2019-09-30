package DemowebDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Wikipedia {
  WebDriver driver;
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @Test
  public void f() {
	  driver.get("https://en.wikipedia.org/wiki/Main_Page");
	  Assert.assertEquals(driver.getTitle(), "Wikipedia, the free encyclopedia");
	  
	  driver.findElement(By.xpath("//a[@title='Portal:History']")).click();
	  Assert.assertEquals(driver.getTitle(), "Portal:History - Wikipedia");
	  
	  String url=driver.getCurrentUrl();
	  System.out.println("The url of the current page is: "+url);
	  
	  System.out.println(driver.getPageSource());
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
		driver.close();
  }

}
