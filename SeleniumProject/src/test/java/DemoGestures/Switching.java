package DemoGestures;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Switching {
	WebDriver driver;
	@Test
	public void f() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		WebElement about=driver.findElement(By.xpath("//span[contains(.,'AboutUs')]"));

		Actions a=new Actions(driver);
		a.moveToElement(about).click().build().perform();
		a.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Our\n" + 
				"												Offices')]"))).click().build().perform();
				a.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Chennai')]"))).click().build().perform();

		Set<String> set=driver.getWindowHandles();
		for(String string : set) {
			driver.switchTo().window(string);
		}
		
			driver.switchTo().frame(driver.findElement(By.name("main_page")));
			String address=driver.findElement(By.tagName("address")).getText();
			System.out.println(address);
			
			Assert.assertTrue(address.contains("Chennai"), "Chennai not found");
		}
	}
