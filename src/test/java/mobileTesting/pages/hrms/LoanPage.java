package mobileTesting.pages.hrms;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoanPage extends BasePage
{
    public LoanPage(WebDriver driver)
    {
        super(driver);
    }

    //region Locators
    private By plusBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(5)");
    private By loanRequest = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Image\").instance(5)");
    private By loanAmt = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ion-input-2\")");
    private By installmentAmt = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ion-input-3\")");
    private By noOfInstallments = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ion-input-4\")");
    private By submit = AppiumBy.androidUIAutomator("new UiSelector().text(\"SUBMIT\")");

    //endregion

    //region Action Methods
    public void clickPlusBtn()
    {
        waitTS(5);
        clickOnElement(plusBtn);
    }

    public void clickLoanRequest()
    {
        waitTS(2);
        clickOnElement(loanRequest);

    }

    public void providedLoanAmount(String loanAmount)
    {
        waitTS(2);
        //clearAndProvide(loanAmt, loanAmount);
        driver.findElement(loanAmt).click();
        driver.findElement(loanAmt).sendKeys(loanAmount);
    }

    public void providedInstallmentAmount(String amount)
    {
        waitTS(2);
        clearAndProvide(installmentAmt, amount);
    }

    public void providedNoOfInstallments(String amount)
    {
        waitTS(2);
        clearAndProvide(noOfInstallments, amount);
    }

    public void clickSubmit()
    {
        waitTS(2);
        clickOnElement(submit);
    }

    //endregion


}