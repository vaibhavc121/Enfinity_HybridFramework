package pageObjects.HRMS.Payroll;

import java.util.List;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.CommonActions;

public class LeaveEncashmentPage extends BasePage
{

    @FindBy(xpath = "//span[normalize-space()='Leave Encashment']")
    WebElement leaveEncashment;

    @FindBy(xpath = "//input[contains(@id,'EffectiveDate')]")
    WebElement encashmentDate;

    @FindBy(xpath = "//input[contains(@id,'EmployeeId')]")
    WebElement empdd;

    @FindBy(xpath = "//input[contains(@id,'LeaveTypeId')]")
    WebElement leaveTypeDD;

    @FindBy(xpath = "//input[contains(@id,'PaidDays')]")
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

    public void provideEncashmentDate(String value)
    {
        try
        {
            clearAndProvide1(encashmentDate, value);
        } catch (Exception e)
        {
            clearAndProvide1(encashmentDate, value);
        }
    }

    public void provideEmp(String value)
    {
        provideAndEnter(empdd, value);
    }

    public void provideLeaveType(String value)
    {
        provideAndEnter(leaveTypeDD, value);
    }

    public void selectPaymentType(String value)
    {
        List<WebElement> paymentTypeBtns = BaseTest.getDriver().findElements(By.xpath("//div[@class='dx-item-content']"));

        for (WebElement btn : paymentTypeBtns)
        {
            if (btn.getText().equalsIgnoreCase(value))
            {
                clickOnElement1(btn);
                break;
            }
        }
    }

    public void provideEncashmentDays(String value)
    {
        clearAndProvide1(paidDaysTB, value);
    }

    public void provideRemarks(String value)
    {
        provideDescription(value);
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