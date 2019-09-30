package DemoExcel;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class RegisterMercury {
WebDriver driver;
@BeforeTest
public void beforeTest() {
 System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
 driver = new ChromeDriver();
 driver.manage().window().maximize();
}


@Test(dataProvider = "login")
public void f(String firstname, String lastname, String phone, String userName, String address1, String address2, String city) throws Exception  {
 driver.get("http://newtours.demoaut.com/mercuryregister.php?");
 //Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours"); 
 driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstname);
 driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastname);
 driver.findElement(By.xpath("//input[contains(@name,'phone')]")).sendKeys(phone);
 driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(userName);
 driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(address1);
 driver.findElement(By.xpath("//input[contains(@name,'address2')]")).sendKeys(address2);
 driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
 Thread.sleep(3000);

}

@DataProvider(name="login")
public Object[][] dp() throws Exception {
 return DataPro.ReadData();
}


@AfterTest
public void afterTest() {
 driver.close();
}

}