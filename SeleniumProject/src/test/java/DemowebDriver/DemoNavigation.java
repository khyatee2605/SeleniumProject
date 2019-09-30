package DemowebDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DemoNavigation {
  WebDriver driver;
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void f() throws InterruptedException {
	  driver.get("https://www.google.com/");
	  Thread.sleep(3000);
	  driver.navigate().to("https://www.seleniumhq.org/");
	  Thread.sleep(3000);
	  driver.navigate().back();
	  Thread.sleep(3000);
	  driver.navigate().forward();
	  Thread.sleep(3000);
	  driver.navigate().refresh();
	  Thread.sleep(3000);
	  System.out.println("Page refreshed");
	  
  }
  
  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
