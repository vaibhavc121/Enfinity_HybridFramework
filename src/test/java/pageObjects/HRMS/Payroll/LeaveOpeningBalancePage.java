package pageObjects.HRMS.Payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LeaveOpeningBalancePage extends BasePage
{

	public LeaveOpeningBalancePage(WebDriver driver)
	{
		super(driver);

	}

	// Locators
	@FindBy(xpath = "//span[normalize-space()='Leave Opening Balance']")
	WebElement leaveOpeningBalance;

	@FindBy(xpath = "//input[@id='LeaveAdjustment.EmployeeIdLookup_I']")
	WebElement empdd;

	@FindBy(xpath = "//input[@id='LeaveAdjustment.EffectiveDate_I']")
	WebElement effectiveDate;

	@FindBy(xpath = "//input[@id='LeaveAdjustment.LeaveTypeIdLookup_I']")
	WebElement leaveType;

	@FindBy(xpath = "//input[@id='LeaveAdjustment.PaidDays_I']")
	WebElement paidDays;

	@FindBy(xpath = "//input[@id='LeaveAdjustment.UnpaidDays_I']")
	WebElement unpaidDays;

	// Action Methods
	public void clickLeaveOpeningBalance()
	{
		leaveOpeningBalance.click();
	}

	public void clickNew()
	{
		clickOnNew();
	}

	public void provideEmp(String value)
	{
		clearAndProvide1(empdd, value);
	}

	public void provideEffectiveDate(String value)
	{
		clearAndProvide1(effectiveDate, value);
	}

	public void provideLeaveType(String value)
	{
		clearAndProvide1(leaveType, value);
	}

	public void providePaidDays(String value)
	{
		clearAndProvide1(paidDays, value);
	}

	public void provideUnpaidDays(String value)
	{
		clearAndProvide1(unpaidDays, value);
	}

	public void provideRemarks(String value)
	{
		provideDescription(value);
	}

	public void clickView()
	{
		clickOnView();
	}

	public void clickApprove()
	{
		clickOnApprove();
	}

}
