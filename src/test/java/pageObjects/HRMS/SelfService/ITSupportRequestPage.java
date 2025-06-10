package pageObjects.HRMS.SelfService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class ITSupportRequestPage extends BasePage
{

	public ITSupportRequestPage(WebDriver driver)
	{
		super(driver);

	}

	// Locators
	@FindBy(xpath = "//span[normalize-space()='Support Request']")
	WebElement iTSupportRequest;

	@FindBy(xpath = "//input[contains(@id,'Title')]")
	WebElement subject;

	@FindBy(xpath = "//input[@id='SupportRequest.SupportRequestCategoryIdLookup_I']")
	WebElement supportRequest;

	@FindBy(id = "SupportRequest.Priority_B-1Img")
	WebElement priority;

	@FindBy(xpath = "//div[@aria-label='Editor content']")
	WebElement desc;

	@FindBy(xpath = "(//i[@class='dx-icon dx-icon-new-icon'])[5]")
	WebElement plusBtn;

	@FindBy(xpath = "Low")
	WebElement low;

	@FindBy(xpath = "Normal")
	WebElement normal;

	@FindBy(xpath = "//div[text()='High']")
	WebElement high;

	@FindBy(xpath = "//img[@id='MainMenu_DXI15_PImg']")
	WebElement contextMenu;

	// Action Methods
	public void clickITSupport()
	{
		iTSupportRequest.click();
		waitTS(3);
	}

	public void clickNew()
	{
		clickOnNew();
	}

	public void clickPlusBtn()
	{
		hoverOverElement(plusBtn);
		plusBtn.click();
	}

	public void provideSubject(String value)
	{
		subject.sendKeys(value);
	}

	public void selectPriority(String value)
	{
		if (value.contains("High"))
		{
			high.click();
		} else if (value.contains("Normal"))
		{
			normal.click();
		} else if (value.contains("Low"))
		{
			low.click();
		} else
		{
			low.click();
			throw new RuntimeException("VRC- Matching priority not found");
		}
	}

	public void provideDesc(String value)
	{
		desc.sendKeys(value);
	}

	public void clickSaveBack()
	{
		clickSaveAndBack();
	}

	public void clickContextMenu()
	{
		contextMenu.click();
	}

	public void clickView()
	{
		clickOnView();
	}

	public void clickOnApproveBack()
	{
		clickApproveAndBack();
	}

	public boolean isTxnCreated(String emp, String desc)
	{
		return resultValue(5).contains(emp) && resultValue(6).contains(desc);
	}

}
