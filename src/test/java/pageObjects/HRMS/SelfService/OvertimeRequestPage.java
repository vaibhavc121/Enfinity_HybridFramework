package pageObjects.HRMS.SelfService;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.JavaScriptUtils;

public class OvertimeRequestPage extends BasePage
{

    public OvertimeRequestPage(WebDriver driver)
    {
        super(driver);
    }

    //region Locators
    @FindBy(xpath = "//a[@id='TxnInstanceView_I0i19_T']//span[@class='dx-vam'][normalize-space()='Profile Update']")
    WebElement profileUpdate;

    @FindBy(xpath = "//span[normalize-space()='Overtime Application']")
    WebElement overtimeApplication;

    @FindBy(xpath = "//input[contains(@id,'OvertimeDate')]")
    WebElement overtimeDate;

    @FindBy(xpath = "//div[@class='dx-dropdowneditor-icon']")
    private WebElement dateDD;

    @FindBy(xpath = "//input[contains(@id,'Hours')]")
    WebElement hours;

    @FindBy(xpath = "//textarea[contains(@id,'Description')]")
    WebElement remarks;

    @FindBy(xpath = "//span[@id='ValidationSummary']")
    WebElement validation;
    //endregion

    //region Action Methods
    public void scrollDownWebpage()
    {
        scrollDownWebPage(profileUpdate);
    }

    public void clickOvertimeRequest()
    {
        overtimeApplication.click();
    }

    public void clickNew()
    {
        clickOnNew();
    }

    public void provideOvertimeDate(String value)
    {
        clearAndProvide1(overtimeDate, value);
        clickOnElement1(dateDD);
    }

    public void provideHrs(String value)
    {
        //clearAndProvide1(hours, value);
        //provideValue(hours, value);
        provideAndEnter(hours, value);
    }

    public void provideRemarks(String value)
    {
        //provideDescription(value);
        provideValueJS(remarks, value);
    }

    public void clickSaveBack()
    {
        clickSaveAndBack();
    }

    public String displayErrorMsg()
    {
        String msg = validation.getText();
        return msg;
    }

    public boolean isTxnCreated(String overtimeType, String hrs)
    {
        return resultValue(8).contains(overtimeType) && resultValue(8).contains(hrs);
    }
    //endregion
}