package pageObjects.HRMS.Attendance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class ShiftPage extends BasePage
{

	public ShiftPage(WebDriver driver)
	{
		super(driver);

	}

	@FindBy(xpath = "//input[@id='Shift.Name_I']")
	WebElement name;

	@FindBy(xpath = "//input[@id='Shift.DefaultTimetableIdLookup_I']")
	WebElement defaultTimetableIdLookup;

	public void clickNew()
	{
		clickOnNew();
	}

	public void provideShiftName(String value)
	{
		name.sendKeys(value);
	}

	public void provideDefaultTimetable(String value)
	{
		provideAndEnter(defaultTimetableIdLookup, value);
		waitTS(3);
	}

	public void clickSaveBack()
	{
		clickSaveAndBack();
	}

	public boolean isTransactionCreated(String expShift)
	{
		filterByIndex(2, expShift);
		return resultValue(1).contains(expShift);
	}

}
