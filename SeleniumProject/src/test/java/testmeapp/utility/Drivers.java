package testmeapp.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Drivers {
	WebDriver driver;
	@Test
	public WebDriver getDriver(String name) {
		if(name.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
			return new ChromeDriver();
		}else if(name.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
			return new FirefoxDriver();
		}else if(name.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "resources\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}else {
			System.out.println("Not a valid driver");
			return null;
		}
	}
}
