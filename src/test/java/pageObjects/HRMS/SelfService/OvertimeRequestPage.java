package pageObjects.HRMS.SelfService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class OvertimeRequestPage extends BasePage
{

	public OvertimeRequestPage(WebDriver driver)
	{
		super(driver);

	}

	// Locators
	@FindBy(xpath = "//a[@id='TxnInstanceView_I0i19_T']//span[@class='dx-vam'][normalize-space()='Profile Update']")
	WebElement profileUpdate;

	@FindBy(xpath = "//span[normalize-space()='Overtime Application']")
	WebElement overtimeApplication;

	@FindBy(xpath = "//input[@id='OvertimeApplication.OvertimeDate_I']")
	WebElement overtimeDate;

	@FindBy(xpath = "//input[@id='OvertimeApplication.OvertimeTypeIdLookup_I']")
	WebElement overtimeType;

	@FindBy(xpath = "//input[@id='OvertimeApplication.Hours_I']")
	WebElement hours;

	@FindBy(xpath = "//textarea[@id='OvertimeApplication.Description_I']")
	WebElement remarks;

	@FindBy(xpath = "//span[@id='ValidationSummary']")
	WebElement validation;

	// Action Methods
	public void scrollDownWebpage()
	{
		scrollDownWebPage(profileUpdate);
	}

	public void clickOvertimeRequest()
	{
		overtimeApplication.click();
	}

	public void clickNew()
	{
		clickOnNew();
	}

	public void provideOvertimeDate(String value)
	{
		clearAndProvide1(overtimeDate, value);
	}

	public void provideOvertimeType(String value)
	{
		clearAndProvide1(overtimeType, value);
	}

	public void provideHrs(String value)
	{
		clearAndProvide1(hours, value);
	}

	public void provideRemarks(String value)
	{
		remarks.sendKeys(value);
	}

	public void clickSaveBack()
	{
		clickSaveAndBack();
	}

	public String displayErrorMsg()
	{
		String msg = validation.getText();
		return msg;
	}

	public boolean isTxnCreated(String overtimeType, String hrs)
	{
		return resultValue(7).contains(overtimeType) && resultValue(7).contains(hrs);
	}

}
