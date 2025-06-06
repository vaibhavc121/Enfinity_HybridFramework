package pageObjects.HRMS.SelfService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.DateUtils;

public class ResignationPage extends BasePage
{

	public ResignationPage(WebDriver driver)
	{
		super(driver);

	}

	// Locators

	// Action Methods

	@FindBy(xpath = "//a[@id='TxnInstanceView_I0i19_T']//span[@class='dx-vam'][normalize-space()='Profile Update']")
	WebElement profileUpdate;

	@FindBy(xpath = "//span[normalize-space()='Resignation Application']")
	WebElement resignationApplication;

	@FindBy(xpath = "//input[@id='ResignationApplication.SubmittedDate_I']")
	WebElement submittedDate;

	@FindBy(xpath = "//textarea[@id='ResignationApplication.Description_I']")
	WebElement remarks;

	public void scrollDownWebpage()
	{
		scrollDownWebPage(profileUpdate);
	}

	public void clickResignation()
	{
		resignationApplication.click();
	}

	public void clickNew()
	{
		clickOnNew();
	}

	public void provideSubmittedDate(String value)
	{
		clearAndProvide1(submittedDate, value);
	}

	public void provideRemarks(String value)
	{
		remarks.sendKeys(value);
	}

	public void clickOnSaveAndBack()
	{
		clickSaveAndBack();
	}

	public boolean isTxnCreated()
	{
		return isTransactionCreated();
	}

	public boolean isTransactionCreated1()
	{
		String expectedDate = DateUtils.currentDateInCustomFormat();
		String expectedDesc = DateUtils.addDaysToGivenDate("01-01-2025", 100);

		if (resultValue(2).contains(expectedDate) || resultValue(7).contains(expectedDesc))
		{
			return true;
		} else
		{
			return false;
		}
	}

}
