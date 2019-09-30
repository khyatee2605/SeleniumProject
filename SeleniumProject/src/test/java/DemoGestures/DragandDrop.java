package DemoGestures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DragandDrop {
	WebDriver driver;
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
	  WebElement from=driver.findElement(By.xpath(("//span[@class='rtText'][contains(.,'Weekend Package')])[3]")));
	  WebElement to=driver.findElement(By.xpath(("//td[contains(.,'Weekend Package')]")));
	  
	  Actions a=new Actions(driver);
	  a.dragAndDrop(from, to).perform();
	  
	  WebDriverWait w=new WebDriverWait(driver,10);
	  w.until(ExpectedConditions.invisibilityOfElementWithText(By.id(ctl00_ContentPlaceholder1_RadGrid1_ctl00__0), "Drop a package here to check price"));
	  
  }
}
