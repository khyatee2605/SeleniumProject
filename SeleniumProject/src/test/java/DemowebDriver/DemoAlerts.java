package DemowebDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class DemoAlerts {
  WebDriver driver;
  @BeforeTest
  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
  }

  @Test
  public void f() throws InterruptedException {
	  driver.get("http://demo.automationtesting.in/Alerts.html");
	  
	  driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
	  
	  WebDriverWait wait=new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='#Textbox']")));
	  
	  driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
	  
	  Alert al=driver.switchTo().alert();
	  
	  String alert=al.getText();
	  System.out.println("Alert msg is : "+alert);
	  
	  al.sendKeys("Kate");
	  
	  al.accept();
  }
  
  @AfterTest
  public void afterTest() {
  }

}
