package pageObjects.HRMS.SelfService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class SelfServicePage extends BasePage
{

    //region Locators
    @FindBy(xpath = "//span[normalize-space()='Self Service']")
    static WebElement selfService;

    @FindBy(xpath = "//span[normalize-space()='Time Off']")
    WebElement timeOff;

    @FindBy(xpath = "//div[normalize-space()='Transactions']")
    WebElement transactions;

    @FindBy(xpath = "//label[normalize-space()='My Approvals']")
    private WebElement myApprovals;
    //endregion

    //region Action Methods
    public static void clickSelfService()
    {
        BasePage.clickMenuIcon();
        selfService.click();
    }

    public void clickTimeOff()
    {
        timeOff.click();
    }

    public void clickTransactions()
    {
        BasePage.openSidebar();
        transactions.click();
    }

    public void clickMyApprovals()
    {
        waitForElement(myApprovals).click();
    }
    //endregion
}