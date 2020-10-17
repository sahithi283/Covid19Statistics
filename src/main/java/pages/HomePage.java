package pages;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Utils;

/**
 * 
 */
public class HomePage {
	WebDriver driver;
	static Logger logger = Utils.getLogger();

	@FindBys(@FindBy(xpath = "//span[@class='nsslWl']/parent::a"))
	static List<WebElement> links;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static boolean checkLinks() {

		boolean flag = true;
		int index = 0;
		for (WebElement link : links) {
			RestAssured.baseURI = link.getAttribute("href");
			RequestSpecification httpRequest = RestAssured.given();
			Response response = httpRequest.get();
			int statusCode = response.getStatusCode();
			if (statusCode != 200) {
				flag = false;
			}
			logger.info((++index) + ". " + link.getAttribute("title") + " Statuscode: " + statusCode);
		}
		return flag;
	}
}
