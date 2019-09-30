package DemoExcel;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginMercuryDDT {
WebDriver driver;
@BeforeTest
public void beforeTest() {
 System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
 driver = new ChromeDriver();
 driver.manage().window().maximize();
}


@Test(dataProvider = "login")
public void f(String username, String password) throws Exception  {
 driver.get("http://www.newtours.demoaut.com/");
 //Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");  
 driver.findElement(By.name("userName")).sendKeys(username);
 driver.findElement(By.name("password")).sendKeys(password);
 driver.findElement(By.name("login")).click();

 Thread.sleep(3000);

}

@DataProvider(name="login")
public Object[][] dp() throws Exception {
 return ExcelReader.ReadData();
}


@AfterTest
public void afterTest() {
 driver.close();
}

}