package pageObjects.HRMS.Payroll;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utilities.JavaScriptUtils;

public class PayrollPage extends BasePage
{

    @FindBy(xpath = "//i[@class='payroll-module-single-color-icon']")
    static WebElement payroll;

    @FindBy(xpath = "//div[normalize-space()='Transactions']")
    WebElement transactions;

    @FindBy(xpath = "//span[normalize-space()='Reports']")
    WebElement reports;

    public static void clkPayroll()
    {
        // waitForElement(payroll);
        BasePage.clickMenuIcon();
        JavaScriptUtils.clickElementByJavaScript(DriverFactory.getDriver(), payroll);
        waitTS(1);
    }

    public void clkTxn()
    {
        JavaScriptUtils.clickElementByJavaScript(DriverFactory.getDriver(), transactions);
    }

    public void clickReports()
    {
        BasePage.openSidebar();
        reports.click();
    }
}