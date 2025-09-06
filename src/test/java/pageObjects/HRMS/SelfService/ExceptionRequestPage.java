package pageObjects.HRMS.SelfService;

import base.BaseTest;
import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.JavaScriptUtils;

public class ExceptionRequestPage extends BasePage
{

    // Locators
    @FindBy(xpath = "//span[contains(text(),'Exception Request')]")
    WebElement exceptionRequest;

    @FindBy(xpath = "//input[contains(@id,'ExceptionDate')]")
    WebElement exceptionDate;

    @FindBy(xpath = "//input[contains(@id,'LoginTime')]")
    WebElement loginTime;

    @FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[3]")
    WebElement loginCal;

    @FindBy(xpath = "//input[contains(@id,'LogoutTime')]")
    WebElement logotTime;

    @FindBy(xpath = "(//div[@class='dx-dropdowneditor-icon'])[4]")
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
        BaseTest.log("provided login time: " + value);
        waitTS(5);
        pressTab();
        BaseTest.log("pressed tab");
        clickOnElement1(loginTime);
        try
        {
            JavaScriptUtils.clickElementByJavaScript(DriverFactory.getDriver(), loginCal);
            BaseTest.log("clicked on login cal");
        } catch (Exception e)
        {
            JavaScriptUtils.clickElementByJavaScript(DriverFactory.getDriver(), okButton);
            BaseTest.log("clicked on ok button");
        }

        pressTab();
    }

    public void provideLogoutTime(String value)
    {
        clearAndProvide1(logotTime, value);

        try
        {
            JavaScriptUtils.clickElementByJavaScript(DriverFactory.getDriver(), logoutCal);
            BaseTest.log("clicked on logout cal");
        } catch (Exception e)
        {
            JavaScriptUtils.clickElementByJavaScript(DriverFactory.getDriver(), okButton);
            BaseTest.log("clicked on ok button");
        }

        JavaScriptUtils.clickElementByJavaScript(DriverFactory.getDriver(), loginCal);
        BaseTest.log("close login calendar");
        JavaScriptUtils.clickElementByJavaScript(DriverFactory.getDriver(), logoutCal);
        BaseTest.log("close logout calendar");
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
            JavaScriptUtils.clickElementByJavaScript(DriverFactory.getDriver(), calendarIcon);
        }

        waitTS(2);
    }

    public void clickSaveBack()
    {
        //clickSaveAndBack();
        JavaScriptUtils.clickElementByJavaScript(DriverFactory.getDriver(), saveButton);
        DriverFactory.getDriver().navigate().back();
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