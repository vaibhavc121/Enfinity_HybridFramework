package pageObjects.HRMS.Attendance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class TimetablePage extends BasePage
{

	public TimetablePage(WebDriver driver)
	{
		super(driver);

	}

	@FindBy(xpath = "//input[@id='Timetable.Name_I']")
	WebElement name;

	@FindBy(xpath = "//input[@id='Timetable.DayType_I']")
	WebElement dayType;

	@FindBy(xpath = "//span[@id='Timetable.NightShift_S_D']")
	WebElement nightShift;

	@FindBy(xpath = "//input[@id='Timetable.TimetableType_I']")
	WebElement mode;

	@FindBy(xpath = "//input[@id='Timetable.MaximumWorkedHourPerDay_I']")
	WebElement maximumWorkedHourPerDay;

	@FindBy(xpath = "//span[@id='Timetable.WorkInTwoShift_S_D']")
	WebElement workInTwoShift;

	@FindBy(xpath = "//input[@id='Timetable.FirstInTime_I']")
	WebElement firstInTime;

	@FindBy(xpath = "//input[@id='Timetable.FirstOutTime_I']")
	WebElement firstOutTime;

	@FindBy(xpath = "//input[@id='Timetable.SecondInTime_I']")
	WebElement secondInTime;

	@FindBy(xpath = "//input[@id='Timetable.SecondOutTime_I']")
	WebElement secondOutTime;

	@FindBy(xpath = "//input[@id='Timetable.ShiftNextDayStartFrom_I']")
	WebElement shiftNextDayStartFromSpe;

	@FindBy(xpath = "//input[@id='Timetable.WorkedHourPerDay_I']")
	WebElement workedHourPerDay;

	@FindBy(xpath = "//input[@id='Timetable.HourlyMinCheckInTime_I']")
	WebElement hourlyMinCheckInTime;

	@FindBy(xpath = "//input[@id='Timetable.HourlyMaxCheckOutTime_I']")
	WebElement hourlyMaxCheckOutTime;

	public void clickNew()
	{
		clickOnNew();
	}

	public void provideTimetableName(String value)
	{
		clearAndProvide1(name, value);
	}

	public void selectDayType(String value)
	{
		dayType.click();
		selectDropdownValueOffice365(value);
	}

	public void clickNightShift()
	{
		nightShift.click();
	}

	public void selectMode(String value)
	{
		mode.click();
		selectDropdownValueOffice365(value);
		waitTS(2);
	}

	public void provideMaximumWorkedHourPerDay(String value)
	{
		clearAndProvide1(maximumWorkedHourPerDay, value);
	}

	public void clickWorkInTwoShift()
	{
		workInTwoShift.click();
		waitTS(2);
	}

	public void provideFirstInTime(String value)
	{
		clearAndProvide1(firstInTime, value);
	}

	public void provideFirstOutTime(String value)
	{
		clearAndProvide1(firstOutTime, value);
	}

	public void provideSecondInTime(String value)
	{
		clearAndProvide1(secondInTime, value);
	}

	public void provideSecondOutTime(String value)
	{
		clearAndProvide1(secondOutTime, value);
	}

	public void selectShiftNextDayStartFrom(String value)
	{
		shiftNextDayStartFromSpe.click();
		selectDropdownValueOffice365(value);
	}

	public void provideWorkedHourPerDay(String value)
	{
		clearAndProvide1(workedHourPerDay, value);
	}

	public void provideHourlyMinCheckInTime(String value)
	{
		clearAndProvide1(hourlyMinCheckInTime, value);
	}

	public void provideHourlyMaxCheckOutTime(String value)
	{
		clearAndProvide1(hourlyMaxCheckOutTime, value);
	}

	public void clickViewBack()
	{
		clickViewAndBack();
	}

}
