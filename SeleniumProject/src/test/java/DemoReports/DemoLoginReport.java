package DemoReports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class DemoLoginReport {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	
	@BeforeTest
	public void startReport() {
		htmlReporter =new ExtentHtmlReporter(System.getProperty("user.dir") +"/extent-reports/"+new SimpleDateFormat("hh-mm-ss-ms-dd-MM-yyyy").format(new Date())+".html");
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "GFT NextGen Testing Stream");
		extent.setSystemInfo("Environment", "Automation testing - Selenium");
		extent.setSystemInfo("User name", "Khyatee A Thakkar");
		
		htmlReporter.config().setDocumentTitle("This is the Title");
		htmlReporter.config().setReportName("Name of the Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}
 /* @Test
  public void passTest() {
	  logger=extent.createTest("passTest");
	  Assert.assertTrue(true);
	  logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
  }
  @Test
  public void failTest() {
	  logger=extent.createTest("failTest");
	  Assert.assertTrue(false);
	  logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.RED));
  }
  @Test
  public void skipTest() {
	  logger=extent.createTest("skipTest");
	  throw new SkipException("Skipping - this is not ready for testing");
  } */
	
	@Test
	public void failTest() {
		logger=extent.createTest("failTest");
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		driver.findElement(By.id("userName")).sendKeys("Lalitha");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(.,'SignOut')]")).isDisplayed());
		driver.findElement(By.xpath("//a[contains(.,'SignOut')]")).click();
	}
	
  
  @AfterMethod
  public void getResult(ITestResult result) throws IOException {
	  if(result.getStatus()==ITestResult.FAILURE) {
		  logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		  TakesScreenshot snap=(TakesScreenshot)driver;
		  File src=snap.getScreenshotAs(OutputType.FILE);
		  String path=System.getProperty("user.dir") +"/extent-reports/snapshots/"+result.getName()+".png";
		  FileUtils.copyFile(src, new File(path));
		  logger.addScreenCaptureFromPath(path, result.getName());
		  logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
	  }else if(result.getStatus()==ITestResult.SKIP) {
		  logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
	  }
  }
  
  @AfterTest
  public void endReport() {
	  extent.flush();
  }
}
