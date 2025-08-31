package pageObjects.HRMS.HRCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HRCorePage extends BasePage
{

    public HRCorePage(WebDriver driver)
    {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    //region Locators
    @FindBy(xpath = "//span[normalize-space()='HR Core']")
    static WebElement hRCore;

    @FindBy(xpath = "//label[normalize-space()='Employee']")
    WebElement employee;

    @FindBy(xpath = "//span[normalize-space()='Setups']")
    WebElement setups;

    @FindBy(xpath = "//span[normalize-space()='Asset Issue']")
    WebElement assetIssue;
    //endregion

    //region Action Methods
    public static void clickHRCore()
    {
        BasePage.clickMenuIcon();
        highlightElement(driver, hRCore, true);
        clickOnElement1(hRCore);
    }

    public void clickEmployee()
    {
        BasePage.openSidebar();
        clickOnElement1(employee);
    }

    public void clickSetupForm()
    {
        highlightElement(driver, setups, true);
        clickOnElement1(setups);
        highlightElement(driver, setups, false); // Remove highlight
    }

    public void clickAssetIssue()
    {
        clickOnElement1(assetIssue);
    }
    //endregion
}