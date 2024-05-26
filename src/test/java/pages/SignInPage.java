package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class SignInPage {

	public SignInPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[@name='uid']")
	public WebElement userIdBox;

	@FindBy(xpath = "//*[@name='password']")
	public WebElement passwordBox;

	@FindBy(xpath = "//*[@name='btnLogin']")
	public WebElement loginButton;

	@FindBy(xpath = "//*[@name='btnReset']")
	public WebElement resetButton;

	@FindBy(xpath = "//h2[@class='barone']")
	public WebElement bankNameText;

	public void performSignIn(String userId, String password) {
		userIdBox.sendKeys(userId);
		passwordBox.sendKeys(password);
		loginButton.click();
	}
}
