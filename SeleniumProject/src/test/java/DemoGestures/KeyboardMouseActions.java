package DemoGestures;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class KeyboardMouseActions {
  @Test
  public void f() {
	  WebDriver driver;
	  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	 WebElement search= driver.findElement(By.xpath("//input[@type='text']"));
	  
	  Actions act=new Actions(driver);
	  act.keyDown(search,Keys.SHIFT).perform();
	  act.sendKeys("b").sendKeys("a").sendKeys("g").perform();
	  act.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Hand bag')]"))).click().perform();
	  driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
	  String text= driver.findElement(By.xpath("//h4[contains(text(),'Hand bag')]")).getText();
	  Assert.assertTrue(text.contains("Hand Bag"));
	  
	  
  }
}
