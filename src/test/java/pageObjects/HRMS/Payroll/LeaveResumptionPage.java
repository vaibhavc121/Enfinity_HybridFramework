package pageObjects.HRMS.Payroll;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeaveResumptionPage extends BasePage
{

    public LeaveResumptionPage(WebDriver driver)
    {
        super(driver);
    }

    //region Locators
    @FindBy(xpath = "(//input[contains(@id,'ActualResumptionDate')])[2]") WebElement resumptionDate;
    @FindBy(xpath = "//input[contains(@id, 'ResumePaidDays')]") WebElement paidDays;
    @FindBy(xpath = "//input[contains(@id,'ResumeGrantDays')]") WebElement grantDays;

    //endregion

    //region Action Methods
    public void provideResumptionDate(String date)
    {
        clearAndProvide1(resumptionDate, date);
        waitTS(1);
        pressEnter();
    }
    public void providePaidDays(String days)
    {
        clearAndProvide1(paidDays, days);
    }
    public void provideGrantDays(String days)
    {
        clearAndProvide1(grantDays, days);
    }
    public void clickView()
    {
        clickOnView();
    }

    //endregion
}