package pagetest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import driverfactory.DriverInvoker;
import pages.HomePage;
import utils.Utils;
/**
 * 
 * This Test checks if there are any Broken Links.
 */
public class BrokenLinksTest extends BaseTest {
	HomePage homeObject;
	DriverInvoker invoker = new DriverInvoker();

	@BeforeMethod
	public void openBrowser() {
		driver = invoker.getDriver(browser);
		driver.manage().window().maximize();
		driver.get(properties.getProperty("url"));
		Utils.waitForMintime();
	}

	@Test(groups = { "brokenLinks" })
	public void testBrokenLinks() {
		homeObject = new HomePage(driver);
		Assert.assertTrue(homeObject.checkLinks());
		logger.info("Successfully Verified for Broken Links.");
	}
}
