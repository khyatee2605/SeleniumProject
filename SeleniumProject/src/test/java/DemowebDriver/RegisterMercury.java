package DemowebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class RegisterMercury {
WebDriver driver;
  @Test
  public void f() throws InterruptedException {
  driver.get("http://www.newtours.demoaut.com/");
  Assert.assertEquals(driver.getTitle(),"Welcome: Mercury Tours");
  System.out.println("Home page title is:- "+driver.getTitle());
 
  driver.findElement(By.linkText("REGISTER")).click();
  Assert.assertEquals(driver.getTitle(),"Register: Mercury Tours");
 
  driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Katie");
  driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Perry");
  driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("4758213695");
  driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("kate@gmail.com");
  driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("flat 3b");
  driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("adarsh colony");
  driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Akola");
  driver.findElement(By.xpath("//input[@name='state']")).sendKeys("mh");
  driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("444001");
 
  Select countryName = new Select(driver.findElement(By.name("country")));
  countryName.selectByIndex(4); //ANGOLA
  Thread.sleep(3000);
  countryName.selectByValue("8"); //ARGENTINA
  Thread.sleep(3000);
  countryName.selectByVisibleText("INDIA"); //INDIA
  Thread.sleep(3000);
 
 
  driver.findElement(By.xpath("//input[@name='email']")).sendKeys("kate26");
  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test02");
  driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("test02");
  driver.findElement(By.xpath("//input[@name='register']")).submit();
  Thread.sleep(3000);
  Assert.assertEquals(driver.getTitle(),"Register: Mercury Tours");
  }
 
  @BeforeTest
public void beforeTest() {
  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
  driver = new ChromeDriver();
  driver.manage().window().maximize();
 
  }
  @AfterTest
  public void afterTest() throws InterruptedException {
  Thread.sleep(3000);
  driver.close();
  }
}