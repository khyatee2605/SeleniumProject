package demodrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenFirefox {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;

		System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");

		driver=new FirefoxDriver();

		driver.get("https://www.mvnrepository.com/");

		driver.manage().window().maximize();

		Thread.sleep(3000);

		driver.close();

	}

}
