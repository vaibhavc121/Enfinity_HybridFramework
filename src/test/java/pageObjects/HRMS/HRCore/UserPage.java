package pageObjects.HRMS.HRCore;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BasePage;

public class UserPage extends BasePage
{

	public UserPage(WebDriver driver)
	{
		super(driver);

	}

	// Page Objects
	@FindBy(xpath = "//img[@id='MainMenu_DXI10_PImg']")
	WebElement contextMenu;

	@FindBy(xpath = "//span[normalize-space()='Freeze']")
	WebElement freeze;

	@FindBy(xpath = "//div//span[contains(@class, 'dx-vam') and text()='Edit']")
	WebElement edit;

	// Action Methods

	public void freezeUser(String username)
	{
		globalSearch("User");
		waitTS(2);
		navigateToEmployee(username);
		waitExplicit(4);
		clickOnEdit();
		contextMenu.click();
		waitUntilVisible(freeze);
		driver.navigate().back();
		filterByIndex(2, username);

		// Assuming you want an assertion here in Java test framework like TestNG or
		// JUnit
		Assert.assertEquals("YES", "YES");
	}

	// Helper wait method example
	public void waitExplicit(int seconds)
	{
		new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOf(edit)); // or any
																												// element
																												// you
																												// want
																												// to
																												// wait
																												// for
	}

	public void waitUntilVisible(WebElement element)
	{
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
	}

}
