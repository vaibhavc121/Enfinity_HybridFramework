package pageObjects.HRMS.SelfService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.JavaScriptUtils;

public class ExceptionRequestPage extends BasePage
{

    public ExceptionRequestPage(WebDriver driver)
    {
        super(driver);
    }

    // Locators
    @FindBy(xpath = "(//span[text()='Exception Request'])[2]")
    WebElement exceptionRequest;

    @FindBy(xpath = "//input[contains(@id,'ExceptionDate')]")
    WebElement exceptionDate;

    @FindBy(xpath = "//input[contains(@id,'LoginTime')]")
    WebElement loginTime;

    @FindBy(xpath = "//input[contains(@id,'LogoutTime')]")
    WebElement logotTime;

    @FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[2]")
    WebElement loginCal;

    @FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[3]")
    WebElement logoutCal;

    @FindBy(xpath = "//span[normalize-space()='OK']")
    private WebElement okButton;

    @FindBy(xpath = "//textarea[contains(@id,'Description')]")
    private WebElement description;

    @FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[3]")
    private WebElement calendarIcon;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    private WebElement saveButton;

    // Action Methods
    public void createExceptionRequest()
    {
        exceptionRequest.click();
    }

    public void clickNew()
    {
        clickOnNew();
    }

    public void provideExceptionDate(String value)
    {
        clearAndProvide1(exceptionDate, value);
    }

    public void provideLoginTime(String value)
    {
        clearAndProvide1(loginTime, value);
        waitTS(5);
        pressTab();
        clickOnElement1(loginTime);
        // clickOnOk();
        // loginCal.click();
        pressTab();
    }

    public void provideLogoutTime(String value)
    {
//		logotTime.click();
//		clearAndProvide1(logotTime, value);
        clickOnOk();
        //provideValue(logotTime, value);
        clearAndProvide1(logotTime, value);
        //clickOnOk();
        JavaScriptUtils.clickElementByJavaScript(driver, okButton);
        // logoutCal.click();
    }

    public void provideRemarks(String value)
    {
        //provideDescription(value);
        provideValueJS(description, value);
        try
        {
            clickOnElement1(calendarIcon);
        } catch (Exception e)
        {
            JavaScriptUtils.clickElementByJavaScript(driver, calendarIcon);
        }
    }

    public void clickSaveBack()
    {
        //clickSaveAndBack();
        JavaScriptUtils.clickElementByJavaScript(driver, saveButton);
        driver.navigate().back();
    }

    public boolean isTxnCreated(String expDate)
    {
        filterDateByIndex(5, expDate);
        if (resultValue(5).contains(expDate))
        {
            return true;
        } else
        {
            return false;
        }
    }
}