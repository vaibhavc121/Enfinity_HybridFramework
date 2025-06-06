package pageObjects.HRMS.SelfService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class SelfServicePage extends BasePage
{

	public SelfServicePage(WebDriver driver)
	{
		super(driver);

	}

	// Locators

	// Action Methods

	@FindBy(xpath = "//span[normalize-space()='Self Service']")
	WebElement selfService;

	@FindBy(xpath = "//span[normalize-space()='Time Off']")
	WebElement timeOff;

	@FindBy(xpath = "//span[text()='Transactions']")
	WebElement transactions;

	public void clickSelfService()
	{
		selfService.click();
	}

	public void clickTimeOff()
	{
		timeOff.click();
	}

	public void clickTransactions()
	{
		transactions.click();
	}

}
