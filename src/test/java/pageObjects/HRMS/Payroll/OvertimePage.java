package pageObjects.HRMS.Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import base.BaseTest;
import utilities.CommonActions;

public class OvertimePage extends BasePage
{

	public OvertimePage(WebDriver driver)
	{
		super(driver);

	}

	@FindBy(xpath = "//span[normalize-space()='Overtime']")
	WebElement overtime;

	@FindBy(xpath = "//img[@id='Overtime.EmployeeIdLookup_B-1Img']")
	WebElement empdd;

	@FindBy(xpath = "//img[@id='Overtime.OvertimeTypeIdLookup_B-1Img']")
	WebElement overtimeTypeDD;

	@FindBy(xpath = "//input[@id='Overtime.Hours_I']")
	WebElement hours;

	@FindBy(xpath = "//img[@id='Overtime.PayBenefitAs_B-1Img']")
	WebElement payBenefitDD;

	@FindBy(xpath = "//img[@id='Overtime.LeaveTypeIdLookup_B-1Img']")
	WebElement leaveTypeDD;

	BaseTest bc = new BaseTest();

	public void clkOvertime()
	{
		overtime.click();

	}

	public void clkNew()
	{
		clickOnNew();
	}

	public void clkEmpDD()
	{
		empdd.click();
	}

	public void slctEmp() throws InterruptedException
	{
		CommonActions.setDropdownValue("Vaibhav Chavan");
	}

	public void clickOverTimeDD() throws InterruptedException
	{
		overtimeTypeDD.click();
		Thread.sleep(2000);
	}

	String overtimeType = "Normal Overtime";

	public void slctOvertime() throws InterruptedException
	{
		CommonActions.setDropdownValue("Normal Overtime");
	}

	public void provideHrs()
	{
		hours.click();
		hours.clear();
		hours.sendKeys("1");
	}

	public void clkPayBenefitDD()
	{
		payBenefitDD.click();

	}

	public void slctPayBenefit()
	{
		CommonActions.setDropdownValueOffice365("Leave Balance Days");
	}

	public void clkLeaveType()
	{
		leaveTypeDD.click();
	}

	public void slctLeaveType() throws InterruptedException
	{
		CommonActions.setDropdownValue("Annual Leave");
	}

	public void clkView()
	{
		clickOnView();
	}

	public void clkApprove()
	{
		clickOnApprove();
	}

	public boolean isTxnCreated()
	{
		String expEffectiveDt = CommonActions.formattedDateMMM();
		String expOvertimeType = overtimeType;
		String expAmt = driver.findElement(By.xpath("//input[@id='Overtime.AmountFC_I']")).getText();

		CommonActions.filterCell5(expEffectiveDt);
		CommonActions.filterCell7(expOvertimeType);
		CommonActions.filterCell8(expAmt);

		if (CommonActions.result5().contains(expEffectiveDt) && CommonActions.result7().contains(expOvertimeType)
				&& CommonActions.result8().contains(expAmt))
		{
			return true;
		} else
		{
			return false;
		}

	}

}
