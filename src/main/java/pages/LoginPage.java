package pages;

import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;

/**
 * 
 *         Website.
 */
public class LoginPage {
	WebDriver driver;

	@FindBy(xpath = "//input[@class='_2zrpKA _1dBPDZ']")
	WebElement usernameTextbox;

	@FindBy(xpath = "//input[@class='_2zrpKA _3v41xv _1dBPDZ']")
	WebElement passwordTextbox;

	@FindBy(xpath = "//button//span[text()='Login']")
	WebElement loginButton;

	@FindBys(@FindBy(xpath = "//a[text()='Login & Signup']"))
	List<WebElement> loginSignupIcon;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginToFlipkart(String username, String password) {
		try {
			usernameTextbox.sendKeys(username);
			passwordTextbox.sendKeys(password);
			loginButton.click();
			Utils.waitForMintime();
		} catch (NoSuchElementException exception) {
			exception.printStackTrace();
		}
	}

	public boolean checkLoginSignupIcon() {
		if (Utils.isPresent(loginSignupIcon))
			return true;
		return false;
	}
}