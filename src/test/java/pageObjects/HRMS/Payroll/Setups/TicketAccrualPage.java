package pageObjects.HRMS.Payroll.Setups;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TicketAccrualPage extends BasePage
{
    //region Locators
    @FindBy(xpath = "//span[text()='Ticket Accrual']")
    private WebElement ticketAccrual;

    @FindBy(xpath = "//input[@id='TicketAccrual.Name_I']")
    private WebElement name;

    @FindBy(id = "TicketAccrual.NumberOfTicket_I")
    private WebElement numberOfTicket;

    @FindBy(id = "TicketAccrual.NumberOfYear_I")
    private WebElement numberOfYear;

    @FindBy(id = "TicketAccrual.EligibleAfterDays_I")
    private WebElement eligibleAfterDays;

    @FindBy(id = "TicketAccrual.EarningSalaryComponentIdLookup_I")
    private WebElement earningSalaryCom;

    @FindBy(id = "TicketAccrual.IncludeUnpaidDaysInProvision_S_D")
    private WebElement includeUnpaidDay;

    @FindBy(id = "TicketAccrual.Description_I")
    private WebElement description;

    @FindBy(id = "TicketAccrualAgeWisePaymentSchedules_RPHT")
    private WebElement ageWisePaymentSchedules;

    @FindBy(xpath = "//i[@class='dx-icon dx-icon-new-icon']")
    private WebElement newLine;

    @FindBy(xpath = "(//div[@class='dxgBCTC dx-ellipsis'])[1]")
    private WebElement tillAge;

    @FindBy(xpath = "(//div[@class='dxgBCTC dx-ellipsis'])[2]")
    private WebElement percentage;
    //endregion

    //region Action Methods
    public void clickTicketAccrual()
    {
        clickOnElement1(ticketAccrual);
    }
    public void enterName(String value)
    {
        clearAndProvide1(name, value);
    }
    public void enterNumberOfTicket(String value)
    {
        clearAndProvide1(numberOfTicket, value);
    }
    public void enterNumberOfYear(String value)
    {
        clearAndProvide1(numberOfYear, value);
    }
    public void enterEligibleAfterDays(String value)
    {
        clearAndProvide1(eligibleAfterDays, value);
    }
    public void enterEarningSalaryCom(String value)
    {
        clearAndProvide1(earningSalaryCom, value);
    }
    public void clickIncludeUnpaidDayBtn()
    {
        clickOnElement1(includeUnpaidDay);
    }
    public void enterDescription(String value)
    {
        clearAndProvide1(description, value);
    }
    public void clickSave()
    {
        clickOnSave();
    }
    public void clickAgeWisePaymentSchedules()
    {
        clickOnElement1(ageWisePaymentSchedules);
    }
    public void scrollPage()
    {
        scrollIntoView(BaseTest.getDriver(), newLine);
    }
    public void clickNewLine()
    {
        clickOnElement1(newLine);
    }
    public void provideTillAge(String value) throws InterruptedException
    {
        clearAndProvide2(tillAge, value);
    }
    public void providePercentage(String value) throws InterruptedException
    {
        clearAndProvide2(percentage, value);
    }
    //endregion
}