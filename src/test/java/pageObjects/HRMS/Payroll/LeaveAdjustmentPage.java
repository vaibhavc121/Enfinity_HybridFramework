package pageObjects.HRMS.Payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LeaveAdjustmentPage extends BasePage
{

	public LeaveAdjustmentPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[normalize-space()='Leave Adjustment']")
	WebElement leaveAdjustment;

	@FindBy(xpath = "//input[@id='LeaveAdjustment.EmployeeIdLookup_I']")
	WebElement empdd;

	@FindBy(xpath = "//input[@id='LeaveAdjustment.EffectiveDate_I']")
	WebElement effectiveDate;

	@FindBy(xpath = "//input[@id='LeaveAdjustment.LeaveTypeIdLookup_I']")
	WebElement leavetypedd;

	@FindBy(xpath = "//input[@id='LeaveAdjustment.PaidDays_I']")
	WebElement paidDaysTB;

	@FindBy(xpath = "//input[@id='LeaveAdjustment.UnpaidDays_I']")
	WebElement unpaidDaysTB;

	@FindBy(xpath = "//textarea[@id='LeaveAdjustment.Description_I']")
	WebElement remarks;

	@FindBy(xpath = "//span[normalize-space()='Approve']")
	WebElement approve;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[6]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement filterCell;;

	@FindBy(xpath = "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/span[1]/a[1]")
	WebElement result;;

	public void clkLeaveAdj()
	{
		leaveAdjustment.click();
	}

	public void clkNewBtn()
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
		clearAndProvide1(leavetypedd, value);
	}

	public void providePaidDaysValue(String value)
	{
		clearAndProvide1(paidDaysTB, value);
	}

	public void provideUnpaidDaysValue(String value)
	{
		clearAndProvide1(unpaidDaysTB, value);
	}

	public void provideRemarks(String value)
	{
		remarks.sendKeys(value);
	}

	public void clkViewBtn()
	{
		clickOnView();
	}

	public void clkApproveBtn() throws InterruptedException
	{
		clickOnApprove();
	}

	public boolean isTxnCreated()
	{
		// String expemp=emp.getText();
		String expemp = "Vaibhav Chavan";
		filterCell.sendKeys(expemp);
		String actemp = result.getText();

		if (actemp.contains(expemp))
		{
			return true;
		} else
		{
			return false;
		}
	}

}
