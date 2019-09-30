package DemoGestures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class MouseAction {
	WebDriver driver;
	@Test
	public void f() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm#");

		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[@href='#'][contains(.,'All\n" + 
				"										Categories')]"))).click()
		.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Electronics')]"))).click()
		.moveToElement(driver.findElement(By.xpath("//span[@onclick='getProducts(11290,112101)'][contains(.,'Head Phone')]"))).click().build().perform();
		 String text = driver.findElement(By.xpath("//span[@onclick='getProducts(11290,112101)'][contains(.,'Head Phone')]")).getText();
	      Assert.assertTrue(text.contains("Head"));
		driver.findElement(By.xpath("//span[contains(.,'Head Phone')]")).click();

	}
}