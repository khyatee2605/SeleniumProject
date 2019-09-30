package testmeapp.tests;
import testmeapp.utility.*;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class OnlineShoppingTest {
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	Drivers d=new Drivers();
	Scanner sc=new Scanner(System.in);




	@BeforeTest
	public void startReportBeforeTest() {
		System.out.println("Browser name");
		String name=sc.next();
		driver=d.getDriver(name);
		htmlReporter =new ExtentHtmlReporter(System.getProperty("user.dir") +"/extent-reports/"+new SimpleDateFormat("hh-mm-ss-ms-dd-MM-yyyy").format(new Date())+".html");
		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "GFT NextGen Testing Stream");
		extent.setSystemInfo("Environment", "Automation testing - Selenium");
		extent.setSystemInfo("User name", "Khyatee A Thakkar");

		htmlReporter.config().setDocumentTitle("Test Report");
		htmlReporter.config().setReportName("TestMeApp-Report");
		htmlReporter.config().setTheme(Theme.DARK);

		logger=extent.createTest("Test");

		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm"); 

	}



	@Test(priority=3)
	public void testCart() {
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//span[contains(.,'All\n" + 
				"										Categories')]"))).click().pause(2000).perform();
		a.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Electronics')]"))).click().pause(2000).perform();
		a.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Head Phone')]"))).click().pause(2000).perform();
		String text = driver.findElement(By.xpath("//h4[contains(.,'Headphone')]")).getText();
		Assert.assertTrue(text.contains("Headphone"));
		driver.findElement(By.xpath("//a[contains(.,'Add to cart')]")).click();
	}
	@Test(priority=2)
	public void testLogin() {
		driver.findElement(By.id("userName")).sendKeys("Lalitha");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.name("Login")).click();
	}
	@Test(priority=4)
	public void testPayment() {
		driver.findElement(By.xpath("//a[contains(.,'Cart\n" + 
				"									1')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Checkout')]")).click();
		driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//label[contains(.,'Andhra Bank')]")).click();
		driver.findElement(By.id("btn")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pass@456");
		String an=driver.findElement(By.id("error")).getText();
		Assert.assertFalse(an.contains("Invalid username/password"));
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		driver.findElement(By.name("transpwd")).sendKeys("Trans@456");
		driver.findElement(By.className("user-right")).click();
		String na=driver.findElement(By.className("panel-body")).getText();
		Assert.assertTrue(na.contains("Your order has been confirmed"));
	}
	@Test(priority=1)
	public void testRegistration() {

		
		driver.findElement(By.xpath("//a[contains(.,'SignUp')]")).click();
		driver.findElement(By.id("userName")).sendKeys("meh123");

		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		boolean existFlag = wait1.until(ExpectedConditions.textToBe(By.id("err"), "New"));
		System.out.println(existFlag);
		Assert.assertTrue(existFlag);
		String errMsg = driver.findElement(By.id("err")).getText();
		Assert.assertEquals("New", errMsg);

		logger.log(Status.INFO, MarkupHelper.createLabel("ID is available", ExtentColor.GREEN));
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Khyatee");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Thakkar");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("katie02");
		driver.findElement(By.xpath("//input[contains(@name,'confirmPassword')]")).sendKeys("katie02");
		driver.findElement(By.xpath("//input[@value='Female']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("kate@gmail.com");
		driver.findElement(By.xpath("//input[@name='mobileNumber']")).sendKeys("9876543210");
		driver.findElement(By.id("dob")).sendKeys("05/26/97");
		driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("Flat 3b - Akola");
		Select obj=new Select(driver.findElement(By.xpath("//select[@name='securityQuestion']")));
		obj.selectByIndex(0);
		driver.findElement(By.xpath("//input[@name='answer']")).sendKeys("Rourkela");
		driver.findElement(By.xpath("//input[@name='Submit']")).submit();

		String flag3 = driver.findElement(By.xpath("//div[@id='errormsg']/following-sibling::div[3]")).getText();
		System.out.println(flag3);
		Assert.assertEquals("User Registered Succesfully!!! Please login", flag3);
		logger.log(Status.INFO, MarkupHelper.createLabel("User Registered Succesfully!!! Please login", ExtentColor.GREEN));

	}
	@AfterMethod
	public void getResultAfterMethod(ITestResult result) throws IOException {
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
		else {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
		}
	}


	@AfterTest
	public void endReportAfterTest() {
		extent.flush();
	}

}
