package pageObjects.HRMS.SelfService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class ExceptionRequestPage extends BasePage
{

	public ExceptionRequestPage(WebDriver driver)
	{
		super(driver);

	}

	// Locators
	@FindBy(xpath = "(//span[text()='Exception Request'])[2]")
	WebElement exceptionRequest;

	@FindBy(xpath = "//input[contains(@id,'ExceptionDate')]")
	WebElement exceptionDate;

	@FindBy(xpath = "//input[contains(@id,'LoginTime')]")
	WebElement loginTime;

	@FindBy(xpath = "//input[contains(@id,'LogoutTime')]")
	WebElement logotTime;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[2]")
	WebElement loginCal;

	@FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[3]")
	WebElement logoutCal;

	// Action Methods
	public void createExceptionRequest()
	{
		exceptionRequest.click();
	}

	public void clickNew()
	{
		clickOnNew();
	}

	public void provideExceptionDate(String value)
	{
		clearAndProvide1(exceptionDate, value);
	}

	public void provideLoginTime(String value)
	{
		clearAndProvide1(loginTime, value);
		waitTS(2);
		// clickOnOk();
		// loginCal.click();
	}

	public void provideLogoutTime(String value)
	{
		clearAndProvide1(logotTime, value);
		clickOnOk();
		// logoutCal.click();
	}

	public void provideRemarks(String value)
	{
		provideDescription(value);
	}

	public void clickSaveBack()
	{
		clickSaveAndBack();
	}

	public boolean isTxnCreated(String expDate)
	{
		filterDateByIndex(5, expDate);
		if (resultValue(5).contains(expDate))
		{
			return true;
		} else
		{
			return false;
		}
	}

}
