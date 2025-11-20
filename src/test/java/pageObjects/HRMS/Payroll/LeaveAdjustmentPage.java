package pageObjects.HRMS.Payroll;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LeaveAdjustmentPage extends BasePage
{

    @FindBy(xpath = "//span[normalize-space()='Leave Adjustment']")
    WebElement leaveAdjustment;

    @FindBy(xpath = "//input[contains(@id,'EmployeeId')]")
    WebElement empdd;

    @FindBy(xpath = "//input[contains(@id,'EffectiveDate')]")
    WebElement effectiveDate;

    @FindBy(xpath = "//input[contains(@id,'LeaveTypeId')]")
    WebElement leavetypedd;

    @FindBy(xpath = "//div[@class='dx-item-content']")
    private WebElement adjustmentType;

    @FindBy(xpath = "//input[contains(@id,'PaidDays')]")
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
        provideAndEnter(empdd, value);
    }

    public void provideEffectiveDate(String value)
    {
        waitTS(2);
        clearAndProvide1(effectiveDate, value);
        clickOnElement1(effectiveDate);
    }

    public void provideLeaveType(String value)
    {
        provideAndEnter(leavetypedd, value);
    }

    public void selectAdjustmentType(String adjustmentTypeValue)
    {
        selectValue(By.xpath("//div[@class='dx-item-content']"), adjustmentTypeValue);
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