package pageObjects.HRMS.SelfService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class SelfServicePage extends BasePage
{

    public SelfServicePage(WebDriver driver)
    {
        super(driver);
    }

    //region Locators
    @FindBy(xpath = "//span[normalize-space()='Self Service']")
    WebElement selfService;

    @FindBy(xpath = "//span[normalize-space()='Time Off']")
    WebElement timeOff;

    @FindBy(xpath = "//div[normalize-space()='Transactions']")
    WebElement transactions;

    @FindBy(xpath = "//label[normalize-space()='My Approvals']")
    private WebElement myApprovals;
    //endregion

    //region Action Methods
    public void clickSelfService()
    {
        selfService.click();
    }

    public void clickTimeOff()
    {
        timeOff.click();
    }

    public void clickTransactions()
    {
        transactions.click();
    }

    public void clickMyApprovals()
    {
        waitForElement(myApprovals).click();
    }
    //endregion
}