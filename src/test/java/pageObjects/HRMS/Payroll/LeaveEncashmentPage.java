package pageObjects.HRMS.Payroll;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.CommonActions;

public class LeaveEncashmentPage extends BasePage
{

	public LeaveEncashmentPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[normalize-space()='Leave Encashment']")
	WebElement leaveEncashment;

	@FindBy(xpath = "//input[@id='LeaveAdjustment.EffectiveDate_I']")
	WebElement effectiveDate;

	@FindBy(xpath = "//input[@id='LeaveAdjustment.EmployeeIdLookup_I']")
	WebElement empdd;

	@FindBy(xpath = "//input[@id='LeaveAdjustment.LeaveTypeIdLookup_I']")
	WebElement leaveTypeDD;

	@FindBy(xpath = "//input[@id='LeaveAdjustment.PaidDays_I']")
	WebElement paidDaysTB;

	@FindBy(xpath = "//td[normalize-space()='1']")
	WebElement countPaidDays;

	public void clkLeaveEncashment()
	{
		leaveEncashment.click();
	}

	public void clkNewBtn()
	{
		clickOnNew();
	}

	public void provideEffectiveDate(String value)
	{
		clearAndProvide1(effectiveDate, value);
	}

	public void provideEmp(String value)
	{
		clearAndProvide1(empdd, value);
	}

	public void provideLeaveType(String value)
	{
		clearAndProvide1(leaveTypeDD, value);
	}

	public void providePaidDays(String value)
	{
		clearAndProvide1(paidDaysTB, value);
	}

	public void selectPaymentType(String value)
	{
		selectDropdownValueOffice365(value);
	}

	public void provideRemarks(String value)
	{
		provideDescription(value);
	}

	public void clkViewBtn()
	{
		clickOnView();
	}

	public void clkApproveBtn() throws InterruptedException
	{
		clickOnApprove();
	}

}
