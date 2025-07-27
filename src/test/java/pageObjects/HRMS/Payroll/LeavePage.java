package pageObjects.HRMS.Payroll;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.github.javafaker.Faker;

import base.BasePage;
import base.BaseTest;
import utilities.DateUtils;

public class LeavePage extends BasePage
{

	public LeavePage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//region Locators
	@FindBy(xpath = "(//span[text()='Leave'])[2]")
	WebElement leave;

	@FindBy(xpath = "//input[@id='Leave.EmployeeIdLookup_I']")
	WebElement empdd;

	@FindBy(xpath = "//input[@id='Leave.EffectiveDate_I']")
	WebElement effectiveDate;

	@FindBy(xpath = "//input[@id='Leave.LeaveTypeIdLookup_I']")
	WebElement leaveTypeDD;

	@FindBy(xpath="//img[@id='Leave.LeaveTypeIdLookup_B-1Img']") WebElement leaveTypeDD1;

	@FindBy(xpath = "//input[@id='Leave.FromDate_I']")
	WebElement fromDate;

	@FindBy(xpath = "//input[@id='Leave.UptoDate_I']")
	WebElement uptoDate;

	@FindBy(xpath="//span[normalize-space()='Edit Resumption']") WebElement editResumption;
	@FindBy(xpath="//span[normalize-space()='Resume']") WebElement resume;
	//endregion


	//region Action Methods
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
		clickOnElement1(leaveTypeDD1);
		waitTS(1);
		clickOnElement1(leaveTypeDD1);
		waitTS(1);
		clickOnElement1(leaveTypeDD1);
		waitTS(1);
		selectDropdownValue(value);
		// clearAndProvide1(leaveTypeDD, value);
	}

	public void provideFromDt(String value)
	{
		clearAndProvide1(fromDate, value);
	}

	public void provideUpToDt(String value)
	{
		clearAndProvide1(uptoDate, value);
	}

	public void provideFromDate()
	{
		clearAndProvide1(fromDate, DateUtils.getCurrentDate("dd-MM-yyyy"));
	}

	public void provideUpToDate()
	{
		clearAndProvide1(uptoDate, DateUtils.getCurrentDate("dd-MM-yyyy"));
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

	public void clickApprove()
	{
		clickOnApprove();
	}
	public void clickEditResumption()
	{
		clickOnElement1(editResumption);
	}
	public void clickResume()
	{
		clickOnElement1(resume);
	}

	//endregion


}