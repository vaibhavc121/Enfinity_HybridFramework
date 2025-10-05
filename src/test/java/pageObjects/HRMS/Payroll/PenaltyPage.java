package pageObjects.HRMS.Payroll;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PenaltyPage extends BasePage
{

    //region Locators
    @FindBy(xpath = "//span[normalize-space()='Penalty']")
    WebElement penalty;
    @FindBy(xpath = "//input[@id='Penalty.EmployeeIdLookup_I']")
    WebElement empdd;
    @FindBy(xpath = "//input[@id='Penalty.PenaltyDate_I']")
    WebElement penaltyDate;
    @FindBy(xpath = "//input[@id='Penalty.PenaltyTypeIdLookup_I']")
    WebElement penaltyTypeDD;
    @FindBy(xpath = "//input[@id='Penalty.PenaltyInDays_I']")
    WebElement penaltyInDays;
    @FindBy(xpath = "//input[@id='Penalty.PenaltyInAmount_I']")
    WebElement penaltyInAmount;
    //endregion

    //region Action Methods
    public void clickOnPenalty()
    {
        penalty.click();
    }

    public void clickNew()
    {
        clickOnNew();
    }
    public void provideEmployee(String empName)
    {
        clearAndProvide1(empdd, empName);
    }

    public void providePenaltyDate(String date)
    {
        clearAndProvide1(penaltyDate, date);
        waitTS(2);
    }

    public void providePenaltyType(String penaltyType)
    {
        clearAndProvide1(penaltyTypeDD, penaltyType);
        waitTS(2);
    }
    public void providePenaltyInDays(String days)
    {
        clearAndProvide1(penaltyInDays, days);
        waitTS(2);
        pressTab();
        waitTS(2);
        pressTab();
        waitTS(2);
    }
    public void providePenaltyInAmount(String amount)
    {
        clearAndProvide1(penaltyInAmount, amount);
        pressTab();
        pressTab();
    }

    public void clickSaveViewApproveBack()
    {
        clickOnSaveViewApproveBack();
    }
    //endregion
}