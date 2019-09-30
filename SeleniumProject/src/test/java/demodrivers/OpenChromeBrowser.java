package demodrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChromeBrowser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		
		driver=new ChromeDriver(); //open Chrome browser
		
		driver.get("https://www.seleniumhq.org/"); //get method to open website
		
		driver.manage().window().maximize(); // maximizes the window
		
		Thread.sleep(3000);
		
		driver.close(); //closes the browser
	}

}
