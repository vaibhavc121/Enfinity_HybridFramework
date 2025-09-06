package pageObjects.HRMS.Payroll;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LeaveAdjustmentPage extends BasePage
{

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
        clickOnViewTxn();
    }

    public void clkApproveBtn() throws InterruptedException
    {
        clickOnApprove();
    }
}