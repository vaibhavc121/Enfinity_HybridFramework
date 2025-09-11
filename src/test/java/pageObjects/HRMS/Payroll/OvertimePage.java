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

    @FindBy(xpath = "//span[normalize-space()='Overtime']")
    WebElement overtime;

    @FindBy(xpath = "//input[contains(@id,'EmployeeId')]")
    WebElement empdd;

    @FindBy(xpath = "//input[contains(@id,'EffectiveDate')]")
    WebElement effectiveDate;

    @FindBy(xpath = "//input[contains(@id,'OvertimeDate')]")
    WebElement overtimeDate;

    @FindBy(xpath = "//input[contains(@id,'OvertimeTypeId')]")
    WebElement overtimeType;

    @FindBy(xpath = "//input[contains(@id,'Hours')]")
    WebElement hours;

    @FindBy(xpath = "(//div[@class='dx-radiobutton-icon-dot'])[1]")
    private WebElement payBenefitAsAmt;

    @FindBy(xpath = "(//div[@class='dx-radiobutton-icon-dot'])[2]")
    private WebElement payBenefitAsLeaveBalDays;

    public void clickOvertime()
    {
        clickOnElement1(overtime);
    }

    public void clickNew()
    {
        clickOnNew();
    }

    public void provideEmp(String value)
    {
        provideAndEnter(empdd, value);
    }

    public void provideEffectiveDate(String value)
    {
        clearAndProvide1(effectiveDate, value);
    }

    public void provideOvertimeDate(String value)
    {
        waitTS(2);
        clearAndProvide1(overtimeDate, value);
    }

    public void provideOvertimeType(String value)
    {
        provideAndEnter(overtimeType, value);
    }

    public void provideHrs(String value)
    {
        clearAndProvide1(hours, value);
    }

    public void payBenefitAsAmt()
    {
        clickOnElement1(payBenefitAsAmt);
    }
    public void payBenefitAsLeaveBalDays()
    {
        clickOnElement1(payBenefitAsLeaveBalDays);
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