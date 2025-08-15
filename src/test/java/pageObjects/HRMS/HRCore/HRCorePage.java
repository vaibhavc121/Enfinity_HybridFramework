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

    @FindBy(xpath = "//span[normalize-space()='HR Core']")
    WebElement hRCore;

    @FindBy(xpath = "//label[normalize-space()='Employee']")
    WebElement employee;

    @FindBy(xpath = "//span[normalize-space()='Setups']")
    WebElement setups;

    @FindBy(xpath = "//span[normalize-space()='Asset Issue']")
    WebElement assetIssue;

    public void clickHRCore()
    {
        highlightElement(driver, hRCore, true);
        clickOnElement1(hRCore);
        // highlightElement(driver, hRCore, false); // Remove highlight
    }

    public void clickEmployee()
    {
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
}