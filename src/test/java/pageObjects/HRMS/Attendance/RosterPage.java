package pageObjects.HRMS.Attendance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.BrowserUtils;
import utilities.DateUtils;

public class RosterPage extends BasePage
{

	public RosterPage(WebDriver driver)
	{
		super(driver);

	}

	@FindBy(xpath = "//input[@id='FromDate_I']")
	WebElement fromDate;

	@FindBy(xpath = "//input[@id='UptoDate_I']")
	WebElement uptoDate;

	@FindBy(xpath = "//input[@id='TimetableIdLookup_I']")
	WebElement timetableIdLookup;

	@FindBy(xpath = "//label[contains(text(),'day')]")
	List<WebElement> days;

	@FindBy(xpath = "//input[@id='EmployeeIds_I']")
	WebElement employee;

	@FindBy(xpath = "//span[text()='Generate']")
	WebElement generate;

	public void clickNew()
	{
		waitTS(3);
		clickOnNew();
	}

	public void switchTheTab()
	{
		waitTS(3);
		switchTab();
	}

	public void provideFromDate(String value)
	{
		waitTS(3);
		clearAndProvide1(fromDate, value);
	}

	public void provideUptoDate(String value)
	{
		clearAndProvide1(uptoDate, value);
	}

	public void provideTimetable(String value)
	{
		clearAndProvide1(timetableIdLookup, value);
	}

	public void selectExcludeDay(String expDay)
	{
		for (int i = 0; i < days.size(); i++)
		{
			if (days.get(i).getText().contains(expDay))
			{
				String toggleXpath = "(//span[@class='dxSwitcher dx-not-acc'])[" + (i + 1) + "]";
				driver.findElement(By.xpath(toggleXpath)).click();
				return;
			}
		}
		throw new RuntimeException("No matching day found: " + expDay);
	}

	public void provideEmp(String value)
	{
		clearAndProvide1(employee, value);
	}

	public void clickOnGenerate()
	{
		generate.click();
	}

	public void switchTheTab1()
	{
		switchTab();
	}

	public void refreshBrowser()
	{
		BrowserUtils.refreshPage(driver);
	}

	public boolean isTransactionCreated(String date)
	{
		String expDate = DateUtils.formattedDateMMM(date);
		return resultValue(2).contains(expDate);
	}

}
