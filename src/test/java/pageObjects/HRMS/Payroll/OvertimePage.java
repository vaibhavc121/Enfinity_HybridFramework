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

	@FindBy(xpath = "//input[@id='Overtime.EmployeeIdLookup_I']")
	WebElement empdd;

	@FindBy(xpath = "//input[@id='Overtime.EffectiveDate_I']")
	WebElement effectiveDate;

	@FindBy(xpath = "//input[@id='Overtime.OvertimeDate_I']")
	WebElement overtimeDate;

	@FindBy(xpath = "//input[@id='Overtime.OvertimeTypeIdLookup_I']")
	WebElement overtimeType;

	@FindBy(xpath = "//img[@id='Overtime.OvertimeTypeIdLookup_B-1Img']")
	WebElement overtimeTypeDD;

	@FindBy(xpath = "//input[@id='Overtime.Hours_I']")
	WebElement hours;

	@FindBy(xpath = "//img[@id='Overtime.PayBenefitAs_B-1Img']")
	WebElement payBenefitDD;

	@FindBy(xpath = "//img[@id='Overtime.LeaveTypeIdLookup_B-1Img']")
	WebElement leaveTypeDD;

	BaseTest bc = new BaseTest();

	public void clickOvertime()
	{
		overtime.click();

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

	public void provideOvertimeDate(String value)
	{
		clearAndProvide1(overtimeDate, value);
	}

	public void provideOvertimeType(String value)
	{
		clearAndProvide1(overtimeType, value);
	}

	public void provideHrs(String value)
	{
		clearAndProvide1(hours, value);
	}

	public void selectPayBenefit()
	{
		payBenefitDD.click();
		selectDropdownValueOffice365("Leave Balance Days");
	}

	public void slctLeaveType() throws InterruptedException
	{
		leaveTypeDD.click();
		selectDropdownValue("Annual Leave");
	}

	public void clickApproveBack()
	{
		clickOnViewApproveBack();
	}

//	public boolean isTxnCreated()
//	{
//		String expEffectiveDt = CommonActions.formattedDateMMM();
//		String expOvertimeType = overtimeType;
//		String expAmt = driver.findElement(By.xpath("//input[@id='Overtime.AmountFC_I']")).getText();
//
//		CommonActions.filterCell5(expEffectiveDt);
//		CommonActions.filterCell7(expOvertimeType);
//		CommonActions.filterCell8(expAmt);
//
//		if (CommonActions.result5().contains(expEffectiveDt) && CommonActions.result7().contains(expOvertimeType)
//				&& CommonActions.result8().contains(expAmt))
//		{
//			return true;
//		} else
//		{
//			return false;
//		}
//
//	}

}
