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
    //endregion

    //region Action Methods
    public void clickSuspend()
    {
        clickOnElement1(suspend);
    }
    //endregion
}