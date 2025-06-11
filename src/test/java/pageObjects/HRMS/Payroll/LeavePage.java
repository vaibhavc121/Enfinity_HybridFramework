package pageObjects.HRMS.Payroll;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.github.javafaker.Faker;

import base.BasePage;
import base.BaseTest;

public class LeavePage extends BasePage
{

	public LeavePage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "(//span[text()='Leave'])[2]")
	WebElement leave;

	@FindBy(xpath = "//input[@id='Leave.EmployeeIdLookup_I']")
	WebElement empdd;

	@FindBy(xpath = "//input[@id='Leave.EffectiveDate_I']")
	WebElement effectiveDate;

	@FindBy(xpath = "//input[@id='Leave.LeaveTypeIdLookup_I']")
	WebElement leaveTypeDD;

	@FindBy(xpath = "//input[@id='Leave.FromDate_I']")
	WebElement fromDate;

	@FindBy(xpath = "//input[@id='Leave.UptoDate_I']")
	WebElement uptoDate;

	public void clkLeave()
	{
		leave.click();
	}

	public void clkNewBtn()
	{
		clickOnNew();
	}

	public void provideEmp(String value)
	{
		clearAndProvide1(empdd, value);
	}

	public void provideEffectiveDt(String value)
	{
		selectDropdownValue(value);
	}

	public void provideLeaveType(String value)
	{
		selectDropdownValue(value);
	}

	public void provideFromDt(String value)
	{
		clearAndProvide1(fromDate, value);
	}

	public void provideUpToDt(String value)
	{
		clearAndProvide1(uptoDate, value);
	}

	public void providePaymentType(String value)
	{
		selectDropdownValueOffice365(value);
	}

	public void clkView()
	{
		clickOnView();
	}

	public void clkApproveBack()
	{
		clickApproveAndBack();
	}

}
