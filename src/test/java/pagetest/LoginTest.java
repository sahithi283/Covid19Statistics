package pagetest;

import static org.testng.Assert.assertFalse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import driverfactory.DriverInvoker;
import pages.LoginPage;
/**
 * 
 *
 * This Test checks if a user is able to Login to Flipkart Website or not.
 */
public class LoginTest extends BaseTest {
	LoginPage loginObject;
	DriverInvoker invoker = new DriverInvoker();

	@BeforeMethod
	public void openBrowser() {
		driver = invoker.getDriver(browser);
		driver.manage().window().maximize();
		driver.get(properties.getProperty("url"));
	}

	@Test(groups = { "loginPass" })
	public void testLoginValidUsernameAndPassword() {
		loginObject = new LoginPage(driver);
		logger.info("Successfully Logged In.");
	}

}
