package pageObjects.HRMS.Payroll;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuspendPage extends BasePage
{
    public SuspendPage(WebDriver driver)
    {
        super(driver);
    }

    //region Locators
    @FindBy(xpath="//span[normalize-space()='Suspend']") WebElement suspend;
    @FindBy(xpath="//input[@id='Suspend.EffectiveDate_I']") WebElement effectiveDate;
    @FindBy(xpath="//input[@id='Suspend.EmployeeIdLookup_I']") WebElement empdd;
    @FindBy(xpath="//input[@id='Suspend.SuspendTypeIdLookup_I']") WebElement suspendTypeDD;
    @FindBy(xpath="//textarea[@id='Suspend.Description_I']") WebElement remarks;
    @FindBy(xpath="//input[@id='Suspend.ReleaseSuspendDate_I']") WebElement releaseSuspendDate;
    @FindBy(xpath="//span[normalize-space()='Release']") WebElement release;
    @FindBy(xpath="//span[@id='ValidationSummary']") WebElement msg;


    //endregion

    //region Action Methods
    public void clickSuspend()
    {
        clickOnElement1(suspend);
    }
    public void clickNew()
    {
        clickOnNew();
    }
    public void provideEffectiveDate(String date)
    {
        clearAndProvide1(effectiveDate, date);
    }
    public void provideEmployee(String empName)
    {
        clearAndProvide1(empdd, empName);
    }
    public void provideSuspendType(String type)
    {
        clearAndProvide1(suspendTypeDD, type);
    }
    public void provideRemarks(String remark)
    {
        clearAndProvide1(remarks, remark);
    }
    public void provideReleaseSuspendDate(String date)
    {
        clearAndProvide1(releaseSuspendDate, date);
    }
    public void clickRelease()
    {
        clickOnElement1(release);
    }
    public void clickViewApproveBack()
    {
        clickOnViewApproveBack();
    }
    public boolean validateMsg()
    {
        String message= msg.getText();
        if(message.contains("Suspend already resumed."))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //endregion
}