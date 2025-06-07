package pageObjects.HRMS.SelfService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class AdminSupportPage extends BasePage
{

	public AdminSupportPage(WebDriver driver)
	{
		super(driver);

	}

	// Locators

	@FindBy(xpath = "//span[normalize-space()='Admin Support']")
	WebElement adminSupport;

	@FindBy(xpath = "//input[@id='SupportRequest.SupportRequestCategoryIdLookup_I']")
	WebElement supportRequest;

	@FindBy(id = "SupportRequest.Priority_B-1Img")
	WebElement priority;

	@FindBy(xpath = "//textarea[@id='SupportRequest.Description_I']")
	WebElement remarks;

	// Action Methods

	public void clickAdminSupport()
	{
		adminSupport.click();
	}

	public void clickNew()
	{
		clickOnNew();
	}

	public void clickSupportRequestCategory()
	{
		supportRequest.click();
	}

	public void provideSupportRequestCat(String value)
	{
		supportRequest.sendKeys(value);
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void clickPriorityDD()
	{
		priority.click();
	}

	public void selectPriority(String value)
	{
		selectDropdownValueOffice365(value);
	}

	public void provideRemarks(String value)
	{
		remarks.sendKeys(value);
	}

	public void clickSave()
	{
		clickSaveAndBack();
	}
//
//	public boolean isTxnCreated(String value)
//	{
//		if (result6().contains(value))
//		{
//			return true;
//		} else
//		{
//			return false;
//		}
//	}
	// endregion

}
