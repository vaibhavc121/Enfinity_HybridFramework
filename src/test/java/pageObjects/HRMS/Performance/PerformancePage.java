package pageObjects.HRMS.Performance;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PerformancePage extends BasePage
{

    //region Locators
    @FindBy(xpath = "//span[normalize-space()='Performance']")
    private WebElement performance;

    @FindBy(xpath = "//label[normalize-space()='Appraisal Cycle']")
    private WebElement appraisalCycle;
    //endregion

    //region Action Methods
    public void clickPerformance()
    {
        BasePage.clickMenuIcon();
        clickOnElement1(performance);
    }
    public void clickAppraisalCycle()
    {
        BasePage.openSidebar();
        waitForElement(appraisalCycle).click();
    }

    //endregion
}