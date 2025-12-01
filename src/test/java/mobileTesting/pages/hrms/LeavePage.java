package mobileTesting.pages.hrms;

import base.BasePage;
import factory.DriverFactory;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static base.BasePage.clickOnElement;
import static base.BasePage.waitTS;

public class LeavePage extends BasePage
{

    //region Locators
    private By plusBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(5)");
    private By expenseClaim = AppiumBy.xpath("//android.widget.TextView[@text=\"Expense Claim\"]");
    //private By advanceAmt = AppiumBy.id("ion-input-4");
    private By advanceAmt = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(24)");
    private By description = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"ion-textarea-1\"]");
    private static By submit = AppiumBy.xpath("//android.widget.Button[@text=\"SUBMIT\"]");

    //endregion

    //region Action Methods
    public void clickPlusBtn()
    {
        waitTS(5);
        clickOnElement(plusBtn);
    }
    public void clickExpenseClaim()
    {
        waitTS(2);
        clickOnElement(expenseClaim);
    }
    public void providedAdvanceAmount()
    {
        waitTS(2);
        DriverFactory.getDriver().findElement(advanceAmt).click();
        DriverFactory.getDriver().findElement(advanceAmt).sendKeys("10");
    }
    public void providedDescription()
    {
        waitTS(2);
        DriverFactory.getDriver().findElement(description).click();
        DriverFactory.getDriver().findElement(description).sendKeys("Expense Claim");
    }
    public static void clickSubmit()
    {
        waitTS(2);
        clickOnElement(submit);
    }

    //endregion
}