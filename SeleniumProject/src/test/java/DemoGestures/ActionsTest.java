package DemoGestures;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class ActionsTest {
	
	WebDriver driver;
	@BeforeTest
	  public void beforeTest() {
			  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
			  driver = new ChromeDriver();
			  driver.manage().window().maximize();
	  }

	@Test
    public void f() throws InterruptedException {
    driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
       Thread.sleep(3000);
       WebElement searchBX = driver.findElement(By.xpath("//input[@id='myInput']"));
       Actions act = new Actions(driver);
       act.keyDown(searchBX, Keys.SHIFT).perform();
    act.sendKeys("b").pause(3000).sendKeys("a").pause(3000).sendKeys("g").perform();
       Thread.sleep(3000);
       WebElement handBagEle = driver.findElement(By.xpath("(//div[contains(.,'Hand bag')])[4]"));
        act.moveToElement(handBagEle).click();
    driver.findElement(By.xpath("//input[@type='submit']")).click();
       String text = driver.findElement(By.xpath("//h4[contains(text(),'Hand bag')]")).getText();
      Assert.assertTrue(text.contains("Hand"));

    }
}
