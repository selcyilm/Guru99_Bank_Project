package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ManagerHomePage;
import pages.SignInPage;
import utils.ConfigReader;
import utils.Driver;

public class SS1 {

	SignInPage signInPage;
	ManagerHomePage managerHomePage;

	@BeforeMethod
	public void setup() {
		Driver.getDriver().get(ConfigReader.getProperty("toBankUrl"));
		signInPage = new SignInPage();
		managerHomePage = new ManagerHomePage();
	}

	@AfterMethod
	public void teardown() {
		Driver.quitDriver();
	}

	@Test(description = "Verify the login section")
	public void ss1() {
		signInPage.performSignIn(ConfigReader.getProperty("userId"),
								ConfigReader.getProperty("userPassword"));
		Assert.assertTrue(managerHomePage.bouncyText.isDisplayed());
	}
}
