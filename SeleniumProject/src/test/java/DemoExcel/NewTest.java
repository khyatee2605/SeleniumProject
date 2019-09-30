package DemoExcel;

import org.testng.annotations.Test;

import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class NewTest {
	  public WebDriver driver;
	  public WebDriverWait wait;
	@Test(dataProvider = "dp")
	public void f(String u, String p) throws InterruptedException {

		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		driver.findElement(By.linkText("SignIn")).click();
		driver.findElement(By.name("userName")).sendKeys(u);
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys(p);
		Thread.sleep(5000);
		driver.findElement(By.name("Login")).click();
	}

	@DataProvider
	public Object[][] dp() throws IOException {
		return Scenario1.ReadData();
	}
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver,30);
	}
	
	

}
