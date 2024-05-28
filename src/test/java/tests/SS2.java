package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ManagerHomePage;
import pages.SignInPage;
import utils.ConfigReader;
import utils.Driver;
import utils.ReusableMethods;

public class SS2 {
	/*
		Day 3 = More Automated Test Cases with the same scenario: Verifying the Login Page
		1. Enter in valid user/valid pw
		2. Enter in invalid user/valid pw
		3. Enter in valid user/invalid pw
		4. Enter in invalid user/invalid pw
	 */
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

	@DataProvider
	public Object[][] user_password() {
		return (new Object[][] {
				{true, ConfigReader.getProperty("userId"), ConfigReader.getProperty("userPassword")},
				{false, ConfigReader.getProperty("invalidUserId"), ConfigReader.getProperty("userPassword")},
				{false, ConfigReader.getProperty("userId"), ConfigReader.getProperty("invalidPassword")},
				{false, ConfigReader.getProperty("invalidUserId"), ConfigReader.getProperty("invalidPassword")}
		});
	}

	@Test(description = "Parametirised test for login functionality", dataProvider = "user_password")
	public void ss2(boolean isPas, String id, String password) {
		signInPage.performSignIn(id, password);
		if (isPas) {
			Assert.assertTrue(managerHomePage.bouncyText.isDisplayed());
		}
		else {
			String expectedText = "not valid";
			String actualText = Driver.getDriver().switchTo().alert().getText();
			Assert.assertTrue(actualText.contains(expectedText));
		}
	}

}
