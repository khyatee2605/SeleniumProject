package DemowebDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginMercury {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void f() throws InterruptedException {
		driver.get("http://newtours.demoaut.com/");

		String pgTitle=driver.getTitle();
		Assert.assertEquals(pgTitle, "Welcome: Mercury Tours");

		driver.findElement(By.name("userName")).sendKeys("kate26");
		driver.findElement(By.name("password")).sendKeys("test02");
		driver.findElement(By.name("login")).click();

		Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");

		Thread.sleep(3000);
		driver.findElement(By.linkText("SIGN-OFF")).click();
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

}
