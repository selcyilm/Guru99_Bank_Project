package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class ManagerHomePage {

	public ManagerHomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(tagName = "marquee")
	public WebElement bouncyText;

	@FindBy(xpath = "//*[@class='menusubnav']//li")
	public List<WebElement> menubarList;


}
