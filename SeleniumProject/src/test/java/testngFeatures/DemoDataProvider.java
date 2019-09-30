package testngFeatures;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DemoDataProvider {
  @Test(dataProvider = "dp")
  public void login(String user, String pass) {
	  System.out.println("Username is: "+user);
	  System.out.println("Password is: "+pass);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Kate", "katie" },
      new Object[] { "Ansh", "anshy" },
      new Object[] { "Meet", "miti" },
    };
  }
}
