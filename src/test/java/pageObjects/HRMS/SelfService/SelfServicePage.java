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

    @FindBy(xpath = "//label[normalize-space()='Team']")
    private WebElement team;

    @FindBy(xpath = "//div[normalize-space()='Transactions']")
    WebElement transactions;

    @FindBy(xpath = "//div[@title='Rohit Chavan']")
    private WebElement emp;

    @FindBy(xpath = "//img[@id='ContextButton_A0A2ADB8-0562-47B1-9208-C65AE8D24D8F_DirectReporteesImg']")
    private WebElement contextButton;

    @FindBy(xpath = "//span[normalize-space()='Transactions']")
    private WebElement transactionsLabel;

    @FindBy(xpath = "//span[contains(text(),'Promotion Request')]")
    private WebElement promotionRequest;

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

    public void clickTeam()
    {
        clickOnElement1(team);
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

    public void openPromotionRequest(String expEmp)
    {
        if (emp.getText().contains(expEmp))
        {
            waitTS(2);
            clickOnElement1(contextButton);
            waitTS(2);
            hoverOverElement(transactionsLabel);
            waitTS(2);
            clickOnElement1(promotionRequest);
        } else
        {
            throw new RuntimeException("Employee not found: " + expEmp);
        }
    }
    //endregion
}